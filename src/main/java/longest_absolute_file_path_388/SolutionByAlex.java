package longest_absolute_file_path_388;


public class SolutionByAlex {
    public int lengthLongestPath(String input) {
        return 0;
    }

    public static void main(String[] args) {
        String str = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        String[] arr = str.split("\\\\n\\\\t");
        for(String path:arr){
            System.out.println(path);
        }
    }
}
