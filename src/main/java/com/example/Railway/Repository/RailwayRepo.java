package com.example.Railway.Repository;

import com.example.Railway.Models.Railway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RailwayRepo extends JpaRepository<Railway, Integer>{

    @Query("SELECT r FROM Railway r WHERE CONCAT(r.pass_name, ' ', r.departure, ' ', r.destination,' ', r.pass_age, ' ', r.time, ' ', r.pnr, ' ', r.date, ' ', r.train_number,' ', r.train_name, ' ', r.coach, ' ', r.amount) LIKE %?1%")
    public List<Railway> search(String something);
}