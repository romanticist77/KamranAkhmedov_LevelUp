package ru.levelup.at.homework5;

import org.testng.annotations.Test;

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

        commonSteps.openWebsite();
        commonSteps.clickSignInButton();
        commonSteps.switchToFrame();
        commonSteps.logIn();
        commonSteps.switchToDefault();
        commonSteps.assertSuccessfulEntry(commonSteps.getIncomingMessages());
        writeLetterSteps.writeLetter();
        writeLetterSteps.fillLetterFields(recipientData, subjectId, loremText);
        writeLetterSteps.saveLetter();
        openFolderSteps.lookDrafts();

        //        var verifySubjectFound = inboxPage.verifySubjectFound(subjectId);
        //
        //        System.out.println(
        //            "Drafts. Target subject is found: " + verifySubjectFound);
        //
        //        inboxPage.clickOnSubject(subjectId)
        //                 .clickSendButton()
        //                 .clickCloseModalWindowButton();
        //
        //        var verifySubjectNotFound = inboxPage.verifySubjectNotFound(subjectId);
        //
        //        System.out.println("Drafts. Target subject is not found: " + verifySubjectNotFound);
        //
        //        inboxPage.clickSentMessagesButton();
        //        verifySubjectFound = inboxPage.verifySelfSubjectFound(subjectId);
        //
        //        System.out.println(
        //            "Sent. Target subject is found: " + verifySubjectFound);
        //
        profileSteps.openProfileMenu();
        profileSteps.exit();
    }
}
