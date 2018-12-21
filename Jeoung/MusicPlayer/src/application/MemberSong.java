package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberSong extends JPanel{
	Vector<Object> row;
	String songName;
	JScrollPane scrollList;
	
	public MemberSong() {
		
		setSize(483, 488);
		setLayout(null);
		
		MemberDAO dao = new MemberDAO();
		Vector<Object> col = new Vector<>();
		col.add("내 음악리스트");
		MemberDTO dto = new MemberDTO();
		MemberSongList list = new MemberSongList();
		list.setId(dto.sessionId);
		try {
			list = dao.selectSongList(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String songlist= list.getFileName();
		String[] b = songlist.split("[,]");
		ArrayList<String> array = new ArrayList<String>();
		Collections.addAll(array, b);
		Vector<Object> dataSet = new Vector<>();
		
		
		for (int i = 0; i < array.size(); i++) {
			row = new Vector<>();
			String songName = array.get(i);
			row.add(songName);
			System.out.println(songName);
			dataSet.add(row);
		}
		JTable table_1 = new JTable(dataSet, col);
		scrollList = new JScrollPane(table_1);
		scrollList.setBounds(11, 17, 347, 403);
		add(scrollList);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new MemberSong();
	}
}
