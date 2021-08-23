import java.io. * ;
import java.util. * ;
import java.text. * ;
import java.math. * ;
import java.util.regex. * ;

public class Solution {
  public static void main(String args[]) throws Exception {
    Scanner scan= new Scanner(System.in);
    int commandNum = scan.nextInt(); //get number of commands
    Stack<Integer> stack = new Stack<Integer>(); //create integer stack
    
    //enter input into stack
    for(int i = 0; i<=commandNum;i++){
      String command = scan.nextLine();
      if(command.matches("PUSH \\d+")){ //if push command, push int
        String num = command.substring(5);
        int x = Integer.parseInt(num);
        stack.push(x);
      }else if(command.matches("POP")){ // if pop command, pop number
        if(stack.isEmpty()){
            break;
        }
        stack.pop();
      }
    }

    int biggestNum = 0;
    boolean empty = true;
    
    //find biggest number
    for(int i = 0; i<=stack.size();i++){
      if(stack.isEmpty() && empty == true){
        break;
      }
      //if number at top of stack is bigger than current biggest number
      if(stack.peek()>biggestNum){
        biggestNum = stack.peek(); 
        stack.pop(); //remove number at top of stack
        empty = false; //stack is not empty
      }
    }
    
    // if stack is empty print empty, otherwise print biggest number
    if(stack.isEmpty() && empty == true){
        System.out.println("empty");
    }else{
      System.out.println(biggestNum);
    }
  }
}