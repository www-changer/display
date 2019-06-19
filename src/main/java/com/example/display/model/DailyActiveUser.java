package com.example.display.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "daily_active_user")
@Data
@AllArgsConstructor
public class DailyActiveUser {
    @Column(name = "active_user")
    private Integer activeUser;

    private String day;

}