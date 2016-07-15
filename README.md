# iOSAppiumUICatalogDemo
iOSAppiumUICatalogDemo is a maven project using the iOS UICatalog Sample App together with Appium Server

## Description
Running test on iOS simulator via the appium server

## Pre-requisite / Requirements
Download Appium v1.5.2 (Ara)

* You must have the latest OS X El Capitan 10.11.4
* You must have the latest XCode 7.3.1
* You must have the latest IntelliJ IDEA (Community Edition)
* Download the latest appium java-client jar file - http://mvnrepository.com/artifact/io.appium/java-client/3.3.0
* Download latest selenium standalone server jar - http://www.seleniumhq.org/download/
* Use the UICatalog app provided 'UICatalog-iphonesimulator.app' for quick setup

## Getting Started
* git clone <**_repo_**>
* Launch IntelliJ and open the project.
* Ensure the jars are set up under the Project Structure.
* Go to File > Project Structure > Libraries (Click the '+' sign to import the jars (java-client and selenium standalone server)

### Launch Appium Client
* Open Appium and set the _App Path_ to the **UICatalog app**
* Hit **_Launch_** to start appium server
* Navigate back to **IntelliJ** > Open src > test > java > CucumberTest > TestRunner.java, right click and Run

### Running test from command line
* mvn clean install

### Cucumber Reports
* To view generated report, go to target > site > cucumber-reports > features-overview.html

![Alt text](https://github.com/giozom/iOSAppiumUICatalogDemo/blob/master/CucumberHTMLReport.png "Cucumber HTML Report")





