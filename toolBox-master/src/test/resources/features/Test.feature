Feature: Creating Business Account


 # @Regression
  #Scenario Outline: Creating Business Account for <brandName>
   # Given I launch '<brandName>' Business Onboarding & Account Opening application
    #When I login with '<credencials>' to the application and navigate to homepage
    #And  I start New application and enter '<personalDetails>','<organizationDetail>','<businessDetails>','<businessfinancials>','<teamDetals>'and'<manageAccounts>'information
    #Then I should get navigate reviewapplication page

    #Examples:
    #  | brandName | credencials                       | personalDetails  | organizationDetail | businessDetails              | businessfinancials                                                                                                                                                                                           | teamDetals                                                                                                         | manageAccounts                                                                                                                                                               |
#      | RBS       | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Sole Trader    | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA | checkPaperStatementsNo,Monthly,checkPayingInBookYes,checkChequeBookYes,radioAdditionalAccNo,Overdraft-AcceptPaymentsFromYourCustomers-FreeAgentCloudBasedAccountancySoftware |
#      | Ulster    | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Sole Trader    | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA | checkPaperStatementsNo,Monthly,checkPayingInBookYes,checkChequeBookYes,radioAdditionalAccNo,AcceptPaymentsFromYourCustomers-FreeAgentCloudBasedAccountancySoftware           |
 #     | NatWest   | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Sole Trader    | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA |checkPaperStatementsNo,Monthly,checkPayingInBookYes,checkChequeBookYes,radioAdditionalAccNo,Overdraft-AcceptPaymentsFromYourCustomers-FreeAgentCloudBasedAccountancySoftware  |

  @wip
  Scenario Outline: Creating Business Account for <brandName>
    Given I launch '<brandName>' Business Onboarding & Account Opening application
    When I login with '<credencials>' to the application and navigate to homepage
    And  I start New application and enter '<personalDetails>','<organizationDetail>','<organisationContactDetails>','<businessOrganisationFinancials>','<businessOrganisationPayments>','<getYourOrganisationAccount>','<teamDetails>'and'<manageAccounts>'information
    Then I should get navigate reviewapplication page

    Examples:
      | brandName | credencials                       | personalDetails         | organizationDetail                      | organisationContactDetails                       | businessOrganisationFinancials                                              | businessOrganisationPayments                                                                                                                   | getYourOrganisationAccount                                                                                                                                                                   | teamDetails                                                                                                        | manageAccounts                                                                                                                        |
      | RBS       | peppinfernando@gmail.com,Rose!234 | MR,Prashanth,Nomula     | Church or Place of Worship,Yes,No,12345 | Scottish Power,Yes,No,ScottishPower,77C,BR1 3AA  | 180000,March,2018,5,TestBenficiaries,https://www.scottishpower.co.uk/,Yes,No,ArearsorLegalProceeding | 55,61-70,51% - 75%,6 monthly,Yes,No,Test,India,50,Director Loan,TestTest,Bermuda,60,Customer Payments,TestTest,Iceland,Greece,India,12345 | Yes,No,34567890,83,28,13,Barclays,It's too expensive,1000000,Full Switch Service,Prashanth,2000000,15000000,1000000,HSBC,India,Prashanth,Family,Barclays Bank plc,Nomula | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA | checkPaperStatementsNo,Monthly,checkPayingInBookYes,checkChequeBookYes,radioAdditionalAccNo,Overdraft-AcceptPaymentsFromYourCustomers-FreeAgentCloudBasedAccountancySoftware |


#  @wip
#  Scenario Outline: Creating Business Account for <brandName>
#    Given I launch '<brandName>' Business Onboarding & Account Opening application
#    When I login with '<credencials>' to the application and navigate to homepage
#    And  I start New application and enter '<personalDetails>','<organizationDetail>','<businessDetails>','<businessfinancials>'and'<teamDetals>'informations
#    Then I should get navigate manageaccount page
#    Examples:
#      | brandName | credencials                       | personalDetails  | organizationDetail                | businessDetails              | businessfinancials                                                                                                                                                                                           | teamDetals                                                                                                         |
#      | NatWest   | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Church or Place of Worship    | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA |
##      | RBS       | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Sole Trader                  | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA |
##      | Ulster    | peppinfernando@gmail.com,Rose!234 | MR,Peppin,Walter | Yes,Sole Trader                  | Reya Tours,No,77C,BR1 3AA,No | 160000,March,2018,December,5,Tour,AllTransferNoCash,United Kingdom,sessionalbusinessNo,intTradeNo,United Kingdom,paytaxoutsideukNO,existingbusrelationshipNo,SwitchYourBusinessAccountToUsNo,MoneyComingInNo | 10,July,1983,+44,Male,United Kingdom,Bromley,personalaccountNo,June,2016,PayTaxOutUKNo,United Kingdom,77 C,BR1 3AA |
