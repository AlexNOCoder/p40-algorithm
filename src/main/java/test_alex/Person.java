package test_alex;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: person
 * @date 2021-12-29 21:22:30
 */
public class Person {
    private Integer personId;
    private String personName;
    private Integer age;
    private String gender;

    public Integer getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Person(Integer personId, String personName, Integer age, String gender) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
        this.gender = gender;
    }
}