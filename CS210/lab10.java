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


// get all numbers from string
// create array of correct length
// put all numbers into array if they don't divide by 3
// sort all arrays
// print


// 'attempt'
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(n);
        
        for(int x = 0; x<1;x++){
            String f =scan.nextLine(); // string from input
            // System.out.println("a: " + a);
            int front = 0;
            int end = 0;
            int numbers = 0;
            // System.out.println("a length: " + a.length());
        }
        
        for(int x = 0; x<n;x++){
            String a =scan.nextLine(); // string from input
            System.out.println("a: " + a);
            int front = 0;
            int end = 0;
            int numbers = 0;
            System.out.println("a length: " + a.length());
            while(end<a.length()){ //gets number of numbers in line
                if(a.charAt(end) == ' '){
                    String num = a.substring(front,end);
                    int addNum = Integer.parseInt(num);
                    if(addNum % 3 ==0){
                        // System.out.print("HELLO111");
                    }else{
                        numbers++;
                        // System.out.print("HELLO222");
                    }
                    // System.out.print("HELLO");
                }
                // System.out.print("addNum");
                front = end;
                end++;
            }
            
            
            end = 0;
            front = 0;
            int arr[] = new int[numbers]; //create array of correct length
            while(end<a.length()-1){ //gets number of numbers in line
                if(a.charAt(end) == ' '){
                    String num = a.substring(front,end);
                    int addNum = Integer.parseInt(num);
                    if(addNum % 3 ==0){
                        
                    }else{
                        arr[x] = addNum;
                    }
                    
                }
                front = end;
                end++;
            }
            System.out.println();
            System.out.print("[ ");
            for(int z=0;z<numbers;z++){
                // System.out.print("HI ");
                System.out.print(arr[z]+ " ");
                // System.out.print("HI ");
            }
            System.out.print("]");
            System.out.println();
            String esge = backup(x,n, arr);
        }
        System.out.println();
    }
    public static String backup(int x, int n, int arr[]){
        if(x ==0){
            int arr1[] = new int[arr.length];
            for(int q = 0; q < arr.length; q++){
                arr1[q] = arr[q];
            }
        }else if(x ==1){
            int arr2[] = new int[arr.length];
            for(int q = 0; q < arr.length; q++){
                arr2[q] = arr[q];
            }
        }
        else if(x ==2){
            int arr3[] = new int[arr.length];
            for(int q = 0; q < arr.length; q++){
                arr3[q] = arr[q];
            }
        }
        else if(x ==3){
            int arr4[] = new int[arr.length];
            for(int q = 0; q < arr.length; q++){
                arr4[q] = arr[q];
            }
        }
        else if(x ==4){
            int arr5[] = new int[arr.length];
            for(int q = 0; q < arr.length; q++){
                arr5[q] = arr[q];
            }
        }
        
        System.out.println(arr3 + arr0 + arr1 + arr2);
        for(int h = 1; h<=n; h++){
            int longest = arr
        }
        return "hh";
    }
}