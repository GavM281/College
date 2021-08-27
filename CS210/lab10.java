import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] arr = new int[n][6];
       
        //input
        for(int x = 0; x<n; x++){
            for(int y = 0; y<6; y++){
                arr[x][y] = scan.nextInt();
            }
        }
        
        //set invalid ints to 9999
        for(int x = 0; x<n; x++){
            for(int y = 0; y<6; y++){
                if(arr[x][y]%3 ==0){
                    arr[x][y]= 9999;
                }
            }
        }
        
        // print arrays
        for(int x = 0; x<n; x++){
            for(int y = 0; y<6; y++){
                if(arr[x][y]!= 9999){
                    System.out.print(arr[x][y] + "  ");
                }
            }
            System.out.println();
        }
    }
}
