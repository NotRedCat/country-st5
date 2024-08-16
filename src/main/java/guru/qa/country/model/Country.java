package guru.qa.country.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import guru.qa.country.data.CountryEntity;

import java.util.Date;

public record Country(
        @JsonProperty("name") String name,
        @JsonProperty("code") String code,
        @JsonProperty("date_of_independence") Date dateOfIndependent) {

    public static Country fromEntity(CountryEntity countryEntity) {
        return new Country(
                countryEntity.getName(),
                countryEntity.getCode(),
                countryEntity.getDateOfIndependent()
        );
    }
}
