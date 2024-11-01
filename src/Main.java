
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text1 = "Café au lait"; // The 'é' contains a diacritical mark
        String text2 = "Hello World!";  // No diacritical mark
        String text3 = "à la carte";    // The 'à' contains a diacritical mark

        // Normalize the strings to decompose combined characters
        text1 = Normalizer.normalize(text1, Normalizer.Form.NFD);
        text2 = Normalizer.normalize(text2, Normalizer.Form.NFD);
        text3 = Normalizer.normalize(text3, Normalizer.Form.NFD);

        // Regular expression to match diacritical marks
        String regex = "\\p{M}";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Check the first string
        Matcher matcher1 = pattern.matcher(text1);
        boolean containsDiacritical1 = matcher1.find();
        System.out.println("Text 1 contains diacritical character: " + containsDiacritical1);

        // Check the second string
        Matcher matcher2 = pattern.matcher(text2);
        boolean containsDiacritical2 = matcher2.find();
        System.out.println("Text 2 contains diacritical character: " + containsDiacritical2);

        // Check the third string
        Matcher matcher3 = pattern.matcher(text3);
        boolean containsDiacritical3 = matcher3.find();
        System.out.println("Text 3 contains diacritical character: " + containsDiacritical3);
    }


}
