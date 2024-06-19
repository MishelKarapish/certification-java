import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления номера телефона
    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Метод для получения всех записей, отсортированных по убыванию числа телефонов
    public List<Map.Entry<String, Set<String>>> getSortedEntries() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entries;
    }

    // Метод для печати телефонной книги
    public void printPhoneBook() {
        List<Map.Entry<String, Set<String>>> sortedEntries = getSortedEntries();
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println("Name: " + entry.getKey() + ", Phones: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        // Добавляем записи в телефонную книгу
        phoneBook.addPhoneNumber("Kate", "12345");
        phoneBook.addPhoneNumber("Lara", "67890");
        phoneBook.addPhoneNumber("Kate", "54321");
        phoneBook.addPhoneNumber("Vera", "11111");
        phoneBook.addPhoneNumber("Lara", "22222");
        phoneBook.addPhoneNumber("Kate", "98765");

        // Печатаем телефонную книгу
        phoneBook.printPhoneBook();
    }
}