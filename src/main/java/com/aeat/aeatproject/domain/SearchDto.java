package com.aeat.aeatproject.domain;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class SearchDto {
        private String seq;
        private String title;
        private String link;
        private String category;
        private String address;
        private String roadAddress;
        private String mapx;
        private String mapy;

        public SearchDto(JSONObject searchJson) {
                this.title = searchJson.get("title").toString();
                this.link = searchJson.get("link").toString();
                this.category = searchJson.get("category").toString();
                this.address = searchJson.get("address").toString();
                this.roadAddress = searchJson.get("roadAddress").toString();
                this.mapx = searchJson.get("mapx").toString();
                this.mapy = searchJson.get("mapy").toString();
        }
}
