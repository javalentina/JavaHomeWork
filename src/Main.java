import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {

        Person person = new Person("John", 35);
        Person person2 = new Person("Jim", 24);
        Person person3 = new Person("Jet", 18);
        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(person);
        listOfPerson.add(person2);
        listOfPerson.add(person3);
        listOfPerson.add(person3);
        listOfPerson.add(person3);

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(person, "DE123123123", 3500));
        accountList.add(new Account(person2, "DE2222222", 3300));
        accountList.add(new Account(person, "DE33333", 3200));
        accountList.add(new Account(person3, "DE444441", 3100));
        accountList.add(new Account(person3, "DE444442", 3100));
        accountList.add(new Account(person3, "DE444443", 3100));


        System.out.println("Account list size:  " + accountList.size());

        /*
         * Дан список Account{Person person, String iban, double balance}.
         * Необходимо сформировать Map<Person, Account>, где ключом будет Person, а значением список его счетов.
         */
        BankTransaction bankTransaction = new BankTransaction(accountList);
        bankTransaction.getAccountsInfo();


        /*Дан список Person(name,age) необходимо написать метод,
        который возвращает Map<Person,Integer>,  где ключ это сам Person,
        а значение – сколько раз он встретился в списке.
        */
        PersonInfo personInfo = new PersonInfo(listOfPerson);
        personInfo.personMap();

        /*
         * Удалить дубликаты
         * */

        List<Person> removeDuplicates = listOfPerson.stream()
                .distinct().toList();
        System.out.println("Removed duplicates: " + removeDuplicates);

        /*
         * Посчитать сколько персон больше 20 лет
         * */

        long personOlderThen = listOfPerson.stream()
                .filter(Person -> Person.getAge() > 20).count();
        System.out.println("Older then3 20: " + personOlderThen);

        /*
         * сколько всего денег на счету
         * */

        double commonAccountsBalance = accountList.stream()
                .mapToDouble(Account -> Account.getBalance()).sum();

        System.out.println("Common Balance: " + commonAccountsBalance);


        /*
         * Показать только людей с одним счетом( iban)
         * */



        Map<String, List<Account>> personWithOneIbanNew = accountList.stream()
                .collect(Collectors.groupingBy(Account->Account.getPerson().getName()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream().map(Account::getIban).distinct().count() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(personWithOneIbanNew);



    }
}