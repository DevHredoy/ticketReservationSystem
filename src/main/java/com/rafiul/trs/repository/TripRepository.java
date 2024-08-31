package com.rafiul.trs.repository;

import com.rafiul.trs.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TripRepository extends JpaRepository<Trip, String> {

    @Query(value = "SELECT * FROM bus_trip t WHERE t.trip_date BETWEEN  :startDate AND :endDate AND t.trip_number = :tripNumber", nativeQuery = true)
    Trip getTripByTripDateTimeAndTripNumber(@Param("startDate")LocalDateTime startDate,
                                            @Param("endDate")LocalDateTime endDate,
                                            @Param("tripNumber") String tripNumber);


    @Query(value = "SELECT * FROM bus_trip bt WHERE bt.enabled = true and bt.trip_date between :startDate and :endDate", nativeQuery = true)
    Page<Trip> findTripByDateRange(Pageable pageable, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
