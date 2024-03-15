package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.Delayed;

import static org.example.Const.*;

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
            showOrderedMenu();
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
                .append("=".repeat(30))
                .append("\n")
                .append("+ ")
                .append(selectedItem);
        System.out.println(inputMsg);
        System.out.print("qty => ");String userInput = inputMenu.nextLine();
        System.out.println("=".repeat(30));
        System.out.println("Konfirmasi pesanan anda");
        System.out.println("=".repeat(30));
        System.out.println(userInput + " " + selectedItem + " | " + getMenuPrice(Integer.parseInt(menu)-1, Integer.parseInt(userInput)));
        order.addOrder(Integer.parseInt(menu), Integer.parseInt(userInput));
        System.out.println("-".repeat(30));
        mainMenu();
    }

    public static int getMenuPrice(int menuId, int qty) {
        return menuPrice[menuId] * qty;
    }

    public static void showOrderedMenu() {
        int[][] item = order.takeOrder();
        int totalPrice = 0;
        for (int i=0;i<item[0].length;i++) {
            if (item[0][i] != 0) {
                System.out.println(item[0][i] + " " + menuList[i] + " | " + item[1][i]);
                totalPrice += item[1][i];
            }
        }
        System.out.println("Total =>" + totalPrice + "\n");
        System.out.println("00. Bayar pesanan");
        System.out.println("01. Batalkan pesanan");
        System.out.print("=> "); String userInput = inputMenu.nextLine();
        if (userInput == "00") {
            WriteRead.writeFile("Struk tercetak");
        } else {
            System.exit(0);
        }
    }
}