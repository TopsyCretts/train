package jdbc.procedures;

import java.sql.*;

public class ProceduresEx {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table if not exists books(id mediumint auto_increment not null " +
                    ", name varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into books(name) values ('Inferno')");
            statement.executeUpdate("insert into books(name) values ('Solomon Key')");

            CallableStatement callableStatement = connection.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("---------------");

            CallableStatement callableStatement2 = connection.prepareCall("{call getBooks(?)}");
            callableStatement2.setInt(1, 2);
            if (callableStatement2.execute()){
                ResultSet resultSet = callableStatement2.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                    System.out.println("-----------");
                }
            }
        }
    }

}
