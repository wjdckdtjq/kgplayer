package application;

import application.MyPage2;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyPage2 extends JPanel {

	private MemberDAO dao;
	private MemberDTO dto;
	private JTable table_1;
	private JScrollPane scrollList;
	
	public MyPage2() throws Exception {
		
		setSize(555, 555);
		setLayout(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBounds(29, 45, 486, 442);
		add(panel);
		
		MemberDAO dao = new MemberDAO();
		Vector<Object> dataSet = new Vector<>();
		Vector<String> col = new Vector<>();
		col.add("Id");
		col.add("Pw");
		col.add("Name");
		col.add("Tel");
		col.add("Address");
		col.add("Point");
		MemberDTO dto = new MemberDTO();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list =  dao.selectinfo(dto.sessionId);
		
		for (int i = 0; i < list.size(); i++) {
			dto = (MemberDTO) list.get(i);
		}
			Vector<Comparable> row = new Vector<Comparable>();
			row.add(dto.getId());
			row.add(dto.getPw());
			row.add(dto.getName());
			row.add(dto.getTel());
			row.add(dto.getAdress());
			row.add(dto.getPoint());
			
			dataSet.add(row);

		table_1 = new JTable(dataSet, col);
		scrollList = new JScrollPane(table_1);
		panel.add(scrollList);
		setVisible(true);
	}
}
