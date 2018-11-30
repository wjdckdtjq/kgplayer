package melon;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MemberDAO {


	
	public void insert(MemberDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer";
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

	public MemberDTO select(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer";
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

		}

		con.close();
		ps.close();
		rs.close();

		return dto;
	}

	public ArrayList<MemberDTO> selectAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/kgplayer";
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
			dto.setAdress(rs.getString(5), rs.getString(5));
			dto.setPoint(rs.getInt(6));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}

	

	
}