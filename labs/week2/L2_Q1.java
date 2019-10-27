public class UsingMod{
    public static void main(String args[]) {
        int num = 123; // sets num value to 123
        System.out.println("The digits in the number 123 are:");
        
        int num1 = num/10; //sets int num1 to 12 by dividing 123 by 10
        num1 = num1/10; //set num1 to 1 by dividing num1(10) by 10
        System.out.println(num1); // prints num1 which is 1
        
        int num2 = num/10; //sets int num2 to 12 by dividing 123 by 10
        num2 = num2%10; // sets num2 to remainder of 12/10 which is 2
        System.out.println(num2); //prints 2
        
        int num3 = num%10; // sets num3 to remainder of 123/10 which is 3
        System.out.println(num3); //prints 3
    }
}