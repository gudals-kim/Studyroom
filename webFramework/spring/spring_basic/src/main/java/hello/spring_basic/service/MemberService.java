package hello.spring_basic.service;

import hello.spring_basic.domain.Member;
import hello.spring_basic.repository.MemberRepository;
import hello.spring_basic.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    회원가입
    public Long join(Member member){
        validateDuplicateMember(member);//중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
//    전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
//    회원 조회
    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }
}
