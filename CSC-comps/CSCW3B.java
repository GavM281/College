public class CSCCompFY32{
    public static void main(String args[]){
        int num = 36;
        int num0 = num;
        int num1 = 0;
        int num2 = 0;
        int count = 0;
        
        while(num0>=10){
            num1 = (num0/10)%10; //3
            num2 = num0%10; //6
            num0 = num1*num2;
            count++;
        }
        System.out.println(num + " needs to be multipled " + count +" times");
    }
}