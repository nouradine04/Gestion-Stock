package com.nouradine.springgestion.Validator;

import com.nouradine.springgestion.Dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {


    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors =new ArrayList<>();
        if(categoryDto==null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("veuillez saisir le code ");
        }

        return errors;
    }
}
