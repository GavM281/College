import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class lab10{
    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int num = Integer.parseInt(myscanner.nextLine());
        String[] dictionary = new String[num];
        for(int i=0;i<num;i++){
            dictionary[i]=myscanner.nextLine();
        }
        String hash = dictionary[num-1]+(int)(Math.random()*100);
        int games = 100;
        int score = 0;
        for(int x=0;x<games;x++){
            Random r = new Random();
            String target = dictionary[r.nextInt(num)];

            System.out.println("============================================================");
            System.out.println("top target: " + target);


            String blackout="";
            for(int i=0;i<target.length();i++){
                blackout=blackout+"_";
            }
            Brain mybrain = new Brain(Arrays.copyOf(dictionary, dictionary.length), blackout);
            int lives=8;
            boolean running = true;
            while(running){
                char guess = mybrain.guessLetter();
                String original = mybrain.hiddenWord;
                char[] arrayform = original.toCharArray();
                for(int i=0;i<target.length();i++){
                    if(target.charAt(i)==guess){
                        arrayform[i]=guess;
                    }
                }
                String newform = "";
                for(int i=0;i<target.length();i++){
                    newform=newform+arrayform[i];
                }
                mybrain.hiddenWord=newform;
                if(newform.equals(original)){
                    lives=lives-1;
                }
                if(lives==0){
                    running=false;
                }
                if(mybrain.hiddenWord.equals(target)){
                    running=false;
                    score=score+1;
                }
            }
        }
        System.out.println("You got "+score+" correct out of 100");
        try{
            System.out.println("Your Receipt: "+sha256(hash+score));
        }catch(NoSuchAlgorithmException e){};
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

class Brain{

    public String[] dictionary;
    public String hiddenWord="_____";
    public boolean letters[] = new boolean[26]; // create boolean array, each index represents character

    public Brain(String[] wordlist, String target){
        dictionary = wordlist;
        hiddenWord = target;
        System.out.println("bottom target: " + target);
    }

    public char guessLetter(){
        //fill this in so as to guess the hiddenWord with the least number of guesses
        //keep track of your used letters so you're using a new letter
        //check the hiddenWord so you can see what letters are known and which ones are unknown
        //unknown characters are marked with an underscore ("_")
        //this method should return a character that is a good guess

        System.out.println(hiddenWord); // Get hiddenword, shows where in word picked letters are

        char pick = ' ';

        // Enter 5 most common letters
        if(letters[4]==false) { //e
            pick = 'e';
            letters[4] = true;

        }else if(letters[0]==false){ // a
            pick = 'a';
            letters[0] = true;

        }else if(letters[17]==false){ // r
            pick = 'r';
            letters[17] = true;

        }else if(letters[8]==false){ // i
            pick = 'i';
            letters[8] = true;

        }else if(letters[14]==false){ // o
            pick = 'o';
            letters[14] = true;

        }else{
            for(int i=0;i<dictionary.length;i++){ // goes through dictionary
                if(dictionary[i].length() == hiddenWord.length()){ // If word in dictionary is same length as word to find
                    for(int x=0;x<dictionary[i].length();x++){ // checks every letter in word
                        char find = dictionary[i].charAt(x); // get letter at position x
                        int f = (int)find; // turns into 0
                        f = f-97; // removes 97, can be compared to letters array
                        if(letters[f]==false){ // letter hasn't been picked before
                            letters[f] = true; // show letter has been picked
                            pick = find; // set pick
                            System.out.println(pick);
                            System.out.println();
                            System.out.println();
                            return pick; // return letter
                        }
                    }
                }
            }
        }



//        Random r = new Random();
//        return (char)(r.nextInt(26)+'a');
        System.out.println(pick);
        System.out.println();
        System.out.println();
        return pick; // return letter
    }
}

// top 5:   7
// top 4:   8
// top 3:   10
// top 2:   6, 11
// top 1:   8
// top 0:   15,

// get dictionary
//


// 36  4fbb06ce4b8f6ac90bedd632252a4a4a3cd2b6fa0ba1fcef6448b8b0252d96c2