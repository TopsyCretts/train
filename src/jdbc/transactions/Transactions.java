package jdbc.transactions;

import java.sql.*;

public class Transactions {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table if not exists books(id mediumint auto_increment not null " +
                    ", name varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into books(name) values ('Inferno')");
            Savepoint savepoint = connection.setSavepoint();
            statement.executeUpdate("insert into books(name) values ('Solomon Key')");
            statement.executeUpdate("insert into books(name) values ('Angles And Demons')");
            connection.rollback(savepoint);
            connection.commit();
            connection.releaseSavepoint(savepoint);

        }
    }
}
