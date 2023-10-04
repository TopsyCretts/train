package jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class CachedRowSetEx {
    public static void main(String[] args) throws SQLException {

        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";
        ResultSet resultSet = getData(url,user,password);
        workWithData(resultSet,url,user,password);
    }
    public static ResultSet getData(String url, String user, String password) throws SQLException {
        try(Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists books ");
            statement.executeUpdate("create table if not exists books(id mediumint not null auto_increment, " +
                    "name varchar(30) not null, primary key (id))");
            statement.executeUpdate("insert into books(name) values ('Inferno')", Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate("insert into books(name) values ('Solomon Key')", Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate("insert into books(name) values ('Angles And Demons')", Statement.RETURN_GENERATED_KEYS);

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            CachedRowSet crs = rowSetFactory.createCachedRowSet();

            Statement statementResult = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statementResult.executeQuery("select * from books");
            crs.populate(resultSet);
            return crs;
        }
    }
    public static void workWithData(ResultSet resultSet,String url, String user, String password ) throws SQLException {
        /*CachedRowSet rowSet = (CachedRowSet) resultSet;

        rowSet.setUrl(url);
        rowSet.setUsername(user);
        rowSet.setPassword(password);

        rowSet.setCommand("select * from books where id = ?");
        rowSet.setInt(1,1);
        rowSet.setPageSize(20);
        rowSet.execute();
        do {
            while (rowSet.next()){
                System.out.println(rowSet.getString("id"));
                System.out.println(rowSet.getString("name"));
            }
        } while (rowSet.nextPage());*/

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setTableName("books");
        cachedRowSet.absolute(2);
        cachedRowSet.deleteRow();
        cachedRowSet.beforeFirst();
        while (cachedRowSet.next()){
            System.out.println(cachedRowSet.getString("id"));
            System.out.println(cachedRowSet.getString("name"));
        }
        //cachedRowSet.acceptChanges();
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        cachedRowSet.acceptChanges(connection);

    }

}
