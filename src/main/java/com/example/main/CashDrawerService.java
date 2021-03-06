package com.example.main;

import com.example.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "cashdrawerservice")
public class CashDrawerService {

    @Autowired
    private CashDrawerRepository cashDrawerRepos;

    public CashDrawer findCashDrawerById(long cashdrawerid) {
        return cashDrawerRepos.findById(cashdrawerid)
                .orElseThrow(() -> new ResourceNotFoundException("Cashdrawer id " + cashdrawerid + " not found!"));
    }

    @Transactional
    public CashDrawer save(CashDrawer cashDrawer)
    {

        CashDrawer newCashDrawer = new CashDrawer();

        if (cashDrawer.getId() != 0)
        {
            cashDrawerRepos.findById(cashDrawer.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cashdrawer id " + cashDrawer.getId() + " not found!"));
            newCashDrawer.setId(cashDrawer.getId());
        }

        newCashDrawer.setTwenty(cashDrawer.getTwenty());
        newCashDrawer.setTen(cashDrawer.getTen());
        newCashDrawer.setFive(cashDrawer.getFive());
        newCashDrawer.setTwo(cashDrawer.getTwo());
        newCashDrawer.setOne(cashDrawer.getOne());
        newCashDrawer.setTotal();

        return cashDrawerRepos.save(newCashDrawer);
    }

    @Transactional
    public CashDrawer addAmounts(CashDrawer cashDrawer, long cashdrawerid) {

        CashDrawer currentCashDrawer = findCashDrawerById(cashdrawerid);

        // update each value from given cashDrawer values
        currentCashDrawer.putBillsInCashDrawer(
                cashDrawer.getTwenty(),
                cashDrawer.getTen(),
                cashDrawer.getFive(),
                cashDrawer.getTwo(),
                cashDrawer.getOne()
        );
        currentCashDrawer.setTotal();

        return cashDrawerRepos.save(currentCashDrawer);

    }

    @Transactional
    public CashDrawer takeAmounts(CashDrawer cashDrawer, long id) {
        CashDrawer currentCashDrawer = findCashDrawerById(id);

        // update each value from given cashDrawer values
        currentCashDrawer.takeBillsFromCashDrawer(
                cashDrawer.getTwenty(),
                cashDrawer.getTen(),
                cashDrawer.getFive(),
                cashDrawer.getTwo(),
                cashDrawer.getOne()
        );
        currentCashDrawer.setTotal();

        return cashDrawerRepos.save(currentCashDrawer);
    }

    @Transactional
    public void deleteAll()
    {
        cashDrawerRepos.deleteAll();
    }


}
