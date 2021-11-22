import java.util.*;
class Assn9{
    static Scanner sc = new Scanner(System.in);
    public static String FAUX = null;
    static volatile boolean exit = false;
    void Armstrong(){
        synchronized(this){
            Thread.currentThread().setName("CRUX");
        System.out.println(Thread.currentThread().getName() + " started");
        System.out.println("Enter the number: ");
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
                FAUX = "It is an Armstrong number";
               System.out.println(FAUX);
            }
            else{
                FAUX = "It is not an Armstrong number";
               System.out.println(FAUX);
            }
            try {
                wait();
            } catch (Exception e) {}
        }
    }
    void Special(){
        synchronized(this){
        Thread.currentThread().setName("SNAP");
        System.out.println(Thread.currentThread().getName() + " started");
            int num, number, last_digit, sum_Of_Fact = 0;  
            System.out.println("Enter the number: ");  
            number = sc.nextInt();  
            num = number;  
            while (number > 0)  
            {       
            last_digit = number % 10;  
            int fact=1;  
            for(int i=1; i<=last_digit; i++)  
            {        
            fact=fact*i;  
            }  
            sum_Of_Fact = sum_Of_Fact + fact;  
            number = number / 10;  
            }  
            if(num==sum_Of_Fact)  
            {  
                 FAUX = "It is a Special number";
                 System.out.println(FAUX);
            }  
            else  
            {  
                FAUX = "It is not a Special number";
            System.out.println(FAUX);  
            }
            try {
                wait();
            } catch (Exception e) {}    
        }

    }
    public static void main(String[]args) throws Exception{
        
        Assn9 assn = new Assn9();
        System.out.println("Main Thread started : " + Thread.currentThread().getName());
        Thread CRUX = new Thread(new Runnable() {
            public void run()
            {
                while(exit == false)
                assn.Armstrong();
                
            }
        });
        Thread SNAP = new Thread(new Runnable(){
            public void run()
            {
                while(exit == false)
                assn.Special();
            }
        });  
        CRUX.start(); 
        SNAP.start();
        try {
            Thread.sleep(6000);
        }
        catch (Exception e) {}
        exit = true;
        System.out.println("Main ended");
    }
}