/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.*;

/**
 *
 * @author Ramy
 */
public class Logo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Charset charset = Charset.forName("US-ASCII");
    Path file=Paths.get("./Logo.in");
try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
    String line = null;
   char   data [][]=null;
      line = reader.readLine();
     data = new char [14][80] ;
       
     
     
 // while((line = reader.readLine())!=null){   System.out.println(line); } 
          
      for(int i=0;i<14;i++ ){
          line = reader.readLine();
      for (int j=0;j<80;j++){
          data[i][j]=line.charAt(j); 
          
            System.out.print(data[i][j]);
      }
       System.out.println();
      }
      int temp[][]=transform(data);
  for(int x=0;x<14;x++ ){
         
      for (int y=0;y<80;y++){
           
          
            System.out.print(" "+temp[x][y]);
      }
       System.out.println();
      }
       
        
    
} catch (IOException x) {
    System.err.format("IOException: %s%n", x);
}
    
    
    }  
    public static int [][] transform( char a[][]){
    
    int temp[][] = null;
    temp = new int [14][80];
    for (int i = 0;i<14;i++){
    for (int j=0;j<80;j++){
    if (a[i][j]=='.'){
    //    System.out.println("doooooooooooooooooooo");
     temp [i][j]=0;}
    if (a[i][j]=='#'){
    
        temp[i][j]=1;}
    
    }
   
    }
   /*  for(int x=0;x<14;x++ ){
         
      for (int y=0;y<80;y++){
           
          
            System.out.print(" "+temp[x][y]);
      }
       System.out.println();
      }*/
    return temp;
    }
}