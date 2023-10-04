package jdbc;

import java.sql.*;

public class InjectionAndPreparementStatement {
    public static void main(String[] args) {
        String userName = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";

        try (Connection connection = DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table users");
            statement.executeUpdate("create table if not exists Users (id mediumint not null auto_increment, " +
                    "name varchar(30) not null, password varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into users (name, password) values ('topsy','123')");
            statement.executeUpdate("insert into users SET name = 'other guy', password = '321'");

          /*  String userId = "1";
            ResultSet resultSet = statement.executeQuery("select * from users where id = '"+userId+"'");
            while (resultSet.next()){
                System.out.println("username = " + resultSet.getString("name"));
                System.out.println("password = " + resultSet.getString("password"));
            }*/
            String userIdInjection = "1' or 1 = '1";
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
                preparedStatement.setString(1, userIdInjection);
                //preparedStatement.setString(2, "userName");
                ResultSet resultSet1 = preparedStatement.executeQuery();
                while (resultSet1.next()){
                    System.out.println("username = " + resultSet1.getString("name"));
                    System.out.println("password = " + resultSet1.getString("password"));
                }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
