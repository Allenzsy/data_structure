package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void buildHeap() {

        int[] A = new int[]{1,2,3,4,5,6,7,8};
        Heap maxHeap = new Heap(A);

        System.out.println("构建前：");
        for(int i : maxHeap.data) {
            System.out.print(i+" ");
        }
        System.out.println("");

        maxHeap.buildHeap();

        System.out.println("构建后：");
        for(int i : maxHeap.data) {
            System.out.print(i+" ");
        }
        System.out.println("");

        int max = maxHeap.delteMax();
        System.out.println("弹出最大值后：");
        for(int i : maxHeap.data) {
            System.out.print(i+" ");
        }
        System.out.println("");

        maxHeap.insert(9);
        System.out.println("插入元素9后：");
        for(int i : maxHeap.data) {
            System.out.print(i+" ");
        }
        System.out.println("");



    }
}