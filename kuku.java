package selenium_local;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class kuku {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/anubhav/Downloads/chromedriver");

		WebDriver w = new ChromeDriver();
		w.get("http://106.186.25.143/kuku-kube/en-3/");
		WebElement start = w.findElement(By.id("index")).findElement(By.tagName("button"));

		start.click();
		WebElement box = w.findElement(By.id("box"))	;

		while(true){

//			WebElement box = w.findElement(By.id("box"))	;

			List<WebElement> allSpans = box.findElements(By.tagName("span"));
			int numEle = allSpans.size();
			int[] sumArr = new int[numEle];
			WebElement[] eleArr = new WebElement[numEle];

			int i = 0;
			for(WebElement e : allSpans){
				String temp = e.getCssValue("background-color");
				sumArr[i] = rgbSum(temp);
				eleArr[i] = e;
				i++;
			}
			int sameSum = -1;	
			int clickIndex = -1;
			int a = sumArr[0];
			int b = sumArr[1];
			int c = sumArr[2];
			
			if(a == b ){
				sameSum = a;
			}
			else if(b == c){
				//click on a
				clickIndex = 0;
				eleArr[clickIndex].click();
				//call click function here
				
				
				continue;
			}
			else{
				clickIndex = 1;
				//click on b
				eleArr[clickIndex].click();

				continue;
			}
			
			int z = 2;
			while(z < numEle){
				if(sumArr[z] != sameSum){
					//click on z;
					clickIndex = z;
					eleArr[clickIndex].click();
					
					break;
				}
				z++;
			}
			
//			System.out.println("Click Index : " + clickIndex);
		} 

	}
	static int rgbSum(String x){

		int sum = 0;
		x = x.replaceAll(" " , "");
		x = x.replaceAll("rgba\\(", "");
		x = x.replaceAll("\\)", "");
	//	System.out.println(x);
		for(String z : x.split(",")){
			sum += Integer.parseInt(z);
		}
		return sum;
	}

}
