fun main(args: Array<String>) {
    val driver = MySelenium.getHeadlessDriver()
    MySelenium.test_composer(driver)
}
