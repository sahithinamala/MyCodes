import java.util.*;
public class Assignment9 {
  
    int counter = 1;
  
    static int N;
  
    // Function to print odd numbers
    public void Armstrong()
    {
        static Scanner sc = new Scanner(System.in);
        synchronized (this)
        {
            try{
            System.out.println("Enter the number");
            int n = sc.nextInt();
            int temp;
            int digits = 0;
            int last = 0;
            int sum = 0;
            temp = n;
            while(temp>0)    
            {  
                temp = temp/10;   
                digits++;   
            }   
            temp = n;   
            while(temp>0)   
            {   
                  
                last = temp % 10;   
                sum +=  (Math.pow(last, digits));      
                temp = temp/10;   
            }  
            if(n == sum){
                Assn9.FAUX = "It is an Armstrong number";
               // System.out.println(Assn9.FAUX);
            }
            else{
                Assn9.FAUX = "It is not an Armstrong number";
               // System.out.println(Assn9.FAUX);
            }
        }
        catch(Exception e){}
        }
    }
  
    // Function to print even numbers
    public void printEvenNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {
  
                // If count is odd then print
                while (counter % 2 == 1) {
  
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
  
                // Print the number
                System.out.print(
                    counter + " ");
  
                // Increment counter
                counter++;
  
                // Notify to 2nd thread
                notify();
            }
        }
    }
  
    // Driver Code
    public static void main(String[] args)
    {
        // Given Number N
          String FAUX = null;
        // Create an object of class
        Assignment9 mt = new Assignment9();
  
        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.Armstrong();
            }
        });
  
        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printOddNumber();
            }
        });
  
        // Start both threads
        t1.start();
        t2.start();
    }
}