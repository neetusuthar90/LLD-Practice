package Splitwise;

import java.util.*;

public class Expense {
    private int expenseId;
    private double amount;
    private String notes;
    private User paidBy;
    private List<Split> splitList;

    public Expense(int expenseId, double amount, User paidBy, String notes) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.notes = notes;
        this.paidBy = paidBy;
        splitList = new ArrayList<>();
    }

    public void addSplit(Split split) {
        splitList.add(split);
    }


    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

}

