package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.CardRequestDto;
import com.rooi.rooi.dto.CardResponseDto;
import com.rooi.rooi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    // 카드 생성 API
    @PostMapping("/{columnId}/card")
    public ResponseEntity<CardResponseDto> createCard(@PathVariable Long columnId, @RequestBody CardRequestDto cardRequestDto) {
        CardResponseDto cardResponseDto = cardService.createCard(columnId, cardRequestDto);
        return new ResponseEntity<>(
                cardResponseDto,
                HttpStatus.CREATED
        );
    }

    // 카드 조회 -> 컬럼에서 조회

    // 카드 수정 API
    @PutMapping("/card/{id}")
    public ResponseEntity<ApiResponseDto> updateCard(@PathVariable Long id, @RequestBody CardRequestDto cardRequestDto) {
        cardService.updateCard(id, cardRequestDto);
        ApiResponseDto apiResponseDto = new ApiResponseDto("카드를 수정했습니다.", HttpStatus.OK.value());
        return new ResponseEntity<>(
                apiResponseDto,
                HttpStatus.OK
        );
    }

    // 카드 삭제 API
    @DeleteMapping("/card/{id}")
    public ResponseEntity<ApiResponseDto> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        ApiResponseDto apiResponseDto = new ApiResponseDto("카드를 삭제했습니다.", HttpStatus.OK.value());
        return new ResponseEntity<>(
                apiResponseDto,
                HttpStatus.OK
        );
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
