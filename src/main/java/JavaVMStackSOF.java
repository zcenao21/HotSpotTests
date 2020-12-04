import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class JavaVMStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws InterruptedException {
        JavaVMStackSOF oom=new JavaVMStackSOF();
        for(int i=0;i<10;i++){
            try {
                oom.stackLeak();
            }catch (Throwable e){
                System.out.println("stack length:"+oom.stackLength);
                oom.stackLength=1;
                sleep(10);
            }
        }

    }
}
