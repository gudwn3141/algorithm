package hyeongjun;

public class bfsdfs1 {
    static int answer =0;
    public static void main(String[] args){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int sum = 0;
        int count = 0;
        dfs(numbers, target, sum,count);
        System.out.println(answer);
    }
    static void dfs(int[] numbers, int target, int sum, int count){
        if(count==numbers.length){
            if(sum==target) answer++;
        }else{
            int sumsum = sum+numbers[count];
            int sumsub = sum-numbers[count];

            count++;
            dfs(numbers, target, sumsub, count);
            dfs(numbers, target, sumsum, count);
        }
    }
}
