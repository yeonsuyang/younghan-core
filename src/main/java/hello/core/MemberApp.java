package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) {

        //스프링 생성, ApplicationContext가 스프링의 모든 객체를 관리함
        //appconfig 에 있는 환경 설정 정보들을 가지고 스프링 컨테이너에 넣어서 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //반환 타입과, 이름, 타입을 지정
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);


       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}