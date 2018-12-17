package kgplayerBbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KgPlayerBbsDAO {
	
	
	public void write(KgPlayerBbsDTO dto) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into bbs value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getTel());
		
		ps.executeUpdate();
		con.close();
		ps.close();
	}
	
	public ArrayList<KgPlayerBbsDTO> select(String Id) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from bbs where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Id);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<KgPlayerBbsDTO> list = new ArrayList<KgPlayerBbsDTO>();
		KgPlayerBbsDTO dto;
		
		while (rs.next()) {
			dto = new KgPlayerBbsDTO();
			
			dto.setId(rs.getString(1));
			dto.setTitle(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setTel(rs.getString(4));
			
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}
	

	public ArrayList<KgPlayerBbsDTO> selectAll() throws Exception { 
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		KgPlayerBbsDTO dto = null;
		ArrayList<KgPlayerBbsDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			dto = new KgPlayerBbsDTO();
			
			String id = rs.getString(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String tel = rs.getString(4);
			
			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setTel(tel);
			
			list.add(dto);	
	}
		return list;
	
}
	

	public void update(String content, String id) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update bbs set content = ? where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, content);
		ps.setString(2, id);
		ps.executeUpdate();		
		
		con.close();
		ps.close();
		
	}
	

	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from bbs where id = ?";
		
		// 정말 삭제하시려면 아이디를 한번더 입력해주세요 를 넣어 아이디를 적도록 유도하기
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	
}
