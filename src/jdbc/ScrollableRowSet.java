package jdbc;

import java.sql.*;

public class ScrollableRowSet {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table if not exists books(id mediumint auto_increment not null " +
                    ", name varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into books(name) values ('Inferno')");
            statement.executeUpdate("insert into books(name) values ('DaVinci Code')",Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate("insert into books(name) values ('Solomon Key')");
            statement.executeUpdate("insert into books(name) values ('Green house')");

            Statement statementRes = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            //PreparedStatement preparedStatement = connection.prepareStatement("", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statementRes.executeQuery("select * from books");
            System.out.println("next");
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");

            System.out.println("next");
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");

            System.out.println("previous");
            if (resultSet.previous())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("relative 2");
            if (resultSet.relative(2))
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");

            System.out.println("relative -2");
            if (resultSet.relative(-2))
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("first");
            if (resultSet.first())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");

            System.out.println("last");
            if (resultSet.last())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("before first");
            System.out.println("next");
            resultSet.beforeFirst();
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            System.out.println("--------------");







        }
    }
}
