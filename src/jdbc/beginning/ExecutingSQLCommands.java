package jdbc.beginning;

import java.sql.*;

public class ExecutingSQLCommands {
    public static void main(String[] args) {
        String userName = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";

        try(Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement()){
            //statement.executeUpdate("drop table Books");
            //statement.executeUpdate("create table Books (id mediumint not null auto_increment, name varchar (30) not null, PRIMARY KEY (id)) ");
            //statement.executeUpdate("insert into Books (name) values ('Inferno')");
            //statement.executeUpdate("insert into Books (name) values ('Solomon Key')");

            ResultSet resultSet = statement.executeQuery("select * from Books");
            while (resultSet.next()){
                /*System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));*/
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println("-----------------");
            }
            ResultSet resultSet1 = statement.executeQuery("select name from books where id = 1");
            while (resultSet1.next()){
                System.out.println(resultSet1.getString(1));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
