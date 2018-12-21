package application;


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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;

public class MemberList {
	private JButton b1;
	private JButton b2;
	private JFrame frame;
	private JPanel panel;

	private JTable tableView;
	private JScrollPane scrollList;
	MemberDAO dao = new MemberDAO();
	private JTextField textField;
	private JLabel label;
	public MemberList() throws Exception {
		frame = new JFrame("ClassData");
		setLayout();
		frame.setSize(500, 600);
		frame.setVisible(true);

	}
	private void setLayout() throws Exception
	{
		b2 = new JButton("나가기");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
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
		panel = new JPanel(new FlowLayout());
		panel.add(scrollList);
		
		label = new JLabel("삭제할 아아디");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		b1 = new JButton("삭제하기");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				try {
					dao.delete(textField.getText());
					JOptionPane.showMessageDialog(panel, "삭제완료");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(b1);
		panel.add(b2);
		
		frame.getContentPane().add(panel);

	}

	public static void main(String[] args) throws Exception {
		MemberList list = new MemberList();
	}


}

