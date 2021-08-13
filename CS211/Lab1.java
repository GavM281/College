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
