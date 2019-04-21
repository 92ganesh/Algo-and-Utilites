import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

class template {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        try {
            br = new BufferedReader(new FileReader("G:\\Warehouse\\custom.txt"));
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int t = ri();
        while(t-- >0){

        }



    }


    /* TEMPLATE CREATED BY GANESH PATRA ON 05 March,2019*/
    private static int ri() throws Exception{           return Integer.parseInt(br.readLine()); }
    private static int ri(String s){                    return Integer.parseInt(s);             }
    private static String rs() throws Exception{        return br.readLine();                   }
    private static String[] rss() throws Exception{     return br.readLine().split(" ");   }
    private static void pf(Object ob){ System.out.print(ob); }
    private static void pfn(Object ob){System.out.println(ob); }
    private static void pfn(int[] arr){
        for(int i=0;i<arr.length;i++){  System.out.print(arr[i]+" ");   }
        System.out.println();
    }
}
