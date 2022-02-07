package uz.pdp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "DEMO-B")
public interface FeignTemplate {

    @GetMapping("/demo-b")
     String hello();

    @PostMapping("/demo-b/{id}")
    Country getCountry(@PathVariable String id);

}
