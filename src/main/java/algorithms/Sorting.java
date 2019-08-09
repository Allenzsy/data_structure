package algorithms;

public class Sorting {

    /**
     * 冒泡排序
     * @param A
     * @param N
     */
    public void bubble_sort(int[] A, int N) {
        if(A == null || A.length == 0 || N ==0) {
            return;
        }
        for(int p = N-1; p >= 0; p--) {
            int flag = 0;
            for (int i = 0; i < p; i++) {
                if (A[i] > A[i+1]) {
                    swap(A, i, i + 1);
                    flag = 1;
                }
            }
            if(flag == 0) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param A
     * @param N
     */
    public void insertion_sort(int[] A, int N) {
        if(A == null || A.length == 0 || N ==0) {
            return;
        }
        for (int p = 1; p < N; p++) {
            int temp = A[p];
            int i = 0;
            for (i = p; i>0 && A[i-1]>temp; i--) {
                A[i] = A[i-1];
            }
            A[i] = temp;
        }
    }

    /**
     *  希尔排序 - 用Sedgewick增量序列
     * @param A
     * @param N
     */
    void ShellSort(int  A[], int N ) {
        int Si, D, P;

        /* 这里只列出一小部分增量 */
        int Sedgewick[] = {929, 505, 209, 109, 41, 19, 5, 1, 0};

        for (Si=0; Sedgewick[Si]>=N; Si++ ) { /* 初始的增量Sedgewick[Si]不能超过待排序列长度 */

            for (D = Sedgewick[Si]; D > 0; D = Sedgewick[++Si]) {
                for (P = D; P < N; P++) { /* 插入排序*/
                    int Tmp = A[P];
                    int i = 0;
                    for (i = P; i >= D && A[i - D] > Tmp; i -= D) {
                        A[i] = A[i - D];
                    }
                    A[i] = Tmp;
                }
            }
        }
    }

    /**
     * 堆排序
     * @param A
     * @param N
     */

    public void heap_sort(int[] A, int N) {
        for (int i = (N-1)/2; i >= 0 ; i--) {
            percDownMax(A, i, N); // 构建最大堆
        }
        for (int i = N-1; i > 0; i--) {
            swap(A, 0, i);
            percDownMax(A, 0, i);
        }
    }
    /**
     * 将一个数组构建成最大堆
     * @param A
     * @param pos
     * @param size
     */
    private void percDownMax(int[] A, int pos, int size) {
        int temp = A[pos];
        int parent,child;
        for (parent=pos; (parent*2+1) < size; parent=child) {
            child = parent*2+1;
            if ((child < size-1) && (A[child]<A[child+1])) {
                child++;
            }
            if (A[child] < temp) {
                break;
            } else {
                A[parent] = A[child];
            }
        }
        A[parent] = temp;
    }


    private void merge (int[] A, int[] tempA, int lStart, int rStart, int rEnd) {
        int lEnd = rStart - 1;
        int tmp = lStart;
        int numElement = rEnd-lStart+1;
        while (lStart <= lEnd && rStart <= rEnd) {
            if (A[lStart] <= A[rStart]) {
                tempA[tmp++] = A[lStart++];
            } else {
                tempA[tmp++] = A[rStart++];
            }
        }
        while (lStart <= lEnd) {
            tempA[tmp++] = A[lStart++];
        }
        while (rStart <= lEnd) {
            tempA[tmp++] = A[rStart++];
        }
        for (int i = 0; i < numElement; i++, rEnd--) {
            A[rEnd] = tempA[rEnd];
        }
    }

    private void mSort (int[] A, int[] tempA, int lStart, int rEnd) {
        int center;
        if(lStart < rEnd) {
            center = (lStart + rEnd) / 2;
            mSort(A, tempA, lStart, center);
            mSort(A, tempA, center+1, rEnd);
            merge(A, tempA, lStart, center+1, rEnd);
        }
    }



    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



}
