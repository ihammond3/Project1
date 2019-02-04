//Isaiah Hammond, Project1, 2/4/19
package com.Hammond.Week1;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    static String[] add(String[] items, String newTask) {
        String[] newitems = new String[items.length + 1];

        for(int i = 0; i < items.length; ++i) {
            newitems[i] = items[i];
        }

        newitems[newitems.length - 1] = newTask;
        return newitems;
    }

    static String[] remove(String[] items, int index) {
        if(index >= 0 && index < items.length) {
            String[] newitems = new String[items.length - 1];

            for(int i = 0; i < items.length; ++i) {
                if(i < index) {
                    newitems[i] = items[i];
                } else if(i != index) {
                    newitems[i - 1] = items[i];
                }
            }

            return newitems;
        } else {
            return items;
        }
    }

    static void update(String[] items, int index, String newTask) {
        if(index >= 0 && index < items.length) {
            items[index] = newTask;
        }
    }

    static void list(String[] items) {
        for(int i = 0; i < items.length; ++i) {
            System.out.println(i + ". " + items[i]);
        }

    }

    public static void main(String[] args) {
        String[] items = new String[0];
        Boolean continueLoop = Boolean.valueOf(true);
        Scanner scanner = new Scanner(System.in);

        while(continueLoop.booleanValue()) {
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(0) Exit.");
            String input = scanner.nextLine();
            byte var6 = -1;
            switch(input.hashCode()) {
                case 48:
                    if(input.equals("0")) {
                        var6 = 4;
                    }
                    break;
                case 49:
                    if(input.equals("1")) {
                        var6 = 0;
                    }
                    break;
                case 50:
                    if(input.equals("2")) {
                        var6 = 1;
                    }
                    break;
                case 51:
                    if(input.equals("3")) {
                        var6 = 2;
                    }
                    break;
                case 52:
                    if(input.equals("4")) {
                        var6 = 3;
                    }
            }

            int index;
            switch(var6) {
                case 0:
                    System.out.println("Enter a description of the new task.");
                    String newTask = scanner.nextLine();
                    items = add(items, newTask);
                    break;
                case 1:
                    System.out.println("Enter the index of the task to remove.");
                    index = Integer.parseInt(scanner.nextLine());
                    items = remove(items, index);
                    break;
                case 2:
                    System.out.println("Enter the index of the task to update.");
                    index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new description of the task.");
                    newTask = scanner.nextLine();
                    update(items, index, newTask);
                    break;
                case 3:
                    list(items);
                    break;
                case 4:
                    continueLoop = Boolean.valueOf(false);
            }
        }

    }
}