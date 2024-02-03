import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        String password = generatePassword();
        System.out.println("Twoje nowe hasło: " + password);
    }

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Initialize sets for characters
        String[] characterSets = {LOWERCASE_CHARACTERS, UPPERCASE_CHARACTERS, DIGITS, SPECIAL_CHARACTERS};
        Set<Character> passwordSet = new HashSet<>();

        // Add at least one character from each character set
        for (String characterSet : characterSets) {
            passwordSet.add(characterSet.charAt(random.nextInt(characterSet.length())));
        }

        // Generate remaining characters randomly
        while (passwordSet.size() < 8) {
            String randomCharacterSet = characterSets[random.nextInt(characterSets.length)];
            char randomCharacter = randomCharacterSet.charAt(random.nextInt(randomCharacterSet.length()));
            passwordSet.add(randomCharacter);
        }

        // Convert set to string
        for (Character character : passwordSet) {
            password.append(character);
        }

        return password.toString();
    }
}
