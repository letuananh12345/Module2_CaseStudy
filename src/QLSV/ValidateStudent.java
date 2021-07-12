package QLSV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateStudent {
    public static final String ID_REGEX = "^C[0-9]{4}[GHIK]{1}[0-9]{1}$";
    public static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    public boolean valid(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
