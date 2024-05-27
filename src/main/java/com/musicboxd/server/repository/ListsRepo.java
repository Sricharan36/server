package com.musicboxd.server.repository;


import com.musicboxd.server.model.Lists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepo extends JpaRepository<Lists, Long> {
}
