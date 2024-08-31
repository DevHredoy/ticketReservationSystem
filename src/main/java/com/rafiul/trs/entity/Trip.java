package com.rafiul.trs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafiul.trs.enums.BusTypeEnum;
import com.rafiul.trs.enums.TripStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "bus_trip")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Trip {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "trip_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tripDateTime;

    @Column(name = "starting_time")
    private String startingTime;

    @Column(name = "bus_type")
    @Enumerated(EnumType.STRING)
    private BusTypeEnum busType;

    @Column(name = "reporting_date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportingDateTime;

    @Column(name = "trip_number")
    private String tripNumber;

    @Column(name = "trip_status")
    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;

    @Column(name = "bus_id")
    private String busId;


    @Column(name = "enabled")
    private Boolean enabled = true;


}
