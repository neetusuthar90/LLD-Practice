package Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<Integer, User> userMap;
    Map<Integer, Group> groupMap;
    Map<Integer, Map<Integer, Double>> balanceSheet;


    public ExpenseManager(){
        userMap = new HashMap<>();
        groupMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getUserId(), user);
    }

    public void addGroup(Group group){
        groupMap.put(group.getGroupId(), group);
    }

    public void addExpense(int groupId, Expense expense){
        Group group = groupMap.get(groupId);
        if(group != null){
            group.addExpense(expense);
            splitExpense(expense);
            updateBalance(expense);
        }
    }

    private void splitExpense(Expense expense){
        double totalAmount = expense.getAmount();
        List<Split> splits = expense.getSplitList();
        int totalSplits = splits.size();

        double splitAmount = totalAmount/totalSplits;
        for(Split split:splits){
            if(split instanceof EqualSplit){
                split.setAmount(splitAmount);
            }else if(split instanceof PercentSplit percentSplit){
                split.setAmount(totalAmount*percentSplit.getAmount() / 100.0);
            }
        }
    }

    private void updateBalance(Expense expense) {
        User paidBy = expense.getPaidBy();
        int paidById = paidBy.getUserId();

        for (Split split : expense.getSplitList()) {
            User user = split.getUser();
            int userId = user.getUserId();
            double amount = split.getAmount();

            if (paidById != userId) {
                // Update paidBy -> user balance
                balanceSheet
                        .computeIfAbsent(paidById, k -> new HashMap<>())
                        .put(userId, balanceSheet.get(paidById).getOrDefault(userId, 0.0) + amount);

                // Update user -> paidBy balance (negative)
                balanceSheet
                        .computeIfAbsent(userId, k -> new HashMap<>())
                        .put(paidById, balanceSheet.get(userId).getOrDefault(paidById, 0.0) - amount);
            }
        }
    }

    public void settleAmount(User user1, User user2, double amount) {
        int user1Id = user1.getUserId();
        int user2Id = user2.getUserId();

        double currentBalance = balanceSheet.getOrDefault(user1Id, new HashMap<>()).getOrDefault(user2Id, 0.0);

        double newBalance = currentBalance - amount;

        balanceSheet.get(user1Id).put(user2Id, newBalance);

        balanceSheet.get(user2Id).put(user1Id, -newBalance);
    }


    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<Integer, Map<Integer, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<Integer, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(Integer user1, Integer user2, double amount) {
        String user1Name = userMap.get(user1).getUsername();
        String user2Name = userMap.get(user2).getUsername();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}
