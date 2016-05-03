package poly_and_strings;

/**
 * @author fotoply
 */
public class FlipUpperLowerManip extends AbstractManipulable {

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        StringBuilder newString = new StringBuilder();
        for (char currentChar : originalString.toCharArray()) {
            if (Character.isUpperCase(currentChar)) {
                newString.append(Character.toLowerCase(currentChar));
            } else {
                newString.append(Character.toUpperCase(currentChar));
            }
        }
        return newString.toString();
    }
}
