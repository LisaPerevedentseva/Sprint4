import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.embosser.Account;

@RunWith(Parameterized.class)
public class ParameterizedTestOfAccount {


    private String name;
    private boolean expected;

    public ParameterizedTestOfAccount(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: name: {0}")
    public static Object[][] getDataForTest() {
        return new Object[][] {
                {"ТРУФФАНОВ ВЛАДИСЛАВ", true}, // ровно 19 символов
                {"A Б", true}, // ровно 3 символа
                {"БЕЛОБОРОДОВА НАТАЛЬЯ", false}, // 20 символов
                {"ИВАНОВ ИВАН", true}, // 11 символов
                {"ТЕРЕНТЬЕВ  ПЁТР", false}, // с двумя пробелами
                {"ТРУФФАНОВВЛАДИСЛАВ", false}, // без пробела между словами
                {" ИВАНОВ СЕРГЕЙ", false}, // с пробелом в начале
                {"ИВАНОВ СЕРГЕЙ ", false}, // с пробелом в конце
                {"IVANOV IVAN", true}, // латиница
                {"", false}, // пустая строка
                {null, false} // null
        };
    }


    @Test
    public void testAccount()
    {
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        Assert.assertEquals("Incorrect result", result, expected);
    }

}
