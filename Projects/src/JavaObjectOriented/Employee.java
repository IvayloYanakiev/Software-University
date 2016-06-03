package JavaObjectOriented;

/**
 * Created by Happiness on 27.5.2016 г..
 */
public class Employee {
    String name ;
    String lastname;
    int age;
public void mailcheck(){
    System.out.println("Mailing to : "+ getName()+" "+ getLastname());
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

}
