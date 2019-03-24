import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SegmentTreeCode {
    public static void main(String[] args){
        InputStreamReader ir;
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("G:\\Warehouse\\custom.txt");
            br = new BufferedReader(fr);
        } catch (Exception e) {
            ir = new InputStreamReader(System.in);
            br = new BufferedReader(ir);
        }

        System.out.println("main");
        int arr[] = new int[]{1,3,5,7,9,11};
        SegmentTree seg = new SegmentTree(arr);

        int[] sega = seg.build();
        int level=1,lcount=0;
        for(int i=1;i<15;i++){
            System.out.print(sega[i]+" ");
            lcount++;
            if(lcount==level){
                level *= 2;
                lcount=0;
                System.out.println();
            }
        }

    }
}


class SegmentTree{
    private int[] segTree;
    private  int[] arr;
    SegmentTree(int[] a){
        arr = a;
    }
    int[] build(){
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        //Maximum size of segment tree
        int max_size =  (1<<(x+1)) - 1;  //2 * (int) Math.pow(2, x) - 1;
        segTree = new int[max_size];
        recurr(1,arr.length,1);
        return segTree;
    }

    void recurr(int left,int right,int ind) {
        //System.out.println((left-1)+" - "+(right-1)+" - "+ind);
        if (left == right) {
            segTree[ind] = arr[left-1];
        } else {
            int mid = left + (right - left) / 2;
            int lchild = ind<<1;
            int rchild = lchild+1;
            recurr(left, mid, lchild);
            recurr(mid + 1, right, rchild);
            segTree[ind] = segTree[lchild]+segTree[rchild];
        }
    }
}
