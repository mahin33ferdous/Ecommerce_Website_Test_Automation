

## Ecommerce Website Test Automation Selenium TestNG

# Content
- [Introduction](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#introduction)
- [Technologies](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#technologies)
- [Installation](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#installation)
- [Prerequisites](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#prerequisites)
- [Scenario](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#scenario)
- [Automation Output](https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation#automation-output)




# Introduction
-This is a complete project where an e-commerce site https://www.automationexercise.com/ is automated by writing test suites using selenium-webdriver and TestNg as testing framework. This project provides test automation scripts to demonstrate user experience for various action through an online clothing store using Selenium WebDriver.

**Modules that are automated:**

* Sign Up 
* Log in
* Home
* Add product to cart 
* View cart
* Place order


# Technologies
Java Development Kit (JDK): JDK

Selenium WebDriver for Java: Selenium WebDriver

Eclipse framwork


TestNG: TestNG 7.8.1

# Installation
Java

https://www.oracle.com/java/technologies/downloads/

Maven

https://maven.apache.org/download.cgi

Click =>Binaries
=>apache-maven-3.9.4-bin.zip


**Prerequisites**

1. Need to install jdk 1.8 
2. Configure Environment variable for jdk 1.8 
3. Clone this project and unzip it
4. Open the project folder
5. Open this folder on eclipse framwork
6. Build this project as a maven project.
7. Run src/test/java/com.qa.testcases/TC_RegisterPage_001.java this file.
8. Then run other testrunners.
9. You can see test results in the terminal


# Scenario

**Positive Scenrio**

* User shall be proceed to signup with valid name and email
* User account shall be created with all required information input
* User shall be logged in and username must be showing
* Varify User logged in with correct email and password
* Varify User logged out
* Verify all the category link exists on homepage
* Verify user can add featured products to the cart
* Verify user can add recomended products to the cart
* Verify user can view cart
* Verify user is able to checkout order after logging in.


**Negative Scenrio**

* User shall not be proceed signup with blank input
* User shall not be able to create account with blank information input
* Varify User can't create account with already used email
* Varify User can't logged in with empty input field
* Varify User can't logged in with invalid email address
* Varify User can't logged in with invalid password
* Verify user can't checkout order without logging into website.

# Automaion Output 

**Sign Up module**

https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation/assets/108746973/1327b31f-241c-43d2-9821-43846276289a

**Log In module** 

https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation/assets/108746973/15e9d172-cb7b-481e-b941-e0b5ed1108ef

**Home and order module** 


https://github.com/mahin33ferdous/Ecommerce_Website_Test_Automation/assets/108746973/6d09d1ec-5131-4c72-a063-f745c6845c44
