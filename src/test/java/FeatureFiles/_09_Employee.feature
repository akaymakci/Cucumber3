#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.

Feature: Employee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create a Employee
    And Click on the element in the left Nav
      | leftNavBar     |
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | acceptCookies |
      | addButton     |

    And User select form value in Form Content
      | genderInput       | <Gender>   |
      | employeeTypeInput | <Type>     |
      | statusInput       | <Status>   |
      | documentTypeInput | <Document> |

    And User sending the keys in Form Content
      | firstNameInput      | <Name>      |
      | lastNameInput       | <Lastname>  |
      | dateOfBirthInput    | <Birthday>  |
      | employeeIDInput     | <ID>        |
      | documentNumberInput | <docNumber> |

    And Click on the element in the FormContent
      | contactAddressTab |

    And User sending text and wait until to be present in Form Content
      | countryInput | <countryInput> |



    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed


    Examples:
      | Name  | Lastname | Birthday   | Gender       | Type                   | ID | Status        | Document                     | docNumber | countryInput |
      | isim1 | soyisim1 | 10/07/1984 | genderMale   | employeeTypeOther      | 24 | statusPassive | documentTypePersonelId       | 11111     | Turkey       |
#      | isim2 | soyisim2 | 10/07/1985 | genderFemale | employeeTypeTeacher    | 01 | statusActive  | documentTypePassport         | 11112     | Ukraine      |
#      | isim3 | soyisim3 | 10/07/1986 | genderMale   | employeeTypeOther      | 22 | statusPassive | documentTypeBirthCertificate | 11113     | Germany      |
#      | isim4 | soyisim4 | 10/07/1987 | genderMale   | employeeTypeOther      | 20 | statusActive  | documentTypePassport         | 11114     | Russia       |
#      | isim5 | soyisim5 | 10/07/1988 | genderFemale | employeeTypeSupervisor | 02 | statusActive  | documentTypePersonelId       | 11115     | France       |