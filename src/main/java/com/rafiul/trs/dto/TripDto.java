package com.rafiul.trs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafiul.trs.enums.BusTypeEnum;
import com.rafiul.trs.enums.TripStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
public class TripDto {

    private String id;

    private String destination;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tripDateTime;

    private String startingTime;

    @Enumerated(EnumType.STRING)
    private BusTypeEnum busType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportingDateTime;

    private String tripNumber;

    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;

    private String busId;


}
