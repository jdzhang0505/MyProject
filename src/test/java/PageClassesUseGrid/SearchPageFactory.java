package PageClassesUseGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(id="hotel-destination-hp-hotel")
	WebElement  DestinationTextbox;
	
	@FindBy(id="hotel-checkin-hp-hotel")
	WebElement CheckinDateTextbox ;
	
	@FindBy(id="hotel-checkout-hp-hotel")
	WebElement CheckoutDateTextbox ;
	
	@FindBy(xpath="//div[@id='traveler-selector-hp-hotel']//button[starts-with(@class,'trigger-utility')]")
	WebElement HotalGuestTextbox;
	
	//���ٳ�������ť
	@FindBy(xpath="//div[@class='room-data-title']//following-sibling::div[1]//button[@class='uitk-step-input-button uitk-step-input-minus']")
	WebElement AdultsMinusButton;
	
	//���ӳ�������ť
	@FindBy(xpath="//div[@class='room-data-title']//following-sibling::div[1]//button[@class='uitk-step-input-button uitk-step-input-plus']")
	WebElement AdultsPlusButton;
	
	//�Ѿ���ʾ�ĳ�����
	@FindBy(xpath="//div[@class='room-data-title']//following-sibling::div[1]//span[@class='uitk-step-input-value']")
	WebElement ExistAdultsTotal;
	
	//�ÿ�������Ĺرհ�ť
	@FindBy(xpath="//button[@class='close btn-text']")
	WebElement AdultDropdownCloseButton;
	
	@FindBy(xpath="//button/span[contains(text(),'����')]//parent::button")
	WebElement SearchButton ;
	
	
	
	
	/*
	 * public SearchPageFactory(WebDriver driver) { this.driver=driver;
	 * PageFactory.initElements(driver, this); }
	 */
	 
	 
	
	public void setDestination(String destination) {
		DestinationTextbox.sendKeys(destination);
	}
	
	public void setCheckinDate(String checkinDate) {
		CheckinDateTextbox.clear();
		CheckinDateTextbox.sendKeys(checkinDate);
	}
	
	public void setCheckoutDate(String checkoutDate) {
		CheckoutDateTextbox.clear();
		CheckoutDateTextbox.sendKeys(checkoutDate);
	}
	
	
	public void clickHotelGuestTextbox() {
		HotalGuestTextbox.click();;
	}
	
	// �ж�Ҫ����ĳ������Ƿ�������ʾ����ֵ
	public void setAdultsTotal(int input) {
		
		int ExistAdults=Integer.parseInt(ExistAdultsTotal.getText());
		
		
		if(ExistAdults>input) {
			for(int i=0;i<ExistAdults-input;i++) {
				clickAdultMinusButton();
			}
			
		}
		else if(ExistAdults<input) {
			for(int i=0;i<input-ExistAdults;i++) {
				clickAdultPlusButton();
			}
		
		}
		closeAdultDropdown();
	} 
	


    public void clickAdultMinusButton() {
    	AdultsMinusButton.click();
    }
	
    public void clickAdultPlusButton() {
    	AdultsPlusButton.click();
    }
    
    public void closeAdultDropdown() {
    	AdultDropdownCloseButton.click();
    }
    
	public void clickSearchButton() {
		SearchButton.click();
	}

}
