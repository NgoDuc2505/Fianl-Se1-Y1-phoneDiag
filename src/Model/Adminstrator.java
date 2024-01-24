package Model;

public class Adminstrator {
    private int adId;
    private String fullName;
    private String email;
    private String role;
    private String password;


    public Adminstrator(String fullName, int adId, String email, String password, String role) {
        this.adId = adId;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public int getAdId() {
        return adId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Adminstrator{" +
                "adId=" + adId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }
}
