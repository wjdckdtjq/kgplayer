package kgplayer;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.Rotation;
import org.jfree.chart.plot.PiePlot3D;

	public class SongChart extends ApplicationFrame {
	//차트 클래스
		
		ChartPanel chartPanel;
	 
		public SongChart(String title) {

	          super(title);   //입력받은 타이틀 가져오기
	          PieDataset dataset = createTestSample();   //데이터셋 객체 정의
	          JFreeChart chart = createChart(dataset);   //데이터셋을 참조하는 차트객체만들기
	          chartPanel = new ChartPanel(chart);   //패널
	          chartPanel.setPreferredSize(new Dimension(800, 400)); //크기
	          setContentPane(chartPanel);   //패널 세팅
	          chartPanel.setLayout(null);
	          chartPanel.validate();
	    }

	    
	   private PieDataset createTestSample() {
	      
	      DefaultPieDataset testData = new DefaultPieDataset();
	      
//	      ChartData chartData = new ChartData();
//	      testData.setValue(chartData.searchSubject, new Double((chartData.countTotal/chartData.count)*10));   //내용, 퍼센트
	      
	      testData.setValue("Iu", new Double(75.1));   //내용, 퍼센트
	      testData.setValue("GirlFriend", new Double(12.3));
	      testData.setValue("GirlsDay", new Double(8.2));
	      testData.setValue("jfla", new Double(4.4));
	      
	      return testData;   //데이터셋 반환
	   }

	   private JFreeChart createChart(PieDataset dataset) {   //위의 파이 데이터셋 메서드에서 가져오기
	      
	      JFreeChart chart = ChartFactory.createPieChart3D(   //3D차트 만들기
	            "user's choics",   //제목
	            dataset,   //데이터셋 연동으로 처리
	            false,      
	            false,      
	            false     
	            );
	      
	      PiePlot3D plot = (PiePlot3D) chart.getPlot();
	      plot.setStartAngle(290);
	      plot.setDirection(Rotation.CLOCKWISE);
	      plot.setForegroundAlpha(0.5f);

	      return chart;
	   }
	   
	   public JPanel chart() {
	      return chartPanel;
	   }
	   
//	 	song 차트 패널에 집어넣기
//	    panel.setLayout(new FlowLayout());
//	    panel.add(new SongChart("").chartPanel);
	   
		public static void main(String[] args) {
			
			JFrame jf = new JFrame();
			jf.setSize(900, 500);
			jf.setLayout(new FlowLayout());
			jf.add(new SongChart("").chartPanel);
			jf.setVisible(true);
			
		}

	
}
