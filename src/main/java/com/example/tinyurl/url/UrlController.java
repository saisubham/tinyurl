package com.example.tinyurl.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
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

	@GetMapping("/{hash}")
	public ResponseEntity<String> getLongUrl(@PathVariable String hash) {
		return urlService.getLongUrl(hash)
				.map(value -> ResponseEntity
						.status(HttpStatus.TEMPORARY_REDIRECT)
						//.location(URI.create(value.getLongUrl()))
						.body(value.getLongUrl())
				)
				.orElseGet(() -> ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.build());
	}

}
