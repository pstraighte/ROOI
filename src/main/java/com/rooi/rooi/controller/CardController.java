package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiResponseDto;
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
    @PostMapping("/{columId}/card")
    public ResponseEntity<ApiResponseDto> createCard(@PathVariable Long columId, @RequestBody CardRequestDto cardRequestDto) {
        cardService.createCard(columId, cardRequestDto);
        return null;
    }

    // 카드 조회 -> 컬럼에서 조회

    // 카드 수정 API
    @PutMapping("/card/{id}")
    public ResponseEntity<ApiResponseDto> updateCard(@PathVariable Long id, @RequestBody CardRequestDto cardRequestDto) {
        cardService.updateCard(id, cardRequestDto);
        return null;
    }

    // 카드 삭제 API
    @DeleteMapping("/card/{id}")
    public ResponseEntity<ApiResponseDto> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return null;
    }

    // 작업자 추가 API
    @PostMapping("/card/worker")
    public ResponseEntity<ApiResponseDto> addWorker() {
        cardService.addWorker();
        return null;
    }

    // 작업자 삭제 API
    @DeleteMapping("/card/worker")
    public ResponseEntity<ApiResponseDto> deleteWorker() {
        cardService.deleteWorker();
        return null;
    }

}
