package lesson7;

public class TestClass {

    @BeforeSuite
    public void beforeTest() {
        System.out.println("Метод c beforesuite");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("Метод с aftersuite");
    }

    @Test(priority = 4)
    public void test_one() {
        System.out.println("Метод test_one, приоритет 4");
    }

    @Test(priority = 3)
    public void test_two() {
        System.out.println("Метод test_ецщ, приоритет 3");
    }

    @Test(priority = 5)
    public void test_three() {
        System.out.println("Метод test_three, приоритет 5");
    }

    @Test(priority = 1)
    public void test_four() {
        System.out.println("Метод test_four, приоритет 1");
    }

    public void test_five() {
        System.out.println("Метод test_four");
    }
}
