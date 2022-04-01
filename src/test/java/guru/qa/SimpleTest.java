package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {

    @BeforeAll
    static void initDB() {
        System.out.println("### Before All");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("###   Before Each");
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void close() {
        System.out.println("###   After Each");
        WebDriverRunner.closeWindow();
    }


    @AfterAll
    static void clearDB() {
        System.out.println("### After All");
    }

    @Test
    void assertTest1() {
        //test1
        System.out.println("###      Test1");

    }

    @Test
    void assertTest2() {
        //test2
        System.out.println("###      Test2");

    }

}
