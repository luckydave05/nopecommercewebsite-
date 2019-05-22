$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/Resources/Features/register.feature");
formatter.feature({
  "name": "User should able to register successfully,",
  "description": "  So that he can use all user features from website.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@register"
    }
  ]
});
formatter.scenario({
  "name": "User should able to register",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on homepage and click register page",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.userIsOnHomepageAndClickRegisterPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter all mandatory details",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.userEnterAllMandatoryDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to register sucessfully",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.userShouldBeAbleToRegisterSucessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});