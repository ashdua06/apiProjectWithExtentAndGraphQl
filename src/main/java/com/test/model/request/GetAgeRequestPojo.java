package com.test.model.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.test.apiRequestBuilder.APIInterface;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class GetAgeRequestPojo implements APIInterface.RequestPojo {
    private String name;
    @JsonProperty("uniqueTrackingId")
    private String jiraId;
    private TestMeta testMeta;
    private String  active_test;

    @Data
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class TestMeta{
        private Map<String,String> tcDescription;
        private String testDescription;
        private int expectedAge;
        private int expectedStatusCode;
    }
}
