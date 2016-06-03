package JavaObjectOriented;

/**
 * Created by Happiness on 27.5.2016 г..
 */
public class MyCalculation extends Calculation{

    public void Izvajdane(int a , int b){
        int z = a-b;
        System.out.println("Izvajdane:"+z);
    }

    public static void main(String[] args) {
        MyCalculation smqtach = new MyCalculation();
        smqtach.Izvajdane(10,5);
        smqtach.Umnojenie(10,5);
        smqtach.Subirane(10,5,5);
    }
}
