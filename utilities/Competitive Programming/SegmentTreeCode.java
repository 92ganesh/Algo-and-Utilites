import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SegmentTreeCode {
    public static int MOD = (int)1e9+7;
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

        long arr[] = new long[]{1, 2 ,3, -2, 3};
        SegmentTree seg = new SegmentTree(arr);

//        int level=1,lcount=0;
//        for(int i=1;i<15;i++){
//            System.out.print(sega[i]+" ");
//            lcount++;
//            if(lcount==level){
//                level *= 2;
//                lcount=0;
//                System.out.println();
//            }
//        }
//        System.out.println();

        System.out.println(seg.query(3,4));
        System.out.println("end ");

    }
}


class SegmentTree{
    private long[] segTree;
    private  long[] arr;
    private long MOD;
    HashMap<Integer,Integer> treeToArryIndex;

    SegmentTree(long[] a, long MOD){
        arr = a;
        this.MOD = MOD;
        treeToArryIndex=new HashMap<>();
        build();
    }
    SegmentTree(long[] a){
        arr = a;
        this.MOD = Long.MAX_VALUE;
        treeToArryIndex=new HashMap<>();
        build();
    }

    // what to store in the nodes
    private long segFunc(long a,long b){
        return (a+b)%MOD;
    }

    private long[] build(){
        //Height of segment tree
        long x = (long) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        //Maximum size of segment tree
        int max_size =  (1<<(x+1)) - 1;  //2 * (int) Math.pow(2, x) - 1;
        segTree = new long[max_size+1];
        recurr(1,arr.length,1);
        return segTree;
    }

    private void recurr(int left,int right,int ind) {
        if (left == right) {
            segTree[ind] = arr[left-1]%MOD;
        } else {
            int mid = left + (right - left) / 2;
            int lchild = ind<<1;
            int rchild = lchild+1;
            recurr(left, mid, lchild);
            recurr(mid + 1, right, rchild);
            segTree[ind] = segFunc(segTree[lchild],segTree[rchild]);
        }
    }

    public long query(int l, int r){
        return query(0,arr.length-1,l,r,1);
    }

    private long query(int left,int right, int qleft,int qright, int ind) {
         if (left == qleft&&right==qright) {
             return segTree[ind];
        } else {
            long sum1=0, sum2=0;
            int mid = left + (right - left) / 2;
            int lchild = ind<<1;
            int rchild = lchild+1;

            if(qleft<=mid){
                if(qright>=mid){
                    sum1 = query(left, mid, qleft, mid, lchild);
                }else{
                    sum1 = query(left, mid, qleft, qright, lchild);
                }
            }

            if(qright>mid){
                if(qleft>mid){
                    sum2 = query(mid+1, right, qleft, qright, rchild);
                }else{
                    sum2 = query(mid+1, right, mid+1, qright, rchild);
                }
            }
            return segFunc(sum1,sum2);
        }
    }
}
