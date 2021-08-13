import java.util.*;
public class lab3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // System.out.println("Enter start");
        int start = scan.nextInt();
        // System.out.println("Enter end");
        int end = scan.nextInt();
        // System.out.println("Enter select");
        int select = scan.nextInt();

        int length = (end - start)+1;
        int arr[][] = new int[2][length];

        // arr index | 0 | 1 | 2 | 3 | 4
        // value     | 4 | 5 | 6 | 7 | 8
        // collatz   | 3 | 6 | 9 | 17| 4

        int collatz = 1;
        for(int i = 0; i<length;i++){
            arr[0][i] = i+start; // add number to array

            collatz = 1;
            int num = arr[0][i];
            while(num!=1) {
                if (num % 2 == 0) { // if even
                    num = num / 2;
                    collatz++;
                } else { // it's odd
                    num = (num * 3) + 1;
                    collatz++;
                }
            }
            arr[1][i] = collatz; // enter collatz value
        }


        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[1][j] > arr[1][j + 1]) {
                    // swapping collatz values
                    int temp = arr[1][j];
                    arr[1][j] = arr[1][j + 1];
                    arr[1][j + 1] = temp;

                    // Swapping original values
                    int oTemp = arr[0][j];
                    arr[0][j] = arr[0][j + 1];
                    arr[0][j + 1] = oTemp;
                }
            }
        }
        System.out.println(arr[0][select-1]);
    }
}
