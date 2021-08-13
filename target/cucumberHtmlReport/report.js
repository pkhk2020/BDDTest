$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:Features/TestScritpDemo.feature");
formatter.feature({
  "name": "Test Script Demo",
  "description": "\"\"\"\nBelow script performs the Acceptance criteria of Codility Test\nScript can also be parameterised by sending values in step\nScript can also be parameterised by sending values in Examples\n\"\"\"",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I Invoke the url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.steps.StepDefn.iInvokeTheUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Script Demo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "I add different products to my wish list",
  "keyword": "Given "
});
formatter.match({
  "location": "com.steps.StepDefn.i_add_different_products_to_my_wish_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I view my wish list table",
  "keyword": "When "
});
formatter.match({
  "location": "com.steps.StepDefn.i_view_my_wish_list_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I find total four selected items in my wish list",
  "keyword": "Then "
});
formatter.match({
  "location": "com.steps.StepDefn.i_find_total_four_selected_items_in_my_wish_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for lowest price product",
  "keyword": "When "
});
formatter.match({
  "location": "com.steps.StepDefn.i_search_for_lowest_price_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am able to add the lowest price item to my cart",
  "keyword": "And "
});
formatter.match({
  "location": "com.steps.StepDefn.i_am_able_to_add_the_lowest_price_item_to_my_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am able to verify the item in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "com.steps.StepDefn.i_am_able_to_verify_the_item_in_my_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.steps.StepDefn.iCloseTheBrowser()"
});
formatter.result({
  "status": "passed"
});
});