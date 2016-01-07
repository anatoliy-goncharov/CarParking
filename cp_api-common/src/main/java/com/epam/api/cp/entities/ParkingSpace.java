package com.epam.api.cp.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"PARKING_SPACE\"")
@XmlRootElement
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"SPACE_ID\"")
    private Long spaceId;

    @Column(name = "\"SPACE_NUMBER\"")
    private Integer spaceNumber;

    @Column(name = "\"IS_SPACE_BUSY\"")
    private Boolean busySpace;

    @Column(name = "\"IS_RESERVATION\"")
    private Boolean reservation;

    public Boolean getReservation() {
        return reservation;
    }

    public void setReservation(Boolean reservation) {
        this.reservation = reservation;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(Integer spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public Boolean getBusySpace() {
        return busySpace;
    }

    public void setBusySpace(Boolean busySpace) {
        this.busySpace = busySpace;
    }

}
