package week4.day1;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
			ChromeDriver chd= new ChromeDriver();
			chd.get("https://www.amazon.in/");
			chd.manage().window().maximize();
			chd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			//search as oneplus 9 pro
			chd.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
			chd.findElement(By.id("nav-search-submit-button")).click();
			
			//get the price of the first product
			String MobPrice=chd.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
			System.out.println("the price of the first product is"+ " " +MobPrice);
			
			//Print the number of customer ratings for the first displayed product
			String customerRatings= chd.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
			System.out.println("the number of customer ratings for the product"+ " " +customerRatings);
			
			//click on the stars 
			chd.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]")).click();
			Thread.sleep(5000);
			
			//Get the percentage of ratings for the 5 star
			
			WebElement table=chd.findElement(By.id("histogramTable"));
			List<WebElement> tablerows=table.findElements(By.tagName("tr"));
			
			for(int i=0;i<tablerows.size();i++) {
				List<WebElement> tablecols=tablerows.get(0).findElements(By.tagName("td"));
				String coldata=tablecols.get(i).getText();
				if(coldata.contains("%")) {
					System.out.println("the 5 star rating % of  product is" + " "+coldata);
					break;
				}
			}
			// Click the first text link of the first image
			chd.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
			
			// Click 'Add to Cart' button
			
			Set<String> handler= chd.getWindowHandles();
	         Iterator<String> it = handler.iterator();
	         String parentWindowID=it.next();
	         System.out.println("Parent window is"+parentWindowID);
	         
	         String childWindowID=it.next();
	         System.out.println("child window is"+childWindowID);
	         chd.switchTo().window(childWindowID);
	         System.out.println("child window title is"+ " "+chd.getTitle());
	         
	         
	         
	        chd.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	        Set<String> handler1= chd.getWindowHandles();
	        Iterator<String> it1 = handler1.iterator();
	        String parentWindowID1=it1.next();
	        System.out.println("Parent window is"+parentWindowID1);
	        chd.switchTo().window(parentWindowID1);
	        Thread.sleep(2000);
	        chd.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
	        chd.findElement(By.xpath("//a[@id='nav-cart']")).click();
	         
	        
	         
			//Get the cart subtotal and verify if it is correct.
	         
	         String cartTotal=chd.findElement(By.xpath("attach-accessory-cart-subtotal")).getText();
	         System.out.println("cart tootal is"+ " "  +cartTotal);
	         if(MobPrice.equalsIgnoreCase(cartTotal)) {
	        	 System.out.println("both subtotal and mobprice are same");
	         }
			chd.quit();
			
			
	}

}
