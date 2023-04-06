#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create and Delete a Exam
    And Click on the element in the left Nav
      | leftNavBar       |
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | ismetEx4 |

    And Click on the element in the Form Content
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    #TODO: Akademik period ve GradeLevel tıklanma problemi

    And Click on the element in the Dialog
      | acceptCookies |
      | saveButton    |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | formSearchInput | ismetEx4 |

    Then Success message should be displayed

