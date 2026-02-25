package com.nouradine.springgestion.Validator;

import com.nouradine.springgestion.Dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {

    public static List<String> validate(AdresseDto adresseDto){
        List<String> errors = new ArrayList<>();
        if(adresseDto==null){
            errors.add("Veuillez saisir L'adresse 1");
            errors.add("Veuillez saisir L'adresse 2");
            errors.add("Veuillez saisir La ville");
            errors.add("Veuillez saisir Le code postal");
            errors.add("Veuillez saisir Le pays");
            return errors;
        }
        if(!StringUtils.hasLength(adresseDto.getAdresse1())){
            errors.add("Veuillez saisir L'adresse 1");
        }
        if(!StringUtils.hasLength(adresseDto.getAdresse2())){
            errors.add("Veuillez saisir L'adresse 2");
        }
        if(!StringUtils.hasLength(adresseDto.getVille())){
            errors.add("Veuillez saisir La ville");
        }
        if(!StringUtils.hasLength(adresseDto.getCodePostale())){
            errors.add("Veuillez saisir Le code postal");
        }
        if(!StringUtils.hasLength(adresseDto.getPays())){
            errors.add("Veuillez saisir Le pays");
        }
       return errors;
    }
}
