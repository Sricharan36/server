package com.musicboxd.server.service.Lists;

import com.musicboxd.server.dto.ListsDto;
import com.musicboxd.server.model.Lists;
import com.musicboxd.server.model.User;
import com.musicboxd.server.repository.ListsRepo;
import com.musicboxd.server.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ListsRepo listsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ListsDto createListUris(ListsDto listsDto) {
        User user = retriveLoggedInUser();
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        Lists lists = modelMapper.map(listsDto, Lists.class);
        lists.setUser(user); // Assuming Lists has a User field to set the owner of the list
        Lists savedLists = listsRepo.save(lists);
        return modelMapper.map(savedLists, ListsDto.class);
    }

    @Override
    public void deleteListUris(long userid, long id) {
        // Implement the logic to delete a list by user ID and task ID
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        Lists lists = listsRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("List Not Found"));

        if (!lists.getUser().equals(user)) {
            throw new IllegalArgumentException("User does not own this list");
        }

        listsRepo.delete(lists);
    }

    private User retriveLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated())
            throw new BadCredentialsException("Bad Credentials login ");
        String username = authentication.getName();
        System.out.println("In Logged In User "+username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found "));
    }

}
