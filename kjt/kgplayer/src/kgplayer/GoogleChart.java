package kgplayer;

import java.util.ArrayList;

public class GoogleChart {
	
	public String getCercleChart(ArrayList<PieElement> list) {
		String htmlString = 
				"<html>\r\n" + 
						"  <head>\r\n" + 
						"   <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
						"   <script type=\"text/javascript\">\r\n" + 
						"      google.charts.load('current', {'packages':['gauge']});\r\n" + 
						"      google.charts.setOnLoadCallback(drawChart);\r\n" + 
						"\r\n" + 
						"      function drawChart() {\r\n" + 
						"\r\n" + 
						"        var data = google.visualization.arrayToDataTable([\r\n" + 
						"          ['항목', '수치'],\r\n";
						for (int i = 0; i < list.size(); i++) {
							htmlString += "[" + list.get(i).getName() + "', " + list.get(i).getValues() + "]\r\n";
						}
						htmlString += " ]); \r\n" + 
						"        var options = {\r\n" + 
						"          width: 400, height: 120,\r\n" + 
						"          redFrom: 90, redTo: 100,\r\n" + 
						"          yellowFrom:75, yellowTo: 90,\r\n" + 
						"          minorTicks: 5\r\n" + 
						"        };\r\n" + 
						"\r\n" + 
						"        var chart = new google.visualization.Gauge(document.getElementById('chart_div'));\r\n" + 
						"\r\n" + 
						"        chart.draw(data, options);\r\n" + 
						"\r\n" + 
						"        setInterval(function() {\r\n" + 
						"          data.setValue(0, 1, 40 + Math.round(60 * Math.random()));\r\n" + 
						"          chart.draw(data, options);\r\n" + 
						"        }, 13000);\r\n" + 
						"        setInterval(function() {\r\n" + 
						"          data.setValue(1, 1, 40 + Math.round(60 * Math.random()));\r\n" + 
						"          chart.draw(data, options);\r\n" + 
						"        }, 5000);\r\n" + 
						"        setInterval(function() {\r\n" + 
						"          data.setValue(2, 1, 60 + Math.round(20 * Math.random()));\r\n" + 
						"          chart.draw(data, options);\r\n" + 
						"        }, 26000);\r\n" + 
						"      }\r\n" + 
						"    </script>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"    <div id=\"chart_div\" style=\"width: 400px; height: 120px;\"></div>\r\n" + 
						"  </body>\r\n" + 
						"</html>";
		return htmlString;
				
	}
	
}
