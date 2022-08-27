package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        //추상화에만 의존. 생성자에만 의존 -> 생성자 주입
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
