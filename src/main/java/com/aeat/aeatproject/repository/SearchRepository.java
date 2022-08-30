package com.aeat.aeatproject.repository;

import com.aeat.aeatproject.domain.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchRepository {

    List<SearchDto> getSearch();
    int insertSearch(SearchDto searchDto);
}
