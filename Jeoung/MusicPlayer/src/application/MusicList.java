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
import javax.swing.SwingConstants;
import java.awt.Component;

public class MusicList {
	JButton b1;
	JButton b2;
	private JFrame frame;
	JPanel wrapper_panel;
	private JButton play;
	private JButton stop;
	JTable tableView;
	JScrollPane scrollList;
	
	MusicDAO dao = new MusicDAO();
	private JTextField textField;
	JLabel label;
	
	public MusicList() throws Exception {
		frame = new JFrame("KG Player");
		setLayout();
		frame.setSize(1000, 920);
//		frame.setVisible(true);
		
	}
	private void setLayout() throws Exception
	{
		b2 = new JButton("2");
		b2.setBounds(526, 796, 74, 23);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		wrapper_panel = new JPanel();
		Vector<Object> dataSet = new Vector<>();
		Vector<String> col = new Vector<>();
		col.add("노래제목");
		col.add("가수");
		col.add("카운터");
		col.add("노래순서");
		ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
		list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			MusicDTO dto = new MusicDTO();
			dto = (MusicDTO) list.get(i);
			Vector<Comparable> row = new Vector<Comparable>();
			play = new JButton();
			row.add(dto.getSongName());
			row.add(dto.getSinger());
			row.add(dto.getCount());
			row.add(dto.getNum());
			
			dataSet.add(row);
		}
		wrapper_panel.setLayout(null);
		
		tableView = new JTable(dataSet, col);
		scrollList = new JScrollPane(tableView);
		scrollList.setBounds(39, 366, 933, 402);
		wrapper_panel.add(scrollList);
		
		label = new JLabel("3");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(205, 800, 81, 15);
		wrapper_panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(298, 797, 116, 21);
		wrapper_panel.add(textField);
		textField.setColumns(10);
		
		
		b1 = new JButton("4");
		b1.setBounds(426, 796, 92, 23);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dao.delete(textField.getText());
					JOptionPane.showMessageDialog(wrapper_panel, ".");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		wrapper_panel.add(b1);
		wrapper_panel.add(b2);
		frame.getContentPane().add(wrapper_panel);

	}

	public static void main(String[] args) throws Exception {
		MusicList list = new MusicList();
	}


}