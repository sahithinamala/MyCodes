import java.util.*;
class q2{
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
public void push(int data)
{
Node new_node = new Node(data);
if(head==null){
head=new_node;
}else
{
new_node.next = head;
head=new_node;
}
}
public void partition(int x)
{
Node smallerHead = null, smallerLast = null;
Node greaterLast = null, greaterHead = null;
Node equalHead = null, equalLast =null;
while (head != null)
{
if (head.data == x)
{
if (equalHead == null)
equalHead = equalLast = head;
else
{
equalLast.next = head;
equalLast = equalLast.next;
}
}
else if (head.data < x)
{
if (smallerHead == null)
smallerLast = smallerHead = head;
else
{
smallerLast.next = head;
smallerLast = head;
}
}
else
{
if (greaterHead == null)
greaterLast = greaterHead = head;
else
{
greaterLast.next = head;
greaterLast = head;
}
}
head = head.next;
}
if (greaterLast != null)
greaterLast.next = null;
if (smallerHead == null)
{
if (equalHead == null){
head=greaterHead;
printList();
return;
}
equalLast.next = greaterHead;
head=equalHead;
printList();
return;
}
if (equalHead == null)
{
smallerLast.next = greaterHead;
head=smallerHead;
printList();
return ;
}
smallerLast.next = equalHead;
equalLast.next = greaterHead;
head=smallerHead;
printList();
}
public void printList()
{
Node temp = head;
while (temp != null)
{
System.out.print(temp.data + " ");
temp = temp.next;
}
}
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    q2 obj=new q2();
    System.out.println("Enter number of nodes");
    int n = sc.nextInt();
    for(int i = 0;i<n;i++){
        obj.push(sc.nextInt());
    }
    int x = 3;
    obj.partition(x-1); 
}
}