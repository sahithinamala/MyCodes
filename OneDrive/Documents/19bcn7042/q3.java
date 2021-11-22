import java.util.*;
public class q3 
{
	class Node
    {    
        int data;    
        Node next;       
        public Node(int data) 
        {    
            this.data = data;    
            this.next = null;    
        }    
    }      
    static Node head = null;          
    public void addNode(int data) 
    {    
        Node newNode = new Node(data);          
        if(head == null)
        {    
            head = newNode;    
        }    
        else
        {    
            newNode.next = head;    
            head = newNode;    
        }    
    } 
    static void removeDuplicate(Node head)
    {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) 
        {
            int curval = current.data;
            if (hs.contains(curval)) 
            {
                prev.next = current.next;
            }
            else 
            {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }
    public void display() 
    {     
        Node current = head;      
        if(head == null) 
        {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) 
        {      
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }    
    public static void main(String[] args) 
    {   
        Scanner sc = new Scanner(System.in); 
        q3 List = new q3(); 
        System.out.println("Enter total number of nodes ") ;
        int n = sc.nextInt();   
        for(int i = 0; i<n;i++){
            List.addNode(sc.nextInt());
         }
        List.display(); 
        removeDuplicate(head);
        List.display();
    } 
}