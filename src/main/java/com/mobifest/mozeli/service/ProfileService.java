package com.mobifest.mozeli.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.ProfileDao;
import com.mobifest.mozeli.models.Profile;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDao profileDao;
	
	public Profile saveProfile(Profile prof) {
		Profile profile = new Profile();
		profile.setPdfFileUrl(prof.getPdfFileUrl());
		Profile savedProf = profileDao.saveAndFlush(profile);
		return savedProf;
	}
	
	public Profile getLastUpdatedProfile() {
		Profile lastUpdatedProfile = profileDao.findTopByOrderByProfileIdDesc();
		return lastUpdatedProfile;
	}
	
	public String deleteProfile(Long profileId) {
		Profile profileToDelete = profileDao.getOne(profileId);
		profileDao.delete(profileToDelete);
		return "Successfully Deleted Profile";
	}
	
	public List<Profile> fetchAllProfiles() {
		return profileDao.findAll();
	}
}
