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

//	网站首页
//	@FindBy(xpath="//div[@class='el-scrollbar']//li[1]/span")
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[1]/span")
	public WebElement siteHome;

	// 德州
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[2]/span")
	public WebElement deZhou;

	// 廊坊
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[3]/span")
	public WebElement langFang;

	// 濱州
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[4]/span")
	public WebElement binZhou;

	// 淄博
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[5]/span")
	public WebElement ziBo;

	// 厦门
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[6]/span")
	public WebElement xiaMen;

	// 徐州
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[7]/span")
	public WebElement xuZhou;

	// 北京朝阳
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/ul/li[8]/span")
	public WebElement beiJingChaoYang;
	
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]/ul/li[1]/span")
	public List<WebElement> contentOptions;
	
	
	public AddArticle(WebDriver brower) {
		super.webDriver = brower;
		PageFactory.initElements(brower, this);
	}
	public WebElement getContentOptions(String opt) {
		List<WebElement> options = this.contentOptions;
		System.out.println(options.size());
		System.out.println(options);
		return null;
	}
	
	public void setContentType() {
		contentType.click();
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
	}

	public void setSiteHome() {
		siteHome.click();
	}

}
