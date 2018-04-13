package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileDemo {
   public static void main(String[] args) {
	   File dir = new File("D:/qxjijian/File/111111.pdf");
	   File dir1 = new File("G:/Heluo/Project/angularjs/qxj_jj/src/main/webapp/pdf");
	   copyFile(dir, dir1, "111111.pdf");
   }
   
   public static long copyFile(File srcFile, File destDir, String newFileName) {
       long copySizes = 0;
       if (!srcFile.exists()) {
           System.out.println("源文件不存在");
           copySizes = -1;
       } else if (newFileName == null) {
           System.out.println("文件名为null");
           copySizes = -1;
       } else {
           try {
               if (!destDir.exists()) {
                   destDir.mkdir();
               }
               FileChannel fcin = new FileInputStream(srcFile).getChannel();
               FileChannel fcout = new FileOutputStream(new File(destDir,
                   newFileName)).getChannel();
               long size = fcin.size();
               fcin.transferTo(0, fcin.size(), fcout);
               fcin.close();
               fcout.close();
               copySizes = size;
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return copySizes;
   }
}