package hello.hellospring.service;

import hello.hellospring.repository.MemoryMemberReposiotory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    MemoryMemberReposiotory repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberReposiotory();
        memberService = new MemberService(repository);
    }

    @AfterEach // 각각의 test 데이터 초기화
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        // given : 주어진 데이터가
        Member member = new Member();
        member.setName("spring");
        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //memberService.join(member2);

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}