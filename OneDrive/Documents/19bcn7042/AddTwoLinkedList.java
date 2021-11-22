
import java.util.*;
class Node{
Node next;
int new_data;
Node(int new_data){
this.new_data=new_data;
}
}
public class AddTwoLinkedList {
static Node head=null;
static Node head1=null;
public static void main(String []args) {
Scanner in=new Scanner(System.in);
System.out.println("Enter values of 1st LinkedList: ");
for(int i=0;i<5;i++) {
int j=in.nextInt();
Push(j);
}
Display();
System.out.println("Enter the values of 2nd LinkedList");
for(int k=0;k<4;k++) {
int l=in.nextInt();
Push2(l);
}
Display2();
Add();
}
static void Push(int new_data) {
Node temp=head;
Node new_node=new Node(new_data);
if(head==null) {
head=new_node;
}
else {
while(temp.next!= null) {
temp=temp.next;
}
temp.next=new_node;
}
}
//static void Pop() {
//Node temp=head;
// if(head==null) {
//}
//}
static void Push2(int new_data) {
Node temp1=head1;
Node new_node=new Node(new_data);
if(head1==null) {
head1=new_node;
}
else {
while(temp1.next!= null) {
temp1=temp1.next;
}
temp1.next=new_node;
}
}
static void Display() {
Node temp=head;
System.out.println("First Linked list");
while(temp!=null) {
System.out.println(temp.new_data+" ");
temp=temp.next;
}
}
static void Display2() {
Node temp1=head1;
System.out.println("Second Linked List");
while(temp1!=null) {
System.out.println(temp1.new_data+" ");
temp1=temp1.next;
}
}
static void Add() {
Node temp=head;
Node temp1=head1;
System.out.println("Sum of both Linked List: ");
while(temp!=null && temp1!=null) {
System.out.print(temp.new_data+temp1.new_data+" ");
temp=temp.next;
temp1=temp1.next;
}
}
}

