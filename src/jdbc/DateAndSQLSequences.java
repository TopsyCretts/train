package jdbc;

import java.sql.*;
import java.util.Calendar;

public class DateAndSQLSequences {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";

        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table if not exists books(id mediumint not null auto_increment, " +
                    "name varchar(30) not null, dt DATE not null, primary key(id))");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into books(name, dt) " +
                    "values ('today',?)");
            preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
            preparedStatement.execute();
            System.out.println(preparedStatement);
            System.out.println(preparedStatement.toString().split(": ")[1]);
            statement.executeUpdate("insert into books(name, dt) values ('today2',{d'2023-10-01'})");

            ResultSet resultSet = statement.executeQuery("select * from books where id = 1 or 2");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("dt"));
                System.out.println("---------------------");
            }

        }

    }
}
