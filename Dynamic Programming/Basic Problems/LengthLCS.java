import java.util.*;
public class LengthLCS {

    //O(2^n) time and space
    public int recursiveLCS(String A, String B){
        if(A==null || B==null) return 0;
        return helper(A, B, A.length()-1, B.length()-1);
    }

    public int helper(String A, String B, int i, int j){
        //Base Case
        if(i<0 || j<0) return 0;
        else if(A.charAt(i)==B.charAt(j)) return 1 + helper(A,B,i-1,j-1);
        else return Math.max(helper(A,B,i,j-1), helper(A,B,i-1,j));
    }

    //O(mn) time and space
    public int LCS(String A, String B){
        //Sanity Check
        if(A==null || B==null) return 0;
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
        return dp[m][n];
    }

    //O(mn) time and O(n) space
    public int spaceOptimizedLCS(String A, String B){
        //Sanity Check
        if(A==null || B==null) return 0;
        int m = A.length();
        int n = B.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }
                else{
                    cur[j] = Math.max(cur[j-1],prev[j]);
                }
            }
            //Assign cur to prev and reset cur
            for(int j=0;j<=n;j++){
                prev[j] = cur[j];
            }
        }
        return cur[n];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LengthLCS l = new LengthLCS();
        System.out.println("Please enter your inputs");
        String A = in.nextLine();
        String B = in.nextLine();
        System.out.println("Recursive version: Length of the LCS of A and B is "+l.recursiveLCS(A,B));
        System.out.println("DP version: Length of the LCS of A and B is "+l.LCS(A,B));
        System.out.println("Space Optimized DP version: Length of the LCS of A and B is "+l.spaceOptimizedLCS(A,B));
        in.close();
    }
}
