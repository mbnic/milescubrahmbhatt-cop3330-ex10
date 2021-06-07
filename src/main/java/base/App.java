/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicolas Milescu-Brahmbhatt
 */
package base;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);
    static float taxRate = .055f;


    public static void main(String[] args) {
        App myApp = new App();
        Item itemOne = new Item();
        Item itemTwo = new Item();
        Item itemThree = new Item();

        myApp.getItemInfo(itemOne, 1);
        myApp.getItemInfo(itemTwo, 2);
        myApp.getItemInfo(itemThree, 3);


        Bill finalBill = new Bill();
        finalBill.subtotal = myApp.getSubtotal(itemOne, itemTwo, itemThree);

        myApp.calculateBill(finalBill);

        myApp.printOutput(finalBill);
    }

    public void printOutput(Bill bill) {
        System.out.printf("Subtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f", bill.subtotal, bill.tax, bill.total);
    }

    public void calculateBill(Bill bill) {
        bill.tax = bill.subtotal * taxRate;
        bill.total = bill.subtotal + bill.tax;
    }

    public float getSubtotal(Item itemOne, Item itemTwo, Item itemThree) {
        itemOne.itemTotal = itemOne.price * itemOne.quantity;
        itemTwo.itemTotal = itemTwo.price * itemTwo.quantity;
        itemThree.itemTotal = itemThree.price * itemThree.quantity;

        return (itemOne.itemTotal + itemTwo.itemTotal + itemThree.itemTotal);
    }

    public void getItemInfo(Item item, int num) {
        System.out.printf("Enter the price of item %d: ", num);
        item.price = Integer.parseInt((in.nextLine()));

        System.out.printf("Enter the quantity of item %d: ", num);
        item.quantity = Integer.parseInt(in.nextLine());
    }
}
