package uz.pdp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/demo-b")
public class AppController {

    List<Country> countries = List.of(
            new Country(1L,"Spain"),
            new Country(2L,"Germany"),
            new Country(3L,"Uzbekistan"),
            new Country(4L,"Argentina")
    );

    @GetMapping
    public String hello(){
        return "Hello from demo-b";
    }

    @PostMapping("/{countryId}")
    public Country getCountyById(@PathVariable Long countryId){
        for (Country country : countries) {
            if (country.getId().equals(countryId)){
                return country;
            }
        }
        return new Country(5L,"Unknown");

    }
}
