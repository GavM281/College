public class CSCW1 {
    public static void main(String args[]){
        int day = 0; //Sets int to 0 to be set in switch statement
        int year = 2020; // sets year
        String month = "February"; // Strng for month
        
        switch(month){ // switch statement to get days in month
            case "January": day = 31; break; // Sets days in January to 31
            case "February": 
                if(year / 400 == 0){ //leap year if year divided by 400 is 0
                    day = 29; //sets days in month to 29 if its a leap year
                    break;
                } else { //if year isn't a leap year
                    day = 28; // days are 28
                    break;
                } 
            case "March": day = 31; break; // Sets days in March to 31
            case "April": day = 30; break; //Sets days in Apr to 30
            case "May": day = 31; break; //Sets days in May to 31
            case "June": day = 30; break; //Sets days in June to 30
            case "July": day = 31; break; //Sets days in July to 31
            case "August": day = 31; break; //Sets days in Aug to 31
            case "September": day = 30; break; //Sets days in Sep to 30
            case "October": day = 31; break; //Sets days in Oct to 31
            case "November": day = 30; break; //Sets days in Nov to 30
            case "December": day = 31; break; //Sets days in Dec to 31
            default: System.out.println("Invalid month"); //Runs if there's no 
                // valid month given
        }
        
        System.out.println("In " + month + " " + year + " there were " + 
            day + " days."); //Prints days in given month in given year
    }
}