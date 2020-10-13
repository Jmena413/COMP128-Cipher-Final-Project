import java.util.*;

public class CipherDecryption {

    public static void main(String[] args) {
        CaesarCipher caesar = new CaesarCipher();
        SubstitutionCipher substitution = new SubstitutionCipher();
        String message = caesar.encrypt("attack at dawn", 5);
        System.out.println(message);
        System.out.println(caesar.decrypt(message,5));
        String key = substitution.shuffleAlphabet();
        message = substitution.encrypt("attack at dawn", key);
        System.out.println(message);
        System.out.println(substitution.decrypt(message, key));
    }
}
