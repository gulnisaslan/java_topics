import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Dosya yolu: ");
        String filePath = input.nextLine();
        File file =new File();
        if(!file.exists()){
            try {
                boolean fileCreated = file.createNewFile();
                if(fileCreated){
                    System.err.println("Dosya olusturuldu.");
                }
                
            } catch (IOException e) {
               System.out.println(e.getMessage());
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter =new FileWriter(file);
            String line = null;
            do {
                line = input.nextLine();
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            } while ("quit");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
        System.out.println("Dosya yazdırma basarlı..");
        System.out.println("Dosya Boyutu "+ file.length()+" byte");

    }
}
