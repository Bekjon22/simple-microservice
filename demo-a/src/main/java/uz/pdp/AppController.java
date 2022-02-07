package uz.pdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo-a")
public class AppController {
    @Autowired
//    private final RestTemplate restTemplate;
    private final FeignTemplate feignTemplate;
    private final FeignTemplateC feignTemplateC;

    public AppController(FeignTemplate feignTemplate, FeignTemplateC feignTemplateC) {
        this.feignTemplate = feignTemplate;
        this.feignTemplateC = feignTemplateC;
    }


    @GetMapping
    public String hello() {
//        ResponseEntity<String> response = restTemplate.exchange("http://DEMO-B/demo-b", HttpMethod.GET, null, String.class);

        String body = feignTemplate.hello();
        return "Hello from demo-a >>>>>>====>>>>>> " + body;
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable String id) {
        return feignTemplate.getCountry(id);
    }

    @PostMapping
    List<Country> createCountry(@RequestBody Country country){
      return feignTemplateC.addCountry(country);
    }
}
