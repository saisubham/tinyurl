package com.example.tinyurl.url;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlController {

	private final UrlService urlService;

	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}

	@PostMapping
	public ResponseEntity<Url> shortenLongUrl(@RequestBody UrlRequest request) {
		Url url = urlService.shorten(request.longUrl());
		return ResponseEntity.ok().body(url);
	}

}
