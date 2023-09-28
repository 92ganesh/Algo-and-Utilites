mergeSort(arr, 0, arr.length-1);



static void mergeSort(long[] arr, int i, int j){
    if(i<j && j<arr.length){
        int middle = i + (j-i)/2;
        mergeSort(arr, i, middle);
        mergeSort(arr, middle+1, j);
        mergeArrays(arr, i, middle, j);
    }
}

static void mergeArrays(long[] arr, int i, int middle, int j){
    long[] tmp1 = Arrays.copyOfRange(arr, i, middle+1);
    long[] tmp2 = Arrays.copyOfRange(arr, middle+1, j+1);

    int t1=0, t2=0;
    for(int ind = i; ind<=j; ind++) {

        if(t1<tmp1.length && t2<tmp2.length){
            if (tmp1[t1] < tmp2[t2]) {
                arr[ind] = tmp1[t1];
                t1++;
            } else {
                arr[ind] = tmp2[t2];
                t2++;
            }
        }else if(t1<tmp1.length){
            arr[ind] = tmp1[t1];
            t1++;
        }else{
            arr[ind] = tmp2[t2];
            t2++;
        }


    }
}
