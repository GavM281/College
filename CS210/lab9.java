import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        System.out.println(tribonacci(n, new long[70]));
    }

    public static long tribonacci(int n, long[] array) {
        long result = 0L;
        
        if(array[n] != 0) return array[n];
        else {
            if(n == 0) return 0;
            else if(n == 1) return 0;
            else if(n == 2) return 1;
            else {
                result = (tribonacci(n - 1, array) + tribonacci(n - 2, array) + tribonacci(n - 3, cache));
            }    
        }
        
        array[n] = result;
        return result;   
    }
}


// CLOSER TO NOTES
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        System.out.println(tribonacci(n, new long[70]));
    }

    public static long tribonacci(int n, long[] array) {
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        if(array[n] != 0){
            return array[n];
        }else {
            array[n] = (tribonacci(n - 1, array) + tribonacci(n - 2, array)+ tribonacci(n - 3, array));
            return array[n];
        }
    }
}


//PART 2, LONG DIVISION
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        System.out.println(tribonacci(n, x));
    }

    public static long tribonacci(int numerator, int divisor) {
        double res =((double)numerator/(double)divisor);
	    char [] dpart = String.valueOf(res).toCharArray();
	    String w = dpart[n+2]+("");
	    int num = 0;
	    return num=Integer.parseInt(w);
    }
}

// PART 2 SIMPLER VERSION
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        double num = scan.nextDouble();
        double div = scan.nextDouble();
        int n = scan.nextInt();
        System.out.println(tribonacci(num, div, n));
    }

    public static char tribonacci(double numerator, double divisor, int n) {
        double d =(numerator / divisor); //answer to 1000/13
	    String str = String.valueOf(d); 
	    int pos = n+2;
	    return (str.charAt(pos));
    }
}





// SUBMITTED
//PART 1
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        System.out.println(tribonacci(n, new long[70]));
    }

    public static long tribonacci(int n, long[] array) {
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        if(array[n] != 0){
            return array[n];
        }else {
            array[n] = (tribonacci(n - 1, array) + tribonacci(n - 2, array)+ tribonacci(n - 3, array));
            return array[n];
        }
    }
}

// PART 2
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ){
        Scanner myscanner = new Scanner(System.in);
        int numerator = myscanner.nextInt();
        int divisor = myscanner.nextInt();
        int n = myscanner.nextInt();
        System.out.println(decimal(numerator,divisor,n));
    }
    
    public static int decimal(int numerator, int divisor, int n){
        double d =((double)numerator / (double)divisor);
        String str = String.valueOf(d); 
        
        int decimalPos = 1;
        if(str.charAt(2) == '.'){
            decimalPos = 2;
        }
        int pos = n+decimalPos;
        try{
            int ans = Character.getNumericValue(str.charAt(pos));
            return (ans);
        }
        catch(Exception e) {
            return 0;
        }
   }  
}
