package com.rafiul.trs.controller;


import com.rafiul.trs.dto.TripDto;
import com.rafiul.trs.dto.search_dto.TripSearchDto;
import com.rafiul.trs.service.TripService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/trip")
@RestController
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/save")
    public String saveTrip(@RequestBody TripDto tripDto) {
        tripService.saveTrip(tripDto);
        return "Saved successfully";
    }

    @DeleteMapping("/delete")
    public void deleteTrip(@RequestParam String tripId) {
        tripService.deleteTrip(tripId);


    }


}


//getall api now


