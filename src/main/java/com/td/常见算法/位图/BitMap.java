package com.td.常见算法.位图;

import org.junit.Test;

/**
 * 位图
 */
public class BitMap {

    @Test
    public void test() {
        BitMap bitMap = new BitMap(3);
        bitMap.set(1);
        bitMap.set(3);
        System.out.println(bitMap.get(1)+ "，" + bitMap.get(2) + "，" + bitMap.get(3)); // true，false，true
    }

    // Java 中 char 类型占 16bit，也即是 2 个字节，这 16 位可对应为 16 个数据
    private char[] bytes;
    private int nBits;

    public BitMap(int nBits) {
        this.nBits = nBits;
        this.bytes = new char[nBits / 16 + 1];
    }

    public void set(int k) {
        if (k > nBits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nBits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
