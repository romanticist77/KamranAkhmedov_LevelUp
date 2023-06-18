package ru.levelup.at.homework5;

import org.testng.annotations.Test;

public class IncomingToTrashBinTest extends SeleniumBaseTest {

    @Test(dataProvider = "Email data provider", dataProviderClass = BaseDataProvider.class)
    public void successfulRoutingTest(String recipientData, String subjectId, String loremText) {

        commonSteps.openWebsite();
        commonSteps.clickSignInButton();
        commonSteps.switchToFrame();
        commonSteps.logIn();
        commonSteps.switchToDefault();
        commonSteps.assertSuccessfulEntry(commonSteps.getIncomingMessages());

        writeLetterSteps.sendFilledLetter(recipientData, subjectId, loremText);

        commonSteps.closeModalWindow();
        openFolderSteps.openToYourselfMessages();

        verifySteps.verifySubject(subjectId);
        verifySteps.subject.click();

        System.out.println("Incoming. Target subject is found: " + verifySteps.subject);

        verifySteps.verifyRecipient(recipientData);
        verifySteps.verifyBody(loremText);

        System.out.println("Incoming. Target recipient is found: " + verifySteps.recipient);
        System.out.println("Incoming. Target body is found: " + verifySteps.body);

        commonSteps.removeLetter();
        openFolderSteps.openTrashBin();
        verifySteps.verifySubject(subjectId);

        System.out.println("Trash bin. Target body is found: " + verifySteps.subject);

        profileSteps.openProfileMenu();
        profileSteps.exit();
    }
}
