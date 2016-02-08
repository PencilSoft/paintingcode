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
       data=new char [14][80];
       int temp[][]=new int [3][3];
       for (int k=1;k<3;k++){
       for(int p=0;p<3;p++){
       temp[k][p]=2;
       }
       }
       for(int m=0;m<3;m++){
       temp[0][m]=1;
       }
       int w= determinant(temp,3);
       System.out.printf("kkk"+w);
 // while((line = reader.readLine())!=null){   System.out.println(line); } 
    /*      
      for(int i=0;i<14;i++ ){
          line = reader.readLine();
      for (int j=0;j<80;j++){
          data[i][j]=line.charAt(j); 
          
            System.out.print(data[i][j]);
      }
       System.out.println();
      }*/
  /* for(int i=0;i<=14;i++ ){
      for (int j=0;j<=80;j++){
        System.out.print(data[i][j]);
           
      }
      System.out.println();
      }*/
       
        
    
} catch (IOException x) {
    System.err.format("IOException: %s%n", x);
}
    
    
    }
  public static  int determinant(int a[][], int n){
	int det = 0, sign = 1, p = 0, q = 0;

	if(n==1){
		det = a[0][0];
	}
	else{
		int b[][] = new int[n-1][n-1];
		for(int x = 0 ; x < n ; x++){
			p=0;q=0;
			for(int i = 1;i < n; i++){
				for(int j = 0; j < n;j++){
					if(j != x){
						b[p][q++] = a[i][j];
						if(q % (n-1) == 0){
							p++;
							q=0;
						}
					}
				}
			}
			det = det + a[0][x] *
                              determinant(b, n-1) *
                              sign;
			sign = -sign;
		}
	}
	return det;
}
    
}
