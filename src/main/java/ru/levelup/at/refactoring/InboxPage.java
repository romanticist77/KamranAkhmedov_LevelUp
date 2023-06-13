package ru.levelup.at.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends MailBasePage {

    //        var incomingMessagesButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-folder-link-id='0']")));
    //
    //        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");
    //
    //        var writeLetterButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-title-shortcut='N']")));
    //        writeLetterButton.click();
    //
    //        var recipient = wait.until(
    //            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input--3slxg']//div//input")));
    //        recipient.sendKeys("test94.00@mail.ru");
    //        var subject = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //            By.xpath("//div[@class='subject__container--HWnat']//div//input")));
    //        subject.sendKeys(uuidAsString);
    //        var body = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //            By.xpath("//div[contains(@class, 'editable-container-')]/div[contains(@class, 'editable-')]")));
    //        body.sendKeys("Hello, this is a testing letter.");
    //
    //        var saveButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='save']")));
    //        saveButton.click();
    //
    //        var lookDraftsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
    //            "//span[@class='notify__Посмотреть']")));
    //        lookDraftsButton.click();

    //        var verifySubject = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString))));
    //        System.out.println(
    //            "Drafts. Target subject is found: " + verifySubject);
    //        verifySubject.click();
    //
    //        var sendButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='send']")));
    //        sendButton.click();
    //
    //        var closeModalWindowButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer__controls']/span")));
    //        closeModalWindowButton.click();
    //
    //        var verifyMessageSent =
    //            wait.until(ExpectedConditions.invisibilityOfElementLocated(
    //                By.xpath("//span[text()='%s']".formatted(uuidAsString))));
    //
    //        System.out.println("Drafts. Target subject is not found: " + verifyMessageSent);
    //
    //        var sentMessagesButton =
    //            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Отправленные']")));
    //        sentMessagesButton.click();
    //
    //        verifySubject = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //            By.xpath("//span[text()='Self: %s']".formatted(uuidAsString))));
    //
    //        System.out.println(
    //            "Sent. Target subject is found: " + verifySubject);
    //
    //        var profileButton = wait.until(
    //            ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'ph-avatar-img')]")));
    //        profileButton.click();
    //
    //        var exitButton = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Выйти']"))));
    //        exitButton.click();

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
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendButton;
    @FindBy(xpath = "//div[@class='layer__controls']/span")
    private WebElement closeModalWindowButton;
    @FindBy(xpath = "//span[text()='%s']")
    private WebElement verifyMessageSent;

    @FindBy(xpath = "//div[text()='Отправленные']")
    private WebElement sentMessagesButton;
    @FindBy(xpath = "//span[text()='Self: %s']")
    private WebElement verifySelfSubject;
    @FindBy(xpath = "//img[contains(@class,'ph-avatar-img')]")
    private WebElement profileButton;
    @FindBy(xpath = "//div[text()='Выйти']")
    private WebElement exitButton;

    public void clickIncomingMessagesButton() {
        wait.until(ExpectedConditions.visibilityOf(incomingMessagesButton)).click();
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
            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString))));
    }

    public boolean verifySubjectNotFound() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString))));
    }

    public WebElement verifySelfSubjectFound() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text()='Self: %s']".formatted(uuidAsString))));
    }

    public void clickOnSubject() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(),'%s')]".formatted(uuidAsString)))).click();
    }

    public void clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void clickCloseModalWindowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalWindowButton)).click();
    }
    // verifySubject sendButton closeModalWindowButton  verifyMessageSent sentMessagesButton verifySubject

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
