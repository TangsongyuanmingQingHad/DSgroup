package ArrayTest;

public class climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs.feibonaqi(10));
    }
    /**
     * 暴力法：递归
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        return climbStairs.climbStairs2(n);
    }

    public static int climbStairsFromZero1(int i,int n) {
        int type = 0;
        if(i > n ) {
            return 0;
        }

        if(i == n ) {
            return 1;
        }

            return  climbStairsFromZero1(i + 1, n) + climbStairsFromZero1(i + 2, n);
    }


    /**
     * 动态规划
     */

    public static int climbStairs2(int n) {
        if(n == 1) {
            return 1;
        }
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n ; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    /**
     * 斐波那契，相对于动态规划用常数来代替数组
     */

    public static int feibonaqi(int n) {
        if(n == 1) {
            return 1;
        }

        int i = 1 ;
        int j = 2;
        for (int k = 3; k <= n ; k++) {
            int m = i + j;
            i = j;
            j = m;
        }

        return j;
    }
}
