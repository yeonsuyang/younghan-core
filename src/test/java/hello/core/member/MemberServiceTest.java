package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        /*
        만약 테스트 케이스가 많아진다면 매번 appConfig에서 호출하는 코드를 테스트 메서드 상단에 추가해야 합니다.
        이런 반복을 beforeEach로 제거할 수 있습니다.
         */
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}