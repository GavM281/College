import java.util.*;
public class Lab1 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine(); // Get string input
        int count[] = new int[255]; // Track how many times each character has been entered

        for (int i = 0; i < input.length(); i++){
            count[input.charAt(i)]++;
        }

        for(int i = 0; i<count.length;i++){
            int highest = count[0];
            int index = 0; // Track index, so it can be changed to index of most frequent letter

            for(int x = 0; x<count.length;x++){ // Get the highest frequency
                if(count[x] > highest){
                    highest = count[x];
                    index = x; // Save index
                }
            }
            char c = (char)index; // Change int back to char
            if(highest != 0) { // If the character has appeared
                System.out.println(c + " " + highest);
            }
            count[index]=0; // Set index count to 0 so it doesn't print again
        }
    }
}

//        char letters[] = input.toCharArray(); // Change string to char array

//        System.out.println("About to fill count with 0");
//        for(int i = 0;i<255;i++){
//            count[i] = 0;
//        }
//        System.out.println("Filled count with 0");
//
//        for(int i = 0;i<letters.length;i++){
//            System.out.println("");
//            char c = letters[i]; // Gets first character in char array letters[]
//            System.out.println("Found char c to be: " + c);
//
//            int x = c-'0'; // Get value of character as int
//            x+=48; // add 48 to be ascii
//
//            char f = (char)x; // verify changing int back to char gives correct char
//            System.out.println("Found value of char c to be: " + x);
//            System.out.println("Found letter from x to be: " + f);
//
//            count[x] +=1; // Increase int at index by 1
//            System.out.println("Found count of char c to be: " + count[x]);
//            System.out.println("");
//        }
//        System.out.println("Now know how often every character appears");
////        Now know how often every character appears