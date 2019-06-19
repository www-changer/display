package com.example.display.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "daily_retained_user_rate")
@Data
@AllArgsConstructor
public class DailyRetainedUserRate {

    @Column(name = "retained_rate")
    private Float retainedRate;

    private String day;
}
