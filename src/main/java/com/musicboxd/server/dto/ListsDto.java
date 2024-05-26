package com.musicboxd.server.dto;

import com.musicboxd.server.model.User;
import lombok.Data;


import java.util.List;
@Data
public class ListsDto {
    private Long id;
    private String nameOfTheList;
    private String descriptionOfTheList;
    private Boolean isAPublicList;
    private Boolean isANumberedList;
    private List<String> contentUris;
    private String listId;
    private User user;
}
