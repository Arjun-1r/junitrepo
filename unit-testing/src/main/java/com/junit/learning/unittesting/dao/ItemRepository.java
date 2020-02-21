package com.junit.learning.unittesting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junit.learning.unittesting.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	

}
