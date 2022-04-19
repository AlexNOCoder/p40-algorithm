package shortest_distance_to_a_character_821;


import com.alibaba.fastjson.JSONObject;

public class SolutionByAlex {
    public static int[] shortestToChar(String s, char c) {

        char[] chars = s.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int l = i, r = i;
            while (l>=0 && r<chars.length) {
                if(chars[l] == c){
                    result[i] = i-l;
                    break;
                }
                if(chars[r] == c){
                    result[i] = r-i;
                    break;
                }
                if(l>0){
                    l--;
                }
                if(r<chars.length-1){
                    r++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str ="loveleetcode";
        char c = 'e';
        int[] result = shortestToChar(str,c);
        System.out.println(JSONObject.toJSONString(result));
    }
}
