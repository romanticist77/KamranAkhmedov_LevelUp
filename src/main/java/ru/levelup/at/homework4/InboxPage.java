package ru.levelup.at.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public InboxPage clickTrashBinButton() {
        wait.until(ExpectedConditions.visibilityOf(
            trashBinButton)).click();
        return this;
    }

    public InboxPage clickRemoveButton() {
        wait.until(ExpectedConditions.visibilityOf(
            removeButton)).click();
        return this;
    }

    public InboxPage clickToYourselfButton() {
        wait.until(ExpectedConditions.visibilityOf(
            toYourselfButton)).click();
        return this;
    }

    public InboxPage clickTestMessagesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(testButton)).click();
        return this;
    }

    public WebElement getIncomingMessagesButton() {
        return wait.until(ExpectedConditions.visibilityOf(incomingMessagesButton));
    }

    public InboxPage clickWriteLetterButton() {
        wait.until(ExpectedConditions.visibilityOf(writeLetterButton)).click();
        return this;
    }

    public InboxPage fillRecipient(String recipientData) {
        wait.until(ExpectedConditions.visibilityOf(recipient)).sendKeys(recipientData);
        return this;
    }

    public InboxPage fillSubject(String subjectId) {
        wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(subjectId);
        return this;
    }

    public InboxPage fillTestSubject(String subjectId) {
        wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys("Test: " + subjectId);
        return this;
    }

    public InboxPage fillBody(String loremText) {
        wait.until(ExpectedConditions.visibilityOf(body)).sendKeys(loremText);
        return this;
    }

    public InboxPage clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }

    public InboxPage clickLookDraftsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(lookDraftsButton)).click();
        return this;
    }

    public WebElement verifySubjectFound(String subjectId) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='%s']".formatted(subjectId))));
    }

    public boolean verifySubjectNotFound(String subjectId) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//span[contains(text(),'%s')]".formatted(subjectId))));
    }

    public WebElement verifySelfSubjectFound(String subjectId) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: %s']".formatted(subjectId))));
    }

    public WebElement verifyTestSubjectFound(String subjectId) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Test: %s']".formatted(subjectId))));
    }

    public WebElement verifySelfTestSubjectFound(String subjectId) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: Test: %s']".formatted(subjectId))));
    }

    public WebElement verifyRecipientFound(String recipientData) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(@title,'%s')]".formatted(recipientData))));
    }

    public WebElement verifyBodyFound(String loremText) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='%s']".formatted(loremText))));
    }

    public InboxPage clickOnSubject(String subjectId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='%s']".formatted(subjectId)))).click();
        return this;
    }

    public InboxPage clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
        return this;
    }

    public InboxPage clickCloseModalWindowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalWindowButton)).click();
        return this;
    }

    public InboxPage clickSentMessagesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sentMessagesButton)).click();
        return this;
    }

    public InboxPage clickProfileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
        return this;
    }

    public InboxPage clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
        return this;
    }

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public InboxPage open() {
        driver.navigate().to("/");
        return this;
    }
}
