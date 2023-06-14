package ru.levelup.at.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;

public class InboxPage extends MailBasePage {

    @FindBy(xpath = "//a[@data-folder-link-id='0']")
    private WebElement incomingMessagesButton;
    @FindBy(xpath = "//a[@data-title-shortcut='N']")
    private WebElement writeLetterButton;
    @FindBy(xpath = "//div[@class='input--3slxg']//div//input")
    private WebElement recipient;
    @FindBy(xpath = "//div[@class='subject__container--HWnat']//div//input")
    private WebElement subject;
    @FindBy(xpath = "//div[contains(@class, 'editable-container-')]/div[contains(@class, 'editable-')]")
    private WebElement body;
    @FindBy(xpath = "//button[@data-test-id='save']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[@class='notify__Посмотреть']")
    private WebElement lookDraftsButton;
    @FindBy(xpath = "ll-sj__normal")
    private WebElement verifySubject;
    @FindBy(xpath = "//span[contains(@title,'test94.00@mail.ru')]")
    private WebElement filledRecipient;
    @FindBy(xpath = "//div[text()='Hello, this is a testing letter.']")
    private WebElement filledBody;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendButton;
    @FindBy(xpath = "//div[@class='layer__controls']/span")
    private WebElement closeModalWindowButton;
    @FindBy(xpath = "//div[text()='Отправленные']")
    private WebElement sentMessagesButton;
    @FindBy(xpath = "//img[contains(@class,'ph-avatar-img')]")
    private WebElement profileButton;
    @FindBy(xpath = "//div[text()='Выйти']")
    private WebElement exitButton;
    @FindBy(xpath = "//div[text()= 'Тест']/parent::div/parent::div")
    private WebElement testButton;
    @FindBy(xpath = "//span[text()='Письма себе']")
    private WebElement toYourselfButton;
    @FindBy(xpath = "//div[text()='Удалить']/parent::span")
    private WebElement removeButton;
    @FindBy(xpath = "//div[text()='Корзина']")
    private WebElement trashBinButton;

    public void clickTrashBinButton() {
        wait.until(ExpectedConditions.visibilityOf(
            trashBinButton)).click();
    }

    public void clickRemoveButton() {
        wait.until(ExpectedConditions.visibilityOf(
            removeButton)).click();
    }

    public void clickToYourselfButton() {
        wait.until(ExpectedConditions.visibilityOf(
            toYourselfButton)).click();
    }

    public void clickTestMessagesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(testButton)).click();
    }

    public WebElement getIncomingMessagesButton() {
        return wait.until(ExpectedConditions.visibilityOf(incomingMessagesButton));
    }

    public void clickWriteLetterButton() {
        wait.until(ExpectedConditions.visibilityOf(writeLetterButton)).click();
    }

    public void fillRecipient() {
        wait.until(ExpectedConditions.visibilityOf(recipient)).sendKeys("test94.00@mail.ru");
    }

    public void fillSubject() {
        wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(uuidAsString);
    }

    public void fillTestSubject() {
        wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys("Test: " + uuidAsString);
    }

    public void fillBody() {
        wait.until(ExpectedConditions.visibilityOf(body)).sendKeys("Hello, this is a testing letter.");
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void clickLookDraftsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(lookDraftsButton)).click();
    }

    public WebElement verifySubjectFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='%s']".formatted(uuidAsString))));
    }

    public boolean verifySubjectNotFound() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString))));
    }

    public WebElement verifySelfSubjectFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: %s']".formatted(uuidAsString))));
    }

    public WebElement verifyTestSubjectFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Test: %s']".formatted(uuidAsString))));
    }

    public WebElement verifySelfTestSubjectFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: Test: %s']".formatted(uuidAsString))));
    }

    public WebElement verifyRecipientFound() {
        return wait.until(ExpectedConditions.elementToBeClickable(filledRecipient));
    }

    public WebElement verifyBodyFound() {
        return wait.until(ExpectedConditions.elementToBeClickable(filledBody));
    }

    public void clickOnSubject() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='%s']".formatted(uuidAsString)))).click();
    }

    public void clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void clickCloseModalWindowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalWindowButton)).click();
    }

    public void clickSentMessagesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sentMessagesButton)).click();
    }

    public void clickProfileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
    }

    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
    }

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.navigate().to("/");
    }
}
