package systemTesting.agePredictor;

import com.test.apiRequestBuilder.agePredictor.AgePredictor;
import com.test.model.request.GetAgeRequestPojo;
import com.test.validators.api.AgeValidator;
import org.testng.annotations.*;
import systemTesting.basePackage.BaseSetup;
import java.util.List;

public class AgePredictionTest extends BaseSetup {

    @DataProvider
    public Object[][] agePredictorDataProvider() {
       // List<GetAgeRequestPojo> testData=getTestData("AgePredictor.xlsx","GetAgeNew", GetAgeRequestPojo.class);
        List<GetAgeRequestPojo> testData=getTestData("AgePredictor.json", GetAgeRequestPojo.class);

        Object[][] data = new Object[testData.size()][3];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
            data[i][1] = testData.get(i).getTestMeta().getTestDescription();
            data[i][2] = testData.get(i).getJiraId();
        }
        return data;
    }

    @Test(dataProvider = "agePredictorDataProvider",priority = 0,enabled = true)
    public void validateGetAgeAPi(GetAgeRequestPojo getAgeRequest,String tcDescription,String JiraId) {
        AgePredictor agePredictor=new AgePredictor(getAgeRequest);
        agePredictor.createRequestJsonAndExecute();
        AgeValidator.getInstance().validateGetAgeResponse(agePredictor);
    }


}
