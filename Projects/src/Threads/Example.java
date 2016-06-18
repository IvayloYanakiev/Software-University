package Threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Happiness on 18.6.2016 г..
 */
public class Example{
    static List<Integer> list ;

    public static void main(String[] args) {
        list = new ArrayList<>();
        for (int i = 0; i < 100100; i++) {
            list.add(i);
        }

        List<Thread> threadlist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> EmptyList());
            threadlist.add(thread);
            thread.start();
        }
        for (Thread thread : threadlist) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.size());
    }

    private static void EmptyList() {
        synchronized (list){
            while(list.size()>0){
                list.remove(list.size()-1);
            }
        }

    }
}
