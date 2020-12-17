package chap4;

import java.util.ArrayList;
import java.util.List;

public class JHSDBTestCase {
    private static class ObjectHolder{}

    static class Test{
        static ObjectHolder staticObj=new ObjectHolder();
        ObjectHolder instanceObj=new ObjectHolder();

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
