package com.example.tinyurl.url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, String> {

	@Query(value = "select nextval('counter')",nativeQuery = true)
	Long getCounterNextVal();

}
