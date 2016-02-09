/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
       
     
     
 
      for(int i=0;i<14;i++ ){
          line = reader.readLine();
      for (int j=0;j<80;j++){
          data[i][j]=line.charAt(j); 
          
          
      }
   
      }
     
      int temp[][]=new int [14][80];
      temp=transform(data);
      for (int l=6;l>=1;l--){
    temp =square(temp,l);}
      TempPicOutput(temp);
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
    
     temp [i][j]=0;}
    if (a[i][j]=='#'){
    
        temp[i][j]=1;}
    
    }
   
    }

    return temp;
    }
    public static int  [][] square(int a[][],int dim) throws FileNotFoundException{
        String command[]=new String[a.length];
         System.out.println("Serach for dimantion "+dim );
        int t=0;
    int temp[][]= a;
   for (int i = 0;i<14;i++){
    for (int j=0;j<80;j++){
        int cell= temp[i][j];
        if (cell==5){
           
            continue;
       }
        if (i-dim>=0&i+dim<14&j-dim>=0&j+dim<80){
            t=0;
           System.out.println(i+" "+j);
        for (int x=i-dim;x<=i+dim;x++){
            System.out.println(" ");
        for (int y=j-dim;y<=j+dim;y++){
            if (temp[x][y]==5){break;}
            if(temp[x][y]==1){
        t = t+temp[x][y];}
         
              System.out.print(" "+temp[x][y]);
     
        }
        }
         System.out.println(" ");
      
        if (t==(4*(dim*dim))+(4*dim)+1) {
            System.out.println("Square operation of dimn"+  dim +"center on"+i+","+j);
         SquarePainting(i,j,dim);
         
         for (int x=i-dim;x<=i+dim;x++){
             
             
        for (int y=j-dim;y<=j+dim;y++){
      
         temp[x][y]=5;
            if (x==i&y==j){temp[x][y]=9;}
        }
        }
        
        
        }
        }
   
    }
   }
  


        return temp;
    }
    public static void SquarePainting( int i ,int j,int d) throws FileNotFoundException{
    try{
       
        	File file =new File("FinalSquareComends.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write("PAINT_SQUARE"+" "+i+" "+j+" "+ d);
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }

      public static void TempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterSquarePainting.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),false);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        
          for(int x=0;x<14;x++ ){
         
      for (int y=0;y<80;y++){
           
            bufferWritter.write(" "+a[x][y]);
           
      }
      bufferWritter.newLine();
      }
        
       bufferWritter.close();
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
    
    
  
    
    
    
 
  
  
    
    
    }

   
