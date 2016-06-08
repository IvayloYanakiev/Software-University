package JavaObjectOriented;

import java.util.Hashtable;

/**
 * Created by Happiness on 27.5.2016 г..
 */
public class TestingEmployee {
    public static void main(String[] args) {
        Employee employee = new Salary("Ivailo","Qnakiev",21,13500);
        Salary salary = new Salary("Todor","Boichev",13,2600.5) ;
        employee.mailcheck();
        System.out.println("-----------------");
        salary.mailcheck();

    }

}
