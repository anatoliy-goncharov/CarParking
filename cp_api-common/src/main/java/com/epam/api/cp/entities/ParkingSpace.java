package com.epam.api.cp.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "parking_space")
@XmlRootElement
public class ParkingSpace implements Serializable {

    private static final long serialVersionUID = -2022963503628127453L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "space_id")
    private Long spaceId;

    @Column(name = "space_number")
    private Integer spaceNumber;

    @Column(name = "is_space_busy")
    private Boolean busySpace;

    @Column(name = "is_reservation")
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
