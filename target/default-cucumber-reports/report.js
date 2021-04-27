$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/RomaFeature.feature");
formatter.feature({
  "line": 2,
  "name": "transfer money",
  "description": "",
  "id": "transfer-money",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "duration": 2853870300,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user goes to the main page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user logs in with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "MainPageBasicValidations.user_goes_to_the_main_page()"
});
formatter.result({
  "duration": 6095492900,
  "status": "passed"
});
formatter.match({
  "location": "MainPageBasicValidations.userLogsInWithValidCredentials()"
});
formatter.result({
  "duration": 14000939700,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "transfer money",
  "description": "",
  "id": "transfer-money;transfer-money",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "user go to transfer functionality",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user chose to transfer from \"checking account\" to \"savings account\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user verify current balance on checking account",
  "keyword": "Then "
});
formatter.match({
  "location": "Roma_steps.user_go_to_transfer_functionality()"
});
formatter.result({
  "duration": 11548211800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "checking account",
      "offset": 29
    },
    {
      "val": "savings account",
      "offset": 51
    }
  ],
  "location": "Roma_steps.user_chose_to_transfer_from_to(String,String)"
});
formatter.result({
  "duration": 11015886700,
  "status": "passed"
});
formatter.match({
  "location": "Roma_steps.user_verify_current_balance_on_checking_account()"
});
formatter.result({
  "duration": 13833160300,
  "status": "passed"
});
formatter.after({
  "duration": 2771113400,
  "status": "passed"
});
});