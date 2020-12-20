package chap4;

import java.util.ArrayList;
import java.util.List;

public class OOMObjectConsoleTest {
    static class OOMObjec{
        public byte[] placeholder=new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObjec> list=new ArrayList<OOMObjec>();
        for(int i=0;i<num;i++){
            Thread.sleep(100);
            list.add(new OOMObjec());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
