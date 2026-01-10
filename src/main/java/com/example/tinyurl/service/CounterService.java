package com.example.tinyurl.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CounterService {

	private static final long RANGE = 1000L;
	private final TinyUrlRepository repository;
	private final AtomicLong cur = new AtomicLong(0);
	private volatile long max = 0L;
	private final Object refillLock = new Object();

	public CounterService(TinyUrlRepository repository) {
		this.repository = repository;
	}

	public long next() {
		while (true) {
			long v = cur.getAndIncrement();
			if (v < max) {
				return v;
			}
			refillIfNeeded(v);
		}
	}

	private void refillIfNeeded(long n) {
		if (n < max) return;
		synchronized (refillLock) {
			if (cur.get() < max) return;
			long start = repository.getCounterNextVal();
			cur.set(start);
			max = start + RANGE;
		}
	}
}
