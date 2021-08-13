import java.util.*;

public class lab11 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt(); // Number to check below
        int primes = 0; // Track number of primes

        for(int i=2;i<=num;i++){ // Every number from 2 to num
            if(prime(i)){ // Number is a prime
                if(circlePrime(i)){ // Number is a circular prime
                    primes++; // Increase number of primes
                }
            }
        }
        System.out.println(primes); // answer
    }

    public static boolean prime(int x){ // Check if prime
        for(int i=2;i<(x/2)+1;i++){ // Try divide every number from 2 to x-1
            if(x%i==0){
                return false; // Not prime
            }
        }
        return true; // Prime
    }

    public static boolean circlePrime(int num){ // Check if number is a circle prime
        char[] arr = Integer.toString(num).toCharArray(); // make int a char array

        for(int i = 0; i < arr.length; i++) {
            char[] rotate = new char[arr.length]; // Track rotated number
            for(int c = 1; c < arr.length; c++) {
                rotate[c - 1] = arr[c]; // Move number
            }
            rotate[arr.length - 1] = arr[0]; // Move last number to start
            int t = Integer.valueOf(new String(rotate)); // Get value as int
            // System.out.println(t);
            if(prime(t) == false) { // Number is not prime
                return false;
            }
            arr = rotate; // Set arr to be the rotated array
        }

//        System.out.println(num);
        return true; // Number is a circular prime
    }
}








/*
import java.util.*;

public class lab11 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt(); // Check below
        int primes = 0;

        for(int i=2;i<=num;i++){
            if(prime(i)){
                if(circlePrime(i)){
                    primes++;
                }
            }
        }
        System.out.println(primes);
    }

    public static boolean prime(int x){ // Check if prime
        for(int i=2;i<x;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean circlePrime(int num){
        char[] array = Integer.toString(num).toCharArray();
        int len = array.length;

        for(int i=0; i<len;i++) {
            char[] temp = new char[len];
            for(int c=1; c<len;c++) {
                temp[c-1] = array[c];
            }
            temp[len-1] = array[0];
            int x = Integer.valueOf(new String(temp));
            // System.out.println(x);
            if(prime(x) == false) {
                return false;
            }
            array = temp;
        }

//        System.out.println(num);
        return true; //Is a circular prime
    }
}
 */