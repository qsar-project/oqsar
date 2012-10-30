package agentClasses;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class lflList extends ArrayList {
	public static lflList GetlflList(){
		Connection connection;
		lflList list = new lflList();
		try {
			// �������� ��������
			String driverName = "com.mysql.jdbc.Driver"; 

			Class.forName(driverName);

			// Create a connection to the database
			String serverName = "localhost";
			String mydatabase = "db_name";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String password = "root";

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("is connect to DB" + connection);

			CallableStatement Cstmt = connection.prepareCall("{call GetlflList}");

			Cstmt.execute();
			ResultSet rs = Cstmt.getResultSet();
			lflInfo info;
			while (rs.next()) {
				info = new lflInfo();
				info.SetAgentID(rs.getInt("AgentID"));
				info.SetFst(rs.getFloat("Fst"));
				info.SetMolarMass(rs.getInt("MolarMass"));
				info.SetName(rs.getString("Name"));
				info.SetSmiles(rs.getString("SMILES"));
				info.SetValue(rs.getFloat("Value"));
				list.add(info);
			} // end while

			connection.close();
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Could not find the database driver
		} catch (SQLException e) {
			e.printStackTrace();
			// Could not connect to the database
		}
		return list;
	}
}
