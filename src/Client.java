
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private final String id;
    private String name;
    private int age;
    private Phone[] phoneList;

    public Client(String name, int age) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.name = name;
        this.age = age;
    }

    public Client(String name, int age, Phone[] phoneList) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.name = name;
        this.age = age;
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneList=" + Arrays.toString(phoneList) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() && getAge() == client.getAge() && Objects.equals(getName(), client.getName()) && Arrays.equals(getPhoneList(), client.getPhoneList());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge());
        result = 31 * result + Arrays.hashCode(getPhoneList());
        return result;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone[] getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Phone[] phoneList) {
        this.phoneList = phoneList;
    }
}
