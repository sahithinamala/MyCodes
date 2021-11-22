import java.util.*;
class Assn9_1{
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
    void Perfect(){
        synchronized(this){
        Thread.currentThread().setName("SNAP");
        System.out.println(Thread.currentThread().getName() + " started");
        long n, sum=0;  
        Scanner sc=new Scanner(System.in);         
        System.out.println("Enter the number: ");  
        n=sc.nextLong();  
        int i=1;  
        while(i <= n/2)  
        {  
        if(n % i == 0)  
        {  
        sum = sum + i;  
        }
        i++;  
        }  
        if(sum==n)  
        {  
            FAUX = "It is a perfect number";
            System.out.println(FAUX);  
        }
        else 
        {
            FAUX = "It is not a perfect number";
            System.out.println(FAUX);   
        }
        try {
            wait();
        } catch (Exception e) {}  
        }

    }
    public static void main(String[]args) throws Exception{
        Assn9_1 assn = new Assn9_1();
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
                assn.Perfect();
                
            }
        });  
        CRUX.start(); 
        SNAP.start();
        try {
            Thread.sleep(6000);
        }
        catch (Exception e) {}
        exit = true;
        // while(CRUX.isAlive()&& SNAP.isAlive()){
        //     CRUX.start(); 
        // SNAP.start();
        // }\
        System.out.println("Main ended");

        
        
    }
}