package poly_and_strings;

/**
 * @author fotoply
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
