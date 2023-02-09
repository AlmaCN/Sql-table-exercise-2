import java.sql.*;
import java.util.Arrays;


public class MyJDBC {


    public static void main(String[] args) {

        /**
         * Ho creato le tre variabili per storare i miei valori
         * dburl per l'url del database
         * user per develoer
         * passord per la password usata
         */
        String dburl = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "DeVe1234@#";

        /**
         * Ho creato un oggetto connection di tipo connection
         */
        Connection connection;

        /**
         * Ho creato un try catch in cui ho connesso il codice al database attraverso il DriveManager
         */
        try{
            connection = DriverManager.getConnection(dburl, user, password);

            /**
             * Ho creato un oggetto di tipo statement
             */
            Statement statement = connection.createStatement();

            /**
             * Ho creato la tabella, ed in seguito ho aggiunto IF NOT EXISTS per non ricevere errori
             */
            statement.execute("CREATE TABLE IF NOT EXISTS students " +
                    "(student_id INT(10) NOT NULL AUTO_INCREMENT, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30), " +
                    "CONSTRAINT pk_students PRIMARY KEY (student_id)" +
                    ");");

            /**
             * Ho aggiuno i 4 studenti con nomi casuali al database
             */
//            statement.execute("insert into students (last_name, first_name) values ('Rossi', 'Mario');");
//            statement.execute("insert into students (last_name, first_name) values ('Bianchi', 'Giulia');");
//            statement.execute("insert into students (last_name, first_name) values ('Solaro', 'Roberta');");
//            statement.execute("insert into students (last_name, first_name) values ('Cielo', 'Ronaldo');");

            /**
             * Ho creato un oggetto rs di tipo ResultSet in cui ho selezionato la tabella
             */
            ResultSet rs = statement.executeQuery("SELECT * FROM newdb.students");

            /**
             * Ho creato un ulteriore metodo try catch
             */
            try {
                while (rs.next()) {

                    /**
                     * Ho assegnato a names e all'array surnames le rispettive colonne, ed ho stampato in console
                     * prima i nome, e poi l'array di stringhe.
                     */
                    String names = rs.getString(2);
                    String[] surnames = {rs.getString(3)};
                    System.out.println(names);
                    System.out.println(Arrays.toString(surnames));
                }
            } catch (Exception e){
                System.out.println(e);
            }


        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
