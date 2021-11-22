
import java.util.Scanner;

class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}
public class Addll {
	Node head = null;
	static Scanner sc = new Scanner(System.in);
	void Add(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.next = null;
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
			}
		}
	void Display() {
		if(head == null)
			System.out.println("Invalid");
		else {
			Node List = head;
			System.out.println("Data : ");
			while(List!=null) {
				System.out.println(""+ List.data +"");
				List = List.next;
			}
		}
	}
	 Node add1(Addll list2) {
		Node a = this.head;
		Node b = list2.head;
		Node c = head;
		 while (a != null && b != null)
	        {
	          c.data = a.data+b.data;
	          a = a.next;
	          b = b.next;
	}
		 
	}
	public static void main(String[]args) {
		Addll list1 = new Addll();
		Addll list2 = new Addll();
		Addll list3 = new Addll();
		for(int i = 0;i <5 ; i++) {
			System.out.println("Enter data for List 1");
		int data = sc.nextInt();
		list1.Add(data);
		list1.Display();
		
		}
		for(int i = 0;i <5 ; i++) {
			System.out.println("Enter data for List 2");
			int data1 = sc.nextInt();
			list2.Add(data1);
			list2.Display();
		}
		list3 = list1.add1(list2);
		list3.Display();
		
	
	}

}