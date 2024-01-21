package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPageTest {

    public static void main(String args[]) {

        WebDriver driver;

//Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wikto\\Desktop\\chromedriver.exe");

//Creating an object of ChromeDriver
        driver = new ChromeDriver();

//launching the specified URL
        driver.get("https://bstackdemo.com/");
    }

    //Exception in thread "main" org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: session not created: This version of ChromeDriver only supports Chrome version 114
    //Current browser version is 120.0.6099.225 with binary path C:\Program Files\Google\Chrome\Application\chrome.exe
    //Host info: host: 'WIKTOR_PC_2', ip:
    //Build info: version: '4.14.1', revision: '03f8ede370'
    //System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '21.0.1'
    //Driver info: org.openqa.selenium.chrome.ChromeDriver
    //Command: [null, newSession {capabilities=[Capabilities {browserName: chrome, goog:chromeOptions: {args: [], extensions: []}}]}]
    //	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:140)
    //	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:96)
    //	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:68)
    //	at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:163)
    //	at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:200)
    //	at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:175)
    //	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:602)
    //	at org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:236)
    //	at org.openqa.selenium.remote.RemoteWebDriver.<init>(RemoteWebDriver.java:163)
    //	at org.openqa.selenium.chromium.ChromiumDriver.<init>(ChromiumDriver.java:108)
    //	at org.openqa.selenium.chrome.ChromeDriver.<init>(ChromeDriver.java:88)
    //	at org.openqa.selenium.chrome.ChromeDriver.<init>(ChromeDriver.java:83)
    //	at org.openqa.selenium.chrome.ChromeDriver.<init>(ChromeDriver.java:51)
    //	at com.example.demo.DriverPageTest.main(DriverPageTest.java:16)
}