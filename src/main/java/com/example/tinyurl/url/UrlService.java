package com.example.tinyurl.url;

import com.example.tinyurl.counter.CounterService;
import com.example.tinyurl.utils.MathUtils;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

	private final UrlRepository repository;
	private final CounterService counterService;

	public UrlService(UrlRepository repository, CounterService counterService) {
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
