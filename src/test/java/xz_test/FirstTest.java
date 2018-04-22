package xz_test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://igorakintev.ru/admin/");


        driver.findElement(By.name("username")).sendKeys("silenium");
        driver.findElement(By.name("password")).sendKeys("super_password");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();

        String title1 = driver.getTitle();
        Assert.assertTrue(title1.contains("Панель управления"));

        driver.findElement(By.xpath("//a[@href='/admin/blog/entry/add/']")).click();

        String title2 = driver. getTitle();
        Assert.assertTrue(title2.contains("Добавить entry"));


        int a = 0;
        int b = 1000000;
        int random_number = a + (int) (Math.random() * b);

        String Title = "Title" + random_number + "";

        driver.findElement(By.id("id_title")).sendKeys(Title);
        driver.findElement(By.id("id_slug")).sendKeys("Slug7526");
        driver.findElement(By.id("id_text_markdown")).sendKeys("Slug7526");
        driver.findElement(By.id("id_text")) .sendKeys("Slug7526");

        driver.findElement(By.xpath("//input[@value='Сохранить']")).click();

        driver.get("http://igorakintev.ru/blog/");

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(Title));


        driver.get("http://igorakintev.ru/admin/blog/entry/");

        String url = driver.findElement(By.xpath("//*[text()='" + Title + "']")).getAttribute("href");

        int lenght = url.length();
        String url1 = url.substring(39,lenght - 1);

        driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + url1 + "']")).click();
        driver.findElement(By.name("action")).click();
        driver.findElement(By.xpath("//option[@value='delete_selected']")).click();
        driver.findElement(By.name("index")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();


//        driver.quit();
    }
}
