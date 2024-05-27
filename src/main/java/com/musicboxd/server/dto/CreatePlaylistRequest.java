package com.musicboxd.server.dto;

import lombok.Data;

@Data
public class CreatePlaylistRequest {
    private String name;
    private String description;
    private boolean isPublic;
}
