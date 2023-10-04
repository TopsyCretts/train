package jdbc;

import java.sql.*;

public class UpdateResultSet {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists books ");
            statement.executeUpdate("create table if not exists books(id mediumint not null auto_increment, " +
                    "name varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into books(name) values ('Inferno')");
            statement.executeUpdate("insert into books(name) values ('Solomon Key')");

            Statement statementUpdate = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statementUpdate.executeQuery("select * from books");
            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("----------------");
            resultSet.last();
            resultSet.updateString("name", "New Value");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "Inserted");
            resultSet.insertRow();

            resultSet.absolute(2);
            resultSet.deleteRow();
            statementUpdate.execute("call setBooksId()");


            ResultSet resultSet2 = statementUpdate.executeQuery("select * from books");
            while (resultSet2.next()){
                System.out.println(resultSet2.getString("id"));
                System.out.println(resultSet2.getString("name"));
            }
        }
    }
}
