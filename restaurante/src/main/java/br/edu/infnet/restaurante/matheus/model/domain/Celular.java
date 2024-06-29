package br.edu.infnet.restaurante.matheus.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Celular {

    private boolean is_valid;
    private String country;
    private String location;
    private String format_national;
    private Integer country_code;

    public Celular() {
        this.setCountry_code(55);
    }

    @Override
    public String toString() {
        return String.format("{ Telefone Válido: %s - País: %s - Localização: %s - Telefone Formatado: %s - Código do País: %s",
                this.is_valid() ? "Sim" : "Não", country, location, format_national, country_code
        );
    }

}
