package com.rafiul.trs.dto.search_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafiul.trs.enums.BusTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
// 06-03-2024 00:00:0 - 07-03-2024 11:59:59 AC cox/

@Getter
public class TripSearchDto {


    //private String searchString;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fromDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toDate;


    @Enumerated(EnumType.STRING)
    private BusTypeEnum busType;

    public Integer page;
    public Integer size = 2;
    //public Map<String, String> sortKeyOrderMap;
}
