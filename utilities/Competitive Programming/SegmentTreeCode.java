//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class SegmentTreeCode {
//    public static int MOD = (int)1e9+7;
//    public static void main(String[] args){
//        InputStreamReader ir;
//        FileReader fr;
//        BufferedReader br;
//        try {
//            fr = new FileReader("G:\\Warehouse\\custom.txt");
//            br = new BufferedReader(fr);
//        } catch (Exception e) {
//            ir = new InputStreamReader(System.in);
//            br = new BufferedReader(ir);
//        }
//
//        System.out.println("main ");
//        int arr[] = new int[]{1, 2 ,3, -2, 3};
//        SegmentTree seg = new SegmentTree(arr,MOD);
//
//        int[] sega = seg.build();
////        int level=1,lcount=0;
////        for(int i=1;i<15;i++){
////            System.out.print(sega[i]+" ");
////            lcount++;
////            if(lcount==level){
////                level *= 2;
////                lcount=0;
////                System.out.println();
////            }
////        }
////        System.out.println();
//
//        System.out.println(seg.query(0,4,0,4,1));
//    }
//}
//
//
//class SegmentTree{
//    private int[] segTree;
//    private int[] segTreeMin;
//    private  int[] arr;
//    private int MOD;
//    HashMap<Integer,Integer> treeToArryIndex;
//
//    SegmentTree(int[] a, int MOD){
//        arr = a;
//        this.MOD = MOD;
//        treeToArryIndex=new HashMap<>();
//    }
//
//    int[] build(){
//        //Height of segment tree
//        int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
//        //Maximum size of segment tree
//        int max_size =  (1<<(x+1)) - 1;  //2 * (int) Math.pow(2, x) - 1;
//        segTree = new int[max_size];
//        segTreeMin = new int[max_size];
//        recurr(1,arr.length,1);
//        return segTree;
//    }
//
//    private void recurr(int left,int right,int ind) {
//        if (left == right) {
//            segTree[ind] = arr[left-1]%MOD;
//            segTreeMin[ind] = arr[left-1]%MOD;
//        } else {
//            int mid = left + (right - left) / 2;
//            int lchild = ind<<1;
//            int rchild = lchild+1;
//            recurr(left, mid, lchild);
//            recurr(mid + 1, right, rchild);
//            if(segTreeMin[lchild]<=segTreeMin[rchild]){
//                segTreeMin[ind] = segTreeMin[lchild];
//            }else{
//                segTreeMin[ind] = segTreeMin[rchild];
//            }
//            segTree[ind] = (segTree[lchild]+segTree[rchild])%MOD;
//        }
//    }
//
//    public int[] query(int left,int right, int qleft,int qright, int ind) {
//         if (left == qleft&&right==qright) {
//             int result[] = new int[2];
//             result[0] = segTree[ind];
//             result[1] = segTreeMin[ind];
//
//            return result;
//        } else {
//            int sum1=0, sum2=0;
//            int mid = left + (right - left) / 2;
//            int lchild = ind<<1;
//            int rchild = lchild+1;
//
//            int result2[]=new int[2];
//            if(qleft<=mid){
//                if(qright>=mid){
//                    result2[0] = query(left, mid, qleft, mid, lchild);
//                }else{
//                    result2[0] = query(left, mid, qleft, qright, lchild);
//                }
//            }
//
//            if(qright>mid){
//                if(qleft>mid){
//                    sum2 = query(mid+1, right, qleft, qright, rchild);
//                }else{
//                    sum2 = query(mid+1, right, mid+1, qright, rchild);
//                }
//            }
//            return (sum1+sum2)%MOD;
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
