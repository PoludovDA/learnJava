import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearn {
    public static void main(String[] args) {
        //split
        String s = "1990.12.12";
        List<String> sList = Arrays.asList(s.split("\\."));
        //replace
        String s1 = "elda zalupa penis her elda zhop";
        String resReplace = s1.replaceAll("\\b\\w{4}\\b", "хуй");
        System.out.println(resReplace);
        String str = "228";
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
            System.out.println(matcher.group(0));
        else
            System.out.println("regex " + regex + " не нашел совпадений");

        //Вывести всю залупу из строки
        List<String> dates = new ArrayList<>();
        String str2 = "19.07.1998 fdfkvl 20.08.1972df oo20.11.2012";
        Pattern pattern1 = Pattern.compile("\\d{2}\\.\\d{2}.\\d{4}");
        Matcher matcher1 = pattern1.matcher(str2);
        while (matcher1.find()) {
            dates.add(matcher1.group());
            System.out.println(matcher1.group());
        }
        int a = 0;
    }
}
