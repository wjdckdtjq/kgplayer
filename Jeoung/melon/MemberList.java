package melon;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.embed.swing.Disposer;

public class MemberList {
	private JLabel l1;
	private JButton b1;
	private JFrame frame;
	private JPanel wrapper_panel;

	private JTable tableView;
	private JScrollPane scrollList;
	
	MemberDAO dao = new MemberDAO();
	public MemberList() throws Exception {
		frame = new JFrame("ClassData");
		setLayout();
		frame.setSize(400, 300);
		frame.setVisible(true);

	}
	private void setLayout() throws Exception
	{
		l1= new JLabel("회원정보");
		b1 = new JButton("나가기");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		wrapper_panel = new JPanel(new BorderLayout());
		Vector<Object> dataSet = new Vector<>();
		Vector<String> col = new Vector<>();
		col.add("Id");
		col.add("Pw");
		col.add("Name");
		col.add("Tel");
		col.add("Address");
		col.add("Point");
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = new MemberDTO();
			dto = (MemberDTO) list.get(i);
			Vector<Comparable> row = new Vector<Comparable>();
			row.add(dto.getId());
			row.add(dto.getPw());
			row.add(dto.getName());
			row.add(dto.getTel());
			row.add(dto.getAdress());
			row.add(dto.getPoint());
			dataSet.add(row);
		}
		
		tableView = new JTable(dataSet, col);
		scrollList = new JScrollPane(tableView);
		wrapper_panel.add(scrollList,BorderLayout.CENTER);
		wrapper_panel.add(l1,BorderLayout.NORTH);
		wrapper_panel.add(b1,BorderLayout.SOUTH);

		frame.add(wrapper_panel);

	}

	public static void main(String[] args) throws Exception {
		MemberList list = new MemberList();
	}


}

