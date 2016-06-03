package JavaObjectOriented;

/**
 * Created by Happiness on 27.5.2016 г..
 */
public class Salary extends Employee{

    double salary;


    public void mailcheck(){
        super.mailcheck();

        System.out.println("Mailing to : "+ getName()+" "+ getLastname()+"with salary: "+getSalary());
    }


    public Salary(String name, String lastname, int age,double salary) {
        super(name,lastname,age);
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



}
