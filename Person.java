/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 10/27/23
 * Assignment: CIS319 Week 4 GP - Database Interactions
 * 
 * Class that represents an individual person record from Persons
 * table in the database. Note that the properties are public in this
 * case as this is purely used to hold data from the Persons
 * table.
*/
public class Person {
    public int ID;
    public String FirstName;
    public String LastName;
    public int Age;

    public Person(int iD, String firstName, String lastName, int age) {
        ID = iD;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public Person(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public Person() {

    }
    
}
