package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.ColumnsRequestDto;
import com.rooi.rooi.dto.ColumnsResponseDto;
import com.rooi.rooi.security.UserDetailsImpl;
import com.rooi.rooi.service.ColumnsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/columns")
@AllArgsConstructor
@Slf4j
public class ColumnsController {

    private final ColumnsService columnsService;

    // 모든 컬럼 조회 API
    @GetMapping("/all/{boardId}")
    public List<ColumnsResponseDto> getPosts(@PathVariable Long boardId) {
        return columnsService.getAllColumns(boardId);
    }

    // 컬럼 조회 API
    @GetMapping("/{columnsId}")
    public ResponseEntity<ColumnsResponseDto> getColumns(@PathVariable Long columnsId) {
        ColumnsResponseDto columnsResponseDto = columnsService.getColumns(columnsId);
        if (columnsResponseDto != null) {
            return ResponseEntity.ok(columnsResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("")
    public ColumnsResponseDto createColumns(@RequestBody ColumnsRequestDto columnsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return columnsService.createColumns(columnsRequestDto, userDetails.getUser());
    }

    @PutMapping("/{columnsId}")
    public ColumnsResponseDto updateColumns(@PathVariable Long columnsId, @RequestBody ColumnsRequestDto columnsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return columnsService.updateColumns(columnsId, columnsRequestDto, userDetails.getUser());
    }

    @DeleteMapping("/delete/{columnsId}")
    public ResponseEntity<ApiResponseDto> deleteColumns(@PathVariable Long columnsId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            columnsService.deleteColumns(columnsId, userDetails.getUser());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok().body(new ApiResponseDto("컬럼을 찾을 수 없습니다", HttpStatus.BAD_REQUEST.value()));
        }

        log.info("반환 전");
        return ResponseEntity.ok().body(new ApiResponseDto("컬럼 삭제 성공", HttpStatus.OK.value()));
    }


}
