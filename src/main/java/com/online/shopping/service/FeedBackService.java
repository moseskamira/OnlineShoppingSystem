package com.online.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.FeedBackDao;
import com.online.shopping.models.FeedBack;

@Service
public class FeedBackService {
	
	@Autowired
	FeedBackDao feedBackDao;
	
	public FeedBack addFeedBack(FeedBack feedBack) {
		FeedBack myFeedBack = new FeedBack();
		myFeedBack.setCommenterFullName(feedBack.getCommenterFullName());
		myFeedBack.setCommenterEmail(feedBack.getCommenterEmail());
		myFeedBack.setCommenterText(feedBack.getCommenterText());
		FeedBack savedFeedBack = feedBackDao.saveAndFlush(myFeedBack);
		return savedFeedBack;
	}
	
	public List<FeedBack> fetchAllComments() {
		return feedBackDao.findAll();
	}
	
	public String deleteComment(Long feedBackId) {
		FeedBack commentToDelete = feedBackDao.getOne(feedBackId);
		feedBackDao.delete(commentToDelete);
		return "Successfully Deleted Comment";
	}
}
