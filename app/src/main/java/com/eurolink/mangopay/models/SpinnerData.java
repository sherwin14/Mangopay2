package com.eurolink.mangopay.models;

import android.widget.ImageView;

/**
 * Created by Sherwin on 12/21/2016.
 */

public class SpinnerData {
    private String cardNumber;
    private String dateExpiry;
    private String balance;

    public SpinnerData(String cardNumber, String dateExpiry, String balance) {
        this.cardNumber = cardNumber;
        this.dateExpiry = dateExpiry;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
