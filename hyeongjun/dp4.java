package hyeongjun;

public class dp4 {
    public static void main(String[] args) {
        int[] money = {4,10,2,5,6};

        int i;
        int answer = 0;
        int[][] dp;
        if (money.length == 0) {
            answer = 0;
        }else{
            dp = new int[money.length][2];
            if(money.length>=3){
                dp[0][1] = money[0];
                dp[1][0] = money[1];
                dp[1][1] = money[0];
                dp[2][0] = Math.max(money[1],money[2]);
                dp[2][1] = Math.max(money[1],money[0]+money[2]);
            }
            if(money.length>=4){
                for(i = 3;i<money.length-1;i++){
                    dp[i][0] = Math.max(dp[i-2][0]+money[i],dp[i-1][0]+money[i]);
                    dp[i][1] = Math.max(dp[i-2][1]+money[i],dp[i-1][1]+money[i]);
                }
            }

            answer = Math.max(dp[money.length-1][0], dp[money.length-1][1]);
        }





        System.out.println(answer);

    }
}
