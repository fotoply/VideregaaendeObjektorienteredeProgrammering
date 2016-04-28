package poly_and_strings;

/**
 * @author fotoply
 */
public class FlipUpperLowerManip extends AbstractManiplulable {

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                newString.append(Character.toLowerCase(currentChar));
            } else {
                newString.append(Character.toUpperCase(currentChar));
            }
        }
        return newString.toString();
    }
}
