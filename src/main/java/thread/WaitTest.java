package thread;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class WaitTest {
    private static final int sleepSecondMax = 1000;  // 随机睡眠时间的最大值
    private static final int threadNum = 3;     // 向队列放置和取数的线程数量
    public static final int showFactor = 1;     // 队列元素个数 x showFactor 等于展示的"="个数
    public static final int showBase = 0;     // 初始元素个数
    private static final int showFrequency = 1000; // 控制台刷新频率
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException, IOException {
        QueueOp test = new QueueOp();
        for(int i=0;i< showBase;i++) test.addInt(1);
        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            int num = random.nextInt(sleepSecondMax);
                            test.addInt(num);
                            Thread.sleep(num);
//                            System.out.println(Thread.currentThread().getName()+" put num");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            Thread.sleep(random.nextInt(sleepSecondMax));
                            test.remove();
//                            System.out.println(Thread.currentThread().getName()+" get num " + );
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        while(true){
            test.printContent();
            Thread.sleep(showFrequency);
        }
    }



}

class QueueOp{
    private static Queue<Integer> q = new LinkedList<Integer>();

    public synchronized void printContent(){
        System.out.println("Queue content:"+q);
    }

    public void printQueueSize(){
        System.out.println("Queue size:"+q.size());
    }

    public void printQueueSizeVisual() throws IOException, InterruptedException {
        int num = q.size();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num*WaitTest.showFactor;i++){
            sb.append("=");
        }
        System.out.println(sb.toString());
    }

    public synchronized void addInt(int i) throws InterruptedException {
        q.add(i);
        this.notifyAll();
    }

    public synchronized int remove() throws InterruptedException {
        while(q.size()<1){
            this.wait();
        }
        return q.remove();
    }
}
