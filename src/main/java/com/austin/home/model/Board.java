package com.austin.home.model;

import lombok.Data;
import lombok.Generated;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Column(updatable=false)
    private String writer;

    @Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
    private Date datetime;


}
