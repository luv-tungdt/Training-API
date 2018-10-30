package com.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchByPostCodeRequest {

    @Pattern(regexp = "[0-9]+$")
    @NotNull
    @JsonProperty("post_code")
    private String postCode;


    public SearchByPostCodeRequest() {
    }

    public SearchByPostCodeRequest(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
