package top.musuixin;

/**
 * @author musuixin
 * @date 2020-06-26 16:47
 */
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminGithub;
    private String adminSalt;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminGithub() {
        return adminGithub;
    }

    public void setAdminGithub(String adminGithub) {
        this.adminGithub = adminGithub;
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminGithub='" + adminGithub + '\'' +
                ", adminSalt='" + adminSalt + '\'' +
                '}';
    }
}
