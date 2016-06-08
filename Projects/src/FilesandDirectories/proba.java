package FilesandDirectories;


import java.io.*;

public class proba {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\IntelliJ JetBrains\\Projects\\src\\FilesandDirectories\\asd1.txt");
        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
            String asd = br.readLine();
            while (asd != null) {
                System.out.println(asd);
                asd = br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        File input = new File("C:\\Users\\Happiness\\Pictures\\lion5.jpg");
        File output = new File("C:\\Users\\Happiness\\Pictures\\copy.jpg");
        try (FileInputStream reading = new FileInputStream(input);
             FileOutputStream writer = new FileOutputStream(output)) {

            int data = reading.read();
            while (data != -1) {
                writer.write(data);
                data = reading.read();
            }


        } catch (Exception s) {
            System.out.println(s);
        }


    }
}
