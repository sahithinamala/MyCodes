public class ThreadE3
{



    public static void main(String [] args)
    {
        //System.out.println("In the main");
        //System.out.println("Old Name of thread \t"+Thread.currentThread().getName());
        Thread.currentThread().setName("OS");
        //System.out.println("New Name of thread \t"+Thread.currentThread().getName());
        System.out.println(100/0);

        
    }
}