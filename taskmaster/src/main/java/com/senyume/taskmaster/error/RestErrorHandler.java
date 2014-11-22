package com.senyume.taskmaster.error;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * @author jigish
 */

// following @ControllerAdvice annotation is used to define @ExceptionHandler, @InitBinder, and @ModelAttribute methods
// that apply to ALL @RequestMapping methods
// if we define our @ExceptionHandler annotation on method in @ControllerAdvice class, it will be applied to all the controllers

@ControllerAdvice
public class RestErrorHandler {

    private static Logger logger = Logger.getLogger(RestErrorHandler.class);

    @Autowired
    private MessageSource messageSource;

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorsList processErrors(MethodArgumentNotValidException ex){
//        logger.info("error handler invoked ...");
//        BindingResult result = ex.getBindingResult();
//        List<FieldError> fieldErrorList = result.getFieldErrors();
//
//        ErrorsList errorsList = new ErrorsList();
//        for(FieldError fieldError: fieldErrorList){
//            String code = fieldError.getCode();
//            String field = fieldError.getField();
//            Locale currentLocale = LocaleContextHolder.getLocale();
//            String errorMessage = messageSource.getMessage(fieldError, currentLocale);
//
//            logger.info("adding error message - " + errorMessage + " - to errorsList");
//            errorsList.addFieldError(code, field, errorMessage);
//        }
//
//        return errorsList;
//    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsList processBindExceptions(BindException ex){
        logger.info("bind exception error handler invoked ...");
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        ErrorsList errorsList = new ErrorsList();
        for(FieldError fieldError: fieldErrorList){
            String code = fieldError.getCode();
            String field = fieldError.getField();
            Locale currentLocale = LocaleContextHolder.getLocale();
            String errorMessage = messageSource.getMessage(fieldError, currentLocale);

            logger.info("adding error message - " + errorMessage + " - to errorsList");
            errorsList.addFieldError(code, field, errorMessage);
        }

        return errorsList;
    }

}
