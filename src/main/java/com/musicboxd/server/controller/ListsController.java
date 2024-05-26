package com.musicboxd.server.controller;


import com.musicboxd.server.dto.ListsDto;
import com.musicboxd.server.service.Lists.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user/list")
public class ListsController {
@Autowired
    ListService listService;


@PostMapping("createList")
    public ListsDto createList(@RequestBody ListsDto listsDto){
    return listService.createListUris(listsDto);
    }
//    @DeleteMapping("/{userid}/deleteList/{id}")
//    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
//        listService.deleteListUris(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("{userid}/deletelist/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable (name = "userid") long userid,@PathVariable (name = "id") long id){
        listService.deleteListUris(userid,id);
        ResponseEntity.ok("Removed from the List successfully.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
