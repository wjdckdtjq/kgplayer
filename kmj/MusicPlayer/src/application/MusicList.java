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

import com.sun.glass.ui.Size;
import com.sun.rowset.internal.Row;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;

import application.Music;
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
	DefaultTableModel table;
	Vector<Object> dataSet;
	public MusicList() throws Exception {
		frame = new JFrame("노래리스트");
		setLayout();
		frame.setSize(1000, 920);
//		frame.setVisible(true);

	}
	private void setLayout() throws Exception
	{
		b2 = new JButton("닫기");
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
		col.add("재생 수");
		col.add("노래번호");
		
		table = new DefaultTableModel(col, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		Music music = new Music();
		ArrayList<MusicDTO> list = new ArrayList<>();
		list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			MusicDTO dto = new MusicDTO();
			dto = (MusicDTO) list.get(i);
			Vector<Comparable> row = new Vector<Comparable>();
			play = new JButton();
			row.addElement(dto.getSongName());
			row.addElement(dto.getSinger());
			row.addElement(dto.getCount());
			row.addElement(dto.getNum());
			
			table.addRow(row);
		}
		
		wrapper_panel.setLayout(null);
		
		tableView = new JTable(table);
		scrollList = new JScrollPane(tableView);
		scrollList.setBounds(39, 366, 933, 402);
		wrapper_panel.add(scrollList);
		
		
		label = new JLabel("삭제할 노래");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(205, 800, 81, 15);
		wrapper_panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(298, 797, 116, 21);
		wrapper_panel.add(textField);
		textField.setColumns(10);
		
		
		b1 = new JButton("삭제하기");
		b1.setBounds(426, 796, 92, 23);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dao.delete(textField.getText());
					JOptionPane.showMessageDialog(wrapper_panel, "삭제되었습니다.");
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