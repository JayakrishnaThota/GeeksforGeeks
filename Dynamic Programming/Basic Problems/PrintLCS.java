import java.util.*;
public class PrintLCS{

    //O(mn) time and space
    public String LCS(String A, String B){
        //Sanity Check
        if(A==null || B==null) return "";
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int index = dp[m][n]-1;
        char[] lcs = new char[index+1];
        int i = m-1, j = n-1;
        while(i>=0 && j>=0){
            if(A.charAt(i)==B.charAt(j)){
                lcs[index] = A.charAt(i);
                index--;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        return new String(lcs);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintLCS p = new PrintLCS();
        System.out.println("Please enter your inputs");
        String A = in.nextLine();
        String B = in.nextLine();
        System.out.println("LCS of A and B is "+p.LCS(A,B));
        in.close();
    }

}
