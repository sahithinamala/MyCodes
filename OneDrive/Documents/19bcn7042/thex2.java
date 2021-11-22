public class thex2 extends Thread{
    public void run()
    {
        System.out.println("Child thread");
        System.out.println(Thread.currentThread().getPriority());
    }
    public static void main(String[] args){
        System.out.println("Old priority \n"+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        System.out.println("New priority main \n"+Thread.currentThread().getPriority());

        thex2 t = new thex2();
        t.setPriority(11);
        t.start();
}
}
