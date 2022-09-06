package com.aeat.aeatproject.repository;

import com.aeat.aeatproject.domain.KakaoSearchDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KakaoSearchRepository {
    int insertKakaoSearch(KakaoSearchDto kakaoSearchDto);
}
