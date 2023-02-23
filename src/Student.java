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
    public Student(String name, String surname){
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

}
