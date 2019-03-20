package hyeongjun;

public class bemin6 {
    public static void main(String[] args){
        int[][] lands ={{10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};
        int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
        int[] point = {10,10,30,30};
        boolean answer = true;
        for(int i = 0;i< lands.length;i++){
            if(!landsconfirm(lands[i], point)){
                answer = false;
            }
        }
        if(answer){
            answer = false;
            for(int i = 0;i<wells.length;i++){
                if(wellsconfirm(wells[i],point)){
                    answer = true;
                    break;
                }
            }
            System.out.println(answer);
        }else{
            System.out.println(answer);
        }

    }
    static boolean landsconfirm(int []lands, int[] point){
        if(lands[0]>=point[2] || lands[2]<=point[0]){
            return true;
        }else{
            if(lands[1]>=point[3] || lands[3]<=point[1]){
                return true;
            }else{
                return false;
            }
        }
    }
    static boolean wellsconfirm(int []wells, int[] point){
        if(wells[0]>=point[0] && wells[2]<=point[2]){
            if(wells[1]>=point[1] && wells[3]<=point[3]){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
