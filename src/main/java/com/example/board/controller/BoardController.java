package com.example.board.controller;


import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public String createBoard(@RequestParam("id") Long memberId, @RequestBody BoardDto boardDto){
        return boardService.createBoard(memberId,boardDto);
    }

}
