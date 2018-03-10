package com.portal.toolbox.framework;

import com.portal.toolbox.Util.RandomGenerator;
import com.portal.toolbox.pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class toolboxUtil extends AbstractPage {
    private YourDetailsPage YourDetailsPage = new YourDetailsPage();
    private LoginPage loginPage = new LoginPage();
    private StartNewApplicationPage startNewApplication = new StartNewApplicationPage();
    private GetStartedPage getStartedPage = new GetStartedPage();
    private BusinessContactPage businessContactPage = new BusinessContactPage();
    private YourBusinessPage yourBusinessPage = new YourBusinessPage();
    private YourTeamPage yourTeamPage = new YourTeamPage();
    private ManageAccountPage manageAccountPage = new ManageAccountPage();

//    public void fillYourdetails()
//    {
//        YourDetailsPage.waitForPageLoad();
//        YourDetailsPage.carRegistrationNumberTextField().sendKeys("ABC123");
//        YourDetailsPage.findCarButton().click();
//        new Select( YourDetailsPage.mileageDropdown()).selectByValue("17000");
//        YourDetailsPage.carValueTextbox().sendKeys("5000");
//        new Select(YourDetailsPage.vehiclePurchaseDatemonthDropdown()).selectByValue("03");
//        new Select(YourDetailsPage.vehiclePurchaseDateyearDropdown()).selectByValue("2011");
//        new Select(YourDetailsPage.coverDateDayDropdown()).selectByValue("01");
//        new Select(YourDetailsPage.coverDateMonthDropdown()).selectByValue("03");
//        new Select(YourDetailsPage.coverDateYearDropdown()).selectByValue("2018");
//        YourDetailsPage.aboutYouNextButton().click();
//        System.out.println("URL : "+ getDriver.getCurrentUrl());
//    }

    public void login(String credencial) {
        loginPage.emailTextFiled().sendKeys(credencial.split(",")[0]);
        loginPage.passwordTextFiled().sendKeys(credencial.split(",")[1]);
        loginPage.loginButton().click();

    }

    public void startNewApplication(String personalDetails, String organizationDetail, String businessDetails, String businessfinancials, String teamDetals, String manageAccounts) {
        waitForPageLoad();
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        startNewApplication.startnewapplicationButton().click();
        startNewApplication.agreementCheckbox().click();
        startNewApplication.letStartButton().click();
        getStarted(personalDetails, organizationDetail);
        businessContact(businessDetails);
        businessfinancials(businessfinancials);
        enterAboutYou(personalDetails, teamDetals);
        manageaccounts(manageAccounts);
    }

    public void startNewApplicationnew(String personalDetails, String organizationDetail, String organisationContactDetails, String businessOrganisationFinancials,String businessOrganisationPayments,String yourOrganisationAccount,String teamDetals, String manageAccounts) {
        waitForPageLoad();
        waitForMoreTime();
        startNewApplication.startnewapplicationButton().click();
        startNewApplication.agreementCheckbox().click();
        startNewApplication.letStartButton().click();
        getStartednew(personalDetails, organizationDetail);
        getOrganisationContactDetails(organisationContactDetails);
        getbusinessfinancialsNew(businessOrganisationFinancials);
        getbusinessOrganisationPayments(businessOrganisationPayments);
        getYourOrganisationAccount(yourOrganisationAccount);
        enterAboutYou(personalDetails, teamDetals);
        manageaccounts(manageAccounts);
    }

    public void getStarted(String personalDetails, String organizationDetail) {

        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();

        new Select(getStartedPage.selectTitle()).selectByVisibleText(personalDetails.split(",")[0]);
        getStartedPage.firstnameTextfield().sendKeys(personalDetails.split(",")[1]);
        getStartedPage.lastnamenameTextfield().sendKeys(personalDetails.split(",")[2]);
        getStartedPage.ukbasedRadioYes().click();
        new Select(getStartedPage.businessTypeSelect()).selectByVisibleText(organizationDetail.split(",")[1]);
        getStartedPage.nextButton().click();

    }

    public void getStartednew(String personalDetails, String organizationDetail) {

        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();

        new Select(getStartedPage.selectTitle()).selectByVisibleText(personalDetails.split(",")[0]);
        getStartedPage.firstnameTextfield().sendKeys(personalDetails.split(",")[1]);
        getStartedPage.lastnamenameTextfield().sendKeys(personalDetails.split(",")[2]);
        getStartedPage.ukbasedRadioYes().click();
        new Select(getStartedPage.businessTypeSelect()).selectByVisibleText(organizationDetail.split(",")[0]);
        if ((organizationDetail.split(",")[1]).equals("Yes ")) {
            getStartedPage.areYouCharityRadioYes().click();
            if ((organizationDetail.split(",")[1]).equals("Yes")) {
                getStartedPage.areYouCharityRegisteredRadioYes().click();
                getStartedPage.yourCharityRegisteredNumberField().sendKeys(organizationDetail.split(",")[3]);
            } else if ((organizationDetail.split(",")[2]).equals("No")) {
                getStartedPage.areYouCharityRegisteredRadioNo().click();
                getStartedPage.nextButton().click();
            }
        }
        else if((organizationDetail.split(",")[1]).equals("No"))
            {
            getStartedPage.areYouCharityRadioNo().click();
        }
        getStartedPage.nextButton().click();

    }

    public void getOrganisationContactDetails(String organisationContactDetails) {
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
        getStartedPage.yourOrganisationCalledField().sendKeys(organisationContactDetails.split(",")[0]);
        if ((organisationContactDetails.split(",")[1]).equals("Yes")) {
            getStartedPage.yourOrganisationHaveAnyOtherTradingNamesOrAliasesYes().click();
            getStartedPage.otherNamesDoesYourOrganisationUseField().sendKeys(organisationContactDetails.split(",")[3]);
        } else  {
            getStartedPage.yourOrganisationHaveAnyOtherTradingNamesOrAliasesNo().click();
        }getStartedPage.tradingBuildingNameandNumber().sendKeys(organisationContactDetails.split(",")[4]);
        getStartedPage.tradingPostcode().sendKeys(organisationContactDetails.split(",")[5]);
        getStartedPage.findAdrressClick().click();
        if ((organisationContactDetails.split(",")[2]).equals("No")) {
            getStartedPage.radioCorrespondenceAddressNo().click();
            getStartedPage.enterBuildingNumberForCorrespondenceAddressField().sendKeys(organisationContactDetails.split(",")[4]);
            getStartedPage.enterPostCodeForCorrespondenceAddressField().sendKeys(organisationContactDetails.split(",")[5]);
            getStartedPage.findCorrespondenceAdrressClick().click();
        } else if ((organisationContactDetails.split(",")[1]).equals("Yes")) {
            getStartedPage.radioCorrespondenceAddressYes().click();
        }
        getStartedPage.nextButton().click();
    }

    public void businessContact(String businessDetails) {
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        businessContactPage.businessCalledTextbox().sendKeys(businessDetails.split(",")[0]);
//        System.out.println(businessDetails.split(",")[1]);
        if ((businessDetails.split(",")[1]).equals("Yes")) {
            businessContactPage.radioHasothertradingnameYes().click();
        } else if ((businessDetails.split(",")[1]).equals("No")) {
            businessContactPage.radioHasothertradingnameNo().click();
        }
        businessContactPage.buildingNameandNumber().sendKeys(businessDetails.split(",")[2]);
        businessContactPage.postCode().sendKeys(businessDetails.split(",")[3]);
        businessContactPage.findAddressButton().click();
        businessContactPage.radioCorrespondenceaddressSameasTradeYes().click();
        businessContactPage.nextButon().click();
    }

    public void businessfinancials(String businessfinancials) {
        int businessValue = Integer.parseInt(businessfinancials.split(",")[0]);
        setBusinessValue(businessValue);
        new Select(yourBusinessPage.selectStartTradingMonth()).selectByVisibleText(businessfinancials.split(",")[1]);
        new Select(yourBusinessPage.selectStartTradingYear()).selectByVisibleText(businessfinancials.split(",")[2]);
        new Select(yourBusinessPage.selectMonthAtFinancialYearEnds()).selectByVisibleText(businessfinancials.split(",")[3]);
        yourBusinessPage.totalNumberOfEmployees().sendKeys(businessfinancials.split(",")[4]);
        yourBusinessPage.sicDescription().sendKeys(businessfinancials.split(",")[5]);
        waitForPageLoad();
        yourBusinessPage.sicOption().click();
        yourBusinessPage.describeHowYouDoAndOperate().sendKeys(RandomGenerator.randomString(120));
        yourBusinessPage.radioBusinessNotFacingLegalProceedings().click();
        yourBusinessPage.nextButton().click();
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
//        Type of payment
        if ((businessfinancials.split(",")[6]).equals("AllTransferNoCash")) {
            waitForPageLoad();
            waitForMoreTime();
            waitForMoreTime();
            yourBusinessPage.checkBoxTransfersFromUKBanks().click();
            yourBusinessPage.checkBoxCheques().click();
            yourBusinessPage.checkBoxCardPayments().click();
            yourBusinessPage.checkBoxDirectDebitAndStandingOrders().click();
        }

//        else if() { }
        yourBusinessPage.radioBusinessIsNotSeasonal().click();
        yourBusinessPage.radioBusinessDoesNotSendOrReceiveInternationalPayments().click();
        new Select(yourBusinessPage.selectCountryBusinessOwnsAssets()).selectByVisibleText(businessfinancials.split(",")[10]);
        yourBusinessPage.radioBusinessIsNotRegisteredToPayTaxOutsideUK().click();
        yourBusinessPage.nextButton().click();

        waitForPageLoad();
        if ((businessfinancials.split(",")[12]).equals("existingbusrelationshipNo")) {
            yourBusinessPage.radioHasNoExistingRelationshipWithNatwest().click();
        }
        if ((businessfinancials.split(",")[13]).equals("SwitchYourBusinessAccountToUsNo")) {
            yourBusinessPage.radioSwitchYourBusinessAccountToUsNo().click();
        }
        if ((businessfinancials.split(",")[14]).equals("MoneyComingInNo")) {
            yourBusinessPage.radioIsMoneyComingInNo().click();
        }
        yourBusinessPage.nextButton().click();
    }

    public void getbusinessfinancialsNew(String businessOrganisationFinancials) {
        int businessValue = Integer.parseInt(businessOrganisationFinancials.split(",")[0]);
        setBusinessValue(businessValue);
        new Select(yourBusinessPage.selectStartTradingMonth()).selectByVisibleText(businessOrganisationFinancials.split(",")[1]);
        new Select(yourBusinessPage.selectStartTradingYear()).selectByVisibleText(businessOrganisationFinancials.split(",")[2]);
        yourBusinessPage.totalNumberOfEmployees().sendKeys(businessOrganisationFinancials.split(",")[3]);
        yourBusinessPage.describeHowYouDoAndOperate().sendKeys(RandomGenerator.randomString(120));
        yourBusinessPage.beneficiariesOfYourOrganisation().sendKeys(businessOrganisationFinancials.split(",")[4]);
        yourBusinessPage.businessWebsiteUrl().sendKeys(businessOrganisationFinancials.split(",")[5]);
        if ((businessOrganisationFinancials.split(",")[6]).equals("Yes")) {
            yourBusinessPage.radioBusinessFacingLegalProceedings().click();
            yourBusinessPage.detailsOfTheArrearsOrLegalProceedings().sendKeys(businessOrganisationFinancials.split(",")[8]);
        } else {
            yourBusinessPage.radioBusinessNotFacingLegalProceedings().click();
        }
        yourBusinessPage.nextButton().click();
        waitForPageLoad();
        waitForMoreTime();
    }

    public void getbusinessOrganisationPayments(String businessOrganisationPayments) {
        waitForPageLoad();
        waitForPageLoad();
        waitForPageLoad();
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        waitForMoreTime();
        //(businessOrganisationPayments.split(",")[0]).equals("Transfers from UK banks")
            yourBusinessPage.checkBoxTransfersFromUKBanks().click();
            yourBusinessPage.checkBoxCheques().click();
            yourBusinessPage.checkBoxCardPayments().click();
            yourBusinessPage.checkBoxDirectDebitAndStandingOrders().click();
            yourBusinessPage.checkBoxCashPayout().click();
            yourBusinessPage.enterPercentageOfAllTransactionsGoingOutOfYourNewAccountWillBeCashPaymentsField().sendKeys(businessOrganisationPayments.split(",")[0]);
            yourBusinessPage.checkBoxCashPaidIn().click();
            new Select (yourBusinessPage.selectPercentageOfCash()).selectByIndex(7);
            yourBusinessPage.incomeStreamForBusiness().sendKeys(RandomGenerator.randomString(120));
            new Select (yourBusinessPage.selectDailyPecentageOfCashPayments()).selectByIndex(3);
            new Select (yourBusinessPage.selectHowOftenYouDepositCashIntoThisAccount()).selectByIndex(6);

        if ((businessOrganisationPayments.split(",")[4]).equals("Yes")) {
            yourBusinessPage.radioBusinessIsSeasonal().click();
            yourBusinessPage.whenOrganisationIsBusyOrQuietTimesOfTheYearField().sendKeys(businessOrganisationPayments.split(",")[6]);
        } else {
            yourBusinessPage.radioBusinessIsNotSeasonal().click();
        }

        if ((businessOrganisationPayments.split(",")[4]).equals("Yes")) {
            yourBusinessPage.radioBusinessSendsOrReceiveInternationalPayments().click();
            yourBusinessPage.checkboxSendPaymentOverseas().click();
            new Select(yourBusinessPage.selectLocationToSendPaymentsFromOverseas()).selectByVisibleText(businessOrganisationPayments.split(",")[7]);
            yourBusinessPage.enterPercentageOfTotalPaymentsSendFromthisField().sendKeys(businessOrganisationPayments.split(",")[8]);
            new Select(yourBusinessPage.selectNatureAndPurposeOfPaymentsSend()).selectByVisibleText(businessOrganisationPayments.split(",")[9]);
            //yourBusinessPage.enterTheNatureAndPurposeofYourOtherPaymentsMadeForPaymentsSendFromOverseasField().sendKeys(businessOrganisationPayments.split(",")[10]);
            yourBusinessPage.checkboxRecievePaymentFromOverseas().click();
            new Select(yourBusinessPage.selectLocationToRecievePaymentsFromOverseas()).selectByVisibleText(businessOrganisationPayments.split(",")[11]);
            yourBusinessPage.enterPercentageOfTotalPaymentsRecievedFromthisField().sendKeys(businessOrganisationPayments.split(",")[12]);
            //yourBusinessPage.enterPercentageOfTotalPaymentsRecievedFromthisField().sendKeys("55");
            new Select (yourBusinessPage.selectNatureAndPurposeOfPaymentsRecieved()).selectByVisibleText(businessOrganisationPayments.split(",")[13]);
            //yourBusinessPage.enterTheNatureAndPurposeofYourOtherPaymentsMadeForPaymentsRecieveFromOverseasField().sendKeys(businessOrganisationPayments.split(",")[14]);
            yourBusinessPage.checkboxOnwersBasedOutOfUK().click();
            new Select(yourBusinessPage.selectLocationForOnwersBasedOutOfUK()).selectByVisibleText(businessOrganisationPayments.split(",")[15]);
            new Select(yourBusinessPage.selectCountryBusinessOwnsAssets()).selectByVisibleText(businessOrganisationPayments.split(",")[16]);

        } else {
            yourBusinessPage.radioBusinessDoesNotSendOrReceiveInternationalPayments().click();
            new Select(yourBusinessPage.selectCountryBusinessOwnsAssets()).selectByVisibleText(businessOrganisationPayments.split(",")[17]);
        }

        if ((businessOrganisationPayments.split(",")[4]).equals("Yes")) {
            yourBusinessPage.radioBusinessIsRegisteredToPayTaxOutsideUK().click();
            //new Select(yourBusinessPage.selectOtherCountryResidentToPayTax()).selectByVisibleText(businessOrganisationPayments.split(",")[18]);
            new Select(yourBusinessPage.selectOtherCountryResidentToPayTax()).selectByIndex(6);
            //yourBusinessPage.enterYourTaxIdentificationNumber().sendKeys(businessOrganisationPayments.split(",")[19]);
            yourBusinessPage.enterYourTaxIdentificationNumber().sendKeys("12345");
            yourBusinessPage.nextButton().click();
        }
        else {
            yourBusinessPage.radioBusinessIsNotRegisteredToPayTaxOutsideUK().click();
            yourBusinessPage.nextButton().click();
        }

    }


    public void getYourOrganisationAccount( String yourOrganisationAccount) {
        waitForPageLoad();
        waitForMoreTime();
        waitForMoreTime();
        /*     Existing Banking Relationships starts here*/
        if ((yourOrganisationAccount.split(",")[0]).equals("Yes")) {
            yourBusinessPage.radioHasExistingRelationshipWithNatwest().click();
            yourBusinessPage.enterYourMainOrganisationCurrentAccountDetails().sendKeys(yourOrganisationAccount.split(",")[2]);
            yourBusinessPage.enterSortCodePart1().sendKeys(yourOrganisationAccount.split(",")[3]);
            yourBusinessPage.enterSortCodePart2().sendKeys(yourOrganisationAccount.split(",")[4]);
            yourBusinessPage.enterSortCodePart3().sendKeys(yourOrganisationAccount.split(",")[5]);
        } else {
            yourBusinessPage.radioHasNoExistingRelationshipWithNatwest().click();
        }

        /* Switch Business Account from other Bank in UK Start here */

        if ((yourOrganisationAccount.split(",")[0]).equals("Yes")) {
            yourBusinessPage.radioSwitchYourBusinessAccountToUsYes().click();
            new Select(yourBusinessPage.selectFinancialInstitutionAreYouSwitchingFrom()).selectByVisibleText(yourOrganisationAccount.split(",")[6]);
            new Select(yourBusinessPage.selectSwitchingBank()).selectByVisibleText(yourOrganisationAccount.split(",")[7]);
            yourBusinessPage.enterTotalAmountOfBorrowingYouHaveInCurrentBank().sendKeys(yourOrganisationAccount.split(",")[8]);
            if ((yourOrganisationAccount.split(",")[1]).equals("No")) {
                yourBusinessPage.radioBorrowingAgainstAnySecurityWithYourCurrentBankNo().click();
                yourBusinessPage.radioYouLikeUsToDoTheSwitchingForYouYes().click();
                if ((yourOrganisationAccount.split(",")[9]).equals("Full Switch Service")) {
                    yourBusinessPage.radioFullSwitchService().click();
                }
                else {
                    yourBusinessPage.radioPartialSwitchService().click();
                }
            }
            else{
                yourBusinessPage.radioBorrowingAgainstAnySecurityWithYourCurrentBankYes().click();
                yourBusinessPage.radioYouLikeUsToDoTheSwitchingForYouNo().click();
            }
        }
        else
            {
            yourBusinessPage.radioSwitchYourBusinessAccountToUsNo().click();
        }
        if ((yourOrganisationAccount.split(",")[0]).equals("Yes")) {
            yourBusinessPage.radioIsMoneyComingInYes().click();
            yourBusinessPage.enterWhoWillMakePaymentsToYourAccountField().sendKeys(yourOrganisationAccount.split(",")[10]);
            yourBusinessPage.cashCheckBox().click();
            yourBusinessPage.enterTotalAmountOfCashThatWillBePaidInField().sendKeys(yourOrganisationAccount.split(",")[11]);
            yourBusinessPage.transferFromUKBankCheckBox().click();
            yourBusinessPage.enterAmountTransferedUKField().sendKeys(yourOrganisationAccount.split(",")[12]);
            yourBusinessPage.transferFromNonUKBankCheckBox().click();
            yourBusinessPage.enterAmountTransferedNonUkField().sendKeys(yourOrganisationAccount.split(",")[13]);
            yourBusinessPage.enterNameOfTheBankNameTheTransferMadeFromField().sendKeys(yourOrganisationAccount.split(",")[14]);
            new Select(yourBusinessPage.selectCountryBankBasedIn()).selectByVisibleText(yourOrganisationAccount.split(",")[15]);
            yourBusinessPage.enterNameOfThePersonMakingTransferField().sendKeys(yourOrganisationAccount.split(",")[16]);
            if((yourOrganisationAccount.split(",")[0]).equals("Yes")){
                yourBusinessPage.radioPersonAssociatedWithYourAccountYes().click();
                yourBusinessPage.enterReasonforNonUKBankTransferField().sendKeys(RandomGenerator.randomString(120));
                new Select(yourBusinessPage.selectFromWhereWillThisCashComeFrom()).selectByVisibleText(yourOrganisationAccount.split(",")[17]);
                yourBusinessPage.enterPleaseProvideMoreDetailsField().sendKeys(RandomGenerator.randomString(120));
                new Select(yourBusinessPage.selectBankOrBuildingSocietyWillTransferMadeFrom()).selectByVisibleText(yourOrganisationAccount.split(",")[18]);
                yourBusinessPage.enternameAccountOrAccountHolderWillBeSendingMoneyField().sendKeys(yourOrganisationAccount.split(",")[19]);
                yourBusinessPage.nextButton().click();
            }

            else{
                yourBusinessPage.radioPersonAssociatedWithYourAccountNo().click();
                yourBusinessPage.enterRelationshipBetweenPersonAndOrganisationField().sendKeys(RandomGenerator.randomString(120));
                yourBusinessPage.enterReasonforNonUKBankTransferField().sendKeys(RandomGenerator.randomString(120));
                new Select(yourBusinessPage.selectFromWhereWillThisCashComeFrom()).selectByVisibleText(yourOrganisationAccount.split(",")[17]);
                yourBusinessPage.enterPleaseProvideMoreDetailsField().sendKeys(RandomGenerator.randomString(120));
                new Select(yourBusinessPage.selectBankOrBuildingSocietyWillTransferMadeFrom()).selectByVisibleText(yourOrganisationAccount.split(",")[18]);
                yourBusinessPage.enternameAccountOrAccountHolderWillBeSendingMoneyField().sendKeys(yourOrganisationAccount.split(",")[19]);
                yourBusinessPage.nextButton().click();
            }

        } else {
            yourBusinessPage.radioIsMoneyComingInNo().click();
        }
    }




    public void enterAboutYou(String personalDetails, String teamDetals) {
        waitForPageLoad();
        waitForPageLoad();
        waitForPageLoad();

        new Select(yourTeamPage.selectDateOfBirth()).selectByVisibleText(teamDetals.split(",")[0]);
        new Select(yourTeamPage.selectMonthOfBirth()).selectByVisibleText(teamDetals.split(",")[1]);
        new Select(yourTeamPage.selectYearOfBirth()).selectByVisibleText(teamDetals.split(",")[2]);
        yourTeamPage.enterEmailId().sendKeys(RandomGenerator.randomEmailAddress(6));
        new Select(yourTeamPage.selectCountryCode()).selectByVisibleText(teamDetals.split(",")[3]);
        yourTeamPage.enterMobileNumber().sendKeys(RandomGenerator.randomInteger(10));
        //Enter Additional Information
        if ((teamDetals.split(",")[4]).equalsIgnoreCase("Male"))
            yourTeamPage.radioGenderMale().click();
        else
            yourTeamPage.radioGenderFeMale().click();
        new Select(yourTeamPage.selectCountryOfBirth()).selectByVisibleText(teamDetals.split(",")[5]);
        yourTeamPage.enterBirthTown().sendKeys((teamDetals.split(",")[6]));

        //for radio button of NATWEST account
        if ((teamDetals.split(",")[7]).equalsIgnoreCase("personalaccountYes"))
            yourTeamPage.radioHoldNatwestAccYes().click();
        else
            yourTeamPage.radioHoldNatwestAccNo().click();
        new Select(yourTeamPage.selectMonthOfStartingWork()).selectByVisibleText(teamDetals.split(",")[8]);
        new Select(yourTeamPage.selectYearOfStartingWork()).selectByVisibleText(teamDetals.split(",")[9]);
        //Are you registered to pay tax outside of the UK?
        if ((teamDetals.split(",")[10]).equalsIgnoreCase("PayTaxOutUKYes"))
            yourTeamPage.radioRegisteredToPayTaxOutUKYes().click();
        else
            yourTeamPage.radioRegisteredToPayTaxOutUKNo().click();
        //nationality
        new Select(yourTeamPage.selectNationality()).selectByVisibleText((teamDetals.split(",")[11]));
        //building number
        yourTeamPage.enterBuildingNumber().sendKeys(teamDetals.split(",")[12]);
        yourTeamPage.enterPostCode().sendKeys(teamDetals.split(",")[13]);
        yourTeamPage.homeAddressSeachButton().click();
        new Select(yourTeamPage.selectMonthMovingIntoAddress()).selectByVisibleText("July");
        new Select(yourTeamPage.selectYearMovingIntoAddress()).selectByVisibleText("2014");
        yourTeamPage.nextButton().click();
    }

    //Manage Account Page


    public void manageaccounts(String manageAccounts) {

        waitForPageLoad();
        waitForMoreTime();
        if (manageAccounts.split(",")[0].equalsIgnoreCase("checkPaperStatementsYes")) {
            manageAccountPage.checkPaperStatements().click();
            new Select(manageAccountPage.selectStatementFrequency()).selectByVisibleText(manageAccounts.split(",")[1]);
            manageAccountPage.selectPreferedStatementDate("6");
            new Select(manageAccountPage.selectAccessibleOptions()).selectByVisibleText("None");

        }
        if (manageAccounts.split(",")[2].equalsIgnoreCase("checkPayingInBookYes")) {
            manageAccountPage.checkPayingInBook().click();
        }
        if (manageAccounts.split(",")[3].equalsIgnoreCase("checkChequeBookYes")) {
            manageAccountPage.checkChequeBook().click();
        }

        if (manageAccounts.split(",")[4].equalsIgnoreCase("radioAdditionalAccYes")) {
            manageAccountPage.radioAdditionalAccYes();
            manageAccountPage.enterAccName().sendKeys(RandomGenerator.randomInteger(7));
        } else {
            manageAccountPage.radioAdditionalAccNo().click();
        }
        manageAccountPage.nextButton().click();

        enterAdditionalProducts(manageAccounts.split(",")[5]);
    }

    public void enterAdditionalProducts(String addtionalProducts) {
        String[] productList = addtionalProducts.split("-");
        System.out.println(productList.length);
        for (int i = 0; i < productList.length; i++) {
            String strProductType = productList[i];
            System.out.println(productList[i]);
            switch (strProductType) {
                case "Overdraft":
                    manageAccountPage.checkOverdraft().click();
                    break;
                case "BusinessCreditCard":
                    manageAccountPage.checkBusinessCreditCard().click();
                    break;
                case "BusinessReserveDepositAccount":
                    manageAccountPage.checkBusinessReverseDepositAccount().click();
                    break;
                case "AcceptPaymentsFromYourCustomers":
                    manageAccountPage.checkAcceptPaymentsFromYourCustomers().click();
                    break;
                case "FreeAgentCloudBasedAccountancySoftware":
                    manageAccountPage.checkFreeAgent().click();
                    break;
            }
        }
        manageAccountPage.nextButton().click();
    }


    public void setBusinessValue(int businessValue) {
        int actualAmount;
        do {
            String text = yourBusinessPage.turnoverTitle().getText();
            String amount[] = text.split("£");
            String turnoverAmount = amount[1].replaceAll(",", "");
            turnoverAmount = turnoverAmount.replaceAll("\\+", "");
            actualAmount = Integer.parseInt(turnoverAmount);
            if (actualAmount < businessValue) {
                yourBusinessPage.incrementControl().click();
            } else if (actualAmount > businessValue) {
                yourBusinessPage.decrementControl().click();
            }
        } while (actualAmount != businessValue);
    }


}

