package poly_and_strings;

/**
 * @author fotoply
 */
public class ToUpperManip extends AbstractManipulable {

    public ToUpperManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        return originalString.toUpperCase();
    }
}
