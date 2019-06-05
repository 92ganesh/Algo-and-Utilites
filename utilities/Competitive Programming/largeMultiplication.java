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
