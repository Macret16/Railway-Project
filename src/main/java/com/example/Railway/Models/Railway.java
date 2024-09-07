package com.example.Railway.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Railway")
public class Railway {

    @JsonIgnore
    Random random = new Random();

    @SequenceGenerator(name="seq", initialValue=100000, allocationSize=100)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "seq")
    private long pnr;

    @NotNull(message = "Passenger Name Cannot Be Empty.")
    @Column private String pass_name;

    @NotNull(message = "Passenger Age Cannot Be Empty.")
    @Min(value=12, message = "Age Must Be More Than 12.")
    @Max(value=100, message = "Age should be less than 100.")
    @Column private int pass_age;

    @Column private LocalDate date = LocalDate.now();

    @NotNull(message = "Departure Cannot Be Empty.")
    @Column private String departure;

    @Column private int time = random.nextInt(1,56);

    @NotNull(message = "Destination Field Cannot Be Empty.")
    @Column private String destination;

    @Column private int train_number = random.nextInt(10000,99999);

    @NotNull(message = "Please Specify Train Name.")
    @Column private String train_name;

    @NotNull(message = "Please Specify Coach.")
    @Column private String coach;

    @Column private long amount = (random.nextLong(100,5000));
}