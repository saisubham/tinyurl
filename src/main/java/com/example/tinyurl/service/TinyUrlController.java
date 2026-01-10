package com.example.tinyurl.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TinyUrlController {

	private final TinyUrlService tinyUrlService;

	public TinyUrlController(TinyUrlService tinyUrlService) {
		this.tinyUrlService = tinyUrlService;
	}

	@PostMapping
	public ResponseEntity<Url> shortenLongUrl(@RequestBody UrlRequest request) {
		Url url = tinyUrlService.shorten(request.longUrl());
		return ResponseEntity.ok().body(url);
	}

}
