Feature: Browsing around

  #Scenario: Login and Vets
    #Given I have opened the browser
    #And I am on the home page
    #When I open veterinarians page
    #Then I search for text "Veterinarian"
#
  #Scenario: Login and check owner based on last name
    #Given I have opened the browser
    #And I am on the home page
    #When I search owner "Franklin"
    #Then I get owner "Franklin" Informations
#
  #Scenario: Login and check different owner based on last name
    #Given I have opened the browser
    #And I am on the home page
    #When I search owner "Black"
    #Then I get owner "Black" Informations

    
  Scenario: The home page menus
    Given I have opened the browser
    And I am on the home page
    Then I should see the menu tabs "Home" "Find owners" "Veterinarians" "Error"