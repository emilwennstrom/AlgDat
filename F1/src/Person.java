public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Compares two Person objects
     * @param per the Person to compare with
     * @return 0 if equal, 1 if object is "bigger",
     * -1 if param is "bigger"
     */
    public int compareTo(Person per) {
        if (lastName.equals(per.lastName))
            return firstName.compareTo(per.firstName);
        else return lastName.compareTo(per.lastName);
    }

    public void changeLastName(boolean justMarried, String newLast) {
        if (justMarried) {
            this.lastName = newLast;
        }
    }

}
