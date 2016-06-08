package SetsMaps;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RubyMatrix {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixcoordinates = scanner.nextLine().split(" ");
        int row = Integer.parseInt(matrixcoordinates[0]);
        int col = Integer.parseInt(matrixcoordinates[1]);
        int[][] matrix = new int[row][col];
        int[][] matrix1 = new int[row][col];
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = count;
                matrix1[i][j] = count;
                count++;
            }
        }
        String numberoflines = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(numberoflines); i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("([0-9]+)\\s+?(down|left|right|up)\\s+?([0-9]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int wanted = Integer.parseInt(matcher.group(1));
                String command = matcher.group(2);
                int times = Integer.parseInt(matcher.group(3));
                switch (command) {
                    case "left":
                        for (int a = 0; a < times % row; a++) {
                            int first = matrix[wanted][0];
                            for (int j = 0; j < col - 1; j++) {

                                matrix[wanted][j] = matrix[wanted][j + 1];

                            }

                            matrix[wanted][col - 1] = first;
                        }

                        break;
                    case "right":
                        for (int a = 0; a < times % row; a++) {
                            int last = matrix[wanted][col - 1];
                            for (int j = col - 1; j > 0; j--) {

                                matrix[wanted][j] = matrix[wanted][j - 1];

                            }

                            matrix[wanted][0] = last;
                        }
                        break;
                    case "up":
                        for (int a = 0; a < times % col; a++) {

                            int first = matrix[0][wanted];
                            for (int b = 0; b < row - 1; b++) {
                                matrix[b][wanted] = matrix[b + 1][wanted];

                            }
                            matrix[row - 1][wanted] = first;
                        }


                        break;
                    case "down":
                        for (int a = 0; a < times % col; a++) {


                            int last = matrix[row - 1][wanted];
                            for (int b = row - 1; b > 0; b--) {
                                matrix[b][wanted] = matrix[b - 1][wanted];

                            }
                            matrix[0][wanted] = last;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix1[i][j] == matrix[i][j]) {
                    System.out.println("No swap required");
                } else {
                    for (int k = 0; k <row; k++) {
                        for (int l = 0; l <col; l++) {
                            if(matrix[k][l]==matrix1[i][j]){
                                int temp = matrix[i][j];
                                matrix[i][j]=matrix[k][l];
                                matrix[k][l]=temp;
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n",i,j,k,l);
                            }
                        }
                    }
                }
            }
        }


    }
}
