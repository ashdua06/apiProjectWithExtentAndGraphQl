package com.test.model.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.model.response.GetSpaceXDetailsResponsePojo;
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

public class GetSpaceXDetailsRequestPojo  implements APIInterface.RequestPojo{
    private String query;
    private TestMeta testMeta;
    @JsonProperty("uniqueTrackingId")
    private String jiraId;
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
        private String testDescription;
        private int expectedStatusCode;
        private GetSpaceXDetailsResponsePojo.Company expectedCompanyDetails;
    }
}
