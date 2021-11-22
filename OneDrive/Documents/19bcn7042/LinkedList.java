import java.util.*;
class LinkedList
{
    Node head;  
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    void EvenOdd()
    {
        Node end = head;
        Node prev = null;
        Node curr = head;
        while (end.next != null)
            end = end.next;
 
        Node new_end = end;
        while (curr.data %2 !=0 && curr != end)
        {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
 
        if (curr.data %2 ==0)
        {
            head = curr;
            while (curr != end)
            {
                if (curr.data % 2 == 0)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }
        else prev = curr;
 
        if (new_end != end && end.data %2 != 0)
        {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }
    void add(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
        LinkedList llist = new LinkedList();
		int n = sc.nextInt();
		int data = 0;
		for(int i = 0;i<n;i++){
			data = sc.nextInt();
			llist.add(data);
		}
        
        System.out.println("Original Linked List");
        llist.printList();
 
        llist.EvenOdd();
 
        System.out.println("New Linked List");
        llist.printList();
    }
}