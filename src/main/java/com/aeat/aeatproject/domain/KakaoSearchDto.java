package com.aeat.aeatproject.domain;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class KakaoSearchDto {
    private String seq;
    private String address_name;
    private String category_name;
    private String phone;
    private String place_name;
    private String place_url;
    private String road_address_name;
    private String x;
    private String y;

    public KakaoSearchDto(JSONObject jsonObject) {
        this.address_name = jsonObject.get("address_name").toString();
        this.category_name = jsonObject.get("category_name").toString();
        this.phone = jsonObject.get("phone").toString();
        this.place_name = jsonObject.get("place_name").toString();
        this.place_url = jsonObject.get("place_url").toString();
        this.road_address_name = jsonObject.get("road_address_name").toString();
        this.x = jsonObject.get("x").toString();
        this.y = jsonObject.get("y").toString();
    }

}
