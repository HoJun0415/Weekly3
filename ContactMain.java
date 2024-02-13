import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        String name, phoneNumber;
        String company, relationship;
        int num;
        boolean chk;

        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print("1. 비즈니스 연락처 추가\n2. 개인 연락처 추가\n3. 연락처 출력\n" +
                        "4. 연락처 검색\n5. 종료\n메뉴를 선택해주세요: ");
                num = sc.nextInt();

                switch (num) {
                    case 1:
                        addCompanyContact(addressBook, sc);
                        break;
                    case 2:
                        addPersonalContact(addressBook, sc);
                        break;
                    case 3:
                        addressBook.displayContacts();
                        break;
                    case 4:
                        searchContact(addressBook, sc);
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
                sc.nextLine();
                num = 0;
            }
        } while (num != 5);
    }
    public static void addCompanyContact(AddressBook addressBook, Scanner sc) {
        String name, phoneNumber, company;

        System.out.println();
        System.out.print("이름을 입력하세요: ");
        name = sc.next();
        System.out.print("전화번호를 입력하세요: ");
        phoneNumber = sc.next();
        System.out.print("회사명을 입력하세요: ");
        company = sc.next();

        addressBook.addContact(new BusinessContact(name, phoneNumber, company));
        System.out.println();
    }

    public static void addPersonalContact(AddressBook addressBook, Scanner sc) {
        String name, phoneNumber, relationship;

        System.out.println();
        System.out.print("이름을 입력하세요: ");
        name = sc.next();
        System.out.print("전화번호를 입력하세요: ");
        phoneNumber = sc.next();
        System.out.print("관계를 입력하세요: ");
        relationship = sc.next();

        addressBook.addContact(new PersonalContact(name, phoneNumber, relationship));
        System.out.println();
    }

    public static void searchContact(AddressBook addressBook, Scanner sc) {
        String name;
        boolean chk;

        System.out.println();
        System.out.print("검색할 이름을 입력하세요: ");
        name = sc.next();

        System.out.println();
        chk = addressBook.searchContact(name);

        if (!chk) {
            System.out.println("연락처를 찾을 수 없습니다.");
        }
        System.out.println();
    }
}
