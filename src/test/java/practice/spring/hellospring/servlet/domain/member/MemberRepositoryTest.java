package practice.spring.hellospring.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clear() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        MemberData memberData = new MemberData("mbpark", 33);

        //when
        MemberData savedMemberData = memberRepository.save(memberData);

        //then
        MemberData checkedMemberData = memberRepository.findById(savedMemberData.getId());
        Assertions.assertThat(savedMemberData).isEqualTo(checkedMemberData);
    }

    @Test
    void findByAll() {
        // given
        MemberData member1 = new MemberData("eundong", 31);
        MemberData member2 = new MemberData("river", 35);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<MemberData> memberDataList = memberRepository.findAll();

        // then
        Assertions.assertThat(memberDataList.size()).isEqualTo(2);
        Assertions.assertThat(memberDataList).contains(member1, member2);
    }
}
