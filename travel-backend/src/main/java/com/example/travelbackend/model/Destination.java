
package com.example.travelbackend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;

    @Column(length = 1000)
    private String shortDescription;

    @Column(length = 4000)
    private String longDescription;

    private Integer price;
    private Integer duration;
    private Double rating;

    @ElementCollection
    @CollectionTable(name = "destination_images", joinColumns = @JoinColumn(name = "destination_id"))
    @Column(name = "image_url")
    private List<String> images;

    public Destination(){}

    // getters and setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getRegion(){return region;} public void setRegion(String region){this.region=region;}
    public String getShortDescription(){return shortDescription;} public void setShortDescription(String s){this.shortDescription=s;}
    public String getLongDescription(){return longDescription;} public void setLongDescription(String l){this.longDescription=l;}
    public Integer getPrice(){return price;} public void setPrice(Integer p){this.price=p;}
    public Integer getDuration(){return duration;} public void setDuration(Integer d){this.duration=d;}
    public Double getRating(){return rating;} public void setRating(Double r){this.rating=r;}
    public List<String> getImages(){return images;} public void setImages(List<String> images){this.images=images;}
}
