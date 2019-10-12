package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {
    Sorting sortingTest = new Sorting();
    int[] A = {13,36,67,42,46,13,87,18,39,10};

    @Test
    public void bubble_sort() {

        System.out.println("排序前：");
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println("");
        sortingTest.bubble_sort(A, A.length);
        System.out.println("排序后：");
        for(int i : A) {
            System.out.print(i+" ");
        }

    }


    @Test
    public void insertion_sort() {
        System.out.println("排序前：");
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println("");
        sortingTest.insertion_sort(A, A.length);
        System.out.println("排序后：");
        for(int i : A) {
            System.out.print(i+" ");
        }

    }
    @Test
    public void heap_sort() {
        System.out.println("排序前：");
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println("");
        sortingTest.heap_sort(A, A.length);
        System.out.println("排序后：");
        for(int i : A) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void quick_sort() {
        System.out.println("排序前：");
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println("");
        sortingTest.quick_sort(A, A.length);
        System.out.println("排序后：");
        for(int i : A) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void test1() {
        int i = 1;
        int a = i++ + (++i + ++i) + ++i;
        System.out.println(a);
    }

}