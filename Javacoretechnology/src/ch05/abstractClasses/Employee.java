package ch05.abstractClasses;

import java.time.LocalDate;

public class Employee extends Person
{

    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day)
    {
        super(n);
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }



    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

}
