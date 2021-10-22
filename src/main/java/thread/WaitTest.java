package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class WaitTest {
    private static final Object obj = new Object();
    private static Queue<Integer> q = new LinkedList<>();
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
                q.add(random.nextInt());
                System.out.println(q);
                Thread.sleep(1000);
                obj.notifyAll();
            }
        }
    }

    public static Thread getThread(){
        return new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized (obj){
                        if(q.size()<1){
                            try{
                                System.out.println(Thread.currentThread().getName()+ " run ");
                                obj.wait();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+ " get " + q.poll());
                        }
                    }
                }
            }
        });
    }
}
