package ch05.abstractClasses;


public class PersonTest {
    public static void main(String[] args) {
        var people = new Person[2];
        people[0] = new Employee("ttr", 50000, 1999, 10, 9);
        people[1] = new Student("lrl", "mks");

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}

