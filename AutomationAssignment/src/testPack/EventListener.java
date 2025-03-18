package testPack;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;


public class EventListener implements WebDriverListener {
	
	@Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println(" Navigating to: " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println(" Navigated to: " + url);
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println(" Before clicking on: " + element.getText());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("After clicking on: " + element.getText());
    }
    
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println(" Trying to find element: " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println(" Element found: " + locator.toString());
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("❌ Error occurred in method: " + method.getName());
        System.out.println("➡️ Exception: " + e.getCause());
    }

}
