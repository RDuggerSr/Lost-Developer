/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 10/27/23
 * Assignment: CIS319 Week 4 GP - Database Interactions
 *
 * Main application class.
*/
import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        final String dbName = "Dugger.db";
        System.out.println("\nRodney Dugger Sr, Week 4 Database Interactions GP\n");
        Connection conn = SQLiteDatabase.connect(dbName);

        if (conn != null) {
            if (PersonDb.createTable(conn)) {
                //Create
                PersonDb.addPerson(conn, new Person("Rodney", "Dugger", 16));
                PersonDb.addPerson(conn, new Person("John", "Smith", 45));
                PersonDb.addPerson(conn, new Person("Jane", "Jones", 24));
                PersonDb.addPerson(conn, new Person("Joe", "Diffy", 61));

                //Update
                Person personToUpdate = new Person(2, "James", "Smith", 37);
                PersonDb.updatePerson(conn, personToUpdate);
                Person updatedPerson = PersonDb.getPerson(conn, personToUpdate.ID);
                System.out.println("\nUpdate Person");
                printPerson(updatedPerson);

                //Delete
                PersonDb.deletePerson(conn, personToUpdate.ID);
                System.out.println("\nAllPeople in the Database");
                printPeople(PersonDb.getAllPeople(conn));
            }
        }
    }
    private static void printPeople(ArrayList<Person> people) {
        for (Person p : people) {
            printPerson(p);
        }
    }

    private static void printPerson(Person p) {
        System.out.print("Person " + p.ID + ": ");
        System.out.print(p.FirstName + " " + p.LastName + " is "
            + p.Age + " years old\n");
    }
}
