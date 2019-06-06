import java.util.*;
public class Helper {
    // Time Complexity O(log(n))
    // Note:- log with base 2
    static public boolean BinarySearch(long arr[], int l,int r,int val){
        if(l<=r&&arr[l]<=val&&val<=arr[r]){
            int mid = l + (r-l)/2;
            if(arr[mid]==val){
                return true;
            }else{
                if(arr[mid]>val){
                    return BinarySearch(arr,l,mid,val);
                }else{
                    return BinarySearch(arr,mid,r,val);
                }
            }
        }
        return false;
    }

    // GCD by Euclidean algorithms
    // Time Complexity: O(Log min(a, b))
    public static long gcd(long a,long b){
        return (b==0?a:gcd(b,a%b));
    }

    // LCM by by property lcm*gcd = a*b
    // Time Complexity: O(Log min(a, b))
    public static long lcm(long a,long b,long MOD){
        long gcdVal = gcd(a,b);
        return ((a*b)/gcdVal)%MOD;
    }


    // returns length of LCS i.e Longest Common Subsequence
    // Time Complexity:- O(m*n)
    public static int LCS(String a,String b){
        int dp[][] = new int[a.length()+1][b.length()+1];
        for(int i=0;i<dp[0].length;i++){ dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){  dp[i][0]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }


    // Self implementation of MultiSet using TreeMap
    static class MultiSet<T>{
        TreeMap<T,Integer> hm;
        int totalElements;
        MultiSet(){
            hm=new TreeMap<>();
            totalElements=0;
        }

        // O(logN)
        void add(T key){
            Integer val = hm.get(key);
            if(val==null){ val=0; }
            hm.put(key,val+1);
            totalElements++;
        }

        // O(logN)
        void removeOne(T key){
            Integer val = hm.get(key);
            if(val!=null){
                val--;  totalElements--;
                if(val==0){ hm.remove(key); }
                else{   hm.put(key,val);    }
            }
        }

        // O(logN)
        void removeAll(T key){
            hm.remove(key);
            totalElements=0;
        }

        // O(N)
        T get(int n){
            if(n<0||n>totalElements-1) return null;
            n++;
            for(T each:hm.keySet()){
                if(hm.get(each)<=n){
                    n -= hm.get(each);
                    if(n==0){ return each; }
                }else{
                    return each;
                }
            }
            return null;
        }

        // O(N)
        ArrayList<T> getAll(){
            ArrayList<T> arr=new ArrayList<>();
            for(T each:hm.keySet()){
                for(int i=1,n=hm.get(each); i<=n; i++){
                    arr.add(each);
                }
            }
            return arr;
        }
    }


    // Merger Sort
    // Time Complexity:- O(logN)

    public static int[] mergeSort(int[] arr){
        if(arr.length==1){  return arr;
        }
        int mid = arr.length/2;
        int[] arr1 = Arrays.copyOfRange(arr,0,mid);
        int[] arr2 = Arrays.copyOfRange(arr,mid,arr.length);
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        return  merge(arr1,arr2);
    }
    public static int[] merge(int[] a,int[] b){
        int[] arr = new int[a.length+b.length];
        int m=0,n=0;
        for(int i=0;i<arr.length;i++){
            if(m<a.length&&n<b.length){
                if(a[m]<=b[n]){
                    arr[i]=a[m]; m++;
                }else{
                    arr[i]=b[n]; n++;
                }
            }else{
                while(m<a.length){
                    arr[i]=a[m]; m++; i++;
                }
                while(n<b.length){
                    arr[i]=b[n]; n++; i++;
                }
            }

        }
        return arr;
    }

    public static int[] multiply(int[] a, int[] b){
        int result[] = new int[a.length+b.length+1];
        int offset=0, inc=0, max=result.length-1;
        for(int i=b.length-1;i>=0;i--){
            inc=0; int c=0;
            for(int j=a.length-1;j>=0;j--){
                int resultInd = result.length-1-offset-inc;  inc++;
                int temp = b[i]*a[j]+c; int re = temp%10; c=temp/10;
                result[resultInd]+=re;
                if(result[resultInd]>=10){
                    result[resultInd-1]+= result[resultInd]/10;
                    result[resultInd]= result[resultInd]%10;
                }
                if(resultInd<max){ max=resultInd;}
                if(j==0){   result[max-1]+=c;}
            }offset++;
        }
        return result;
    }

    // fast exponentiation
    static long MOD;
    static long exp(long a, long b) {
        if(b==0)
            return 1;
        long temp = exp(a, b/2);
        if(b%2!=0)
            return ((temp * temp) % MOD * a) % MOD;
        else
            return (temp * temp) % MOD;
    }

    // modular inverse fast exponentiation
    static long modular_inverse(long n) {
        return exp(n, MOD-2);
    }
}

/*
5   - BinarySearch
23  - gcd
29  - lcm
37  - LCS
58  - MultiSet
120 - MergerSort
154 - Large Multiplication
174 - fast exponentiation
186 - modular inverse fast exponentiation
*/
