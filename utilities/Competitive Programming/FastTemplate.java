/*
 * 1) FAST READER is used from www.geeksforgeeks.org
 *    refer at https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 *
 * 2) Helper functions template from :-
 *    https://github.com/92ganesh/Algo-and-Utilites/edit/master/utilities/Competitive%20Programming/FastTemplate.java
 * */

import java.io.*;
import java.util.*;

class FastTemplate {
    static Reader br;
    public static void main(String[] args) throws Exception{
        try {
            br=new Reader("G:\\Workspace\\codechef\\custom.txt");
        } catch (Exception e) {
            br=new Reader();
        }
        StringBuilder sb = new StringBuilder();

        int t = ri();
        while (t-- > 0) {

        }



    }









    // Helper functions template from :-
    // https://github.com/92ganesh/Algo-and-Utilites/edit/master/utilities/Competitive%20Programming/FastTemplate.java
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


    //**************************************************************************
    /*
     * FAST READER referred from www.geeksforgeeks.org
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     * */
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    //**************************************************************************



}
