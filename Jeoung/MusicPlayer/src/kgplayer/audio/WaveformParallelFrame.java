package kgplayer.audio;

import kgplayer.audio.BackgroundExecutor;
//import it.pievis.utils.BarrierMonitorLock;
import kgplayer.audio.Timer;
import kgplayer.audio.Utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.util.concurrent.Executor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WaveformParallelFrame extends JFrame {

	private int WIDTH = 450;
	private int HEIGHT = 100;
	private int N_TASK = 2;
	private int NTOTLINES = 0;
	private int DISCARD_FACTOR = 4; 
	private WaveformPanel wfp;
	private int[] polyliney, polylinex;	
	
	Executor executor = BackgroundExecutor.get();
	boolean updatedOnScreen = true;
	private boolean canWriteOnScreen = false;

	ImageIcon frameIcon = new ImageIcon(getClass().getResource("/res/waveicon.png"));
	
	int taskCount = 0;
	Timer timer = new Timer(); 
	public WaveformParallelFrame() {
		super();
		setIconImage(frameIcon.getImage());
		setSize(WIDTH, HEIGHT+20);
		setTitle("Waveform Frame");
		setName("Main FRAME");
		wfp = new WaveformPanel();
		wfp.setSize(WIDTH, HEIGHT);
		wfp.setName("Waveform PANEL");
		add(wfp);
	}
	
	public void updateWave(byte[] pcmdata)
	{
		wfp.updateWave(pcmdata);
	}
	
	/**
	 * This panel gets a signal with updateWave and each time
	 * he can (not busy), he asks the executor to run
	 * N_TASK tasks that calculate the absolute position of the
	 * polyline relative to part of the signal (that is pcmdata)
	 * @author Pierluigi
	 */
	class WaveformPanel extends JPanel
	{
		byte[] pcmdata = null;
		Label cdtlmx; 
		Label cdtlmn; 
		Label cdtlavg; 

		public WaveformPanel()
		{
			super();
			setLayout(null);
			cdtlmx = new Label("DrawTime max");
			cdtlmx.setBounds(0, 0, 80, 10);
			add(cdtlmx);
			cdtlmn = new Label("DrawTime min");
			cdtlmn.setBounds(0, 10, 80, 10);
			add(cdtlmn);
			cdtlavg = new Label("DrawTime avg");
			cdtlavg.setBounds(160, 0, 80, 10);
			add(cdtlavg);
		}
		
		/**
		 * Refresh the wave every times a new pcmdata arrives
		 */
		public void updateWave(byte[] pcmdata)
		{
			//repaint();
			synchronized (wfp) {
				if(!updatedOnScreen)
					return;
				updatedOnScreen = false;
			}
			this.pcmdata = pcmdata;
			callTask();
		}
		
		/**
		 * This makes the executor run some task
		 * each task calculate position for part of the signal
		 */
		private void callTask()
		{
			timer.start();
			int numLines = pcmdata.length/4;
			numLines/=DISCARD_FACTOR;
			
			if(NTOTLINES != numLines){
				NTOTLINES = numLines;
				instantiateEmptyLinesArray();
				log("Lines we are drawing: " + numLines );
			}
	
			int diff = pcmdata.length / N_TASK;
			for(int i = 0; i<N_TASK; i++)
				executor.execute(new WaveformTask(getWidth(), getHeight(), i*diff, (i+1)*diff, i));
		}
		
		/**
		 * Handle the refresh of the waveform
		 * @param g
		 */
		private void doDrawing(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			
			if(pcmdata == null){
				int HEIGHT = getHeight();
				int WIDTH = getWidth();
				g2d.drawLine(0, HEIGHT/2, WIDTH, HEIGHT/2);
				return;
			}
			if(polylinex != null){
				drawLines(g2d);
				}
		}
		
		/**
		 * This task calculates part of the polyline, relative to a portion
		 * of the signal (pcmdata.lenght/N_TASK)
		 * @author Pierluigi
		 */
		class WaveformTask implements Runnable
		{
			int HEIGHT;
			int WIDTH;
			int from;
			int to;
			int N;
			
			public WaveformTask(int width, int height, int from, int to, int n) {
				HEIGHT = height;
				WIDTH = width;
				this.to = to;
				this.from = from;
				this.N = n;
			}
			
			@Override
			public void run() {
				calcLine2d();
	    		synchronized (polylinex) {
					taskCount++;
					if(taskCount == N_TASK){
						taskCount = 0;
						canWriteOnScreen = true;
						repaint();
					}
				}
			}
			
			void calcLine2d(){
				float scale = (float) HEIGHT/65536; 
				int npoints = (to-from)/(2*DISCARD_FACTOR);
	    		float pwidth = (float) WIDTH/N_TASK;
	    		float dx = (pwidth)*N;
	    		int dy = HEIGHT/2;
	    		float lineLen = (float) pwidth/npoints;
	    		int ix = 0;
	    		int absi;
	    		int inc = DISCARD_FACTOR * 2;
	    		for(int i = from; i < to; i+=inc){
	    			int sample0 = Utils.getSixteenBitSample(pcmdata[i+1], pcmdata[i]);
	    			int val0 = (int) (sample0*scale)+dy;
	    			int diffx0 = Math.round(lineLen*ix+dx);
	    			absi = ix+(N*npoints);
	    			WaveformParallelFrame.this.polylinex[absi] = diffx0;
	    			WaveformParallelFrame.this.polyliney[absi] = val0;
	    			ix++;
	    		}
			}
		}
		/**
		 * This should draw lines
		 * @param g2d 
		 */
		void drawLines(Graphics2D g2d)
		{
			assert(polylinex != null);
			assert(taskCount == 0);
			
			if(canWriteOnScreen){
				g2d.drawPolyline(polylinex, polyliney, polylinex.length);
				g2d.dispose();
				timer.stop();
				synchronized (wfp) {
					canWriteOnScreen = false;
					updatedOnScreen = true;
				}
			}
			
		}
		
		/**
		 * Called each time the UI is rendered
		 */
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			doDrawing(g);
			cdtlmx.setText(timer.getMax() + "");
			cdtlmn.setText(timer.getMin() + "");
			cdtlavg.setText(timer.getAvg() + "");
		}

		/**
		 * Initialize arrays
		 */
		private void instantiateEmptyLinesArray()
		{
			polylinex = new int[NTOTLINES*2];
			polyliney = new int[NTOTLINES*2];
			for(int i = 0; i<NTOTLINES*2; i++)
			{
				polylinex[i] = 0;
				polyliney[i] = 0;
			}
		}
	}

	private void log(String line)
	{
		System.out.println("WF out] " + line);
	}
}
