package ch05.inheritance;

public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("ttr",80000,1999,10,9);
        boss.setBonus(50000);

        var staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("lrl", 10000, 1997, 8, 5);
        staff[2] = new Employee("lrlaaa", 20000, 1997, 8, 5);

        for(Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
    }
}
