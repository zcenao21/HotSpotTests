package com.will;

import org.junit.Test;

public class GCTests{
    private static final int _1MB=1024*1024;
    @Test
    public void testAllocation(){
        byte[] allocation1,allocation2, allocation3, allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
        allocation4=new byte[2*_1MB];
    }

    @Test
    public void testPretenureSizeThreshold(){
        byte[] allocation1;
        allocation1=new byte[4*_1MB];
    }
}