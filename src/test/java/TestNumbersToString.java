import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNumbersToString {

    @Test
    public void one_1() {
        Assert.assertEquals(NumbersToString.conversion(6), "шесть");
    }

    @Test
    public void two_1() {
        Assert.assertEquals(NumbersToString.conversion(10), "десять");
    }

    @Test
    public void two_2() {
        Assert.assertEquals(NumbersToString.conversion(11), "одинадцать");
    }

    @Test
    public void two_3() {
        Assert.assertEquals(NumbersToString.conversion(90), "девяносто");
    }

    @Test
    public void two_4() {
        Assert.assertEquals(NumbersToString.conversion(91), "девяносто один");
    }

    @Test
    public void three_1() {
        Assert.assertEquals(NumbersToString.conversion(300), "триста");
    }

    @Test
    public void three_2() {
        Assert.assertEquals(NumbersToString.conversion(219), "двести девятнадцать");
    }

    @Test
    public void three_3() {
        Assert.assertEquals(NumbersToString.conversion(229), "двести двадцать девять");
    }

    @Test
    public void four_1() {
        Assert.assertEquals(NumbersToString.conversion(1000), "одна тысяча");
    }

    @Test
    public void four_2() {
        Assert.assertEquals(NumbersToString.conversion(3012), "три тысячи двенадцать");
    }

    @Test
    public void four_3() {
        Assert.assertEquals(NumbersToString.conversion(9999), "девять тысяч девятьсот девяносто девять");
    }

    @Test
    public void five_1() {
        Assert.assertEquals(NumbersToString.conversion(10000), "десять тысяч");
    }

    @Test
    public void five_2() {
        Assert.assertEquals(NumbersToString.conversion(13312), "тринадцать тысяч триста двенадцать");
    }

    @Test
    public void five_3() {
        Assert.assertEquals(NumbersToString.conversion(13322), "тринадцать тысяч триста двадцать два");
    }

    @Test
    public void five_4() {
        Assert.assertEquals(NumbersToString.conversion(21315), "двадцать одна тысяча триста пятнадцать");
    }

    @Test
    public void five_5() {
        Assert.assertEquals(NumbersToString.conversion(33320), "тридцать три тысячи триста двадцать");
    }

    @Test
    public void six_1() {
        Assert.assertEquals(NumbersToString.conversion(200000), "двести тысяч");
    }

    @Test
    public void six_2() {
        Assert.assertEquals(NumbersToString.conversion(112312), "сто двенадцать тысяч триста двенадцать");
    }

    @Test
    public void six_3() {
        Assert.assertEquals(NumbersToString.conversion(112345), "сто двенадцать тысяч триста сорок пять");
    }

    @Test
    public void six_4() {
        Assert.assertEquals(NumbersToString.conversion(102312), "сто две тысячи триста двенадцать");
    }

    @Test
    public void six_5() {
        Assert.assertEquals(NumbersToString.conversion(151382), "сто пятьдесят одна тысяча триста восемьдесят два");
    }

    @Test
    public void inv_1() {
        Assert.assertEquals(NumbersToString.conversion(0), "Программа работает от 1 до 999999");
    }

    @Test
    public void inv_2() {
        Assert.assertEquals(NumbersToString.conversion(1000000), "Программа работает от 1 до 999999");
    }

    @Test
    public void inv_3() {
        Assert.assertEquals(NumbersToString.conversion(-15), "Программа работает от 1 до 999999");
    }

}
