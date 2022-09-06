package com.aeat.aeatproject.service;

import com.aeat.aeatproject.domain.KakaoSearchDto;
import com.aeat.aeatproject.repository.KakaoSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoSearchService {
    private final KakaoSearchRepository kakaoSearchRepository;

    public int insertKakaoSearch(KakaoSearchDto kakaoSearchDto) {
        return kakaoSearchRepository.insertKakaoSearch(kakaoSearchDto);
    }
}
