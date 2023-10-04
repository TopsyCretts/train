package jdbc.beginning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";

        try(Connection connection = DriverManager.getConnection(url,name,password)){
            System.out.println("connected");
        }
    }
}
