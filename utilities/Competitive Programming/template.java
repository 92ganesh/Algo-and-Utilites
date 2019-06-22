import java.io.*;
import java.util.*;

class template {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        try {
            br = new BufferedReader(new FileReader("G:\\Workspace\\codechef\\custom.txt"));     debug=0;
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));      debug=0;
        }
        StringBuilder sb = new StringBuilder();

        int t = ri();
        while(t-- >0){

        }



    }








    //****************  Helper functions template from  ******************
    public static int MOD = (int)1e9+7;
    private static int ri() throws Exception{           return Integer.parseInt(br.readLine().trim());}
    private static long rl() throws Exception{          return Long.parseLong(br.readLine().trim());}
    private static int ri(String s){                    return Integer.parseInt(s);}
    private static long rl(String s){                   return Long.parseLong(s);}
    private static String rs() throws Exception{        return br.readLine();}
    private static String[] rss() throws Exception{     return br.readLine().trim().split("\\s+");}
    private static void pf(Object ob){ System.out.print(ob);}
    private static void pfn(Object ob){System.out.println(ob);}
    private static void pfn(){System.out.println();}
    private static void pfn(int[] arr){
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<arr.length;i++){  temp.append(arr[i]).append(' ');}
        System.out.println(temp);
    }
    private static void pfn(long[] arr){
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<arr.length;i++){  temp.append(arr[i]).append(' ');  }
        System.out.println(temp);
    }
    static int debug=0;
    private static void df(Object ob){ if(debug==1) System.out.print(ob); }
    private static void dfn(Object ob){ if(debug==1) System.out.println(ob); }
    private static void dfn(){ if(debug==1) System.out.println(); }
    private static void dfn(int[] arr){
        if(debug==1) {
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<arr.length;i++){  temp.append(arr[i]).append(' ');  }
            System.out.println(temp);
        }
    }
}
