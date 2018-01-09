package br.com.cwmconsultoria.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://192.168.15.10:3306/financas_db", "root", "cwmRoot15") ;
		//return DriverManager.getConnection("jdbc:mysql://cwmnote:3306/financas_db", "root", "cwmRoot15") ;
	}
}