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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Railway")
public class Railway {

    public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public long getPnr() {
		return pnr;
	}

	public void setPnr(long pnr) {
		this.pnr = pnr;
	}

	public String getPass_name() {
		return pass_name;
	}

	public void setPass_name(String pass_name) {
		this.pass_name = pass_name;
	}

	public int getPass_age() {
		return pass_age;
	}

	public void setPass_age(int pass_age) {
		this.pass_age = pass_age;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTrain_number() {
		return train_number;
	}

	public void setTrain_number(int train_number) {
		this.train_number = train_number;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

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