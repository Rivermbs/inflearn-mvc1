package practice.spring.hellospring.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository {

    private ConcurrentHashMap<Long, MemberData> memberStore = new ConcurrentHashMap<>();
    private static long sequence = 0L;
    private static MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    public MemberRepository() {

    }

    private MemberData save(MemberData memberData) {
        memberData.setId(++sequence);
        memberData.setUsername("mbpark");
        memberData.setAge(33);

        memberStore.put(memberData.getId(), memberData);
        return memberData;
    }

    private MemberData findById(long id) {
        return memberStore.get(id);
    }

    private List<?> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    private void clearStore() {
        memberStore.clear();
    }

}
