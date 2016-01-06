package com.epam.api.cp.entities;

import java.util.Date;

public class AdditionalInfo {

    private Date leaveDate;

    private Long userId;

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
