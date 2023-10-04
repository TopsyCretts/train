package jdbc.blob;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class BLOBex {
    public static void main(String[] args) throws SQLException, IOException {
        String user = "root";
        String password = "23Dek1976";
        String url = "jdbc:mysql://localhost:3306/test";

        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists books");
            statement.executeUpdate("create table if not exists books(id mediumint not null auto_increment, " +
                    "name varchar(30) not null, img BLOB, primary key(id))");

            BufferedImage image = ImageIO.read(new File("src\\swing\\img\\strb.jpg")); //firstly we should load image
            Blob blob = connection.createBlob(); // then we should create Blob object
            try(OutputStream outputStream = blob.setBinaryStream(1)){
                ImageIO.write(image,"jpg",outputStream); // here we write image to Blob
            }

            PreparedStatement preparedStatement = connection.prepareStatement("insert into " + //create PS
                    "books (name, img) values (?,?)");
            preparedStatement.setString(1,"Strawberry"); // set name
            preparedStatement.setBlob(2, blob); // set blob
            preparedStatement.execute(); //execute PS

            ResultSet resultSet = statement.executeQuery("select * from books");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                Blob blob2 = resultSet.getBlob("img");
                BufferedImage result = ImageIO.read(blob2.getBinaryStream());
                ImageIO.write(result, "jpg",new File("src\\jdbc\\blob\\"+name+".jpg"));
            }



        }

    }
}
