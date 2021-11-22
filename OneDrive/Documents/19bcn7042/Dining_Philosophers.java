import java.util.*;
 class Philosopher implements Runnable{
    private Object leftfork;
    private Object rightfork;
    Philosopher(Object leftfork, Object rightfork){
        this.leftfork = leftfork;
        this.rightfork = rightfork;
    }
    void Action(String act){
        try {
           System.out.println( Thread.currentThread().getName() + " " + act);
        } catch (Exception e) {

        }
    }
    public void run(){
        try {
            while(true){
                Action("Thinking");
                synchronized (leftfork){
                    Action("Lift left fork");
                
                synchronized(rightfork){
                    Action("Lift right fork up and Eat");
                    Action("Right fork down");
                    
                }
            }
            Action("Left fork down and think");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return;
        }

    }
}
public class Dining_Philosophers {

    public static void main(String[] args) throws Exception {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher(leftFork, rightFork);
            
            Thread t 
              = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}



