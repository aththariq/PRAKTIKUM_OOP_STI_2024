package LAT_UTS;

public class GeoLoc {
    private float lat;
    private float lon;
    private int alt;

    public GeoLoc(float lat, float lon, int alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public void setLoc(float lat, float lon, int alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public int getAlt() {
        return alt;
    }
}
