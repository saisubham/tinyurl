package com.example.tinyurl.service;

import com.example.tinyurl.utils.MathUtils;
import org.springframework.stereotype.Service;

@Service
public class TinyUrlService {

	private final TinyUrlRepository repository;
	private final CounterService counterService;

	public TinyUrlService(TinyUrlRepository repository, CounterService counterService) {
		this.repository = repository;
		this.counterService = counterService;
	}

	public Url shorten(String longUrl) {
		Url url = new Url();
		url.setHash(MathUtils.base10ToBase62(counterService.next()));
		url.setLongUrl(longUrl);
		return repository.save(url);
	}

}
