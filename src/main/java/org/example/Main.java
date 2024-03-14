package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner inputMenu = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(
                "=".repeat(30) + "\n Selamat datang di Binar Food \n" + "=".repeat(30)
        );
        mainMenu();
    }

    public static void mainMenu() {
        List<String> menuList = Arrays.asList("1","2","3","4","5","6","7","8");
        List<String> menuOption = Arrays.asList("00","01");
        System.out.println(
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
                        
                        00. Pesan dan bayar
                        01. Keluar dan batalkan"""
        );
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
        //block
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
        String[] item = new String[8];
        StringBuilder inputMsg = new StringBuilder();
        inputMsg.append("=".repeat(30))
                .append("\n")
                .append("Silahkan masukkan jumlah makanan/minuman \n")
                .append("+")
                .append(selectedItem);
        System.out.println(inputMsg);
        System.out.print("qty => ");String userInput = inputMenu.nextLine();
        item[Integer.parseInt(menu) - 1] = userInput;
        System.out.println("Jumlah yang anda pesan untuk menu "+ selectedItem +" adalah " + userInput + " pesanan");
    }
}