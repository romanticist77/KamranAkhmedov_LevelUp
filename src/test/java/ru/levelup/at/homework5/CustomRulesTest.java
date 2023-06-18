package ru.levelup.at.homework5;

import org.testng.annotations.Test;

public class CustomRulesTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulRoutingTest(String recipientData, String subjectId, String loremText) {

        commonSteps.openWebsite();
        commonSteps.clickSignInButton();
        commonSteps.switchToFrame();
        commonSteps.logIn();
        commonSteps.switchToDefault();
        commonSteps.assertSuccessfulEntry(commonSteps.getIncomingMessages());

        writeLetterSteps.sendCustomFilledLetter(recipientData, subjectId, loremText);
        commonSteps.closeModalWindow();
        openFolderSteps.openSentMessages();
        verifySteps.verifySelfTestSubject(subjectId);

        System.out.println("Sent. Target subject is found: " + verifySteps.subject);

        openFolderSteps.openTestMessages();
        verifySteps.verifyTestSubject(subjectId);
        verifySteps.subject.click();
        verifySteps.verifyRecipient(recipientData);
        verifySteps.verifyBody(loremText);

        System.out.println("Test. Target subject is found: " + verifySteps.subject);
        System.out.println("Test. Target recipient is found: " + verifySteps.recipient);
        System.out.println("Test. Target body is found: " + verifySteps.body);

        profileSteps.openProfileMenu();
        profileSteps.exit();
    }
}
