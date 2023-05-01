import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankTransaction {
    private List<Account> accountList;

    public BankTransaction(List<Account> accountList) {
        this.accountList = accountList;
    }

    //Stream.of(accountList.stream().collect())


    public void getAccountsInfo() {
        Map<Person, List<Account>> accountsMap = accountList.stream()
                .collect(Collectors.groupingBy(
                        Account::getPerson,
                        Collectors.toList()
                ));

        Map<Person, List<String>> accountsIban = accountList.stream()
                .collect(Collectors.groupingBy(
                        Account::getPerson,
                        Collectors.mapping(Account::getIban, Collectors.toList())
                ));
        Map<String, List<String>> accountsName = accountList.stream()
                .collect(Collectors.groupingBy(
                        account -> account.getPerson().getName(),
                        Collectors.mapping(Account::getIban, Collectors.toList())
                ));
        System.out.println(accountsMap);
        System.out.println(accountsIban);
        System.out.println(accountsName);
    }
}
