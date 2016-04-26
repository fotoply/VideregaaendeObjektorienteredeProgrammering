package poly_and_strings;

/**
 * Created 4/26/16
 *
 * @author Niels Norberg
 */
public class ToLowerManip extends AbstractManiplulable {

    public ToLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        return originalString.toLowerCase();
    }
}
