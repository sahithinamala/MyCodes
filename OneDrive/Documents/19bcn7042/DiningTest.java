public class DiningTest {
    public static void main(String[] args){
		
        Chopstick CH = new Chopstick();
            new Philosopher(CH).start();
            new Philosopher(CH).start();
            new Philosopher(CH).start();
            new Philosopher(CH).start();
            new Philosopher(CH).start();
    }
}