package com.example.board.controller;

import com.example.board.dto.MemberSignUpReqDto;
import com.example.board.dto.MembersRequestUpdate;
import com.example.board.entity.Member;
import com.example.board.service.MemberService;
import com.example.board.dto.MembersResDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/user")
    public String sginup(@RequestBody MemberSignUpReqDto memberSignUpReqDto){
        return memberService.signup(memberSignUpReqDto);
    }

    @GetMapping("/user")
    public List<MembersResDto> getMembers()
    {
        return memberService.getMembers();
    }

    //아이디 별로 회원 조회
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id){
        Optional<Member> memberOptional=memberService.getUserById(id);

        if (memberOptional.isPresent())
            return ResponseEntity.ok(memberOptional.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 ID의 회원이 존재하지 않습니다");
    }

    //수정
    @PutMapping("/user/{id}")
    public String updateMember(@RequestBody MembersRequestUpdate request){
        return memberService.updateMember(request);
    }

    //삭제
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable("id") long id){
        try{
            memberService.deleteMember(id);
            ResponseEntity.noContent();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "삭제 완료";
    }




}

