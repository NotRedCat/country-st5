package guru.qa.country.model;

import java.util.Date;

public record Country(String code,
                      String name,
                      Date dateOfIndependent) {

}
