package kgplayerBbs;

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

import javax.swing.JTabbedPane;

public class KgPlayerListBbs extends JFrame{
	
	//수정은 Jtable
	//기본목록은 무엇으로
	
	KgPlayerBbsDAO dao = new KgPlayerBbsDAO();
	KgPlayerBbsDTO dto = new KgPlayerBbsDTO();
	
//    
//	for (int i = 0; i < dto.count; i++) {
//	       for (int j = 0; j < 4; j++) {
//                rowData[i][j] = dao.selectAll();
//            }
//        }
//	
	public KgPlayerListBbs() throws Exception {
		
//		TableModel model = new AbstractTableModel(){
			
		    String title [] = {"넘버", "제목", "작성자", "내용"};
		    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row2-Column3"},
		            { "Row2-Column1", "Row2-Column2", "Row2-Column3", "Row2-Column3"} };
		    
//		jTABLE마김, 모델설정 헷갈림
		
		setSize(810,748);
		getContentPane().setLayout(null);
		
		JButton Button1 = new JButton("등록하기");
		Button1.setBounds(551, 57, 97, 23);
		getContentPane().add(Button1);
		
		JButton Button2 = new JButton("수정하기");
		Button2.setBounds(660, 57, 97, 23);
		getContentPane().add(Button2);
		
		JLabel Label1 = new JLabel("자유게시판");
		Label1.setFont(new Font("문체부 궁체 흘림체", Font.BOLD, 28));
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(95, 30, 427, 68);
		getContentPane().add(Label1);

		JPanel jp = new JPanel();
		getContentPane().add(jp, new BorderLayout().CENTER);
		
		JTable table = new JTable(rowData, title);
	    JScrollPane sp = new JScrollPane(table);
	    jp.add(sp, new BorderLayout().SOUTH);
	    table.setBounds(62, 175, 637, 469);
	    
	    setVisible(true);
		
	}
	
	public static void main(String[]args) throws Exception {
		new KgPlayerListBbs();
	}
}
