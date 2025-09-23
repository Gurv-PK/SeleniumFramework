package Utils;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    public void OnTestResultFailure(ITestResult iTestResult){
        String filename = System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+iTestResult.getMethod().getMethodName();
        File file = ((TakesScreenshot) BaseTest.webdriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File(filename+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void transform(ITestAnnotation iTestAnnotation, Class testclass, Constructor testConstructor, Method testMethod){
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
