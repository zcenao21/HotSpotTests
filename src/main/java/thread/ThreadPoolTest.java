package thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        LinkedList<Future<String>> list = new LinkedList();
        for(int i=0;i<10;i++){
            list.add(executor.submit(new CallableThread()));
        }
        while(!list.isEmpty()){
            Future<String> resultFuture = list.removeLast();
            if(resultFuture.isDone()){
                System.out.println("get result " + resultFuture.get());
            }else{
                list.addFirst(resultFuture);
            }
        }
        executor.shutdown();
    }
}

class CallableThread implements Callable<String> {
    static int cnt = 0;
    static Random random = new Random();
    public synchronized void addOne(){
        cnt++;
    }
    public synchronized void minusOne(){
        cnt--;
    }
    public String getCnt(){
        return Thread.currentThread().getName()+" get " + cnt;
    }

    @Override
    public String call() throws Exception {
        int sleepSec = random.nextInt(1000);
        System.out.println(Thread.currentThread().getName()+" sleep " + sleepSec + " s");
        Thread.sleep(sleepSec);
        addOne();
        return getCnt();
    }
}
