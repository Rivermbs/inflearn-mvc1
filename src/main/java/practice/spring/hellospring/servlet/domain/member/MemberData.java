package practice.spring.hellospring.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberData {

    public MemberData(String username, int age) {
        this.username = username;
        this.age = age;
    }

    private String username;
    private int age;
    private long id;
}
