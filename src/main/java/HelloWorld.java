import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HelloWorld {
    public static void main(String[] args) throws Exception{
        FileWriter writer = new FileWriter("./data1.txt");
        try {
            for(int i=0;i<100000000;i++){
                String str = generateRandomLine();
                writer.write(str);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }

    }


    public static String generateRandomLine(){
        StringBuilder sb = new StringBuilder();
        int tempId = generateRandomInt(1000000);
        String tempName = generateRandomString(4);
        int tempAge = generateRandomInt(100);
        String tempAdrress = generateRandomString(10);
        String tempLove = generateRandomString(5);
        String tempCompany = generateRandomString(10);
        int tempGender = 1;
        int tempPhone = generateRandomInt(10000000);
        String tempSchool = generateRandomString(14);
        float tempMoney = generateRandomFloat(1);
        sb.append(tempId);
        sb.append(",");
        sb.append(tempName);
        sb.append(",");
        sb.append(tempAge);
        sb.append(",");
        sb.append(tempAdrress);
        sb.append(",");
        sb.append(tempLove);
        sb.append(",");
        sb.append(tempCompany);
        sb.append(",");
        sb.append(tempGender);
        sb.append(",");
        sb.append(tempPhone);
        sb.append(",");
        sb.append(tempSchool);
        sb.append(",");
        sb.append(tempMoney);
        sb.append("\n");
        return sb.toString();
    }


    public static int generateRandomInt(int maxValue){
        int randomInt = (int) ((maxValue + 1)* Math.random()) - (int)(maxValue * Math.random());
        return randomInt < 0 ? (0 - randomInt): randomInt;
    }

    public static float generateRandomFloat(int maxValue){
        float randomFloat =(float) (((maxValue + 1)* Math.random()) - (maxValue * Math.random()));
        return randomFloat < 0 ? (0 - randomFloat): randomFloat;
    }

    public static String generateRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
