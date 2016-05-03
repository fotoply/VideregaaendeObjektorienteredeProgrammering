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
        StringBuilder builder = new StringBuilder();
        for (char currentChar : originalString.toCharArray()) {
            if (Character.isUpperCase(currentChar)) {
                builder.append(Character.toLowerCase(currentChar));
            } else {
                builder.append(Character.toUpperCase(currentChar));
            }
        }
        return builder.toString();
    }
}
