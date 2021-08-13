import java.util.*;

public class lab4 {
    public static void main (String args[]){
        //fill this in
        Scanner scan = new Scanner(System.in);

        // Alice
        long p = scan.nextLong(); // prime modulus, 150001
        long g = scan.nextLong(); // generator, 7
        long gx = scan.nextLong(); // g^x mod p, 66436

        // Bob
        long c1 = scan.nextLong(); // gy, 90429
        long c2 = scan.nextLong(); // m.g^xy, 57422

        //  He therefore calculates 7^1000 mod 150001 which is 90,429

        long x = 0;
        for(int i =0; i<=p; i++){
            if(modPow(g,i,p)==gx){  //g(7) ^ i mod p(150001) == gx(66436)
                x=i; // set x to i, the power that gives gx
                break;
            }
        }

        // 1 / c1^x is the same as c1^p-1-x which is
        //90429(c1) ^149887(p-1-x)  mod 150001(p)   which is 80802
        long f = modPow(c1, p-1-x, p);


        // Now she multiplies 80802(x) by c2 mod 150001(p) to yield the original message 131513
        long m = modMult(f, c2, p); // get message
        System.out.println(m);
    }

    public static long modPow(long number, long power, long modulus){
//raises a number to a power with the given modulus
//when raising a number to a power, the number quickly becomes too large to handle
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together
        if(power==0)
            return 1;
        else if (power%2==0) {
            long halfpower=modPow(number, power/2, modulus);
            return modMult(halfpower,halfpower,modulus);
        }else{
            long halfpower=modPow(number, power/2, modulus);
            long firstbit = modMult(halfpower,halfpower,modulus);
            return modMult(firstbit,number,modulus);
        }
    }

    public static long modMult(long first, long second, long modulus){
//multiplies the first number by the second number with the given modulus
//a long can have a maximum of 19 digits. Therefore, if you're multiplying two ten digits numbers the usual way, things will go wrong
//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
//however you want the algorithm to work quickly - having an addition loop would result in an O(n) algorithm!
//the trick is to use recursion - keep breaking down the multiplication into smaller pieces and mod each of the pieces individually
        if(second==0)
            return 0;
        else if (second%2==0) {
            long half=modMult(first, second/2, modulus);
            return (half+half)%modulus;
        }else{
            long half=modMult(first, second/2, modulus);
            return (half+half+first)%modulus;
        }
    }
}
