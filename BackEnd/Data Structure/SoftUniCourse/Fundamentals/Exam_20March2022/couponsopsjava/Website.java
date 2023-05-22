package couponsopsjava;

public class Website {

    public String domain;
    public int usersCount;

    public Website(String domain, int usersCount) {
        this.domain = domain;
        this.usersCount = usersCount;
    }

    public String getDomain() {
        return domain;
    }

    public int getUsersCount() {
        return usersCount;
    }
}
