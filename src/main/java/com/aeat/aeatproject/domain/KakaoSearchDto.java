package com.aeat.aeatproject.domain;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class KakaoSearchDto {
    private String seq;
    private String addressName;
    private String categoryName;
    private String phone;
    private String placeName;
    private String placeUrl;
    private String roadAddressName;
    private String mapx;
    private String mapy;

    public KakaoSearchDto(JSONObject jsonObject) {
        this.addressName = jsonObject.get("address_name").toString();
        this.categoryName = jsonObject.get("category_name").toString();
        this.phone = jsonObject.get("phone").toString();
        this.placeName = jsonObject.get("place_name").toString();
        this.placeUrl = jsonObject.get("place_url").toString();
        this.roadAddressName = jsonObject.get("road_address_name").toString();
        this.mapx = jsonObject.get("x").toString();
        this.mapy = jsonObject.get("y").toString();
    }

}
