package com.rooi.rooi.service;

import com.rooi.rooi.dto.CardRequestDto;
import com.rooi.rooi.dto.CardResponseDto;
import com.rooi.rooi.entity.Card;
import com.rooi.rooi.entity.Columns;
import com.rooi.rooi.repository.CardRepository;
import com.rooi.rooi.repository.ColumnsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final ColumnsRepository columnsRepository;

    // 카드 생성 API
    public CardResponseDto createCard(Long columnId, CardRequestDto cardRequestDto) {
        // columnId 필요
        Columns columns = columnsRepository.findById(columnId).orElseThrow(() -> new NullPointerException("Could Not Found Column"));

        Card card = new Card(columns, cardRequestDto);
        cardRepository.save(card);

        return new CardResponseDto(card);
    }

    // 카드 수정 API
    public void updateCard(Long id, CardRequestDto cardRequestDto) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new NullPointerException("Could Not Found Card"));
        card.update(cardRequestDto);

        cardRepository.save(card);
    }

    // 카드 삭제 API
    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new NullPointerException("Could Not Found Card"));
        cardRepository.delete(card);
    }

    // 작업자 추가 API
    public void addWorker() {

    }

    // 작업자 삭제 API
    public void deleteWorker() {

    }
}
