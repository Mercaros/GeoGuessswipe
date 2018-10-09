package khaled.geoguessswipe;

/**
 * Created by khaled on 24-09-18.
 */

public class GeoObject {
    private int mGeoImageName;
    private boolean inEurope;

    public static final int[] PRE_DEFINED_OBJECT_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final String[] PRE_DEFINED_NAMES = {
            "_denmark", "_canada", "_bangladesh", "_kazachstan", "_colombia", "_poland", "_malta", "_thailand"
    };

    public GeoObject(int mGeoImageName, boolean inEurope) {
        this.mGeoImageName = mGeoImageName;
        this.inEurope = inEurope;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }
}
