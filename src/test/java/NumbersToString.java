public class NumbersToString {

    public static String checkNumber(String[] str, String numb, int begin, int end) {
        String temp = "";
        for (int i = 1; i <= str.length; i++) {
            if (Integer.parseInt(numb.substring(begin, end)) == i) {
                temp = str[i];
            }
        }
        return temp;
    }

    public static String getCompare(String numb, int begin, int end) {
        if (Integer.parseInt(numb.substring(begin, end)) == 1) {
            return " тысяча ";
        }
        else if (Integer.parseInt(numb.substring(begin, end)) == 2 | Integer.parseInt(numb.substring(begin, end)) == 3 | Integer.parseInt(numb.substring(begin, end)) == 4) {
            return " тысячи ";
        }
        else
            return " тысяч ";
    }

    public static String conversion(int a) {
        String numb = String.valueOf(a);
        String[] one = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемьнадцать", "девятнадцать", "двадцать"};
        String[] two = {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] ten = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] hundred = {"", "сто", "двести", "триста","четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот", "тысяча"};
        if (a == 0) {
            return "Программа работает от 1 до 999999";
        }
        else if (numb.length() == 1) {
            return checkNumber(one, numb,0, 1);
        }
        else if (numb.length() == 2) {
            if (Integer.parseInt(numb.substring(0, 1)) == 1) {
                return checkNumber(one, numb, 0, 2);
            }
            else {
                return (checkNumber(ten, numb, 0, 1) + " " + checkNumber(one, numb, 1, 2)).trim();
            }
        }
        else if (numb.length() == 3) {
            if (Integer.parseInt(numb.substring(1, 2)) == 1) {
                return checkNumber(hundred, numb, 0, 1) + " " + checkNumber(one, numb, 1, 3);
            } else {
                return (checkNumber(hundred, numb, 0, 1) + " " + checkNumber(ten, numb, 1, 2) + " " + checkNumber(one, numb, 2, 3)).trim();
            }
        }
        else if (numb.length() == 4) {
            if (Integer.parseInt(numb.substring(2, 3)) == 1) {
                return (checkNumber(two, numb, 0, 1) + getCompare(numb,0,1) + checkNumber(hundred,numb, 1, 2) + " " + checkNumber(one, numb, 2, 4)).trim();
            }
            return (checkNumber(two, numb, 0, 1) + getCompare(numb,0,1) + checkNumber(hundred,numb, 1, 2) + " " + checkNumber(ten, numb, 2, 3) + " " + checkNumber(one, numb, 3, 4)).trim();
        }
        else if (numb.length() == 5) {
            if (Integer.parseInt(numb.substring(0, 1)) == 1) {
                if (Integer.parseInt(numb.substring(3, 4)) == 1) {
                    return (checkNumber(one, numb, 0, 2) + " тысяч " + checkNumber(hundred, numb, 2, 3) + " " + checkNumber(one, numb, 3, 5)).trim();
                }
                else {
                    return (checkNumber(one, numb, 0, 2) + " тысяч " + checkNumber(hundred, numb, 2, 3) + " " + checkNumber(ten, numb, 3, 4) + " " + checkNumber(one, numb, 4, 5)).trim();
                }
            }
            else {
                if (Integer.parseInt(numb.substring(3, 4)) == 1) {
                    return (checkNumber(ten, numb, 0, 1) + " " + checkNumber(two, numb, 1 , 2) + getCompare(numb, 1, 2) + checkNumber(hundred, numb, 2, 3) + " " + checkNumber(one, numb, 3, 5)).trim();
                }
                else {
                    return (checkNumber(ten, numb, 0, 1) + " " + checkNumber(two, numb, 1 , 2) + getCompare(numb, 1, 2) + checkNumber(hundred, numb, 2, 3) + " " + checkNumber(ten, numb, 3, 4) + " " + checkNumber(one, numb, 4, 5)).trim();
                }
            }
        }
        else if (numb.length() == 6) {
            if (Integer.parseInt(numb.substring(1, 2)) == 1) {
                if (Integer.parseInt(numb.substring(4, 5)) == 1) {
                    return (checkNumber(hundred, numb, 0, 1) + " " + checkNumber(one, numb, 1, 3) + " тысяч " + checkNumber(hundred, numb, 3, 4) + " " + checkNumber(one, numb, 4,6)).trim();
                }
                else {
                    return (checkNumber(hundred, numb, 0, 1) + " " + checkNumber(one, numb, 1, 3) + " тысяч " + checkNumber(hundred, numb, 3, 4) + " " + checkNumber(ten, numb, 4,5) + " " + checkNumber(one, numb, 5, 6)).trim();
                }
            }
            else {
                if (Integer.parseInt(numb.substring(4, 5)) == 1) {
                    return (checkNumber(hundred, numb, 0, 1) + " " + checkNumber(ten, numb, 1, 2) + " " + checkNumber(two, numb, 2, 3) + getCompare(numb, 2, 3) + checkNumber(hundred, numb, 3, 4) + " " + checkNumber(one, numb, 4,6)).trim();
                }
                else {
                    return (checkNumber(hundred, numb, 0, 1) + " " + checkNumber(ten, numb, 1, 2) + " " + checkNumber(two, numb, 2, 3) + getCompare(numb, 2, 3) + checkNumber(hundred, numb, 3, 4) + " " + checkNumber(ten, numb, 4,5) + " " + checkNumber(one, numb, 5, 6)).trim();
                }
            }
        }
        else
            return "Программа работает от 1 до 999999";
    }
}
