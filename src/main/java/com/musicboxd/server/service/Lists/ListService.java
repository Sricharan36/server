package com.musicboxd.server.service.Lists;

import com.musicboxd.server.dto.ListsDto;
import org.springframework.stereotype.Service;

@Service
public interface ListService {

   ListsDto createListUris(ListsDto listsDto);

    void deleteListUris(long userid, long id);
}
