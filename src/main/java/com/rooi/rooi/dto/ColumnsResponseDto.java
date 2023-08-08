package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Columns;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColumnsResponseDto extends ApiResponseDto {
    private String title;

    public ColumnsResponseDto(Columns columns){
        this.title = columns.getTitle();
    }

}
