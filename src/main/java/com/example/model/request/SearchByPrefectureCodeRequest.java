package com.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchByPrefectureCodeRequest {
    @Pattern(regexp = "[0-9]+$")
    @NotNull
    @JsonProperty("prefecture_code")
    private String prefectureCode;

    public SearchByPrefectureCodeRequest() {
    }

    public SearchByPrefectureCodeRequest(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }

    public String getPrefectureCode() {
        return prefectureCode;
    }

    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }
}
