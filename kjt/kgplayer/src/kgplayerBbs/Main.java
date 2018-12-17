package kgplayerBbs;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import kgplayer.GoogleChart;
import kgplayer.PieElement;

public class Main extends JFrame {
	
	private Browser browser = new Browser();
	private BrowserView browserview = new BrowserView(browser);
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자바차트 띄우기");
		setVisible(true);
		setResizable(false);
		setSize(600,500);
		
		browser.addLoadListener(new LoadAdapter() {
			@Override
			public void onFinishLoadingFrame(FinishLoadingEvent event) {
				if (event.isMainFrame()) {
					System.out.println("HTML 문서가 로드되었습니다");
				}
			}
		});
		
		ArrayList<PieElement> list = new ArrayList<PieElement>();
		list.add(new PieElement("CPU 사용량", 50));
		list.add(new PieElement("메모리 사용량", 100));
		list.add(new PieElement("데이터 사용량", 49));
		browser.loadHTML(new GoogleChart().getCercleChart(list));
		add(browserview,BorderLayout.CENTER);
	}

}


