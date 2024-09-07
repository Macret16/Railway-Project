package com.example.Railway.Controllers;

import com.example.Railway.Models.Railway;
import com.example.Railway.Repository.RailwayRepo;
import com.example.Railway.Services.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HtmlController {

    @Autowired private RailwayService service;

    @Autowired private RailwayRepo repo;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/display")
    public String getMyPage(Model model) {
        List<Railway> data = service.getALlBookings();
        model.addAttribute("data",data);
        return "display";
    }

    @GetMapping("/search")
    public String searchpage(){
        return "search";
    }

    @GetMapping("/search/{query}")
    public String searchByFilter(@PathVariable String query, Model model){
        List<Railway> data = service.searchByFilter(query);
        model.addAttribute("data",data);
        return "search";
    }


    @GetMapping("/ticket")
    public String insert(){
        return "insert";
    }

    @PostMapping("/book")
    public String bookTicket(@ModelAttribute Railway railway){
        System.out.println(railway);
        repo.save(railway);
        //service.bookTicket(railway);
        return "insert";
    }

    @GetMapping("/cancel")
    public String cancelTicket(){
        return "cancel";
    }

    @GetMapping("/cancel/{id}")
    public String cancelTicketSuccess(@PathVariable int id){
        service.deleteBooking(id);
        return "redirect:/display";
    }
}