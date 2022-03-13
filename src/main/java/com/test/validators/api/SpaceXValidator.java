package com.test.validators.api;

import com.avis.reporting.assertions.CustomAssert;
import com.test.apiRequestBuilder.agePredictor.AgePredictor;
import com.test.apiRequestBuilder.spaceX.GetSpaceXDetails;
import com.test.exceptions.AgePredictorException;
import com.test.exceptions.SpacexException;

public class SpaceXValidator {
    private static volatile SpaceXValidator instance;

    private SpaceXValidator() {
    }

    public static SpaceXValidator getInstance() {
        if (instance == null) {
            synchronized (SpaceXValidator.class) {
                if (instance == null) {
                    instance = new SpaceXValidator();
                }
            }
        }
        return instance;
    }

    public void validateGetSpaceXDetailsResponse(GetSpaceXDetails obj){
        try{
            CustomAssert.assertEquals(obj.getApiResponse().getStatusCode(),obj.getRequestPojo().getTestMeta().getExpectedStatusCode()," HTTP Status code validation");
            CustomAssert.assertEquals(obj.getResponsePojo().getData().getCompany().getName(),obj.getRequestPojo().getTestMeta().getExpectedCompanyDetails().getName(),"Company Name Validation in response");
            CustomAssert.assertEquals(obj.getResponsePojo().getData().getCompany().getCeo(),obj.getRequestPojo().getTestMeta().getExpectedCompanyDetails().getCeo(),"Company CEO Validation in response");
            CustomAssert.assertEquals(obj.getResponsePojo().getData().getCompany().getCoo(),obj.getRequestPojo().getTestMeta().getExpectedCompanyDetails().getCoo(),"Company COO Validation in response");
        }
        catch (Exception e){
            throw new SpacexException("Error in validating SpaceX details response ",e);
        }

    }

}
