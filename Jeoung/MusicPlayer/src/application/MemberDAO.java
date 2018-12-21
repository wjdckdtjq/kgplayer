package application;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MemberDAO {

	public void insert(MemberDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into member value(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getTel());
		ps.setString(5, dto.getAdress());
		ps.setInt(6, dto.getPoint());

		ps.executeUpdate();

		con.close();
		ps.close();
	}
	public void insertSongList(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into memberSongList value(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,id);
		ps.setString(2,"5.mp3");
		
		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	
	public MemberSongList selectSongList(MemberSongList list) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from memberSongList where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, list.getId());

		ResultSet rs = ps.executeQuery();
		MemberSongList list2 = null;
		while (rs.next()) {
			list2 = new MemberSongList();
			list2.setId(rs.getString(1));
			list2.setFileName(rs.getString(2));
		}
		
		con.close();
		ps.close();
		
		return list2;
	}
	

	public MemberDTO select(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setTel(rs.getString(4));
//			dto.setPoint(rs.getInt(5));

		}

		con.close();
		ps.close();
		rs.close();

		return dto;
	}
	
	public MemberDTO selectId(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setTel(rs.getString(4));
			dto.setAdress(rs.getString(5));
			dto.setPoint(rs.getInt(6));
			
		}
		
		con.close();
		ps.close();
		rs.close();
		return dto;
	}
	public boolean idCheck(String id) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select count(id) from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
	
		ResultSet rs = ps.executeQuery();
		
		int result = 0;
		if(rs.next()) {
			result = Integer.valueOf(rs.getString(1));
		}
		
	

		con.close();
		ps.close();
		rs.close();

		return (result > 0) ? true : false;
	}
	
	
	public ArrayList<MemberDTO> selectinfo(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setTel(rs.getString(4));
			dto.setAdress(rs.getString(5));
			dto.setPoint(rs.getInt(6));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}
	
	
	public MemberDTO selectName(String name) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setTel(rs.getString(4));
			
		}
		
		con.close();
		ps.close();
		rs.close();
		
		return dto;
	}

	public ArrayList<MemberDTO> selectAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setTel(rs.getString(4));
			dto.setAdress(rs.getString(5));
			dto.setPoint(rs.getInt(6));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}

	public void delete(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		con.close();
		ps.close();
	}
	
	public void pointId(String id, int point) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update member set point = point+? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, point);
		ps.setString(2, id);
		ps.executeUpdate();
		con.close();
		ps.close();
		
	}
	
	public void updateSongList(MemberSongList list) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update memberSongList set songlist = concat(songList, ?) where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, "," + list.getFileName());
		ps.setString(2, list.getId());

		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	public void updateAllSongList(MemberSongList list) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update memberSongList set songlist =? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, list.getFileName());
		ps.setString(2, list.getId());

		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	public void update(String id, String pw, String name, String tel, String adress) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update member set pw = ?, name = ?, tel = ?, adress = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pw);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, adress);
		ps.setString(5, id);


		ps.executeUpdate();

		con.close();
		ps.close();
	}

}