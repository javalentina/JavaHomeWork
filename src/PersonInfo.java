import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonInfo {
    private List<Person> listOfPerson;

    public PersonInfo(List<Person> listOfPerson) {
        this.listOfPerson = listOfPerson;
    }

    public void personMap() {
        Map<Person, Long> personCounting = listOfPerson.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(personCounting);
    }
}
