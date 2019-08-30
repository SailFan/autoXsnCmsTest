package org.xsn.autotest.page.content;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.xsn.autotest.common.PublicMethod;

public class AddArticle extends PublicMethod {

	@FindBy(xpath = "//form/div[2]//input")
	WebElement article;

	@FindBy(xpath = "//form/div[3]//input")
	WebElement author;

	@FindBy(xpath = "//form/div[4]//input")
	WebElement source;

	@FindBy(xpath = "//form/div[5]//textarea")
	WebElement explain;

	@FindBy(xpath = "//form/div[6]//input")
	WebElement topic;

	@FindBy(xpath = "//form/div[7]//input")
	WebElement site;

	@FindBy(xpath = "//form/div[8]//input")
	WebElement contentType;

	@FindBy(xpath = "//form/div[9]//input")
	WebElement keyWord;

	@FindBy(xpath = "//form/div[10]//button")
	WebElement img;

	@FindBy(xpath = "//div[@data-placeholder=\"Insert text here ...\"]")
	WebElement inputContent;

	@FindBy(xpath = "//form/div[12]/div/button")
	WebElement commit;

	@FindBy(xpath = "//form/div[12]/div/a/button")
	WebElement cancel;
	
	@FindBy(xpath="//div[3]/div[1]/div[1]/ul/li[1]")
	WebElement siteHome;
	public AddArticle(WebDriver brower) {
		super.webDriver = brower;
		PageFactory.initElements(brower, this);
	}

	public void setArticle(String str) {
		article.clear();
		article.sendKeys(str);
	}
	
	public void setAuthor(String str) {
		author.clear();
		author.sendKeys(str);
	}
	
	public void setSource(String str) {
		source.clear();
		source.sendKeys(str);
	}
	
	public void setExplain(String str) {
		explain.clear();
		explain.sendKeys(str);
	}
	
	public void setTopic(String str) {
		topic.clear();
		topic.sendKeys(str);
	}
	
	public void setSite() {
		site.click();
		List<WebElement> list = super.webDriver.findElements(By.xpath("//div[@class='el-scrollbar']//li"));
		
	}

}
