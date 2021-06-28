package com.austin.home.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String meaning;
    private String memo;
    @Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
    private Date datetime;

}
