package guru.qa.country.service;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.model.Country;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryService {

    private final CountryRepository countryRepository;


    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(e -> new Country(
                        e.getName(),
                        e.getCode(),
                        e.getDateOfIndependent()
                ))
                .toList();
    }

    public Country addCountry(@NonNull Country country) {
        return Country.fromEntity(
                countryRepository.save(
                        CountryEntity.fromJson(country)
                ));
    }

    public Country getCountryByCode(String code) {
        CountryEntity countryEntity = countryRepository.findCountryByCode(code);
        return Country.fromEntity(countryEntity);
    }

    public Country editCountry(String code, Country country) {
        CountryEntity countryEntity = countryRepository.findCountryByCode(code);
        countryEntity.setName(country.name());
        countryEntity.setCode(country.code());
        countryEntity.setDateOfIndependent(country.dateOfIndependent());
        return Country.fromEntity(countryRepository.save(countryEntity));
    }

    public Country editCountryName(String code, String name) {
        CountryEntity countryEntity = countryRepository.findCountryByCode(code);
        countryEntity.setName(name);
        return Country.fromEntity(countryRepository.save(countryEntity));
    }
}
