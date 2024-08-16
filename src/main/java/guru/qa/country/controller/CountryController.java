package guru.qa.country.controller;

import guru.qa.country.model.Country;
import guru.qa.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Country> allCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/edit/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Country editCountry(@PathVariable String code, @RequestBody Country country) {
        return countryService.editCountry(code, country);
    }

    @PatchMapping("/edit/{code}/")
    @ResponseStatus(HttpStatus.OK)
    public Country editCountryName(@PathVariable String code, @RequestParam String name) {
        return countryService.editCountryName(code, name);
    }
}

