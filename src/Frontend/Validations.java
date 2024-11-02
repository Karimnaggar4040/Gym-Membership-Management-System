package Frontend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    protected static boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    } // DONE

    protected static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11)
            return false;
        return phoneNumber.matches("\\d+"); // Returns true if str contains only digits

    } // DONE

    protected static boolean validateMemberId(String memberId){
        char[] memberIdChars = memberId.toCharArray();
        return memberIdChars[0] == 'M';
    }

    protected static boolean validateClassId(String classId){
        char[] classIdChars = classId.toCharArray();
        return classIdChars[0] == 'C';
    }
}
