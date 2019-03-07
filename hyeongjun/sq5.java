package hyeongjun;

import java.util.Stack;

public class sq5 {
    public static void main(String[] args){
        int[] heights = {3,9,9,3,5,7,2};
        int[] answer = new int[heights.length];
        boolean t = false;
        Stack<Integer> st  = new Stack<>();
        for(int i=heights.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(heights[i]<heights[j]){
                    st.push(j+1);
                    System.out.println(j+1);
                    t = true;
                    break;
                }
            }
            if(!t){
                st.push(0);

            }else{
                t=false;
            }
        }
        st.push(0);
        for(int i = 0;i<heights.length;i++){
            answer[i] = st.pop();
        }
        for(int i = 0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }
}