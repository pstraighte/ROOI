package com.rooi.rooi.service;

import com.rooi.rooi.dto.CardRequestDto;
import com.rooi.rooi.entity.Card;
import com.rooi.rooi.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    // 카드 생성 API
    public void createCard(CardRequestDto cardRequestDto) {
        // columnId 필요

        Card card = new Card(cardRequestDto);
        cardRepository.save(card);
    }

    // 카드 수정 APi
    public void updateCard(Long id, CardRequestDto cardRequestDto) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new NullPointerException("Could Not Found Card"));
        card.update(cardRequestDto);

    }

    // 카드 삭제 APi
    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new NullPointerException("Could Not Found Card"));
        cardRepository.delete(card);
    }

}
