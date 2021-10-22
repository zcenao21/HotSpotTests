package thread;

public class InteruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true);
            }
        });

        t1.start();
        t2.start();
        t1.interrupt();
        t2.interrupt();

        System.out.println(t1.isInterrupted());
        System.out.println(t2.isInterrupted());
    }
}
