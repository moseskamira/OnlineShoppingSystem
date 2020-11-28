package com.online.shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.shopping.models.FeedBack;

@Repository
public interface FeedBackDao extends JpaRepository<FeedBack, Long>{
	
	@Query("SELECT feedBackObj FROM FeedBack feedBackObj ORDER BY feedBackObj.feedBackId DESC")
	List<FeedBack> findAllFeedBackDescending();

}
