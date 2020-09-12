package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getPlusButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-plus-circle")));
        return driver.findElement(By.cssSelector(".fa-plus-circle"));
    }
    private WebElement getNewPlaylistField(){
        return driver.findElement(By.xpath("//*[contains(@placeholder,'to save')]"));
    }

    public String createPlaylist(String name){
        for(int i=0; i<20; i++){
            try {
                getPlusButton().click();
                break;
            } catch (ElementClickInterceptedException ignored) {}
        }


        getNewPlaylistField().sendKeys(name);
        getNewPlaylistField().sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='success show']")));

        return driver.getCurrentUrl().split("/")[5];
    }

    public boolean isPlaylistExist(String playlistId, String name){
        List<WebElement> list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        return list.size() > 0 && list.get(0).getText().equals(name);
    }

    public boolean isLogoutButton(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".logout")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public void renamePlaylist(String playlistId, String newName) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        jsExecutor.executeScript( "arguments[0].scrollIntoView();",playlist);

        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();

        WebElement editPlaylistField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
        editPlaylistField.sendKeys(Keys.CONTROL+"a");
        editPlaylistField.sendKeys(newName);
        editPlaylistField.sendKeys(Keys.ENTER);


    }
}
