package hello.servlet.domain.member;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();



    @AfterEach
    void afterEch(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);


        //when
        Member saveMember = memberRepository.save(member);


        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);


    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 23);
        Member member2 = new Member("member2", 32);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> findAllMembers = memberRepository.findAll();

        //then
        assertThat(findAllMembers.size()).isEqualTo(2);
        assertThat(findAllMembers).contains(member1,member2);

    }

    @Test
    void clearStore() {
    }
}