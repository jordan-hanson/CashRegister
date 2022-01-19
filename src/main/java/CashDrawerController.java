import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CashDrawerController {

    @Autowired
    private CashDrawerService cashDrawerService;

    @GetMapping(value = "/cashdrawer")
    public String getCashDrawer(@PathVariable CashDrawer cashDrawer)
    {
        return cashDrawer.toString();
    }

    @PostMapping(value = "/cashdrawer", consumes="applicaton/json")
    public ResponseEntity<?> addNewCashDrawer(@RequestBody CashDrawer newCashDrawer)
    {
        newCashDrawer.setId(0);
        newCashDrawer = cashDrawerService.save(newCashDrawer);

        // set the location header for the newly created cash drawer
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCashDrawerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cashdrawerid}")
                .buildAndExpand(newCashDrawer.getId())
                .toUri();
        responseHeaders.setLocation(newCashDrawerURI);
        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);

    }

}
