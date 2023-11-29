package com.example.board.service;


import com.example.board.repository.BoardRepository;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    public String createBoard(Long memberId, BoardDto boardDto){
        Board board = new Board(boardDto.getTitle(),boardDto.getContent());

        board.setMember(memberRepository.findById(memberId).orElseThrow());

        boardRepository.save(board);

        return "저장완료";
    }
}
