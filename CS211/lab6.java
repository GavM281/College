//6b9cb93bd81bc3ee973e73ed8307955aa7cdc97b629e2a123e7e23910ac0210b
// 127

//ee8bda8148898b4755c86a10216ad6c1271078f3fb2f7b1dea5ee40b4d00b7d0
// 997


//ee8bda8148898b4755c86a10216ad6c1271078f3fb2f7b1dea5ee40b4d00b7d0


import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class lab6{

    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int items = myscanner.nextInt()-1;
        myscanner.nextLine();
        String[] contents = new String[items];
        for(int i=0;i<items;i++){
            contents[i]=myscanner.nextLine();

        }
        String hash = myscanner.nextLine();
        int size=99991;
        Solution mysolution = new Solution();
        String[] hashtable=mysolution.fill(size, contents);
        HashTable mytable = new HashTable(hashtable);

        Solution mysolution2 = new Solution(); //prevents cheating by using memory
        for(int i=0;i<items;i++){
            int rand = (int)(Math.random()*items);
            String temp = contents[i];
            contents[i]=contents[rand];
            contents[rand]=temp;
        }
        int total=0;
        for(int i=0;i<items;i++){
            int slot = mysolution2.find(size, mytable, contents[i]);
            if(!hashtable[slot].equals(contents[i])){
                System.out.println("error!");
            }
        }
        long status=mytable.gettotal();
        System.out.println("Collisions: " + status);
        if(status>0){
            try{
                System.out.println("Here is your receipt: "+sha256(hash+mytable.gettotal()));
            }catch(NoSuchAlgorithmException e){};
        }
    }

    public static String sha256(String input) throws NoSuchAlgorithmException {
        byte[] in = hexStringToByteArray(input);
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if(len%2==1){
            s=s+"@";
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}


class HashTable{

    private String[] hashTable;
    private long total=0;

    public HashTable(String[] input){
        hashTable = input;
    }

    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check)){
            return true;
        }else{
            total++;
            return false;
        }
    }

    public long gettotal(){
        return total;
    }
}



class Solution{

    public int find(int size, HashTable mytable, String word){

        //fill this in so as to minimize collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is

        int wordIndex = hash(size,word); // Get length of word
        while(!mytable.check(wordIndex, word)){ // Check if word is at index
            wordIndex = (wordIndex +997) % size; // Check index 7 ahead
        }
        return wordIndex;
    }

    public String[] fill(int size, String[] array){

        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashtable array

        String[] hashtable = new String[size]; // create new string array using size of hashtable

        for(int i = 0; i<array.length;i++){
            String word = array[i]; // Get word
            int index = hash(size,word); // Get index

            while(hashtable[index] != null){ // When the index isn't empty
                index = (index + 997) % size; // Jump 997 spaces and modulo by size to loop back to start
            }
            hashtable[index]=word; // Set value at index to word
        }
        return hashtable; // return hashtable

    }

    // Add all letters together and modulo by hashtable size
    public int hash(int size,String word){
        int total = 0;
        for(int i = 0; i<word.length();i++){
            int c = word.charAt(i);
            total = total+c;
        }
        total = total%size;
        return total;
    }
}