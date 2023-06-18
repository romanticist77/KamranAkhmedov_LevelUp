package ru.levelup.at.homework5;

import org.testng.annotations.Test;

public class EntryTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulEntryTest(String recipientData, String subjectId, String loremText) {

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
        verifySteps.verifySubject(subjectId);

        System.out.println(
            "Drafts. Target subject is found: " + verifySteps.subject);

        commonSteps.clickSubject(subjectId);
        writeLetterSteps.sendLetter();
        commonSteps.closeModalWindow();

        verifySteps.verifyNoSubject(subjectId);

        System.out.println("Drafts. Target subject is not found: " + verifySteps.noSubject);

        openFolderSteps.openSentMessages();
        verifySteps.verifySelfSubject(subjectId);

        System.out.println(
            "Sent. Target subject is found: " + verifySteps.subject);

        profileSteps.openProfileMenu();
        profileSteps.exit();
    }
}
