import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class cardDeliveryTest {
    @Test
    public void cartsTestV1() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("span[data-test-id=city] input").setValue("Вологда");
        LocalDate date = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        $("span[data-test-id=date] input").setValue(date.format(formatter));
        $("span[data-test-id=name] input").setValue("Пупиков Васютка");
        $("span[data-test-id=phone] input").setValue("+78906754678");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $("div[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}
