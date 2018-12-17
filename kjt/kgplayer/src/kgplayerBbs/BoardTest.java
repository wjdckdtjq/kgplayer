package kgplayerBbs;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BoardTest extends JFrame{
 /*
  * JTable에 보여질 실제 데이터를 조작하는 객체!!
  * 테이블은 껍데기
  * */
 TableModel model;
 JTable table;
 JScrollPane scroll;
 
 public BoardTest(){
  /*
   * Tablemodel은 JTable이 데이터를 조작할 수 있도록
   * 많은 메서드를 지원해주는 객체인데, 인터페이스로 되어있다.
   * 하지만 sun에서는 이 인터페이스를 구현한 추상클래스인 AbstractTableModel을 지원해주므로
   * 개발자는 이  추상클래스를 재정의하여 사용하면 된다!
   * */
  model = new AbstractTableModel(){

  
   public int getColumnCount() {
    return 5;
   }

   
   public int getRowCount() {
    return 10;
   }

   
   public Object getValueAt(int arg0, int arg1) {
    return null;
   }
   
   
  };
  table = new JTable(model);
  scroll = new JScrollPane(table);
  
  add(scroll);
  
  setSize(500,150);
  setVisible(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  
 }
 
 public static void main(String[] args) {
  new BoardTest();
 }
}
