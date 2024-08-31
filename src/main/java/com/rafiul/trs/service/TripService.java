package com.rafiul.trs.service;

import com.rafiul.trs.dto.TripDto;
import com.rafiul.trs.dto.search_dto.TripSearchDto;
import com.rafiul.trs.entity.Trip;
import com.rafiul.trs.enums.BusTypeEnum;
import com.rafiul.trs.enums.TripStatusEnum;
import com.rafiul.trs.repository.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.rafiul.trs.utility.TransformUtil.copyProp;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    public void saveTrip(TripDto tripDto) {
        Trip trip = copyProp(tripDto, Trip.class);
        trip.setTripDateTime(LocalDateTime.now());
        trip.setReportingDateTime(LocalDateTime.now());
        trip.setEnabled(Boolean.TRUE);

        trip.setTripStatus(TripStatusEnum.PENDING);
        if (Objects.nonNull(tripDto.getBusType())) {
            if (tripDto.getBusType() == BusTypeEnum.NON_AC) {
                trip.setBusType(BusTypeEnum.NON_AC);
            }

        }
        if (Objects.nonNull(tripDto.getBusType())) {
            if (tripDto.getBusType() == BusTypeEnum.AC) {
                trip.setBusType(BusTypeEnum.AC);
            }
        }

        if (!ObjectUtils.isEmpty(tripDto.getTripNumber())) {
            LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
            LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);

            Trip persistedTrip = tripRepository.getTripByTripDateTimeAndTripNumber(startOfDay, endOfDay, tripDto.getTripNumber());
            if (!Objects.nonNull(persistedTrip)) {
                tripRepository.save(trip);
            }
        }

    }


    public void deleteTrip(String tripId) {
        if (!StringUtils.isEmpty(tripId)) {
            Trip tripToBeDeleted = tripRepository.findById(tripId).get();
            if (Objects.nonNull(tripToBeDeleted)) {
                tripToBeDeleted.setEnabled(Boolean.FALSE);
                tripRepository.save(tripToBeDeleted);
            }

        }

    }


    public Page<TripDto> getAllTrips(TripSearchDto tripSearchDto) {

        int offset = (tripSearchDto.getPage() - 1) * tripSearchDto.getSize();
        Pageable pageable = PageRequest.of(offset, tripSearchDto.getSize());

        Page<Trip> tripPage = tripRepository.findTripByDateRange(pageable, tripSearchDto.getFromDate(), tripSearchDto.getToDate());
        List<TripDto> tripDtoList = tripPage
                .stream()
                .map(element -> copyProp(element, TripDto.class))
                .toList();
        return new PageImpl<>(tripDtoList, pageable, tripSearchDto.getSize());
    }


}
