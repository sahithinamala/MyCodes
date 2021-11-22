public class thec9 extends Thread{
    public void run()
    {
         try{
            for (int i = 6; i <= 10; i++)

            {
                System.out.println("Inside outer thread\t:"+i);
             Thread.sleep(1000);
            }
        }
        catch (Exception x)
        {
            System.out.println("Sleep interrupted for the thread:"+Thread.currentThread().getName());
        }
    }

 public static void main(String[] args) {
     thec9 t1 =  new thec9();
     t1.interrupt();
     t1.start();

        
    }
    
}
