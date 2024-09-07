package com.example.Railway.Controllers;
import com.example.Railway.Models.Railway;
import com.example.Railway.Services.RailwayService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class RailController {

    @Autowired
    RailwayService service;

    @PostMapping("/bookTicket")
    public ResponseEntity<String> bookTicket(@RequestBody @Valid Railway railway){
        service.bookTicket(railway);
        return ResponseEntity.ok("Ticket Booked Successfully.");
    }

    @GetMapping("/getById/{pnr}")
    public Railway getById(@Valid @PathVariable int pnr){
        return service.getBookingById(pnr);
    }

    @GetMapping("/getAll")
    public List<Railway> getAll(){
        return service.getALlBookings();
    }

    @PutMapping("/updateUser/{pnr}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable int pnr, @RequestBody Railway railway){
        service.updateDetails(pnr,railway);
        return ResponseEntity.ok("Details Updated Successfully.");
    }

    @DeleteMapping("/delete/{pnr}")
    public ResponseEntity<String> deleteBooking(@Valid @PathVariable int pnr){
        service.deleteBooking(pnr);
        return new ResponseEntity<String>("Ticket Cancelled!", HttpStatus.OK);
    }

    @GetMapping("/search/{str}")
    public List<Railway> searchRailways(@PathVariable String str){
        return service.searchByFilter(str);
    }
}