package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // クライアントのURLを指定
@RestController
public class UserProfileController {
    
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/user-profiles/add")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
    	System.out.println(userProfile);
        return userProfileService.createUserProfile(userProfile);
    }
     
    @GetMapping("/show-profile")
    public List<UserProfile> showprofile () {
    	return userProfileService.getList();
    }
    
  //削除
//    @DeleteMapping("/user-profiles/delete")
//    public void deleteUser(@PathVariable int id) {
//    userProfileService.deleteUser(id);
//    }
    
}