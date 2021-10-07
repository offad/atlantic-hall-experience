package edu.school.atlantichallexperience;

/**
 * Created by FEMI on 21/01/2018.
 */

public class InfoItem {
    private String url = "";
    private String text = "";
    private int imageID = R.mipmap.ic_launcher;

    public InfoItem(String a, String b, int c){
        text = a;
        url = b;
        imageID = c;
    }

    public int getImageID() {
        return imageID;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

}
