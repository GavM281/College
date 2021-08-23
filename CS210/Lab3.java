import java.util.*;
public class Solution {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int lower = scan.nextInt(); //lower boundary
      int higher = scan.nextInt(); //higher boundary
      System.out.println("LOWER: " + lower + "  HIGHER: " + higher);

      int prime = 0; //counts number of primes
      boolean isPrime = false; //tracks if number is prime
      boolean isValid = true;
      if(lower >=higher){
        int tempL = lower;
        int tempH = higher;
        lower = tempH;
        higher = tempL;
      }
      for(int current = lower; current<=higher; current++){// moves through each number in range
        for(int x = 2; x<=(current/2) +2; x++){ // moves through all numbers between 2 and half current number
            isPrime = true;
            if(current == 1){
                isPrime = false;
                //   System.out.println("Breaking! #NOT PRIME#. CURRENT IS 1");
                break;
            }
            else if(current == 2 || current == 3){ //check if number is 2 or 3, which are prime
                isPrime = true;
                //   System.out.println("Breaking! #PRIME#. Current is 2");
                break;
            }
            else if(current % x == 0){
                isPrime = false;
                // System.out.println("Breaking! #NOT PRIME#  " + current + "   " + x);
                break;
            }
            //   System.out.println("current: " + current + " x= " + x + " current%x= " + current%x + "                   prime=" + prime);
            }
            if(isPrime == true){
                prime++;
                // System.out.println("PRIME. current: " + current);
            }
            // System.out.println("primes: " + prime);
            // System.out.println();
        }
        //   System.out.println();
        //   System.out.println();
        System.out.println(prime);
    }
}
