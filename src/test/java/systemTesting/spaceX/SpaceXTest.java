package systemTesting.spaceX;

import com.test.apiRequestBuilder.agePredictor.AgePredictor;
import com.test.apiRequestBuilder.spaceX.GetSpaceXDetails;
import com.test.global.Groups;
import com.test.model.request.GetAgeRequestPojo;
import com.test.model.request.GetSpaceXDetailsRequestPojo;
import com.test.validators.api.AgeValidator;
import com.test.validators.api.SpaceXValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import systemTesting.basePackage.BaseSetup;

import java.util.List;

public class SpaceXTest extends BaseSetup {
    //SpaceXCompanyDetails.json
    @DataProvider
    public Object[][] spaceXDetailsDataProvider() {
        List<GetSpaceXDetailsRequestPojo> testData=getTestData("SpaceXCompanyDetails.json", GetSpaceXDetailsRequestPojo.class);

        Object[][] data = new Object[testData.size()][3];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
            data[i][1] = testData.get(i).getTestMeta().getTestDescription();
            data[i][2] = testData.get(i).getJiraId();
        }
        return data;
    }

    @Test(dataProvider = "spaceXDetailsDataProvider",groups = {Groups.GRAPHQL,Groups.REGRESSION})
    public void validateSpaceXDetailsAPi(GetSpaceXDetailsRequestPojo getSpaceXDetailsRequestPojo,String tcDescription,String JiraId) {
        GetSpaceXDetails spaceXDetails=new GetSpaceXDetails(getSpaceXDetailsRequestPojo);
        spaceXDetails.createRequestJsonAndExecute();
        SpaceXValidator.getInstance().validateGetSpaceXDetailsResponse(spaceXDetails);
    }
}
