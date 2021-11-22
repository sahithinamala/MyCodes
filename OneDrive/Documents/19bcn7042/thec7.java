public class thec7 extends Thread {
    public void run(){
        try{
System.out.println("---");
            for (int i = 6; i <= 10; i++)
    
            {
                Thread.yield();
sleep(1000);
                System.out.println("Inside thread\t:"+Thread.currentThread().getName());
                System.out.println("Priority is:"+Thread.currentThread().getPriority());
                System.out.println(i);
            }
}
catch(Exception e){}
        
        
    }
    public static void main(String[] args) {
        thec7 t1 = new thec7();
        t1.start();
        for (int i = 11; i <= 16; i++)
    
            {
                Thread.yield();
                System.out.println("Inside thread\t:"+Thread.currentThread().getName());
                System.out.println("Priority is:"+Thread.currentThread().getPriority());

                System.out.println(i);
           }

    }
}
