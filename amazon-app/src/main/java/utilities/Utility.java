package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {

	public static void takeScreenshot(WebDriver driver,int testID) throws IOException
	{
		String screenshotPath = "C:\\Users\\swapn\\Desktop\\shot\\";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath +testID+ ".jpeg");
		FileHandler.copy(source,dest);
	}
	
}
