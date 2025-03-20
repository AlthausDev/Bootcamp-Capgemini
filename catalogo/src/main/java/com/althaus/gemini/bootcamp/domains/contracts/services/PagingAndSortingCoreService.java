package com.althaus.gemini.bootcamp.domains.contracts.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PagingAndSortingCoreService<T> extends CoreService<T> {
	Iterable<T> getAll(Sort sort);
	Page<T> getAll(Pageable pageable);
}
