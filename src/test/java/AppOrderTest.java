
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class AppOrderTest {


    @Test

    public void appOrderValidTest() {

        open("http://localhost:9999/");

        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("+71234567890");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    public void appOrderInValidNameTest() {

        open("http://localhost:9999/");

        $("[data-test-id=name] input").setValue("Aleksandr");
        $("[data-test-id=phone] input").setValue("+71234567890");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }
    @Test
    public void appOrderInValidPhoneTest() {

        open("http://localhost:9999/");

        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("712345678901");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));


    }
    @Test
    public void appOrderInValidCheckboxTest() {

        open("http://localhost:9999/");

        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("+79951343000");
        $("[class=button__text]").click();
        $("[data-test-id=agreement].input_invalid .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));

    }
    @Test
    public void appOrderInValidEmptyNameTest() {

        open("http://localhost:9999/");


        $("[data-test-id=phone] input").setValue("+71234567890");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

@Test
public void appOrderInValidEmptyPhoneTest() {

    open("http://localhost:9999/");

    $("[data-test-id=name] input").setValue("Александр");
    $("[data-test-id=agreement]").click();
    $("[class=button__text]").click();
    $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

}
}
