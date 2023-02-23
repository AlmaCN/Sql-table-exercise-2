import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Ho creato la classe Student
 */
public class Student {

    /**
     * Ho creato le due variabili name e surname
     */
    String name;
    String surname;

    /**
     * Ho creato il costruttore
     * @param name sara il first name dello studente
     * @param surname sara il last name dello studente
     */
    public void Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    /**
     * Ho creato il metodo getName per poter prendere il name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Ho creato il metodo getSunrname per poter prendere il surname
     * @return surname
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Ho creato il metodo italianStudents in cui mi sono connessa nuovamente al db e all'interno ho creato l'ArrayList
     * italianStudents.
     * Attravero un ciclo while ho preso dal db first name e last name dello studento e l'ho aggiunto al ArrayList
     * italianStudents.
     * @return ArrayList italianStudents
     */
    public ArrayList<Student> italianStudents() {
        ArrayList<Student> italianStudents = new ArrayList<Student>();

        String dburl = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "DeVe1234@#";

        Connection connection;

        try {

            connection = DriverManager.getConnection(dburl, user, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM italian_students;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();

                student.Student(rs.getString("first_name"), rs.getString("last_name"));
                italianStudents.add(student);

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return (italianStudents);
    }

    /**
     * Ho creato il metodo italianStudents in cui mi sono connessa nuovamente al db e all'interno ho creato l'ArrayList
     * germanStudents.
     * Attravero un ciclo while ho preso dal db first name e last name dello studento e l'ho aggiunto al ArrayList
     * germanStudents.
     * @return ArrayList germanStudents
     */
    public ArrayList<Student> germanStudents() {
        ArrayList<Student> germanStudents = new ArrayList<Student>();

        String dburl = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "DeVe1234@#";

        Connection connection;

        try {

            connection = DriverManager.getConnection(dburl, user, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM german_students;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();

                student.Student(rs.getString("first_name"), rs.getString("last_name"));
                germanStudents.add(student);

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return (germanStudents);
    }

}
