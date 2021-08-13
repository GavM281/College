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


//        int res=0;
//
//        byte b3 = (byte)((x>>24) & 0xff);
//        byte b2 = (byte)((x>>16) & 0xff);
//        byte b1 = (byte)((x>>8) & 0xff);
//        byte b0 = (byte)((x>>0) & 0xff);

//        int b0 = ((x>>0) & 0xff);
//        int b1 = ((x>>8) & 0xff);
//        int b2 = ((x>>16) & 0xff);
//        int b3 = ((x>>24) & 0xff);
//
//        int res = b0 << 24 | b1 << 16 | b2 << 8 | b3 << 0;


//        int b0 = (x& 0xff);
//        int b1 = (x & 0xff);
//        int b2 = (x & 0xff);
//        int b3 = (x & 0xff);
//
//        int res = b0 << 24 | b1 << 8 | b2 >> 8 | b3 >> 24;



//
//
//        int res = b0 << 24 | b1 << 16 | b2 << 8 | b3 << 0;



//        int res = (i&0xff)<<24 | (i&0xff00)<<8 | (i&0xff0000)>>8 | (i>>24)&0xff;

//
//        int d0 = Integer.parseInt(Integer.toString(i).substring(0, 1));
//        int d1 = Integer.parseInt(Integer.toString(i).substring(1, 2));
//        int d2 = Integer.parseInt(Integer.toString(i).substring(2, 3));
//        int d3 = Integer.parseInt(Integer.toString(i).substring(3, 4));
//        d0-=1;
//        d1-=1;
//        d2-=1;
//        d3-=1;
//
//        System.out.println("bytes:  " +b0 + "     " + b1+ "     " + b2 +"     " + b3);
//        System.out.println("digits:  "  + d0 + "     " + d1+ "     " + d2 +"     " + d3);
//
//
//
//        byte []arr = new byte[4];
//        arr[0] = b0;
//        arr[1] = b1;
//        arr[2] = b2;
//        arr[3] = b3;
//
//        if(d0==0){
//
//        }else if(d0==1){
//            byte temp = b0;
//            arr[0] = b1;
//            arr[1] = temp;
//        }else if(d0==2){
//            byte temp = b0;
//            arr[0] = b2;
//            arr[2] = temp;
//        }else if(d0==3){
//            byte temp = b0;
//            arr[0] = b3;
//            arr[3] = temp;
//        }
//
//
//        if(d1==0){
//            byte temp = b1;
//            arr[1] = b0;
//            arr[0] = temp;
//        }else if(d1==1){
//
//        }else if(d1==2){
//            byte temp = b1;
//            arr[1] = b2;
//            arr[2] = temp;
//        }else if(d1==3){
//            byte temp = b1;
//            arr[1] = b3;
//            arr[3] = temp;
//        }
//
//
//        if(d2==0){
//            byte temp = b2;
//            arr[2] = b0;
//            arr[0] = temp;
//        }else if(d2==1){
//            byte temp = b2;
//            arr[2] = b1;
//            arr[1] = temp;
//        }else if(d2==2){
//
//        }else if(d2==3){
//            byte temp = b2;
//            arr[2] = b3;
//            arr[1] = temp;
//        }
//
//
//        if(d3==0){
//            byte temp = b3;
//            arr[3] = b0;
//            arr[0] = temp;
//        }else if(d3==1){
//            byte temp = b3;
//            arr[3] = b1;
//            arr[1] = temp;
//        }else if(d3==2){
//            byte temp = b3;
//            arr[3] = b3;
//            arr[2] = temp;
//        }else if(d3==3){
//
//        }
//
//        System.out.println(arr[0] + "     " + arr[1]+ "     " + arr[2] +"     " + arr[3]);
//        String s = new String(arr, StandardCharsets.UTF_8);
//        System.out.println(s);
//        System.out.println(d1 + "   " + d2 + "   " + d3 + "     " + d4);



        int filter = Integer.parseInt("11111111000000000000000000000000",2);
        int firstByte = i & filter;
       filter = Integer.parseInt("00000000111111110000000000000000",2);
        int secondByte = i & filter;
         filter = Integer.parseInt("00000000000000001111111100000000",2);
        int thirdByte = i & filter;
         filter = Integer.parseInt("00000000000000000000000011111111",2);
        int fourthByte = i & filter;



//        int b0,b1,b2,b3;
//        b3 = ((x>>24) & 0xff);
//        b2 = ((i>>16)&0xff);
//        b1 = ((i>>8)&0xff);
//        b0 = ((i>>0)&0xff);

//        int res = 0;

//        res = swap(x);
//            int res = ((b0 >> 0) | (b1 << 8) | (b2 << 8) | (b3 >> 16));
//        int res = b0 << 24 | b1 << 16 | b2 << 8 | b3 << 0;

        int res = ((firstByte>>0)|(secondByte<<8)|(thirdByte<<8)|(fourthByte>>16));
        System.out.println(res);
    }

//    public static int swap (int value)
//    {
//        int b1 = (value >>  0) & 0xff;
//        int b2 = (value >>  8) & 0xff;
//        int b3 = (value >> 16) & 0xff;
//        int b4 = (value >> 24) & 0xff;
//
//        return b1 << 24 | b2 << 16 | b3 << 8 | b4 << 0;
//    }
}
