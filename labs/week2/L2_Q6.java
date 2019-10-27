public class Ternary{
    public static void main(String args[]){
        char member = 'N'; //sets char member to N which means user isnt a member
        int fee = 0; //sets fee to 0
        
        //if user is a member, fee changes to 5, otherwise changes to 20
        fee = (member == 'Y')?5: 20;
            System.out.println("The fee is: " + fee); //prints fee 
    }
}