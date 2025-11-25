
package com.example.travelbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingRef;
    private String destinationName;
    private String customerName;
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer travelers;
    private Integer price; // total price in smallest currency unit or integer

    private LocalDateTime createdAt = LocalDateTime.now();

    public Booking(){}

    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getBookingRef(){return bookingRef;} public void setBookingRef(String b){this.bookingRef=b;}
    public String getDestinationName(){return destinationName;} public void setDestinationName(String d){this.destinationName=d;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String c){this.customerName=c;}
    public String getCustomerEmail(){return customerEmail;} public void setCustomerEmail(String e){this.customerEmail=e;}
    public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate s){this.startDate=s;}
    public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate e){this.endDate=e;}
    public Integer getTravelers(){return travelers;} public void setTravelers(Integer t){this.travelers=t;}
    public Integer getPrice(){return price;} public void setPrice(Integer p){this.price=p;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime c){this.createdAt=c;}
}
