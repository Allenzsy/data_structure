package datastructures;

public class Heap {

    int[] data = null;
    int capacity = 0;
    int size = 0;

    Heap() {
        this(10);
    }

    Heap(int maxSize) {
        data = new int[maxSize];
        capacity = maxSize;
    }

    Heap(int[] data) {
        this.data = data;
        this.size = data.length;
        this.capacity = data.length;
    }

    /**
     * 调整 data 中的元素，使满足最大堆的有序性,这里假设所有 size 个元素已经存在 data 中
     */
    public void buildHeap() {
        for(int i = (size-1)/2; i>=0; i--) {
            percDown(i);
        }
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int delteMax() {
        if(isEmpty()) {
            throw new RuntimeException("最大堆已空");
        }
        int maxTemp = data[0];
        int last = data[size-1];
        size--;
        data[0] = last;
        percDown(0);
        return maxTemp;
    }

    public void insert(int x) {
        if(isFull()) {
            throw new RuntimeException("最大堆已满");
        }
        int i = ++size; // 因为索引从0开始的
        for(i = i-1; (data[(i-1)/2] < x) &&(i > 0) ; i = (i-1)/2) {
            data[i] = data[(i-1)/2];
        }
        data[i] = x;
    }


    /**
     * 从指定节点从上到下调整最大堆
     * @param p
     */
    private void percDown(int p) {

        // 缓存要移动的节点值
        int temp = data[p];
        int parent, child;
        for(parent=p; (parent*2+1) < size; parent=child) {
            child = parent*2+1;
            if((child < size-1) && (data[child] < data[child+1])) {
                child++;
            }
            if(temp > data[child]) {
                break;
            } else {
                data[parent] = data[child];
            }
        }
        data[parent] = temp;
    }





}
