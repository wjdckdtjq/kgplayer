package kgplayer.audio;

import kgplayer.audio.AudioPlayer;
import kgplayer.audio.BackgroundExecutor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import javazoom.jlgui.basicplayer.BasicPlayerException;

public class SeekBar extends JProgressBar {

	AudioPlayer p = AudioPlayer.getInstance();
	private int updatedValue = 0;

	/**
	 * Update SeekBar position
	 * @param progress in microseconds
	 * @param totalVal in seconds
	 */
	public void updateSeekBar(long progress, float totalVal)
	{
		if(p.isSeeking())
			return;
		BackgroundExecutor.get().execute(new UpdatingTask(progress, totalVal)); 
		setValue(updatedValue);
	}
	
	
	/**
	 * Task used for updating the seek value in another thread.
	 * @author Pierluigi
	 */
	private class UpdatingTask implements Runnable {

		long progress; float totalVal;
		public UpdatingTask(long progress, float totalVal) {
			this.progress = progress;
			this.totalVal = totalVal;
		}
		
		@Override
		public void run() {
			
			int lp = (int) (progress / 1000);
			int seekLenght = getMaximum();
			int n = (int) ((lp/(totalVal*1000))*seekLenght); 
			updatedValue = n;
		}
	}

	/**
	 * New Constructor, sets a mouseListener
	 * (extends JProgressBar)
	 */
	public SeekBar()
	{
		super();
		setMaximum(10000);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(p.isSeeking())
					return;
				float val =  ((float)e.getX()/getWidth()) * getMaximum();
				returnValueToPlayer(val);
				setValue((int)val);
				log("SeekBar pressed: " + val + " x: " + e.getX());
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	
	/**
	 * Informs the player about the relative value selected in the seekbar 
	 * @throws BasicPlayerException 
	 */
	private void returnValueToPlayer(float val){
		BackgroundExecutor.get().execute(new SeekTask(val));
	}
	
	/**
	 * Class for executing seek outside the UI thread
	 * @author Pierluigi
	 */
	class SeekTask implements Runnable{
		
		float val;
		public SeekTask(float val) {
			this.val = val;
		}
		
		@Override
		public void run() {
			float relVal = val/getMaximum();
			int newSongPos = (int) (relVal * p.getAudioDurationSeconds());
			p.setLastSeekPositionInMs(newSongPos*1000000);
			long seekvalue = (long) ((float)newSongPos * p.getAudioFrameRate() * p.getAudioFrameSize());
			try {
				p.seek(seekvalue);
			} catch (BasicPlayerException e) {
				log("Error with calculated seek value");
				e.printStackTrace();
			}
		}
	}

	/**
	 * The returned value refears to seconds
	 * @return
	 */
	private void log(String str)
	{
		System.out.println("SeekBar] " +str);
	}
}
