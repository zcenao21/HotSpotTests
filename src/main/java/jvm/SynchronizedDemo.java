package jvm;

public class SynchronizedDemo {
    public void method(){
        synchronized(this){
            System.out.println("Synchronized 代码块");
        }
    }

}