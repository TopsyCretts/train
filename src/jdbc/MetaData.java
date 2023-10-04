package jdbc;

import java.sql.*;

public class MetaData {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables("test",null,null,
                    new String[]{"TABLE"});
            while (resultSet.next()){
                System.out.println(resultSet.getString(3));
            }

           System.out.println("---------------");
            statement.executeQuery("select * from books");
            ResultSet resultSet2 = statement.getResultSet();
            ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                System.out.println(resultSetMetaData.getColumnLabel(i));
            }
        }
    }
}
