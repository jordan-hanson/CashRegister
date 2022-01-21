package com.example.main;

import com.example.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashDrawerService {

    @Autowired
    private CashDrawerRepository cashDrawerRepos;
    
    public CashDrawer findCashDrawerById(long cashdrawerid) {
        return cashDrawerRepos.findById(cashdrawerid)
                .orElseThrow(() -> new ResourceNotFoundException("Cashdrawer id " + cashdrawerid + " not found!"));
    }
    public CashDrawer save(CashDrawer newCashDrawer) {
        return newCashDrawer;
    }


    public void addAmounts(CashDrawer cashDrawer, long cashdrawerid) {
    }

    public void takeAmounts(CashDrawer cashDrawer, long id) {
    }


}
