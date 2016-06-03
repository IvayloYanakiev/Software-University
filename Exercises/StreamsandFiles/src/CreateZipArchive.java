import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

	public static void main(String[] args) throws IOException{
        ZipOutputStream zip = new ZipOutputStream(
                new FileOutputStream("text-files.zip"));
        FileInputStream fis = new FileInputStream(
                new File("words.txt"));
        int byteContainter;
        zip.putNextEntry(new ZipEntry("words.txt"));

        while((byteContainter = fis.read())!=-1){
            zip.write(byteContainter);
        }
        zip.closeEntry();
        zip.putNextEntry(new ZipEntry("count-chars.txt"));
        fis = new FileInputStream(
                new File("count-chars.txt"));
        while((byteContainter = fis.read())!=-1){
            zip.write(byteContainter);
        }
        zip.closeEntry();
        zip.putNextEntry(new ZipEntry("lines.txt"));
        fis = new FileInputStream(
                new File("lines.txt"));
        while((byteContainter = fis.read())!=-1){
        	 zip.write(byteContainter);
        }
        zip.closeEntry();
        zip.finish();
        zip.close();
	}

}
