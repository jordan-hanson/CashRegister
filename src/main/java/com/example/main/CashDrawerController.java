package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CashDrawerController {

    @Autowired
    private CashDrawerService cashDrawerService;

    @GetMapping(value = "/cashdrawers/cashdrawer/{cashdrawerid}")
    public ResponseEntity<?> getCashDrawerById(@PathVariable long cashdrawerid)
    {
        CashDrawer cashDrawer = cashDrawerService.findCashDrawerById(cashdrawerid);
        return new ResponseEntity<>(cashDrawer, HttpStatus.OK);
    }


    @PostMapping(value = "/cashdrawers/cashdrawer", consumes="application/json")
    public ResponseEntity<?> addNewCashDrawer(@RequestBody CashDrawer cashDrawer)
    {
        cashDrawer.setId(0);
        cashDrawer = cashDrawerService.save(cashDrawer);

        // set the location header for the newly created cash drawer
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCashDrawerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cashdrawerid}")
                .buildAndExpand(cashDrawer.getId())
                .toUri();
        responseHeaders.setLocation(newCashDrawerURI);
        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);

    }

    @PutMapping(value = "/cashdrawers/cashdrawer/{cashdrawerid}/transactions/{typeOf}", consumes="application/json")
    public ResponseEntity<String> addValueToCashDrawer(@RequestBody CashDrawer cashDrawer, @PathVariable String typeOf, @PathVariable long cashdrawerid)
    {

        switch(typeOf){
            case "put":
                CashDrawer updatedAmountsAddedToCashDrawer = cashDrawerService.addAmounts(cashDrawer, cashdrawerid);
                return new ResponseEntity<>(updatedAmountsAddedToCashDrawer.toString(), HttpStatus.OK);
            case "take":
                CashDrawer updatedAmountsTakenFromCashDrawer = cashDrawerService.takeAmounts(cashDrawer, cashdrawerid);
                return new ResponseEntity<>(updatedAmountsTakenFromCashDrawer.toString(),HttpStatus.OK);
            default:
                return new ResponseEntity<>("Not a valid type", HttpStatus.BAD_REQUEST);
        }

    }

}
