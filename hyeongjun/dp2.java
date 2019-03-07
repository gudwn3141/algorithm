package hyeongjun;

class dp2 {
    public long solution(int N) {
        long[] pibo = new long[N];
        long answer = 0;
        pibo[0] = 1;
        pibo[1] = 1;
        if(N>=2){
            for(int i=2;i<N;i++){
                pibo[i] = pibo[i-1]+pibo[i-2];
            }
        }
        if(N==1){
            answer = 4;
        }else{
            answer = pibo[N-1]*4+2*pibo[N-2];
        }
        return answer;
    }
}