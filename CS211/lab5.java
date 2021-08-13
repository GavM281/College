// convert little endian to big endian
// Byte 1 -> Byte 4
// Byte 2 -> Byte 3
// Byte 3 -> Byte 2
// Byte 4 -> Byte 1

import java.util.*;
import java.nio.charset.StandardCharsets;
public class lab5 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt(); // 3
        int i = scan.nextInt(); // 4321, normally 1234, move to this int

        int b0 = ((x>>0) & 0xff);
        int b1 = ((x>>8) & 0xff);
        int b2 = ((x>>16) & 0xff);
        int b3 = ((x>>24) & 0xff);

        System.out.println(b0 << 24 | b1 << 16 | b2 << 8 | b3 << 0);
        
        int filter = Integer.parseInt("11111111000000000000000000000000",2);
        int firstByte = i & filter;
       filter = Integer.parseInt("00000000111111110000000000000000",2);
        int secondByte = i & filter;
         filter = Integer.parseInt("00000000000000001111111100000000",2);
        int thirdByte = i & filter;
         filter = Integer.parseInt("00000000000000000000000011111111",2);
        int fourthByte = i & filter;

        int res = ((firstByte>>0)|(secondByte<<8)|(thirdByte<<8)|(fourthByte>>16));
        System.out.println(res);
        
    }
}
