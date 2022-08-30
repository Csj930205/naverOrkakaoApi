package com.aeat.aeatproject.controller;

import com.aeat.aeatproject.api.SearchApiClient;
import com.aeat.aeatproject.domain.SearchForm;
import com.aeat.aeatproject.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    private final SearchApiClient searchApiClient;

    /*
    * 네이버 검색페이지 이동
    */
    @GetMapping("search")
    public String search(SearchForm form, Model model) {
        return "search/search";
    }

    /*
    * 네이버 검색조회
    * */
    @GetMapping("list")
    public String searchKeyword (SearchForm form, Model model){
        String result = searchApiClient.naverSearchApi(form.getKeyword());
        model.addAttribute("searchList",searchApiClient.naverJsonSearchApi(result));
        return "search/search";
    }

    /*
    * 카카오 검색페이지 이동
    * */
    @GetMapping("kakaosearch")
    public String kakaoSearch() {
        return "search/kakaosearch";
    }

    /*
    * 카카오 검색조회
    * */
    @GetMapping("kakaosearch/list")
    public String kakaoSearchKeyword(SearchForm form, Model model) {
        String result = searchApiClient.kakaoSearchApi(form.getKeyword());
        model.addAttribute("kakaoSearchList", searchApiClient.kakaoJsonSearchApi(result));
        return "search/kakaosearch";
    }

    @GetMapping("kakaoTest")
    public String test() {
        return "search/kakaoTest";
    }
}
