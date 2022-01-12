import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.By

object MySelenium {

    fun getDriver(): FirefoxDriver {
        return FirefoxDriver()
    }

    fun getHeadlessDriver(): FirefoxDriver {
        val firefoxBinary = FirefoxBinary()
        val firefoxOptions = FirefoxOptions()
        firefoxBinary.addCommandLineOptions("--headless")
        firefoxBinary.also { firefoxOptions.binary = it }
        return FirefoxDriver(firefoxOptions)
    }

    fun test_composer(driver: FirefoxDriver) {

        val composer = "Mozart"

        driver.get("https://www.prestomusic.com/classical/composers")

        var search = driver.findElement(By.xpath("""//a[contains(text(), "$composer")]"""))
        driver.get(search.getAttribute("href"))
        search = driver.findElement(By.xpath("""//a[contains(text(), "Hi-Res")]"""))
        driver.get(search.getAttribute("href"))
        search = driver.findElement(By.xpath("""//a[contains(text(), "Award Winners")]"""))

        println("$composer Hi-Res ${search.text}")
    }
}
