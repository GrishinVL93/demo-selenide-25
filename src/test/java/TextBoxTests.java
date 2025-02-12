import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    public String name = "Ivan Ivanov";
    public String email = "ivanivanov@gmail.com";
    public String currentAddress = "Moscow address1";
    public String permanentAddress = "Kirov address2";


    @BeforeAll
    public static void setUp(){
    Configuration.timeout = 20000;
    Configuration.browser = "safari";
    Configuration.browserSize = "1920x1080";
    }
    @Test
    public void fillFormTest(){
        open("https://demoqa.com/text-box");

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("button#submit").click();

        $("div#output #name").shouldHave(Condition.text(name));
        $("div#output #email").shouldHave(Condition.text(email));
        $("div#output #currentAddress").shouldHave(Condition.text(currentAddress));
        $("div#output #permanentAddress").shouldHave(Condition.text(permanentAddress));
    }
}
