package lab7;
import java.util.*;

public class lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long input = scan.nextLong();
        int palBases = 0; // Track number of palindrome bases

        for(int i = 10; i >=2 ; i--) { // Starts at base 10 down to 2
            long newNum = changeBase(input,i);
//            System.out.println("base: " + i + "   the number is: " + newNum);
            if(checkPal(newNum) == true){ // Checks if base is a palindrome
//                System.out.println("Is a palindrome");
                palBases++;
            }else{
//                System.out.println("Is not a palindrome");
            }
//            System.out.println("");
//            System.out.println("==================================================================");
//            System.out.println("");
        }

//        System.out.println(palBases); // Print number of bases that are palindromes
    }

    public static long changeBase(long num, int newBase){ // Converts to inputted base
        long temp = num; // new int same as num

        long converted = 0; // Saves converted number
        long remainder;

        for (long i = 0; temp >= 1; i++) { // loops until base can't divide into number
            remainder = temp % newBase; // Save remainder from dividing number by base
//            System.out.println("remainder is: " + remainder);

            temp /= newBase; // Divide number by the base

            converted += remainder * (long)Math.pow(10, i);
//            System.out.println("converted is " + converted + "     temp is: " + temp + "      i is: " + i);
        }
//        System.out.println();
        return converted;
    }

    public static boolean checkPal(long num) { // Checks if a number is a palindrome
        long reverse = 0; // Saves reverse of number
        long remainder;

//        System.out.println();
//        System.out.println("check pal");
//        System.out.println();

        long original = num; // Save num
        while(num!=0){ // Loop until num is 0
//            System.out.println("num is: " + num);
            remainder = num % 10; // Save last digit of number
//            System.out.println("remainder is: " + remainder);

            reverse = reverse * 10 + remainder; // Set last number from num to be first number of reverse int
//            System.out.println("reverse is: " + reverse);
//            System.out.println();
            num = num/10;
        }

        if (original == reverse){ // Check if original and reversed are the same numbers
//            System.out.println("True");
//            System.out.println("");
            return true;
        }else {
            return false;
        }
    }
}
