package algorithms;

public class Sorting {

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

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

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

}
