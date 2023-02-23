import java.sql.*;
import java.util.ArrayList;


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

            // ---------------------------------------------------------------------------------------------------------

            /**
             * Ho creato un oggetto rs di tipo ResultSet in cui ho selezionato la tabella
             */
            ResultSet rs = statement.executeQuery("SELECT * FROM newdb.students");

            /**
             * Ho creato un ulteriore metodo try catch
             */
//            try {
//                while (rs.next()) {
//
//                    /**
//                     * Ho assegnato a names e all'array surnames le rispettive colonne, ed ho stampato in console
//                     * prima i nome, e poi l'array di stringhe.
//                     */
//                    String names = rs.getString(2);
//                    String[] surnames = {rs.getString(3)};
//                    System.out.println(names);
//                    System.out.println(Arrays.toString(surnames));
//                }
//            } catch (Exception e){
//                System.out.println(e);
//            }

            //----------------------------------------------------------------------------------------------------------

            /**
             * Ho creato la nuova colonna chiamata country attraverso ALTER TABLE e ADD
             */
//            statement.execute("alter table newdb.students add country varchar(30);");

            /**
             * Ho poi fatto il SET del country con la parola UPDATE, Italy per i primi due studenti, e Germany per gli
             * ultimi 2
             */
//            statement.execute("update newdb.students set country = 'Italy' where student_id = 1;");
//            statement.execute("update newdb.students set country = 'Italy' where student_id = 2;");
//            statement.execute("update newdb.students set country = 'Germany' where student_id = 3;");
//            statement.execute("update newdb.students set country = 'Germany' where student_id = 4;");


            //---------------------------------------Esercizio VIEW-----------------------------------------------

            /**
             * Ho creato le due view, italian_students e german_students e le ho eseguite (su workbench sono presenti
             * e funzionanit)
             */
//            statement.execute("CREATE VIEW italian_students AS " +
//                    "SELECT last_name, first_name " +
//                    "FROM students " +
//                    "WHERE country = 'Italy';");
//
//            statement.execute("CREATE VIEW german_students AS " +
//                    "SELECT last_name, first_name " +
//                    "FROM students " +
//                    "WHERE country = 'Germany';");

            System.out.println("---Italian Students---");

            /**
             * Ho creato un ArrayList di italianStudent, succesivamente attraverso l'oggetto rs di tipo ResultSet ho
             * eseguito la query per elezionare la view italian_students.
             * Attraverso un ciclo while ho dato aggiunto i due studenti all'ArrayList.
             * Attraverso un ciclo for sono andata a richiamare i dati dell'ArrayList
             */
            ArrayList<Student> italianStudent = new ArrayList<>();
            rs = statement.executeQuery("select * from italian_students;");
            while(rs.next()){
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                italianStudent.add(new Student(name, surname));
            }

            for(Student student : italianStudent){
                System.out.println(student.getName() + " " + student.getSurname());
            }

            System.out.println("---German Students---");

            /**
             * Ho creato un ArrayList di germanStudent, succesivamente attraverso l'oggetto rs di tipo ResultSet ho
             * eseguito la query per elezionare la view german_students.
             * Attraverso un ciclo while ho dato aggiunto i due studenti all'ArrayList.
             * Attraverso un ciclo for sono andata a richiamare i dati dell'ArrayList
             */
            ArrayList<Student> germanStudent = new ArrayList<>();
            rs = statement.executeQuery("select * from german_students;");
            while(rs.next()){
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                germanStudent.add(new Student(name, surname));
            }

            for(Student student : germanStudent){
                System.out.println(student.getName() + " " + student.getSurname());
            }

        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
