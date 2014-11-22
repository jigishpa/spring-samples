package com.senyume.taskmaster.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jigish
 */

@JsonAutoDetect
public class ErrorsList {

    private List<Error> errors = new ArrayList<Error>();

    public void addFieldError(String code, String field, String message){
        Error error = new Error();
        error.setCode(code);
        error.setField(field);
        error.setMessage(message);

        errors.add(error);
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
