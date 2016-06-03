package SetsMaps;


import java.util.ArrayList;
import java.util.Scanner;

public class CrossFire {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int count = 1;
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> asd = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                asd.add(count);
                count++;
            }
            array.add(asd);
        }
        String input1 = scanner.nextLine();
        while (!input1.equals("Nuke it from orbit")) {
            String[] things = input1.split(" ");
            int wantedrow = Integer.parseInt(things[0]);
            int wantedcol = Integer.parseInt(things[1]);
            int times = Integer.parseInt(things[2]);


            for (int i = wantedcol+times; i >wantedcol; i--) {
                try {
                    array.get(wantedrow).remove(i);
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }
            for (int i = 1; i <= times; i++) {
                try {
                    array.get(wantedrow).remove(wantedcol - i);
                } catch (IndexOutOfBoundsException e) {

                    continue;

                }

            }

            for (int i = 0; i < times; i++) {
                try {
                    array.get(wantedrow - 1 - i).remove(wantedcol);
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }


            }
            for (int i = wantedrow+times; i >wantedrow; i--) {
                try {
                    array.get(i).remove(wantedcol);
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }

            boolean checker = false;
            try {
                array.get(wantedrow).remove(wantedcol);
            } catch (IndexOutOfBoundsException e) {
                checker = true;
                input1 = scanner.nextLine();
            }

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).size() == 0) {
                    array.remove(i);
                }
            }

            if (checker == false) {
                input1 = scanner.nextLine();
            }
        }



        for (ArrayList<Integer> integers : array) {
            String a = "";
            for (Integer integer : integers) {

                a = a + integer + " ";
            }
            System.out.println(a.trim());

        }


    }
}


