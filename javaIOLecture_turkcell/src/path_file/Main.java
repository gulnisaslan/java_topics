package path_file;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        File file = new File(path);
        String[] icerik = file.list();
        for (int i = 0; i < icerik.length; i++) {
            System.out.println(icerik[i]);
        }
        scan.close();



      
       

        
        
    }   
    private static void fileMethods() {
        File file = new File("C:\\Users\\ercan\\Desktop\\sample.txt");
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());//Dosyanı ve klasörğn tam pathin verir.
        System.out.println(file.getParentFile());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
    }
    private static void  fileMethods2(File file){
         if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(file.exists()){
            file.delete();
            System.out.println("Dosya Silindi.");

        }

    }


}
