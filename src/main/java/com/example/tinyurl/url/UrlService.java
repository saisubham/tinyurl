package com.example.tinyurl.url;

import com.example.tinyurl.counter.CounterService;
import com.example.tinyurl.utils.MathUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

	private final UrlRepository repository;
	private final CounterService counterService;
	private final String hostname;

	public UrlService(UrlRepository repository, CounterService counterService, @Value("${tinyurl.hostname}") String hostname) {
		this.repository = repository;
		this.counterService = counterService;
		this.hostname = hostname;
	}

	public Url shorten(String longUrl) {
		Url url = new Url();
		url.setHash(MathUtils.base10ToBase62(counterService.next()));
		url.setLongUrl(longUrl);
		Url savedUrl = repository.save(url);
		return new Url(hostname + "/" + savedUrl.getHash(), savedUrl.getLongUrl(), savedUrl.getCreatedAt());
	}

	public Optional<Url> getLongUrl(String hash) {
		return repository.findById(hash);
	}
}
