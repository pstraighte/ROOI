package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiresponseDto;
import com.rooi.rooi.dto.CardRequestDto;
import com.rooi.rooi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    // 카드 생성 API
    @PostMapping("/card")
    public ResponseEntity<ApiresponseDto> createCard(@RequestBody CardRequestDto cardRequestDto) {
        cardService.createCard(cardRequestDto);
        return null;
    }

    // 카드 조회 -> 컬럼에서 조회

    // 카드 수정 API
    @PutMapping("/card/{id}")
    public ResponseEntity<ApiresponseDto> updateCard(@PathVariable Long id, @RequestBody CardRequestDto cardRequestDto) {
        cardService.updateCard(id, cardRequestDto);
        return null;
    }

    // 카드 삭제 API
    @DeleteMapping("/card/{id}")
    public ResponseEntity<ApiresponseDto> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return null;
    }

    // 작업자 추가 API
    @PostMapping("/card/worker")
    public ResponseEntity<ApiresponseDto> addWorker() {
        cardService.addWorker();
        return null;
    }

    // 작업자 삭제 API
    @DeleteMapping("/card/worker")
    public ResponseEntity<ApiresponseDto> deleteWorker() {
        cardService.deleteWorker();
        return null;
    }

}
