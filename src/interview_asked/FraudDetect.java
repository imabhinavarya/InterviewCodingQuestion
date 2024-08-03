package interview_asked;
/*
Write a function which takes in a 2D List/Array of transactions and returns a list of transaction IDs which are fraudulent.
Any transaction greater than or equal to 10000 is considered fraudulent. Any transaction from the same credit card in a
different city within 30 minutes is considered fraudulent.

Input: A 2D List/Array of transactions with each transaction record having a transaction ID (integer),
credit card ID (integer, transaction amount (double), city (string), and time in minutes (integer).
You can assume all transactions happen on the same day.

Example:
Input: [
        [1, 1000, 500.00, “Vadodara”, 0],
        [2, 1000, 500.00, “Mumbai”, 5],
        [3, 1001, 500.00, “Mumbai”, 10],
        [4, 1001, 10000.00, “Mumbai”, 10]
       ]
Output: [2, 4]

Transactions 2 and 4 should be considered fraudulent. Transaction 2 occurred within 30 min of transaction 1 with the
same credit card ID (1000) and in a different city. Transaction 4 has an amount is greater than or equal to 10000.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction{
    int transId;
    int creditCardId;
    double amount;
    String city;
    int time;

    public Transaction(int transId, int creditCardId, double amount, String city, int time) {
        this.transId = transId;
        this.creditCardId = creditCardId;
        this.amount = amount;
        this.city = city;
        this.time = time;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

public class FraudDetect {
    public static void main(String[] args) {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction(1, 1000, 500.00, "Vadodara", 0));
        transactionList.add(new Transaction(2, 1000, 500.00, "Mumbai", 5));
        transactionList.add(new Transaction(3, 1001, 500.00, "Mumbai", 10));
        transactionList.add(new Transaction(4, 1001, 10000.00, "Mumbai", 10));

        List<Integer> id = detectFraud(transactionList);
        System.out.println(id);
    }

    private static List<Integer> detectFraud(List<Transaction> transactionList) {
        Map<Integer, String> map = new HashMap<>();
        return transactionList.stream()
                .filter(trans -> isSafe(trans,map))
                .map(Transaction::getTransId)
                .collect(Collectors.toList());
    }

    private static boolean isSafe(Transaction trans, Map<Integer,String> map) {
        int tId = trans.getTransId();
        int cId = trans.getCreditCardId();
        double am = trans.getAmount();
        String city = trans.getCity();
        int time = trans.getTime();
        if(am >= 10000){
            return true;
        }

        String cityTime = city+","+time;
        if(map.containsKey(cId)){
            String[] split = map.get(cId).split(",");
            String prevCity = split[0];
            int prevTime = Integer.parseInt(split[1]);
            if(!prevCity.equals(city) && Math.abs(prevTime-time) <= 30){
                return true;
            }
        }
        map.put(cId,cityTime);
        return false;
    }
}
