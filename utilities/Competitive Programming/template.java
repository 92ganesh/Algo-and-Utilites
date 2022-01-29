/*
Credits:-
1) Helper functions template from :-
https://github.com/92ganesh/Algo-and-Utilites/blob/master/utilities/Competitive%20Programming/template.java
*/

import java.io.*;
import java.util.*;

class template {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        try {
            br = new BufferedReader(new FileReader("F:\\Workspace\\CompetitiveProgramming\\input.txt"));  debug=true;
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));      debug=false;
        }
        StringBuilder sb = new StringBuilder();

        int t = ri();
        while(t-- >0){


        }
    }


    //Helper functions template from :-
    //https://github.com/92ganesh/Algo-and-Utilites/blob/master/utilities/Competitive%20Programming/template.java
    public static int MOD = (int)1e9+7;
    private static int ri() throws Exception{           return Integer.parseInt(br.readLine().trim());}
    private static long rl() throws Exception{          return Long.parseLong(br.readLine().trim());}
    private static int ri(String s){                    return Integer.parseInt(s);}
    private static long rl(String s){                   return Long.parseLong(s);}
    private static String rs() throws Exception{        return br.readLine();}
    private static String[] rss() throws Exception{     return br.readLine().trim().split("\\s+");}
    private static int[] ass() throws Exception{
        String[] ss = rss();
        int[] arr = new int[ss.length];
        for(int i=0;i<ss.length;i++){
            arr[i]=ri(ss[i]);
        }
        return arr;
    }
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
    static boolean debug=false;
    private static void df(Object ob){ if(debug) System.out.print(ob); }
    private static void dfn(Object ob){ if(debug) System.out.println(ob); }
    private static void dfn(){ if(debug) System.out.println(); }
    private static void dfn(int[] arr){
        if(debug) {
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<arr.length;i++){  temp.append(arr[i]).append(' ');  }
            System.out.println(temp);
        }
    }
}
