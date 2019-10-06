package th.ac.su.sc.nakhonpathom.model;

public class Place {

    public int id;
    public String name;
    public String district;
    public int imageRes;

    public Place(int id, String name, String district, int imageRes) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.imageRes = imageRes;
    }
}
