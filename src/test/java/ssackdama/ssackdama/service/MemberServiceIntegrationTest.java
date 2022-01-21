package ssackdama.ssackdama.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.domain.Role;
import ssackdama.ssackdama.repository.MemberRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void join() throws Exception{
        //given
        Member added=new Member("1@gmail.com","password","user1", Role.CUSTOMER);
        memberService.join(added);
        //when
        Member member = memberRepository.findOneByEmail("1@gmail.com").get();

        //then
        Assertions.assertThat(added.toString()).isEqualTo(member.toString());
    }
    @Test
    public void duplicate_user_exception() throws Exception{
        //Given
        Member member = new Member("2@gmail.com","password","user2", Role.CUSTOMER);
        Member member2 = new Member("2@gmail.com","password","user2", Role.CUSTOMER);
        //when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}