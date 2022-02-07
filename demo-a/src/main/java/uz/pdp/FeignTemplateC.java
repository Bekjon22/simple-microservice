package uz.pdp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "DEMO-C")
public interface FeignTemplateC {

    @PostMapping("/demo-c")
    List<Country> addCountry(@RequestBody Country country);
}
