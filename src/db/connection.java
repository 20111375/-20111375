package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connection {
	protected ResultSet resultset = null;
	public connection() {
	}
	public ResultSet connect(String SQLString) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:derby:../camp/database");
            //Connection connect = DriverManager.getConnection("jdbc:derby:..\\camp\\database");
			PreparedStatement statement = connect.prepareStatement(SQLString);
			resultset = statement.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultset;
	}
}
