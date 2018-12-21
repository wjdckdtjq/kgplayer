package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import application.MusicDTO;
import application.MemberDTO;

public class MusicDAO {
	
	public void insert(MusicDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		//?useUnicode=true&characterEncoding=utf8
		String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into songinfo values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getSongName());
		ps.setString(2, dto.getSinger());
		ps.setInt(3, dto.getCount());
		ps.setInt(4, dto.getNum());
		
		ps.executeUpdate();

		con.close();
		ps.close();
	}

	public void countUp(String songName, int count) throws Exception {
	      String url = "jdbc:mysql://localhost:3306/Kgplayer?useUnicode=true&characterEncoding=utf8";
	      String user = "root";
	      String password = "1234";
	      
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection(url, user, password);
	      String sql = "update songinfo set count = count+? where songName = ?";
	      PreparedStatement ps = con.prepareStatement(sql);
	      ps.setInt(1, count + 1);
	      ps.setString(2, songName);
	      ps.executeUpdate();
	      con.close();
	      ps.close();
	      
	   }
	
	
	public MusicDTO select(int num) throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from songinfo where num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, num);

		ResultSet rs = ps.executeQuery();
		MusicDTO dto = null;
		while (rs.next()) {
			dto = new MusicDTO();
			dto.setSongName(rs.getString(1));
			dto.setSinger(rs.getString(2));
			dto.setCount(rs.getInt(3));
			dto.setNum(rs.getInt(4));
		}

		con.close();
		ps.close();
		rs.close();

		return dto;
	}
	
	
	public ArrayList<MusicDTO> selectAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from songinfo ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
		MusicDTO dto;
		while (rs.next()) {
			dto = new MusicDTO();
			dto.setSongName(rs.getString(1));
			dto.setSinger(rs.getString(2));
			dto.setCount(rs.getInt(3));
			dto.setNum(rs.getInt(4));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}
	
	
	public void delete(String songName) throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from songinfo where songName = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, songName);
		ps.executeUpdate();
		con.close();
		ps.close();
	}
}
