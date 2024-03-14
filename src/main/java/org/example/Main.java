package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Scanner inputMenu = new Scanner(System.in);
    private static Order order = null;
    public static void main(String[] args) {
        System.out.println(
                "=".repeat(30) + "\n Selamat datang di Binar Food \n" + "=".repeat(30)
        );
        mainMenu();
    }

    public static void mainMenu() {
        order = Order.getInstance();
        List<String> menuList = Arrays.asList("1","2","3","4","5","6","7","8");
        List<String> menuOption = Arrays.asList("00","01");
        String menuMessage =
                """
                    Silahkan pilih menu makanan minuman:\s
                    1. Nasi Goreng              | 10.000
                    2. Mie Goreng               | 10.000
                    3. Ayam Bali                | 12.000
                    4. Telur Bali               | 10.000
                    5. Orak-arik Ayam           | 10.000
                    6. Orak-arik Telur          |  8.000
                    7. Es Teh                   |  3.000
                    8. Es Jeruk                 |  3.000
                                                        
                    00. Lihat pesanan dan bayar         
                    01. Keluar dan batalkan             """;

        System.out.println(menuMessage);
        System.out.print("=> ");String userInput = inputMenu.nextLine();
        if (menuList.contains(userInput)) {
            selectedMenu(userInput);
        } else if (menuOption.contains(userInput)) {
            subMenu(userInput);
        } else {
            System.out.println("Maaf, masukkan menu atau pilihan yang sesuai! \n" + "=".repeat(30));
            mainMenu();
        }
    }

    private static void subMenu(String menu) {
        if (Objects.equals(menu, "00")) {
            int[] orders = order.takeOrder();
            for (int i=0;i<orders.length;i++) {
                System.out.println(orders[i]);
            }
        } else {
            System.out.println("OK");
            System.exit(0);
        }
    }

    public static void selectedMenu(String menu) {
        String selectedItem = switch (menu) {
            case "1" -> "Nasi Goreng";
            case "2" -> "Mie Goreng";
            case "3" -> "Ayam Bali";
            case "4" -> "Telur Bali";
            case "5" -> "Orak-arik Ayam";
            case "6" -> "Orak-arik Telur";
            case "7" -> "Es Teh";
            case "8" -> "Es Jeruk";
            default -> "";
        };
        StringBuilder inputMsg = new StringBuilder();
        inputMsg.append("=".repeat(30))
                .append("\n")
                .append("Silahkan masukkan jumlah pesanan \n")
                .append("+ ")
                .append(selectedItem);
        System.out.println(inputMsg);
        System.out.print("qty => ");String userInput = inputMenu.nextLine();
        System.out.println("Jumlah pesanan "+ selectedItem +" adalah " + userInput + " pesanan");
        order.addOrder(Integer.parseInt(menu), Integer.parseInt(userInput));
        System.out.println("-".repeat(30));
        mainMenu();
    }
}