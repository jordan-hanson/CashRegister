package com.example.main;

import com.example.main.exceptions.InvalidAmountException;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "cashdrawers")
public class CashDrawer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column
    private int twenty;
    @NotNull
    @Column
    private int ten;
    @NotNull
    @Column
    private int five;
    @NotNull
    @Column
    private int two;
    @NotNull
    @Column
    private int one;
    @NotNull
    @Column
    private int total;


    public CashDrawer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CashDrawer(int twenty, int ten, int five, int two, int one) {
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.two = two;
        this.one = one;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = (20 * twenty)  + (10 * ten) + (5 * five) + (2 * two) + (1 * one);
    }

    public void putBillsInRegister(int twenty, int ten, int five, int two, int one){
        this.twenty += twenty;
        this.ten += ten;
        this.five += five;
        this.two += two;
        this.one += one;
    }

    public void takeBillsFromRegister(int twenty, int ten, int five, int two, int one){
        this.twenty -= twenty;
        this.ten -= ten;
        this.five -= five;
        this.two -= two;
        this.one -= one;
    }

    public boolean validateReturn(int changeLeftOver){
        if(changeLeftOver > 0){
            return false;
        } return true;
    }

    public int[] makeChange(int changeAmount) throws InvalidAmountException {
        int[] amountsToStore = new int[5];
        while(changeAmount >= 20 && this.twenty -1 > 0) {
            changeAmount -= 20;
            amountsToStore[0] = amountsToStore[0]+1;
        }
        while(changeAmount >= 10 && this.ten -1 > 0) {
            changeAmount -= 10;
            amountsToStore[1] = amountsToStore[1]+1;
        }
        while(changeAmount >= 5 && this.five -1 > 0) {
            changeAmount -= 5;
            amountsToStore[2] = amountsToStore[2]+1;
        }
        while(changeAmount >= 2 && this.two -1 > 0) {
            changeAmount -= 2;
            amountsToStore[3] = amountsToStore[3]+1;
        }
        while(changeAmount >= 1 && this.one -1 > 0) {
            changeAmount -= 1;
            amountsToStore[4] = amountsToStore[4]+1;
        }
        boolean isReturnAvailable = validateReturn(changeAmount);
        if(isReturnAvailable){
            return amountsToStore;
        } else {
            throw new InvalidAmountException(changeAmount);
        }

    }

    public String changeDrawerString(){
        return " " + twenty +
                " " + ten +
                " " + five +
                " " + two +
                " " + one;
    }

    @Override
    public String toString() {
        return "$" + total +
                " " + twenty +
                " " + ten +
                " " + five +
                " " + two +
                " " + one;
    }

}
