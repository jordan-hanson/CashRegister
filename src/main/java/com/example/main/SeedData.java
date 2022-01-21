package com.example.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ConditionalOnProperty(
        prefix = "command.line.runner",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@Component
public class SeedData
        implements CommandLineRunner {
    @Autowired
    CashDrawerService cashDrawerService;

    @Transactional
    @Override
    public void run(String[] args) {
        cashDrawerService.deleteAll();
        CashDrawer cd1 = new CashDrawer();
        cd1.setId(0);
        cashDrawerService.save(cd1);

    }
}
