package systemTesting.basePackage;

import com.avis.constants.AvisConstants;
import com.avis.constants.TestNGParams;
import com.avis.reporting.generics.ReportingGenericFunctions;
import com.avis.reporting.listeners.AnnotationTransformer;
import com.avis.reporting.listeners.ReportingTestngListener;
import com.avis.utils.dataUtils.ExcelUtils;
import com.avis.utils.dataUtils.JsonFileUtils;
import com.avis.utils.jsonProcessor.JacksonJsonImpl;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.xml.XmlTest;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Listeners({ ReportingTestngListener.class, AnnotationTransformer.class})
public class BaseSetup  {

    @BeforeSuite(alwaysRun = true)
    public void startTest(XmlTest xmlTest, ITestContext context) {
        TestNGParams.getInstance().setTestNgParameters(xmlTest,context);
        initExtentReporter();
    }

    public List<Object> getTestDataFromSheet(String workBook, String sheetName){
        List<Object> excelData= ExcelUtils.getInstance().getSheetDataAsList(workBook,sheetName);
        return excelData;
    }

    public List<Object> getTestDataFromJsonFile(String jsonFileName){
        List<Object> jsonData= JsonFileUtils.getInstance().getTestDataFromJsonFile(jsonFileName);
        return jsonData;
    }




    //Get Test Data From Excel
    public <T> List<T> getTestData(String workBook, String sheetName, Class<T> clas) {
        List<Object> excelData = getTestDataFromSheet(workBook, sheetName);
        try {
            CollectionType typeReference =
                    TypeFactory.defaultInstance().constructCollectionType(List.class, clas);
            List<T> li= JacksonJsonImpl.getInstance().fromJsonArray(excelData.toString(),typeReference);
            return li;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getTestData(String jsonFileName, Class<T> clas) {
        List<Object> excelData = getTestDataFromJsonFile(jsonFileName);
        try {
            CollectionType typeReference =
                    TypeFactory.defaultInstance().constructCollectionType(List.class, clas);
            List<T> li= JacksonJsonImpl.getInstance().fromJsonArray(excelData.toString(),typeReference);
            return li;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public synchronized void initExtentReporter() {
        ReportingGenericFunctions.initExtentReporter(AvisConstants.FLAG_REMOVE_RETRIEDTESTS, AvisConstants.FLAG_UPDATE_SCREENSHOTS, AvisConstants.FILE_NAME_REPORT, AvisConstants.REPORT_TITLE);
    }
    public synchronized void initAPIPerfReporter() {
            ReportingGenericFunctions.initAPIPerfReporter(AvisConstants.FILE_NAME_REPORT, AvisConstants.REPORT_TITLE);

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        initAPIPerfReporter();
    }
}
