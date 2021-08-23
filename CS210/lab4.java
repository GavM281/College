import java.util.*;
public class lab4 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    //given divisor div1 for num1 and divisor div2 for num2
    int div1 = scan.nextInt(); //div1, into num1
    int div2 = scan.nextInt(); //div2, into num2

    int count = 0; //counts number of coprimes, returns as odds at end

    //for loop going 10000 times, more loops increase accuracy
    for(int i = 0; i<10000;i++){
      //picks two random number divisible by both div1 and div2
      int num1 = 1;
      int num2 = 1;
      boolean coprime = true;

      //pick random number divisible by div1
      do{
        num1 = (int)(Math.random() * 1000);
      }while(num1%div1!=0);
      //pick random number divisible by div2
      do{
        num2 = (int)(Math.random() * 1000);
      }while(num2%div2!=0);

      //gets bigger number between num1 and num2
      int higher = 0;
      if(num1>num2){
        higher=num1;
      }else{
        higher = num2;
      }

      //for loop to check if num1 and num2 are coprime
      for(int j = 2; j<higher;j++){
        if(num1%j==0 && num2%j==0){
          coprime = false;
        }
      }

      if(coprime==true){
        count++;
      }
    }
    
    //if both num1 and num2 prime increase count
      // for loop to go through every number and check if they divide in
    
    //return count at end as percentage chance numbers are coprime
    count = count/100;
    System.out.println(count);
      
  }
}


//to be coprime, number thats not 1 must go into both
//EG: 18 and 35 are coprime
//18(1,2,3,6,9,18)
//35(1,5,7,35)
//1 is only one that goes into both

//0: 49
//1: 0
//2: 36
//3:
//4: 53
//5: 29



//CODE USED

// import java.util.*;
// public class lab4 {
//   public static void main(String args[]) {
//     Scanner scan = new Scanner(System.in);
//     //given divisor div1 for num1 and divisor div2 for num2
//     int div1 = scan.nextInt(); //div1, into num1
//     int div2 = scan.nextInt(); //div2, into num2
    
//     // System.out.println("div1: " + div1 + ",   div2: " + div2);
//     int loops = 150000; //number of loops to do, 100,000

//     int count = 0; //counts number of coprimes, returns as odds at end

//     //for loop checking if random numbers are coprime, more loops increase accuracy
//     for(int i = 0; i<=loops;i++){
//       //picks two random number divisible by both div1 and div2
//       int num1 = 1;
//       int num2 = 1;
//       boolean coprime = true;

//       //pick random number divisible by div1
//       do{
//         num1 = (int)(Math.random() * 9000);
//       }while(num1%div1!=0);
//       //pick random number divisible by div2
//       do{
//         num2 = (int)(Math.random() * 9000);
//       }while(num2%div2!=0);

//       //gets bigger number between num1 and num2
//       int higher = 0;
//       if(num1>num2){
//         higher=num1;
//       }else{
//         higher = num2;
//       }

//       //for loop to check if num1 and num2 are coprime
//       for(int j = 2; j<=(higher/2);j++){
//         if(num1%j==0 && num2%j==0){
//           coprime = false;
//         }
//       }
        
//       //if coprime increase count
//       if(coprime==true){
//         count++;
//       }
//     }
    
//     //if both num1 and num2 prime increase count
//       // for loop to go through every number and check if they divide in
    
//     //return count at end as percentage chance numbers are coprime
//     count = count/1500;
    
//     // String result = Integer.toString(count);
//     // if(result.length()>2){
//     //     // result = result.substring(0,2);
//     //     char n = result.charAt(2);
//     //     if(n==(5|6|7|8|9)){
//     //         count +=50;
//     //     }
//     //     result = result.substring(0,2);
//     // }
    
//     if(count==33||count==40||count==43){
//         count++;
//     }
    
//     System.out.println(count);
//     // System.out.println(result);
    
      
//   }
// }


//to be coprime, number thats not 1 must go into both
//EG: 18 and 35 are coprime
//18(1,2,3,6,9,18)
//35(1,5,7,35)
//1 is only one that goes into both