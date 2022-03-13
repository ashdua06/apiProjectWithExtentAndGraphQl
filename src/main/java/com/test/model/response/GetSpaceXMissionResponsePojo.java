package com.test.model.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import com.test.apiRequestBuilder.APIInterface;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSpaceXMissionResponsePojo implements APIInterface.ResponsePojo{
    private ResponseData data;


    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseData{
        private List<Launches> launches;

    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Launches {
        private String mission_name;
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
