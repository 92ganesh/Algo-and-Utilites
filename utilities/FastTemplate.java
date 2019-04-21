/*
 * FAST READER is used from www.geeksforgeeks.org
 * refer at https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 *
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class FastTemplate {
    static Reader br;
    public static void main(String[] args) throws Exception{
        try {
            br=new Reader("G:\\Warehouse\\custom.txt");
        } catch (Exception e) {
            br=new Reader();
        }
        StringBuilder sb = new StringBuilder();

        int t = ri();
        while (t-- > 0) {

        }



    }


    /* HELPER FUNCTIONS CREATED BY GANESH PATRA ON 05 March,2019*/
    private static int ri() throws Exception{           return br.nextInt(); }
    private static int ri(String s){                    return Integer.parseInt(s);             }
    private static String rs() throws Exception{        return br.readLine();                   }
    private static String[] rss() throws Exception{     return br.readLine().split(" ");   }
    private static void pf(Object ob){ System.out.print(ob); }
    private static void pfn(Object ob){System.out.println(ob); }
    private static void pfn(int[] arr){
        for(int i=0;i<arr.length;i++){  System.out.print(arr[i]+" ");   }
        System.out.println();
    }

    //**************************************************************************
    /*
     * FAST READER copied from www.geeksforgeeks.org
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
