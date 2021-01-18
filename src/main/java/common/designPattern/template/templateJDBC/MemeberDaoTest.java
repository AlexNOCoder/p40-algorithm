package common.designPattern.template.templateJDBC;

import java.util.List;

public class MemeberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result =  memberDao.selectAll();
        System.out.println(result);
    }
}
