package hyeongjun;

public class graph2 {
    public static void main(String[] args){
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        int answer = 0;
        int[][] score = new int[n][n];
        for(int i = 0;i<results.length;i++){
            score[results[i][0]-1][results[i][1]-1]=1;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(score[i][j]==1){
                    for(int k=0;k<n;k++){
                        if(score[j][k]==1){
                            score[i][k]=1;
                        }
                    }
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(confirm(score,i,n)) answer++;
        }
        System.out.println(answer);
    }
    static boolean confirm(int[][] score, int i,int n){
        for(int j = 0;j<n;j++){
            if(i==j) continue;
            if(score[i][j]==0 && score[j][i]==0) return false;
        }
        return true;
    }
}
