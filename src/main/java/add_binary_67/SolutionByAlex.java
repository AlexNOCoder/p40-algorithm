package add_binary_67;


public class SolutionByAlex {

    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int flag = 0;
        StringBuffer sb = new StringBuffer();
        int i = al - 1;
        int j = bl - 1;
        while (i>=0 && j>=0) {
            int sum = flag;
            sum += a.charAt(i) - '0';
            sum += b.charAt(j) - '0';
            flag = sum /2;
            sb.append(sum%2);
            i--;
            j--;
        }
        while(i>=0){
            int sum = flag;
            sum += a.charAt(i) - '0';
            flag = sum/2;
            sb.append(sum%2);
            i--;
        }

        while(j>=0){
            int sum = flag;
            sum += b.charAt(j) - '0';
            flag = sum/2;
            sb.append(sum%2);
            j--;
        }
        if(flag != 0){
           sb.append(flag);
        }
        return sb.reverse().toString();
    }

}

