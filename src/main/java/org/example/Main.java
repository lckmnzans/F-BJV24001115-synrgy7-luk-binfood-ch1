package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner inputMenu = new Scanner(System.in);
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println(
                "=".repeat(30) + "\n Selamat datang di Binar Food \n" + "=".repeat(30)
        );
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
        System.out.print("=> ");
        String userInput = inputMenu.nextLine();
        selectedMenu(userInput);
    }

    private static void subMenu() {
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
        System.out.println("=".repeat(30) + "\nSilahkan masukkan jumlah makanan/minuman \n + " + selectedItem);
        System.out.println("qty => ");String userInput = inputMenu.nextLine();
        System.out.println("Jumlah yang anda pesan "+ userInput);
    }
}