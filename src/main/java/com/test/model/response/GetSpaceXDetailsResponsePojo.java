package com.test.model.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import com.test.apiRequestBuilder.APIInterface;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSpaceXDetailsResponsePojo implements APIInterface.ResponsePojo{
    private ResponseData data;


    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseData{
        private Company company;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Company{
        private String name;
        private String ceo;
        private String coo;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public Object getErrors() {
        return null;
    }

    @Override
    public Object getBody() {
        return null;
    }
}
