package org.example;

import java.util.Arrays;

import static org.example.Const.menuPrice;

public class Order {
    private static Order order;
    private int[][] orderedMenu = new int[2][8];

    public static Order getInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    public void addOrder(int menuId, int qty) {
        orderedMenu[0][menuId-1] = qty;
        orderedMenu[1][menuId-1] = menuPrice[menuId-1] * qty;
        System.out.println("Menu berhasil ditambahkan ke daftar pesanan anda");
    }

    public int[][] takeOrder() {
        return orderedMenu;
    }

    public void clearOrder() {
        Arrays.fill(orderedMenu, 0);
    }

}
