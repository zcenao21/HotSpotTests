package chap3;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("I am still Alive :)");
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK= new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        // Finalizer的方法优先级比较低，等待一会儿
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("I am Dead! Bye :(");
        }
;
        SAVE_HOOK = null;
        System.gc();
        // Finalizer的方法优先级比较低，等待一会儿
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("I am Dead! Bye :(");
        }
    }
}
