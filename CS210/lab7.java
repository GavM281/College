import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan= new Scanner(System.in);
        Queue myQueue = new Queue(20);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        for(int i = 0; i<8;i++){
            String command = scan.nextLine();
            if(command.matches("INSERT \\w+")){ //if push command, push int
                String word = command.substring(7);
                myQueue.insert(word);
                // System.out.println(word);
            }else if(command.matches("REMOVE")){ // if pop command, pop number
                if(myQueue.isEmpty()){
                    break;
                }
                myQueue.remove();
            }
        }
        
        // System.out.println("answer");
        boolean empty = true;
        String answer = "";
        
        for(int i = 0; i<2;i++){
            if(myQueue.isEmpty() && empty == true){
                break;
            }
            else{
                answer = myQueue.peekFront();
                myQueue.remove();
                empty = false;
            }
        }
        // System.out.println(answer);
        if(myQueue.isEmpty() && empty == true){
            System.out.println("empty");
        }else{
            System.out.println(answer);
        }    
    }
}

class Queue{
    
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int s){
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    
    public boolean insert(String item){ 
        //fill this in
        if(isFull()) return false; //don’t remove if full
        if(rear == maxSize-1) // deal with wraparound
        rear = -1;
        rear++;
        queArray[rear] = item; // increment rear and insert
        nItems++; // one more item
        return true;
    }
      
    public String remove(){
        //fill this in
        if(isEmpty()) return null; //don’t remove if empty
        String temp = queArray[front];// get value and incr front
        front++;
        if(front == maxSize) // deal with wraparound
        front = 0;
        nItems--; // one less item
        return temp;
    } 

    public boolean isEmpty(){ 
        return (nItems==0);
    }
        
    public boolean isFull(){
        return (nItems==maxSize);
    }
        
    public int size(){ 
        return nItems;
    } 
    
    public String peekFront(){ // peek at front of queue
        return queArray[front];
    }
}
