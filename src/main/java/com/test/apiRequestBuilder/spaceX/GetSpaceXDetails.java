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
import com.test.model.response.GetSpaceXDetailsResponsePojo;
import io.restassured.response.Response;

public class GetSpaceXDetails extends BaseApi implements APIInterface {
    private Response response;
    private String request;
    private GetSpaceXDetailsRequestPojo spaceXDetailsRequestPojo;
    private GetSpaceXDetailsResponsePojo spaceXDetailsResponsePojo;

    public GetSpaceXDetails(GetSpaceXDetailsRequestPojo requestPojo){
        this.spaceXDetailsRequestPojo=requestPojo;
        setMethod(MethodType.POST);
        setContentType(ContentType.JSON);
        setBaseUri(LocalConfig.SPACEX);
        setBasePath(APIEndpoints.SPACEX.GRAPHQL);
    }
    @Override
    public GetSpaceXDetailsRequestPojo getRequestPojo() {
        return spaceXDetailsRequestPojo;
    }

    @Override
    public GetSpaceXDetailsResponsePojo getResponsePojo() {
        return spaceXDetailsResponsePojo;
    }

    @Override
    public Response getApiResponse() {
        return response;
    }

    @Override
    public void createRequestJsonAndExecute() {
        try {
            this.request = JacksonJsonImpl.getInstance().toJSon(this.spaceXDetailsRequestPojo);
            setBody(request);
            response=execute();
            this.spaceXDetailsResponsePojo=JacksonJsonImpl.getInstance().fromJson(response.asString(),GetSpaceXDetailsResponsePojo.class);
        }
        catch (Exception e){
            throw new SpacexException("Error in executing graphql spaceX api",e);
        }
    }
}
