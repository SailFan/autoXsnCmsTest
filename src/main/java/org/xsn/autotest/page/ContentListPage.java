package org.xsn.autotest.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xsn.autotest.common.PublicMethod;

/**
 * 
 * 内容列表页面
 * 
 * @author ikan
 *
 */
public class ContentListPage extends PublicMethod{
	
	
	public ContentListPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	By searchArtcleName = By.cssSelector("input[placeholder=\"文章名称\"]");
	By searchArtcleId = By.cssSelector("input[placeholder=\"文章id\"]");
	By queryButton = By.cssSelector("button.el-button--primary:nth-child(1)");
	By resetButton = By.cssSelector("button.el-button--default:nth-child(2)");
	By addArtcleButton = By.cssSelector(".con_btn_wrap > a:nth-child(1) > button:nth-child(1)");
	By deleteArtcleButton = By.cssSelector("button.el-button--danger:nth-child(2)");
	By selectzdClassify = By.cssSelector(
			"div.el-form-item:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
	By selectContentClassify = By.cssSelector(
			"div.el-form-item:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");

	By startTime = By.cssSelector("input[placeholder=\"开始日期\"]");
	By endTime = By.cssSelector("input[placeholder=\"结束日期\"]");

	// 审批状态
	By examineArtcleStatus = By.cssSelector(
			"div.el-form-item:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
	// 文章状态
	By type = By.cssSelector("input[placeholder=\"请选择文章状态\"]");
	By contentSources = By.cssSelector(
			"#app > section > section > main > section > div > div.el-row.el-row--flex > form > div:nth-child(9) > div > div > div.el-input.el-input--suffix > input");

	// 快速检索模块输入文章名字
	public void setSearchArtcleName(String keysToSend) {
		new WebDriverWait(super.webDriver, 10)
				.until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.searchArtcleName)));
		super.webDriver.findElement(this.searchArtcleName).sendKeys(keysToSend);
	}

	// 快速检索模块输入文章Id
	public void setsearchArtcleId(String keysToSend) {
		new WebDriverWait(super.webDriver, 10).until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.searchArtcleId)));
		super.webDriver.findElement(this.searchArtcleId).sendKeys(keysToSend);
	}

	// 快速检索点击搜索
	public void clickQueryButton() {
		new WebDriverWait(super.webDriver, 10).until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.queryButton)));
		super.webDriver.findElement(this.queryButton).click();
	}

	// 快速检索模点击重置按键
	public void clickResetButton() {
		new WebDriverWait(super.webDriver, 10).until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.resetButton)));
		super.webDriver.findElement(this.resetButton).click();
	}

	// 点击增加文章按键
	public void clickAddArtcle() {
		new WebDriverWait(super.webDriver, 10)
				.until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.addArtcleButton)));
		super.webDriver.findElement(this.addArtcleButton).click();
	}

	// 快速减速模块点击删除按键

	public void clickDeleteArtcle() {
		new WebDriverWait(super.webDriver, 10)
				.until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.deleteArtcleButton)));
		super.webDriver.findElement(this.deleteArtcleButton).click();
	}

	// 选择站点分类
	public void getZDClassify() {
		new WebDriverWait(super.webDriver, 10)
				.until(ExpectedConditions.visibilityOf(super.webDriver.findElement(this.selectzdClassify)));
		List<WebElement> list = super.webDriver.findElements(this.selectzdClassify);

	}

}
