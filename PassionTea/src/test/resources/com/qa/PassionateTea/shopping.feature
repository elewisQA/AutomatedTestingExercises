#Author: elewis@qa.com
#Feature: Browsing a shopping site

Feature: Shopping on a site
  I want to browse items on a website
  So that I can purchase items I want

  Scenario: Browse the items available on the website
    Given the correct web address
    When I navigate to the 'Menu' page
    Then I can browse a list of available products

  Scenario Outline: Add an item to the checkout
    Given the correct web address
    When I click on the checkout button
    Then I am taken to the checkout page