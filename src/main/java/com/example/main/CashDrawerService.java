package com.example.main;

import org.springframework.stereotype.Service;

@Service
public class CashDrawerService {

    public CashDrawer save(CashDrawer newCashDrawer) {
        return newCashDrawer;
    }

    public void addAmounts(CashDrawer cashDrawer, long cashdrawerid) {
    }

    public void takeAmounts(CashDrawer cashDrawer, long id) {
    }
}
