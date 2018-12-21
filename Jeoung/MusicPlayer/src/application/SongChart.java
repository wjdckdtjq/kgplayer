package application;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

		ChartPanel chartPanel;
		Double IU = (double)0;;
	    Double Girlf = (double)0;;
	    Double BigBang = (double)0;;
	    Double seeYa = (double)0;;
	    Double Davichi = (double)0;;
	    Double Dalshabet = (double)0;;
	    Double ETC = (double)0;
		public SongChart(String title) throws Exception {

	          super(title);   
	          PieDataset dataset = createTestSample();   
	          JFreeChart chart = createChart(dataset);   
	          chartPanel = new ChartPanel(chart);   
	          chartPanel.setPreferredSize(new Dimension(800, 400)); 
	          setContentPane(chartPanel);   
	          chartPanel.setLayout(null);
	          chartPanel.validate();
	    }

	    private PieDataset createTestSample() throws Exception {
	          
	        DefaultPieDataset testData = new DefaultPieDataset();
	          
	        Class.forName("com.mysql.jdbc.Driver");
	          
	        String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
	        String user = "root";
	        String password = "1234";
	          
	        Connection con = DriverManager.getConnection(url, user, password);
	        String sql = "select * from songinfo";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	          
	         
	         while( rs.next( ) ) {
	            
	               if(rs.getString(2).equals("IU")) {
	                  
	                 IU = IU += rs.getDouble(3);
	                 testData.setValue(rs.getString(2), IU); 
	                 
	               } else if(rs.getString(2).equals("Girlf")){
	                  
	                  Girlf = Girlf += rs.getDouble(3);
	                    testData.setValue(rs.getString(2), Girlf);
	                    
	            } else if(rs.getString(2).equals("BigBang")) {
	               
	               BigBang = BigBang += rs.getDouble(3);
	                    testData.setValue(rs.getString(2), BigBang);
	               
	            } else if(rs.getString(2).equals("seeYa")) {
	               
	               seeYa = seeYa += rs.getDouble(3);
	                    testData.setValue(rs.getString(2), seeYa);
	               
	            } else if(rs.getString(2).equals("Davichi")) {
	               
	               Davichi = Davichi += rs.getDouble(3);
	                    testData.setValue(rs.getString(2), Davichi);
	                    
	            } else if(rs.getString(2).equals("Dalshabet")) {
	                  
	               Dalshabet = Dalshabet += rs.getDouble(3);
	                     testData.setValue(rs.getString(2), Dalshabet);
	            }else {
	                
	                ETC = ETC += rs.getDouble(2);
	                testData.setValue("기타",ETC);
	             }
	         }
	        
	        return testData;   //데이터셋 반환
	       }


	   private JFreeChart createChart(PieDataset dataset) {  
	      
	      JFreeChart chart = ChartFactory.createPieChart3D(   
	            "user's choics",  
	            dataset,   
	            true,      
	            true,      
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
	   
//	 	song 
//	    panel.setLayout(new FlowLayout());
//	    panel.add(new SongChart("").chartPanel);
	   
		public static void main(String[] args) throws Exception {
			
			JFrame jf = new JFrame();
			jf.setSize(900, 500);
			jf.setLayout(new FlowLayout());
			jf.add(new SongChart("").chartPanel);
			jf.setVisible(true);
			
		}

	
}
