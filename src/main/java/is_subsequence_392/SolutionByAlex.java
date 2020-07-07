package is_subsequence_392;

public class SolutionByAlex {
    public static void main(String[] args) {
        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        //s较短，t较长
        byte[] sbs = s.getBytes();
        byte[] tbs = t.getBytes();
        int i=0,j=0;
        for(;i<sbs.length && j<tbs.length;){
            if(sbs[i] == tbs[j]){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i == s.length() ? true : false;
    }
}
