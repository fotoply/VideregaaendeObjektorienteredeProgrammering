package poly_and_strings;

/**
 * @author fotoply
 */
public class ToLowerManip extends AbstractManipulable {

    public ToLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        return originalString.toLowerCase();
    }
}
