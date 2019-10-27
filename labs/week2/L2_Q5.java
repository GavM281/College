public class Switch2{
    public static void main(String args[]){
        char grade = 'F';
        switch(grade){ // uses value of char grade to choose which case to run
        // uses cases in single brackets to compare to grade value in single brackets
            case 'A': System.out.println("Excellent Grade"); break;
            case 'B': System.out.println("Good Grade"); break;
            case 'C': System.out.println("Average Grade"); break;
            case 'D': System.out.println("Poor Grade"); break;
            case 'E': System.out.println("Fail"); break;
            case 'F': System.out.println("Fail"); break;
            default: System.out.println("Not a valid grade"); //runs if no 
                //valid grade given
        }
    }
}