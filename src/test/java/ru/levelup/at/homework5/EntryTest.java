package ru.levelup.at.homework5;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelup.at.homework4.EntryPage;
import ru.levelup.at.homework4.FramePage;
import ru.levelup.at.homework4.InboxPage;

public class EntryTest extends SeleniumBaseTest {

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulEntryTest(String recipientData, String subjectId, String loremText) {

//        1. Войти в почту
//        2. Assert, что вход выполнен успешно
//        3. Создать новое письмо (заполнить адресата, тему письма и тело)
//        4. Сохранить его как черновик
//        5. Verify, что письмо сохранено в черновиках
//        6. Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
//        7. Отправить письмо
//        8. Verify, что письмо исчезло из черновиков
//        9. Verify, что письмо появилось в папке отправленные
//        10. Выйти из учётной записи

        var entryPage = new EntryPage(driver);
        entryPage.open();
        entryPage.clickSignInButton();
        var framePage = new FramePage(driver);
        var switchToFrame = framePage.switchToFrame();
        framePage.fillUsername();
        framePage.clickEnterPasswordButton();
        framePage.fillPassword();
        framePage.clickSignInButton();
        switchToFrame.switchTo().defaultContent();
        var inboxPage = new InboxPage(driver);
        var incomingMessagesButton = inboxPage.getIncomingMessagesButton();

        assertThat(incomingMessagesButton.getText()).as("Нет ожидаемой вкладки на странице").contains("Входящие");

        inboxPage.clickWriteLetterButton();
        inboxPage.fillRecipient(recipientData);
        inboxPage.fillSubject(subjectId);
        inboxPage.fillBody(loremText);
        inboxPage.clickSaveButton();
        inboxPage.clickLookDraftsButton();
        var verifySubjectFound = inboxPage.verifySubjectFound(subjectId);

        System.out.println(
            "Drafts. Target subject is found: " + verifySubjectFound);

        inboxPage.clickOnSubject(subjectId);
        inboxPage.clickSendButton();
        inboxPage.clickCloseModalWindowButton();
        var verifySubjectNotFound = inboxPage.verifySubjectNotFound(subjectId);

        System.out.println("Drafts. Target subject is not found: " + verifySubjectNotFound);

        inboxPage.clickSentMessagesButton();
        verifySubjectFound = inboxPage.verifySelfSubjectFound(subjectId);

        System.out.println(
            "Sent. Target subject is found: " + verifySubjectFound);

        inboxPage.clickProfileButton();
        inboxPage.clickExitButton();
    }
}
