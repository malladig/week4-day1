package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver chd= new ChromeDriver();
		chd.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		chd.manage().window().maximize();
		chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	    //Switch to the frame	
		WebElement webelement= chd.findElement(By.id("iframeResult"));
		chd.switchTo().frame(webelement);
		
		//Then click Try It with xpath
		chd.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Switch to the alert
		Alert a= chd.switchTo().alert();
		String text= a.getText();
		System.out.println(text);
		a.sendKeys("aaaa");
		
		//Then perform accept / dismiss
		a.accept();
        
		//Get the text using id 
		WebElement wl= chd.findElement(By.id("demo"));
		String text1= wl.getText();
		
		//Verify the text based on the action
		if(text1.contains("aaa")) {
			System.out.println("text contains enetred name"+text1);

	}

}
	
}
