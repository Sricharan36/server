package com.musicboxd.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Lists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTheList;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descriptionOfTheList;
    private Boolean isAPublicList;
    private Boolean isANumberedList;
    private List<String> contentUris;
    private String listId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
