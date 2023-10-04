package jdbc.transactions;

import java.sql.*;

public class TransactionsLevels {
    public static void main(String[] args) throws SQLException, InterruptedException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // to repair - COMMITTED
            statement.execute("update books set name = 'New Value' where id = 2");
            new OtherTransactionDirtyReads().start();
            Thread.sleep(2000);
            connection.rollback(); //dirty read

            System.out.println("--------------");

            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ResultSet resultSetNoneRepeat = statement.executeQuery("select * from books");
            while (resultSetNoneRepeat.next()){
                System.out.println(resultSetNoneRepeat.getString("name"));
            }
            System.out.println();

            new OtherTransactionNoneRepeatable().start();
            Thread.sleep(3000);

            ResultSet resultSetNoneRepeat2 = statement.executeQuery("select * from books");
            while (resultSetNoneRepeat2.next()){
                System.out.println(resultSetNoneRepeat2.getString("name"));
            } //none repeatable

            System.out.println("---------------");

            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ResultSet resultSetSerial = statement.executeQuery("select count(*) from books");
            while (resultSetSerial.next()){
                System.out.println(resultSetSerial.getInt(1));
            }

            System.out.println();
            new OtherTransactionSerialization().start();
            Thread.sleep(2000);

            ResultSet resultSetSerial2 = statement.executeQuery("select count(*) from books");
            while (resultSetSerial2.next()){
                System.out.println(resultSetSerial2.getInt(1));
            } //serial


        }

    }
    public static class OtherTransactionDirtyReads extends Thread{
        @Override
        public void run() {
            String user = "root";
            String password = "23Dek1976";
            String url = "jdbc:mysql://localhost:3306/test";
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                ResultSet resultSet = statement.executeQuery("select * from books");
                while (resultSet.next()){
                    System.out.println(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static class OtherTransactionNoneRepeatable extends Thread{
        @Override
        public void run() {
            String user = "root";
            String password = "23Dek1976";
            String url = "jdbc:mysql://localhost:3306/test";
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                statement.executeUpdate("update books set name = 'None' where id = 1");
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static class OtherTransactionSerialization extends Thread{
        @Override
        public void run() {
            String user = "root";
            String password = "23Dek1976";
            String url = "jdbc:mysql://localhost:3306/test";
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                statement.executeUpdate("insert into books(name) values ('new Book')");
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
