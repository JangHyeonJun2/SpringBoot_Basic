package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositroy;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepositroy memberRepositroy = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member);

        memberRepositroy.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepositroy.findByName(member.getName())
                .ifPresent(member1 -> { //ifPresent는 만약 null이 아니라 값이 있다면?
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepositroy.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepositroy.findById(memberId);
    }
}
