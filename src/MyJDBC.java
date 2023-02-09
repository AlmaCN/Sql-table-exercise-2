import java.sql.*;


public class MyJDBC {


    public static void main(String[] args) {

        String dburl = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "DeVe1234@#";

        Connection connection;

        try{
            connection = DriverManager.getConnection(dburl, user, password);
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS students " +
                    "(student_id INT(10) NOT NULL AUTO_INCREMENT, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30), " +
                    "CONSTRAINT pk_students PRIMARY KEY (student_id)" +
                    ");");
            statement.execute("insert into students (last_name, first_name) values ('Rossi', 'Mario');");
            statement.execute("insert into students (last_name, first_name) values ('Bianchi', 'Giulia');");
            statement.execute("insert into students (last_name, first_name) values ('Solaro', 'Roberta');");
            statement.execute("insert into students (last_name, first_name) values ('Cielo', 'Ronaldo');");

        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
