package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KgPlayerBbsDAO {
	
	
	public void write(KgPlayerBbsDTO dto) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into bbs value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, null);
		ps.setString(2, dto.getId());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getContent());
		
		
		ps.executeUpdate();
		con.close();
		ps.close();
	}

	public ArrayList<KgPlayerBbsDTO> selectAll() throws Exception { 
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
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
			
			int num = rs.getInt(1);
			String id = rs.getString(2);
			String title = rs.getString(3);
			String content = rs.getString(4);
			
			dto.setNo(num);
			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			
			list.add(dto);	
	}
		return list;
	
}

	public void update(KgPlayerBbsDTO dto) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update bbs set title = ? , content = ? where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		MemberDTO memDTO = new MemberDTO();
		ps.setString(1, dto.getTitle());
		ps.setString(2, dto.getContent());
		ps.setString(3, memDTO.sessionId);
		
		ps.executeUpdate();		
		
		con.close();
		ps.close();
		
	}
	
	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from bbs where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
}
