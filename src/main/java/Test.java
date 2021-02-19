import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
       getFileMappingFromJson("{\"properties\":{\"eid\":{\"type\":\"long\"},\"dataDate\":{\"type\":\"keyword\"},\"create_time\":{\"format\":\"yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis\",\"type\":\"date\"},\"gender\":{\"type\":\"keyword\"},\"id_card\":{\"analyzer\":\"idcard_analyzer\",\"type\":\"text\"},\"updater\":{\"type\":\"keyword\"},\"update_time\":{\"format\":\"yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis\",\"type\":\"date\"},\"medical_card_id\":{\"analyzer\":\"ecard_analyzer\",\"type\":\"text\"},\"nationality\":{\"type\":\"keyword\"},\"phone\":{\"analyzer\":\"phone_analyzer\",\"type\":\"text\"},\"brithday\":{\"type\":\"text\"},\"creater\":{\"type\":\"keyword\"},\"name\":{\"type\":\"text\",\"fields\":{\"raw\":{\"type\":\"keyword\"}}},\"health_card_id\":{\"analyzer\":\"ecard_analyzer\",\"type\":\"text\"},\"addr\":{\"type\":\"text\",\"fields\":{\"raw\":{\"type\":\"keyword\"}}}}}");
    }


    public static Map<String,String> getFileMappingFromJson(String input){
//        String procces1 = input.substring(input.indexOf("properties")+13,input.length()-1);
        String procces1 = "c={type=keyword}, dd={analyzer=pinyin, type=text}, zz={type=text}, des={type=text, fields={raw={type=keyword}}}, id={analyzer=ngram_analyzer, type=text}, addr={type=text, fields={raw={type=keyword}}}}";
        String[] files = procces1.split("},");
        String file;
        String type;
        Map<String,String> fileMapping = new HashMap<>();
        for(String str:files){
            file = str.substring(1,str.indexOf(":")-1);
//            System.out.println(str);
            String tempStr =str.substring(str.indexOf("type\":\"")+7);
            type = tempStr.substring(0,tempStr.indexOf("\""));
            System.out.println(file+":"+type);
            fileMapping.put(file,type);
        }
        return fileMapping;
    }
}
