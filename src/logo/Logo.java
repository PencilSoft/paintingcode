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
    
    static String totalCommend[]= null;
    static int total=-1;
    
    public static void main(String[] args) {
        // TODO code application logic here
      Charset charset = Charset.forName("US-ASCII");
    Path file=Paths.get("./Logo.in");
try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
    String line = null;
   char   data [][]=null;
      line = reader.readLine();
     data = new char [14][80] ;
     
     totalCommend=new String [14*80];
     
 
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
      /*
  for(int x=0;x<14;x++ ){
         
      for (int y=0;y<80;y++){
           
          
            System.out.print(" "+temp[x][y]);
      }
       System.out.println();
      }*/
  temp=linearPainting(temp);
  LinearTempPicOutput(temp);
  temp=ZerosquerCheck(temp);
  ZeroSqaureTempPicOutput(temp);
  outputfile();
  System.out.println("-------------------------------------------------");
       
         for( int x=0;x<14;x++ ){
         
      for (  int y=0;y<80;y++){
           
          
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
           //System.out.println(i+" "+j);
        for (int x=i-dim;x<=i+dim;x++){
          //  System.out.println(" ");
        for (int y=j-dim;y<=j+dim;y++){
            if (temp[x][y]==5){break;}
            if(temp[x][y]==1){
        t = t+temp[x][y];}
         
        //      System.out.print(" "+temp[x][y]);
     
        }
        }
         //System.out.println(" ");
      
        if (t==(4*(dim*dim))+(4*dim)+1) {
         //   System.out.println("Square operation of dimn"+  dim +"center on"+i+","+j);
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
            String commend="PAINT_SQUARE"+" "+i+" "+j+" "+ d;
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(commend);
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    total=total+1;
totalCommend[total]=commend;
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
    
    
  
    
    
    
 public  static int [][] linearPainting(int a[][]) throws FileNotFoundException{
 int temp=0,temp1=0,temp2=0,temp3=0;
 int r=0,c=0;
 for (int i=0;i<14;i++){
  //System.out.println("currenjjjjjjjjjjt"+i);
 for (int j=0;j<80;j++){
     if (a[i][j]==5){continue;}
      if (a[i][j]==9){continue;}
        if (a[i][j]==6){continue;}
         if (a[i][j]==7){continue;}
    temp2=temp=a[i][j];
    c=0;
    r=0;

    for (int y=j;y<80;y++){
      if (a[i][y]==5){continue;}
      if (a[i][y]==9){continue;}
        if (a[i][y]==6){continue;}
           if (a[i][y]==7){continue;}
       temp1=temp;
       temp=temp+a[i][y];
       if (temp==temp1) {break;}
       else{c=y;}
 
    }
    
    
    
    
    for(int x=i;x<14;x++){
         if (a[x][j]==5){continue;}
      if (a[x][j]==9){continue;}
        if (a[x][j]==6){continue;}
         if (a[x][j]==7){continue;}
    temp3=temp2;
    temp2=temp2+a[x][j];
    
    if (temp2==temp3){break;}
    else{r=x;}
 }
    if (temp2==temp&temp==a[i][j]){
    
       continue;
      
    }
    temp=temp-1;
    temp2=temp2-1;
    if (temp>temp2){
        boolean dis=false;
      
       System.out.println("Horzintal from "+i+","+j+" To "+i+","+c); 
    for(int k=j;k<=c;k++){
        if (a[i][k]==7){dis=true;break;}
         if (a[i][k]==5){dis=true;break;}
          if (a[i][k]==9){dis=true;break;}
    a[i][k]=6;
    }
      if(!dis){  LinearPainting(i,j,i,c);}
    }
     if (temp==temp2&temp2!=a[i][j]){
         boolean dis=false;
     
       System.out.println("Horizintal from "+i+","+j+" To "+i+","+c); 
    for(int k=j;k<=c;k++){
        if (a[i][k]==7){ dis = true; break;}
         if (a[i][k]==5){ dis=true;break;}
          if (a[i][k]==9){ dis =true;break;}
           
    a[i][k]=6;
    }
    if(!dis){  LinearPainting(i,j,i,c);}
    }
 if (temp<temp2){
     boolean dis=false;
     
       System.out.println("vertical from "+i+","+j+" To "+r+","+j); 
    for(int k=i;k<=r;k++){
          if (a[k][j]==6){dis=true;break;}
           if (a[i][k]==5){dis=true;break;}
            if (a[i][k]==9){dis=true;break;}
             
    a[k][j]=7;
    }
    if (!dis){
      LinearPainting(i,j,r,j);
    }
    } 
 }
 }
  
  
    
    return a;
    }
   public static void LinearTempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterLinearPainting.txt");
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
     public static void LinearPainting( int i1 ,int j1,int i2,int j2) throws FileNotFoundException{
    try{
       
        	File file =new File("FinalLinearComends.txt");
                if(!file.exists()){
    			file.createNewFile();}
                  String commend="PAINT_LINE "+" "+i1+" "+j1+" "+ i2+" "+j2;
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
              
    	        bufferWritter.write(commend);
               
                
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    
	    total=total+1;
totalCommend[total]=commend;
                
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
     public static int [][] ZerosquerCheck(int a[][]) throws FileNotFoundException
     {
       for(int x=0;x<14;x++ ){
         
      for (int y=0;y<80;y++){
     if (a[x][y]==1){
         
         a[x][y]=8;
        SquarePainting(x,y,0);
         
     }}
     }

   return a;
}
       public static void ZeroSqaureTempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterZeroSquarePainting.txt");
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
       public static void outputfile(){
          
       
           
       System.out.println("this is toaral"+total);
         try{
       File file =new File("FinalOutputfile.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
          bufferWritter.write(""+total);
           bufferWritter.newLine();
          for(int x=0;x<total;x++ ){
         
  
           
            bufferWritter.write(totalCommend[x]);
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
