import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashDrawerController {

    @GetMapping(path = "/cashdrawer")
    public String getCashDrawer(@PathVariable CashDrawer cashDrawer){
        return cashDrawer.toString();
    }
    
}
