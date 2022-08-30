package com.aeat.aeatproject.service;

import com.aeat.aeatproject.api.SearchApiClient;
import com.aeat.aeatproject.domain.SearchDto;
import com.aeat.aeatproject.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchApiClient searchApiClient;
    private final SearchRepository searchRepository;

    @Transactional
    public int insertSearch(SearchDto searchDto){
        return searchRepository.insertSearch(searchDto);
    }
}
