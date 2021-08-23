import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myscanner = new Scanner(System.in);
        int num = Integer.parseInt(myscanner.nextLine());
        Link[] array = new Link[num];
        for(int i=0;i<num;i++){
            array[i]=new Link(Integer.parseInt(myscanner.nextLine()));    
        }
        while(myscanner.hasNext()){
            int select=myscanner.nextInt();
            int previous=myscanner.nextInt();
            int next=myscanner.nextInt();
            if(previous!=-1){
                array[select].previous=array[previous];
            }
            if(next!=-1){
                array[select].next=array[next];
            }
        }
        LinkedList mylist = new LinkedList();
        if(num>0){
            mylist.first=array[0];
            mylist.last=array[num-1];
        }
        System.out.println(search(mylist));
    }


    public static int search(LinkedList mylist){
        /* return the highest value held in any of the links, 0 if defective or empty*/
        Link current = mylist.first;
        if(mylist.isEmpty() || mylist.first != mylist.last.next){
            return 0;
        }
        int highest = 0;
        
        while(true){
            if(current.data > highest){
                highest = current.data;
            }
            if(current.next == null){
                break;
            }
            current = current.next;
        }   
        // return 0;
       return highest; 
    }

}

class Link{
	public int data;
	public Link next;
	public Link previous;
    
    public Link(int input){
        data=input;
        next=null;
        previous=null;
    }
}

class LinkedList {
	public Link first;
    public Link last;

	public LinkedList( ){
		first=null;
        last=null;
	}

	public boolean isEmpty( ){
		return (first==null);
	}
    
    public void insertHead(Link insert){
        if(isEmpty()){
            first=insert;
            last=insert;
        }else{
            first.previous=insert;
            insert.next=first;
            first=insert;
        }
    }
}