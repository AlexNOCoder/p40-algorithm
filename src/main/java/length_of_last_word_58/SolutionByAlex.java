package length_of_last_word_58;


public class SolutionByAlex {
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if(arr.length>0){
            return arr[arr.length-1].length();
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
    }
}
