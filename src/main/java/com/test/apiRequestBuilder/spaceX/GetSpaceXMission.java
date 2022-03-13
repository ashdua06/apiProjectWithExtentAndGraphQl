package com.test.apiRequestBuilder.spaceX;

import com.avis.constants.ContentType;
import com.avis.constants.MethodType;
import com.avis.core.BaseApi;
import com.avis.utils.jsonProcessor.JacksonJsonImpl;
import com.test.apiRequestBuilder.APIInterface;
import com.test.exceptions.SpacexException;
import com.test.global.APIEndpoints;
import com.test.global.LocalConfig;
import com.test.model.request.GetSpaceXDetailsRequestPojo;
import com.test.model.request.GetSpaceXMissionRequestPojo;
import com.test.model.response.GetSpaceXDetailsResponsePojo;
import com.test.model.response.GetSpaceXMissionResponsePojo;
import io.restassured.response.Response;

public class GetSpaceXMission extends BaseApi implements APIInterface {
    private Response response;
    private String request;
    private GetSpaceXMissionRequestPojo spaceXMissionRequestPojo;
    private GetSpaceXMissionResponsePojo spaceXMissionResponsePojo;

    public GetSpaceXMission(GetSpaceXMissionRequestPojo requestPojo){
        this.spaceXMissionRequestPojo=requestPojo;
        setMethod(MethodType.POST);
        setContentType(ContentType.JSON);
        setBaseUri(LocalConfig.SPACEX);
        setBasePath(APIEndpoints.SPACEX.GRAPHQL);
    }
    @Override
    public GetSpaceXMissionRequestPojo getRequestPojo() {
        return spaceXMissionRequestPojo;
    }

    @Override
    public GetSpaceXMissionResponsePojo getResponsePojo() {
        return spaceXMissionResponsePojo;
    }

    @Override
    public Response getApiResponse() {
        return response;
    }

    @Override
    public void createRequestJsonAndExecute() {
        try {
            this.request = JacksonJsonImpl.getInstance().toJSon(this.spaceXMissionRequestPojo);
            setBody(request);
            response=execute();
            this.spaceXMissionResponsePojo=JacksonJsonImpl.getInstance().fromJson(response.asString(),GetSpaceXMissionResponsePojo.class);
        }
        catch (Exception e){
            throw new SpacexException("Error in executing graphql spaceX api",e);
        }
    }
}
