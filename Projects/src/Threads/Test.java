package Threads;

public class Test {
    public static void main(String args[]) {

        Testing T1 = new Testing( "Thread-1");

        Testing T2 = new Testing( "Thread-2");
        T1.start();

        T2.start();
    }
}