package test;

import java.io.File;

public class FileDemo {
   public static void main(String[] args) {
      File f = null;           
      try{
         // creates temporary file
         f = File.createTempFile("tmp", ".txt");
         
         // prints absolute path
         System.out.println("File path: "+f.getAbsolutePath());
         
         // deletes file when the virtual machine terminate
          f.deleteOnExit();
         
         // creates temporary file
         f = File.createTempFile("tmp", null);
         
         // prints absolute path
         System.out.print("File path: "+f.getAbsolutePath());
         
         // deletes file when the virtual machine terminate
         f.deleteOnExit();
         
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}