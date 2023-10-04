package jdbc;

import java.sql.*;

public class Batch {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.addBatch("drop table if exists books");
            statement.addBatch("create table if not exists books(id mediumint auto_increment not null " +
                    ", name varchar(30) not null, primary key (id))");
            statement.addBatch("insert into books(name) values ('Inferno')");
            statement.addBatch("insert into books(name) values ('Solomon Key')");
            statement.addBatch("insert into books(name) values ('Angles And Demons')");

            if (statement.executeBatch().length == 5){
                connection.commit();
            } else connection.rollback();

        }
    }
}
