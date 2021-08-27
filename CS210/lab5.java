import java.util.*;
public class lab5 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        len++;
        int select = scan.nextInt();

        //create array of len length
        String array[] = new String[len];
        
        //for loop fill in array with inputted words
        for(int i = 0; i<len; i++){
            array[i] = scan.nextLine();
        }
        
        //sort using bubble sort
        int outer, inner;
        for(outer=len-1; outer > 0; outer--){
            for(inner=0;inner < outer; inner++){
                if(array[inner].length() > array[inner+1].length()){ //if inner is longer than inner+1
                    String temp = array[inner];
                    array[inner] = array[inner+1];
                    array[inner+1] = temp;
                    
                }else if(array[inner].length() == array[inner+1].length()){ //if lengths are the same
                    char in = array[inner].charAt(0); //get first letter at postion inner
                    char inPlus = array[inner+1].charAt(0); //get first letter at postion inner+1
                    if(inPlus>in){ //if inner+1 is bigger swap
                        String temp = array[inner];
                        array[inner] = array[inner+1];
                        array[inner+1] = temp;
                        
                    }else if(inPlus==in){//if first letters are equal move to second letters
                        char in2 = array[inner].charAt(1); //
                        char inPlus2 = array[inner+1].charAt(1);
                        if(inPlus2>in2){
                            String temp = array[inner];
                            array[inner] = array[inner+1];
                            array[inner+1] = temp;
                            
                        }else if(inPlus2==in2){//if second letters are equal move to third letters
                            char in3 = array[inner].charAt(2);
                            char inPlus3 = array[inner+1].charAt(2);
                            if(inPlus3>in3){
                                String temp = array[inner];
                                array[inner] = array[inner+1];
                                array[inner+1] = temp;
                            }
                            
                            else if(inPlus3==in3){//if third letters are equal move to fourth letters
                                char in4 = array[inner].charAt(2);
                                char inPlus4 = array[inner+1].charAt(2);
                                if(inPlus4>in4){
                                    String temp = array[inner];
                                    array[inner] = array[inner+1];
                                    array[inner+1] = temp;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(array[select]); //print word in selected position     
    }
}




// New version that reduces the repetition of code used for lab

// import java.util.*;
// public class lab5 {
//     public static void main(String args[]) {
//         Scanner scan = new Scanner(System.in);
//         int len = scan.nextInt();
//         len++;
//         int select = scan.nextInt();

//         //create array of len length
//         String array[] = new String[len];
        
//         //for loop fill in array with inputted words
//         for(int i = 0; i<len; i++){
//             array[i] = scan.nextLine();
//         }
        
//         //sort using bubble sort
//         int outer, inner;
//         for(outer=len-1; outer > 0; outer--){
//             for(inner=0;inner < outer; inner++){
//                 if(array[inner].length() > array[inner+1].length()){ //if inner is longer than inner+1
//                     String temp = array[inner];
//                     array[inner] = array[inner+1];
//                     array[inner+1] = temp;
                    
//                 }else if(array[inner].length() == array[inner+1].length()){ //if lengths are the same
//                     array = check(array[inner].length(),inner, array);
//                 }
//             }
//         }
//         System.out.println(array[select]); //print word in selected position     
//     }
    
//     public static String[] check(int len,int inner, String arr[]){
//         for(int i=0; i<len-1;i++){ // Go through word length
//             char in = arr[inner].charAt(i); //get letter i for word at index inner
//             char inPlus = arr[inner+1].charAt(i); //get letter i for word at index inner+1
            
//             if(inPlus>in){ // If letter at inner+1 is bigger swap the words
//                 String temp = arr[inner];
//                 arr[inner] = arr[inner+1];
//                 arr[inner+1] = temp;
//             }   
//         }
//         return arr; // Return array
//     }
// }
