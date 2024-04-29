import java.util.*;
import java.util.stream.Collectors;


public class App {
    //Рассчитать суммарный возраст для определенного имени
    public int getTotalAgeByName(Client[] clients, String name) {
        int[] sum = new int[1];
        Arrays.stream(clients).filter(client -> (Objects.equals(client.getName(), name)))
                .forEach(client -> sum[0] += client.getAge());
        return sum[0];
    }

    //Получить Set, который содержит в себе только имена клиентов в порядке их упоминания в исходном массиве.
    public Set<String> getClientNamesSet(Client[] clients) {
        return Arrays.stream(clients).collect(
                LinkedHashSet::new,
                (HashSet, t) -> HashSet.add(t.getName()),
                (AbstractCollection::addAll)
        );
    }

    //Узнать, содержит ли список хотя бы одного клиента, у которого возраст больше заданного числа.
    public boolean ageMoreThanNumber(Client[] clients, int age) {
        return Arrays.stream(clients).anyMatch(client -> (client.getAge() > age));
    }

    //Преобразовать массив в Map, у которой ключ - уникальный идентификатор, значение - имя.
    // Поддержать порядок, в котором клиенты добавлены в массив.
    public HashMap<String, String> getIdNameMap(Client[] clients) {
        return Arrays.stream(clients).collect(
                LinkedHashMap::new,
                (HashMap, client) -> HashMap.put(client.getId(), client.getName()),
                LinkedHashMap::putAll
        );
    }

    //Преобразовать массив в Map, у которой ключ - возраст, значение - коллекция клиентов с таким возрастом.
    public HashMap<Integer, List<Client>> getMapGroupByAge(Client[] clients) {
        return Arrays.stream(clients).collect(
                HashMap::new,
                (HashMap, client) -> HashMap.put(client.getAge(), Arrays.stream(clients).filter(client1 -> (client.getAge() == client1.getAge())).collect(Collectors.toList())),
                HashMap::putAll
        );
    }

    //Получить строку, содержащую телефоны всех клиентов через запятую.
    // Предусмотреть, что у клиента телефонов может и не быть.
    public String getNumberString(Client[] clients) {
        ArrayList<String> r = new ArrayList<>();
        Arrays.stream(clients).forEach(client -> {
            if (client.getPhoneList() != null)
                Arrays.stream(client.getPhoneList()).forEach(
                        phone -> r.add(phone.getPhoneNum())
                );
        });
        return r.stream().reduce("", (s, s2) -> {
            if (s.isEmpty())
                return s2;
            else
                return s + "," + s2;
        });
    }

    //Найти самого возрастного клиента, которой пользуется стационарным телефоном.
    public Client oldestClientWtPhone(Client[] clients) {
        ArrayList<Client> rez = new ArrayList<>();
        Arrays.stream(clients).forEach(client -> {
            if (client.getPhoneList() != null)
                if (Arrays.stream(client.getPhoneList()).anyMatch(phone -> phone.getType().equals("Стационарный"))) {
                    rez.add(client);
                }
        });
        return rez.stream().max(Comparator.comparing(Client::getAge)).get();
    }

}
