Feature: ValidatingPlace API's

  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload with "<name>""<language>""<address>"
    When User calls "AddPlaceAPI" with post http Request
    Then the API call is success with staus code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name    | language | address            |  |
      | MoGhara | Odia     | Sec-2,Balasore     |  |
      | AAHouse | English  | World cross centre |  |
      | BBHouse | Spanish  | Sea Cross Centre   |  |