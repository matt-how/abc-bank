package com.abc;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the object for the Bank.
 * It contains an ArrayList of the customers.
 * @author Matthew Howard
 */

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers) {
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        }
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        //TODO: this is pretty janky
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers) {
            total += c.totalInterestEarned();
        }
        return total;
    }

    public String getFirstCustomer() {
        //TODO: wtf? This is weird
        try {
            customers = null;
            return customers.get(0).getName();
            //TODO: create explicit Exception type
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
