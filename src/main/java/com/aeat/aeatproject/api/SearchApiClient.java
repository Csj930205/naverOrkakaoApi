package com.aeat.aeatproject.api;

import com.aeat.aeatproject.domain.KakaoSearchDto;
import com.aeat.aeatproject.domain.SearchDto;
import com.aeat.aeatproject.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchApiClient {

    /*
     * Naver Rest API
     * */
    private final RestTemplate restTemplate;
    private final String CLIENT_ID = "oooK9JnnZTRCZdUMR1sh";
    private final String CLIENT_SECRET = "2rr3mvTz4D";

    /*
    * Kakao Rest API
    * */
    private final String KAKAO_REST_API_KEY = "de117df7c77c27ef6224c1e24999e14f";

    /*
    * 네이버 정책상의 문제로 최대 5개 표시 가능(dispaly =5)
    * query = 키워드 입력
    * sort = 정렬 옵션(random: 키워드 유사도 순으로 정렬, comment: 블로그/카페 리뷰순으로 정렬)
    * */
    private final String searchUri = "https://openapi.naver.com/v1/search/local.json?query=이수역+{keyword}&display=5";

    /*
    * 카카오 키워드 검색
    * */
    private final String kakaoSearchUri = "https://dapi.kakao.com/v2/local/search/keyword.json?query=이수역+{keyword}&sort=accuracy&size=1";

    /*
    * 네이버검색 API
    * */
    public String naverSearchApi(String keyword) {
        final HttpHeaders headers = new HttpHeaders(); // 헤더에 key를 담아준다.
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        String result = restTemplate.exchange(searchUri, HttpMethod.GET, entity, String.class, keyword).getBody();

        return result;
    }
    
    /*
    * 네이버 JSON데이터 파싱 후 SearchDto 저장
    * */
    @SneakyThrows
    public List<SearchDto> naverJsonSearchApi(String result) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        List<SearchDto> searchList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject searchObj = (JSONObject) jsonArray.get(i);
            SearchDto searchDto = new SearchDto(searchObj);
            searchList.add(searchDto);
        }
        return searchList;
    }

    /*
    * 카카오 키워드 검색 API
    * */
    public String kakaoSearchApi(String keyword) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization" , "KakaoAK " + KAKAO_REST_API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        String result = restTemplate.exchange(kakaoSearchUri, HttpMethod.GET, entity, String.class, keyword).getBody();

        return result;
    }
    /*
    * 카카오 JSON 데이터 파싱 후 KakaoSearchDto에 저장
    * */
    @SneakyThrows
    public List<KakaoSearchDto> kakaoJsonSearchApi(String result) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("documents");

        List<KakaoSearchDto> kakaoSearchDtoList = new ArrayList<>();
        for (int i=0; i<jsonArray.size(); i++){
            JSONObject kakaoSearchObj = (JSONObject) jsonArray.get(i);
            KakaoSearchDto kakaoSearchDto = new KakaoSearchDto(kakaoSearchObj);
            kakaoSearchDtoList.add(kakaoSearchDto);
        }
        return kakaoSearchDtoList;
    }
}
