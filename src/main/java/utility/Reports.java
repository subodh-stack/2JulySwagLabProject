package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReport() {
		ExtentSparkReporter html = new ExtentSparkReporter("SwagLab.html");
		
		ExtentReports reports = new ExtentReports();
		
		reports.attachReporter(html);
		
		reports.setSystemInfo("Testing", "Regression");
	
		return reports;
	}
}
