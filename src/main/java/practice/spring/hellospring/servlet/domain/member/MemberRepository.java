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

    public MemberData save(MemberData memberData) {
        memberData.setId(++sequence);
        memberData.setUsername("mbpark");
        memberData.setAge(33);

        memberStore.put(memberData.getId(), memberData);
        return memberData;
    }

    public MemberData findById(long id) {
        return memberStore.get(id);
    }

    public List<?> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    public void clearStore() {
        memberStore.clear();
    }

}
