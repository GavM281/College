import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      String num = scan.nextLine();
      
      int pos = 0;
      int sum = 0;
      while(pos<num.length()){
          char c = num.charAt(pos);
          int currentNum = Character.getNumericValue(c); //changes character into int
          if(pos%2 !=0){
              currentNum = currentNum *2;
              if(currentNum > 9 ){
                  currentNum -= 9;
              }
          }
          System.out.println("Sum: " + sum + "    currentNum: " + currentNum);
          sum += currentNum;
          pos++;
      }

      System.out.println("Sum: " + sum);
      sum %= 10;
      System.out.println(sum);
    }
}