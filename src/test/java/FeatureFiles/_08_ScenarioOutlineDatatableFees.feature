#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create a Fee, delete Fee
    And Click on the element in the left Nav
      | leftNavBar |
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | searchInput | <name> |

    Examples:
      | name      | code    | intCode   | priority |
      | IsmetFee1 | 0100001 | paypal    | 754      |
      | IsmetFee2 | 0100020 | applePay  | 765      |
      | IsmetFee3 | 0230001 | googlePay | 755      |