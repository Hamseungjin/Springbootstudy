package com.example.board.service;

import com.example.board.dto.Dto;
import com.example.board.dto.MemberSignUpReqDto;
import com.example.board.dto.MembersRequestUpdate;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import com.example.board.dto.MembersResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String signup(MemberSignUpReqDto memberSignUpReqDto){

        Member member = new Member(memberSignUpReqDto.getEmail(), memberSignUpReqDto.getPassword(), memberSignUpReqDto.getAge());

        memberRepository.save(member);

        return "저장 완료";
    }

    public List<MembersResDto> getMembers(){

        List<MembersResDto> list = memberRepository.findAll().stream()
                .map(member->new MembersResDto(member.getEmail(),member.getAge()))
                .collect(Collectors.toList());
        return list;
    }

    //아이디 별로 유저 조회
    public Optional<Member> getUserById(Long id) {

        Optional<Member> memberData=memberRepository.findById(id);

        return memberData;
    }

    //수정
    public String updateMember(@RequestBody MembersRequestUpdate request) {

        // 이메일로 사용자 찾기
        Member member = memberRepository.findByEmail(request.getEmail());

        if (member == null) {
            return "사용자를 찾을 수 없습니다";
        }

        // 기존 비밀번호 확인
        if (!member.getPassword().equals(request.getOldPassword())) {
            return "기존 비밀번호가 일치하지 않습니다";
        }

        // 새로운 비밀번호로 업데이트
        member.setPassword(request.getNewPassword());
        memberRepository.save(member);

        return "비밀번호가 성공적으로 업데이트되었습니다";
    }

    //삭제
    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
