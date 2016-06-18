package JavaObjectOriented;


public class Proba {
    private int sum ;

    private boolean Plusone(){
        sum++;
        return true;
    }

    private boolean Plustwo(){
        sum+=2;
        return false;
    }

    protected int Example(){
        sum=1;
        if(Plustwo() || Plusone()){
            return sum;
        }
        else { return -1;}
    }

    public static void main(String[] args) {
        Proba proba = new Proba();
        System.out.println(proba.Example());

    }

}
