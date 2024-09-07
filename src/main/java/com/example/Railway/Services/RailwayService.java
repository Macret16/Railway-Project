package com.example.Railway.Services;

import com.example.Railway.Models.Railway;
import com.example.Railway.Repository.RailwayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RailwayService {

    @Autowired private RailwayRepo repo;

    // Insert Data
    public void bookTicket(Railway railway){
        repo.save(railway);}

    // Display by ID
    public Railway getBookingById(int pnr){
        return repo.findById(pnr).orElse(null);}

    // Display all
    public List<Railway> getALlBookings(){
        return repo.findAll();}

    // Update Details
    public void updateDetails(int pnr, Railway railway){
        Railway oldrail = repo.findById(pnr).orElse(null);
        oldrail.setPass_name(railway.getPass_name());
        oldrail.setPass_age(railway.getPass_age());
        repo.save(oldrail);}

    // Delete Details
    public void deleteBooking(int id){
        repo.deleteById(id);}

    // Search By Filter
    public List<Railway> searchByFilter(String something) {
        if (something != null){
            return repo.search(something);
        }
        return repo.findAll();
    }
}
