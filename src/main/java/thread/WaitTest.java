package thread;

import java.util.Random;

public class WaitTest {
    private static final Object obj = new Object();
    private static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {
        WaitTest test = new WaitTest();
        for(int i=0;i<10;i++){
            getThread().start();
        }
        test.run();
    }

    public void run() throws InterruptedException {
        while(true){
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+" - thread run");
                obj.notifyAll();
            }
        }
    }

    public static Thread getThread(){
        return new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized (obj){
                        System.out.println(Thread.currentThread().getName()+" thread run");
                        try {
                            Thread.sleep(random.nextInt(2000));
                            obj.wait();
                            System.out.println(Thread.currentThread().getName()+" thread wait stop!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
