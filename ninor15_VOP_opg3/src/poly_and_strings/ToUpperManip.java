package poly_and_strings;

/**
 * Created 4/26/16
 *
 * @author Niels Norberg
 */
public class ToUpperManip extends AbstractManiplulable {

    public ToUpperManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        return originalString.toUpperCase();
    }
}
