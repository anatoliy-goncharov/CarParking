package com.epam.api.cp.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "\"ADDITIONAL_INFO\"")
@XmlRootElement
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INFO_ID")
    private Long addInfoId;

    @Column(name = "\"LEAVE_DATE\"")
    private Date leaveDate;

    @ManyToOne
    @JoinColumn(name = "\"USER_ID\"")
    private User user;

    public Long getAddInfoId() {
        return addInfoId;
    }

    public void setAddInfoId(Long addInfoId) {
        this.addInfoId = addInfoId;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
