package poly_and_strings;

import java.util.Arrays;

/**
 * Created 4/26/16
 *
 * @author Niels Norberg
 */
public class FlipUpperLowerManip extends AbstractManiplulable {

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        char[] newStringAsArray = new char[originalString.length()];
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            if(Character.isUpperCase(currentChar)) {
                newStringAsArray[i] = Character.toLowerCase(currentChar);
            } else {
                newStringAsArray[i] = Character.toUpperCase(currentChar);
            }
        }
        return Arrays.toString(newStringAsArray);
    }
}
