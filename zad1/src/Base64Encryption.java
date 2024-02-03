import java.util.Scanner;
import java.util.Base64;

public class Base64Encryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Szyfruj tekst");
            System.out.println("2. Deszyfruj tekst");
            System.out.println("3. Wyjdź");
            System.out.print("Wybierz opcję: ");

            String option = scanner.nextLine();

            switch (option.trim()) {
                case "1":
                    System.out.print("Wprowadź tekst do zaszyfrowania: ");
                    String plainText = scanner.nextLine();
                    String encryptedText = encryptText(plainText);
                    System.out.println("Zaszyfrowany tekst: " + encryptedText);
                    break;
                case "2":
                    System.out.print("Wprowadź zaszyfrowany tekst do odszyfrowania: ");
                    String encodedText = scanner.nextLine();
                    String decryptedText = decryptText(encodedText);
                    System.out.println("Odszyfrowany tekst: " + decryptedText);
                    break;
                case "3":
                    System.out.println("Zamykam program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }
        }
    }

    public static String encryptText(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String decryptText(String encodedText) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        return new String(decodedBytes);
    }
}
