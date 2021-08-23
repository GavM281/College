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



//array attempt

import java.util.*;
public class Solution {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int lower = scan.nextInt(); //lower boundary
      int higher = scan.nextInt(); //higher boundary

      //swaps lower and higher if lower is bigger than higher
      if(lower >= higher){ 
        int tempL = lower;
        int tempH = higher;
        lower = tempH;
        higher = tempL;
      }
      
      int primeCount = 0; //counts number of primes
      
      //create boolean array
      boolean prime[] = new boolean[higher+1];
      //set every index to true
      for(int x = lower; x<=higher; x++){
          prime[x] = true;
      }
    
      for(int current = lower; current<=higher; current++){ //range
          for(int i = 2; i<(current/2) +2; i++){ //divide by numbers from 2 to current
              if(current % i ==0 && current!=2){
                  prime[current] = false;
              }
          }
          //if index is still true increase primeCount by 1
          if(prime[current] ==true && current != 0 && current != 1){
              primeCount++;
          }
      }
      //print number of prime numbers
      System.out.println(primeCount);
    }
}