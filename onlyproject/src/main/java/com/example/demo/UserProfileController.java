package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3001") // クライアントのURLを指定
@RestController
public class UserProfileController {
    
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/user-profiles")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    // 他のエンドポイント (削除、更新など) を追加できます
}