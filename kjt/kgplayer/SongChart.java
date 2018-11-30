package kgplayer;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
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
	          chartPanel.setPreferredSize(new Dimension(1200, 260)); //크기
	          setContentPane(chartPanel);   //패널 세팅
	          chartPanel.setLayout(null);
	          chartPanel.validate();
	    }

	    
	   private PieDataset createTestSample() {
	      
	      DefaultPieDataset testData = new DefaultPieDataset();
	      
//	      ChartData chartData = new ChartData();
//	      testData.setValue(chartData.searchSubject, new Double((chartData.countTotal/chartData.count)*10));   //내용, 퍼센트
	      
	      testData.setValue("Iu", new Double(0.751*10));   //내용, 퍼센트
	      testData.setValue("GirlFriend", new Double(0.123*10));
	      testData.setValue("GirlsDay", new Double(0.082*10));
	      testData.setValue("jfla", new Double(0.044*10));
	      
	      return testData;   //데이터셋 반환
	   }

	   private JFreeChart createChart(PieDataset dataset) {   //위의 파이 데이터셋 메서드에서 가져오기
	      
	      JFreeChart chart = ChartFactory.createPieChart3D(   //3D차트 만들기
	            "user's choics",   //제목
	            dataset,   //데이터셋 연동으로 처리
	            false,      //설명창
	            false,      //모름
	            false     //모름
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
	   


	
}
