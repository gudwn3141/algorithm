package hyeongjun;
import java.util.*;

public class hash4 {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop","balad"};
        int[] plays = {500,600,150,800,2500,6000};
        //중복된 장르 합치기
        Map<String , Integer> merge_genres = new HashMap<>();
        merge_genres.put(genres[0],plays[0]);
        for(int i = 1;i<genres.length;i++){
            if(!merge_genres.containsKey(genres[i])){
                merge_genres.put(genres[i],plays[i]);
            }else{
                merge_genres.put(genres[i],merge_genres.get(genres[i])+plays[i]);
            }
        }
        Queue<Integer> album = new LinkedList<>();
        //Map 오름차순정렬
        List sortlist = sortByValue(merge_genres);
        //검색하면서 순서대로 앨범에 넣기
        for(int i = 0; i<sortlist.size();i++){
            for(int k = 0;k<2;k++){
                int max = 0;
                int index = -1;
                for(int j = 0;j<genres.length;j++){
                    if(sortlist.get(i).equals(genres[j])){
                        if(max<plays[j]){
                            max = plays[j];
                            index = j;
                        }
                    }
                }
                if(max!=0){
                    album.add(index);
                    plays[index] = 0;
                }
            }
        }
        int[] answer = new int[album.size()];
        for(int i = 0;i<answer.length;i++){
            answer[i] = album.remove();
        }

        for(int i = 0;i<answer.length;i++){
            System.out.print(answer[i]+ " ");
        }
    }
    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });
        return list;
    }
}
