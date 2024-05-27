package com.musicboxd.server.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isPublic;
    private Set<String> uris;
}
