public class CSCCompFY2{
    public static void main(String args[]){
        char animal = 'c'; //sets character representing animal
        
        switch(animal){
            case 'c': System.out.println("Cow - Moo");break;
            case 'h': System.out.println("Horse - Neigh");break;
            case 'p': System.out.println("Pig - Oink");break;
            case 's': System.out.println("Sheep - Baa");break;
            case 'd': System.out.println("Duck - Quack");break;
            default: System.out.println("Not a valid animal");break;
        }
    }
}