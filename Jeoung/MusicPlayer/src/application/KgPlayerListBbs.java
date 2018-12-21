package application;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KgPlayerListBbs extends JPanel {
	
	// id가져와서 입력할때 보여주기 - 외부키
	// 수정할때 id title content 다 보여주기 - id 외부키, title content 내꺼
	// 차트 count 받은걸로 숫자넣고, 옆에 세부내용 보여주기
	// 시간되면 google 차트
	
	KgPlayerBbsDAO dao = new KgPlayerBbsDAO();
	KgPlayerBbsDTO dto = new KgPlayerBbsDTO();

	ArrayList<KgPlayerBbsDTO> list = dao.selectAll();	
	
	String title [] = {"넘버", "작성자", "제목", "내용"};
	Object rowData[][] = new Object[list.size()][4];
	
	public KgPlayerListBbs() throws Exception {

		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = list.get(i).getNo();
			rowData[i][1] = list.get(i).getId();
			rowData[i][2] = list.get(i).getTitle();
			rowData[i][3] = list.get(i).getContent();
		}
        
		setSize(810,748);
		setLayout(null);
		
		JButton Button1 = new JButton("등록하기");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KgPlayerWriteBbs insert = new KgPlayerWriteBbs();
				
			}
		});
		Button1.setBounds(658, 87, 97, 36);
		add(Button1);
		
		JLabel Label1 = new JLabel("자유게시판");
		Label1.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(170, 31, 427, 68);
		add(Label1);

		DefaultTableModel mod = new DefaultTableModel(rowData, title) {	
		        public boolean isCellEditable(int rowIndex, int mColIndex) {
		                return false;
		            }
		        };

		JTable table = new JTable(mod);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BbsUpdateAndDelete upAndDel = new BbsUpdateAndDelete();
			}
		});
	    JScrollPane sp = new JScrollPane(table);
	    add(sp, new BorderLayout().SOUTH);
	    sp.setBounds(35, 133, 719, 548);

	    setVisible(true);
		
	}
	
}
