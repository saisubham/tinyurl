package com.example.tinyurl.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TinyUrlRepository extends JpaRepository<Url, String> {

	@Query(value = "select nextval('counter')",nativeQuery = true)
	Long getCounterNextVal();

}
