package com.aeat.aeatproject.controller;

import com.aeat.aeatproject.api.SearchApiClient;
import com.aeat.aeatproject.domain.KakaoSearchDto;
import com.aeat.aeatproject.domain.SearchForm;
import com.aeat.aeatproject.service.KakaoSearchService;
import com.aeat.aeatproject.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    private final KakaoSearchService kakaoSearchService;
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
    /*
    * 카카오 등록
    * */
    @PostMapping("kakaosearch/insert")
    public String kakaoSearchInsert(HttpServletRequest req) {
        String[] insertList = req.getParameterValues("valueArr");
        for (int i=0; i<insertList.length; i++) {
            System.out.println(insertList[i]);
        }
        return "search/kakaosearch";
    }

}
