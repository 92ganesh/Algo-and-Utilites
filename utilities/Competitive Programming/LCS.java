public static int LCS(String a,String b){
	int dp[][] = new int[a.length()+1][b.length()+1];
	for(int i=0;i<dp[0].length;i++){
		dp[0][i]=0;
	}
	for(int i=0;i<dp.length;i++){
		dp[i][0]=0;
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

//        for(int i=0;i<dp.length;i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

	return dp[a.length()][b.length()];
}