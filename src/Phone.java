import java.util.Objects;

public class Phone {
    private String phoneNum;
    private String type;

    public Phone(String phoneNum, String type) {
        this.phoneNum = phoneNum;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNum='" + phoneNum + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(getPhoneNum(), phone.getPhoneNum()) && Objects.equals(getType(), phone.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNum(), getType());
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
