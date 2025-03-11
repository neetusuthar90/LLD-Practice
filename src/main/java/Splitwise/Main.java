package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ExpenseManager expenseManager = new ExpenseManager();
        //add users using expenseManager
        User user1 = new User(1,"Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");
        User user4 = new User(4, "Nena");

        expenseManager.addUser(user1);
        expenseManager.addUser(user2);
        expenseManager.addUser(user3);
        expenseManager.addUser(user4);

        //create group
        Group group1 = new Group(1, "Flat");
        group1.addUsers(user1);
        group1.addUsers(user2);
        group1.addUsers(user3);
        group1.addUsers(user4);

        expenseManager.addGroup(group1);


        List<Split> splits = new ArrayList<>();

        Expense expense = new Expense(1,300.0, user1, "Rent");
        EqualSplit equalSplit1 = new EqualSplit(user1);
        EqualSplit equalSplit2 = new EqualSplit(user2);
        EqualSplit equalSplit3 = new EqualSplit(user3);
        PercentSplit percentSplit = new PercentSplit(user4, 20.0);
        expense.addSplit(equalSplit1);
        expense.addSplit(equalSplit2);
        expense.addSplit(equalSplit3);
        expense.addSplit(percentSplit);

        expenseManager.addExpense(group1.getGroupId(), expense);

        expenseManager.showBalances();

        Scanner scanner = new Scanner(System.in);
        double settleAmount = scanner.nextDouble();

        expenseManager.settleAmount(user1, user2, settleAmount);

        expenseManager.showBalances();
    }
}
