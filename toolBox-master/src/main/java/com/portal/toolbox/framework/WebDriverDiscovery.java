package com.portal.toolbox.framework;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;


public class WebDriverDiscovery extends EventFiringWebDriver {
    protected static final Logger log = LoggerFactory.getLogger(WebDriverDiscovery.class);
    public static BrowserMobProxy server;
    public static RemoteWebDriver remoteWebDriver = setDriver();

    public WebDriverDiscovery() {
        super(remoteWebDriver);
    }

    public static RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    private static RemoteWebDriver setDriver() {
        server = new BrowserMobProxyServer();
        server.enableHarCaptureTypes(CaptureType.getRequestCaptureTypes());
        server.enableHarCaptureTypes(CaptureType.getResponseCaptureTypes());
        server.start();
//        String var0 = System.getProperty("driverType");
//        byte var1 = -1;

        System.out.println("Driver Name : " + System.getProperty("driverType"));
        switch (System.getProperty("driverType")) {
            case "firefox":
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();

            case "saucelabs":
                if (getPlatform().contains("iOS") || getPlatform().contains("android")) {
//                    return new SauceLabsDriver(getPlatform(), getBrowserName(), getAppiumVersion(), getDeviceName(), getDeviceOrientation(), getPlatformVersion());
                } else {
//                    return new SauceLabsDriver(getPlatform(), getBrowserName(), getBrowserVersion());
                }
            case "fastest":
                if (getPlatform().contains("iOS") || getPlatform().contains("android")) {
//                    return new FastestDriver(getPlatform(), getBrowserName(), getAppiumVersion(), getDeviceName(), getDeviceOrientation(), getPlatformVersion());
                } else {
//                    return new FastestDriver(getPlatform(), getBrowserName(), getBrowserVersion(), getFastestUser(), getFastestPassword(), getRequestKey());
                }
            case "docker":
//                try {
//                    return new BrowserWebDriverContainer()
//                            .withDesiredCapabilities(DesiredCapabilities.chrome())
//                            .withRecordingMode(RECORD_ALL, new File("target")).getWebDriver();
//                } catch (Exception e) {
//                    log.warn("context", e);
//                    return null;
//                }

            case "phantom":
                ArrayList<String> cliArgsCap = new ArrayList<String>();
                cliArgsCap.add("--webdriver-loglevel=NONE");
                cliArgsCap.add("--web-security=false");
                cliArgsCap.add("--ssl-protocol=any");
                cliArgsCap.add("--ignore-ssl-errors=true");
                return new PhantomJSDriver();

            default:
                ChromeOptions driverOptions = new ChromeOptions();
                driverOptions.addArguments(new String[]{"--start-maximized"});
                return new ChromeDriver(driverOptions);
        }
    }


    public static String getPlatform() {
        return System.getProperty("platform");
    }

    public static String getBrowserVersion() {
        return System.getProperty("browserVersion");
    }

    public static String getBrowserName() {
        return System.getProperty("browserName");
    }

    public static String getFastestUser() {
        return System.getProperty("fastestUser");
    }

    public static String getFastestPassword() {
        return System.getProperty("fastestPassword");
    }

    public static String getRequestKey() {
        return System.getProperty("fastestRequestKey");
    }

    public static String getAppiumVersion() {
        return System.getProperty("appiumVersion");
    }

    public static String getDeviceName() {
        return System.getProperty("deviceName");
    }

    public static String getDeviceOrientation() {
        return System.getProperty("deviceOrientation");
    }

    public static String getPlatformVersion() {
        return System.getProperty("platformVersion");
    }

    public WebDriver getDriver() {
        return remoteWebDriver;
    }

    public void get(String s) {
    }

    public String getCurrentUrl() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public String getPageSource() {
        return null;
    }

    public void close() {
    }

    public void quit() {
    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public String getWindowHandle() {
        return null;
    }

    public TargetLocator switchTo() {
        return null;
    }

    public Navigation navigate() {
        return null;
    }

    public Options manage() {
        return null;
    }
}
