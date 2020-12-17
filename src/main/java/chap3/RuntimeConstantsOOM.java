package chap3;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantsOOM {


    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        int i=1;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
