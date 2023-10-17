package HighQualityMistakes_03_1;

import java.io.Serializable;

public class Reflection implements Serializable {

    private static final String NICKNAME = "Pinguin";
    public String name;
    protected String webAddress;
    String email;
    private int zip;

    public Reflection() {
        this.setName("Java");
        this.setWebAddress("oracle.com");
        this.setEmail("mail@oracle.com");
        this.setZip(1407);
    }

    private Reflection(String name, String webAddress, String email) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    protected Reflection(String name, String webAddress, String email, int zip) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setZip(int zip) {
        this.zip = zip;
    }

    public final String getName() {
        return name;
    }

    protected String getWebAddress() {
        return webAddress;
    }

    public String getEmail() {
        return email;
    }

    protected final int getZip() {
        return zip;
    }

    public String toString() {
        return "Name: " + getName() + System.lineSeparator() +
                "WebAddress: " + getWebAddress() + System.lineSeparator() +
                "email: " + getEmail() + System.lineSeparator() +
                "zip: " + getZip();
    }

}
