package com.epam.api.cp.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"CARS\"")
@XmlRootElement
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"CAR_ID\"")
    private Long carId;

    @Column(name = "\"MODEL\"")
    private String model;

    @Column(name = "\"CAR_NUMBER\"")
    private String carNumber;

    @ManyToOne()
    @JoinColumn(name="\"USER_ID\"")
    private User user;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
