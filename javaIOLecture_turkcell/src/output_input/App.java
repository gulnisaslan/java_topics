import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("hello.txt");
       FileInputStream fileInputStream = null;
       try {
        fileInputStream =  new FileInputStream(file);
        int c = 0;
        while((c = fileInputStream.read()) != -1){
            System.out.print((char)c);
        }
       } catch (IOException e) {
         System.out.println(e.getMessage());
       }
       finally{
        try {
            if(fileInputStream !=null){
                fileInputStream.close();
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
       }
     
       
       
       
       
        /* FileOutputStream fileOutputStream =null;

        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("Merhaba".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            try{
                if(fileOutputStream !=null){
                    fileOutputStream.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }*/
    }
}
