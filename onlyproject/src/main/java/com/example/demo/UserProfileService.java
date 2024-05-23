package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    
     public List<UserProfile> getList(){
		
		List<UserProfile> profile = userProfileRepository.findAll();
	
		return profile;
	}
    // Other service methods

//	public void deleteUser(int id) {
//		
//			userProfileRepository.deleteById(id);
//			
//	}
}
