package xx.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtils {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.100.102:3306/test";
		String user = "root";
		String password = "1219root";
		String imageFile = "src" + File.separator + "images" + File.separator + "forests1.jpg";

		try {
			org.apache.commons.dbutils.DbUtils.loadDriver(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			QueryRunner queryRunner = new QueryRunner();
			List<String> list = queryRunner.query(conn, "select * from string", new BeanListHandler<>(String.class));
		

			org.apache.commons.dbutils.DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
