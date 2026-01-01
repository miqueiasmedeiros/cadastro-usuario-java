package crud.javanauta.cadastro_usuario.util;

import java.util.regex.Pattern;

public class ValidaEmail {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean isValidEmail(String email){
        return Pattern.matches(EMAIL_REGEX, email);
    }
}
