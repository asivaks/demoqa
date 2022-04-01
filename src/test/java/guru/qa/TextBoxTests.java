package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests {

    @BeforeAll
    static void setUP() {
        System.out.println("### Before All");
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {
        String name = "Alex Kosh";
        String email = "alex@mail.xxx";
        String currAddr = "Current Address";
        String permAddr = "Permanent Address";

        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currAddr);
        $("[id=permanentAddress]").setValue(permAddr);
        $("[id=submit]").click();

        //Asserts
        $("[id=output]").shouldHave(text(name), text(email), text(currAddr), text(permAddr));
        $("[id=output] [id=name]").shouldHave(text(name));
        $("[id=output]").$("[id=name]").shouldHave(text(name));
        $("p[id=permanentAddress]").shouldHave(text(permAddr));  //of type p

        //the same as shouldHave but longer
        String expectedCurrentAddress = currAddr;
        String actualCurrentAddress = $("p[id=permanentAddress]").text();
        assertEquals(expectedCurrentAddress,actualCurrentAddress);

    }

}
