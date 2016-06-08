package JavaObjectOriented;

/**
 * Created by Happiness on 8.6.2016 г..
 */
public class B extends A {
    int age;

    public B(String name, String lastname, int age) {
        super(name, lastname);
        this.age = age;
    }

    public void information(){
        System.out.println(this.name + " " + this.lastname + "->" + this.age);
    }
}
