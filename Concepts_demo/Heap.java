package Concepts_demo;

import java.util.Arrays;

public class Heap {
    int[] heapArr;

    public Heap(int[] arr) {
        this.heapArr = Arrays.copyOf(arr, arr.length);
//        this.heapArr = new int[arr.length];
        buildMaxHeap(heapArr, 0);
    }

    void buildMaxHeap(int[] arr, int index){
        System.out.println("index "+index);
        if(index>=arr.length){
            return;
        }

        int leftChildIndex = index*2+1;
        int rightChildIndex = index*2+2;

        if(leftChildIndex >= arr.length && rightChildIndex>=arr.length) {
            System.out.println("leaf "+index);
            //leaf nodes
            heapArr[index] = arr[index];
        }else{
            buildMaxHeap(arr, leftChildIndex);
            buildMaxHeap(arr, rightChildIndex);

            if ( leftChildIndex<arr.length && arr[leftChildIndex] > arr[index] && compare(arr, leftChildIndex, rightChildIndex, true)  ) {
                swap(arr, leftChildIndex, index);
            } else if (rightChildIndex<arr.length && arr[rightChildIndex] > arr[index] && compare(arr, rightChildIndex, leftChildIndex, true)  ) {
                swap(arr, rightChildIndex, index);
            }
        }
    }

    boolean compare(int[] arr, int i, int j, boolean defaultVal){
        if(i>=arr.length || j>=arr.length) return defaultVal;
        return  arr[i] > arr[j];
    }

    void swap(int[] arr, int i, int j) {
        if(i<arr.length && j<arr.length){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    @Override
    public String toString() {
        return "Heap{" +
                "heapArr=" + Arrays.toString(heapArr) +
                '}';
    }
}
