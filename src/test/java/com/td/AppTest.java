package com.td;

import com.td.常见算法.位图.BitMap;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() {
        BitMap bitMap = new BitMap(3);
        bitMap.set(1);
        bitMap.set(3);
        System.out.println(bitMap.get(1)+ "，" + bitMap.get(2) + "，" + bitMap.get(3)); // true，false，true
    }
}
