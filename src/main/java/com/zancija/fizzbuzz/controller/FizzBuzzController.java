package com.zancija.fizzbuzz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zancija.fizzbuzz.data.FizzBuzzError;
import com.zancija.fizzbuzz.data.FizzBuzzRequest;
import com.zancija.fizzbuzz.data.FizzBuzzResponse;
import com.zancija.fizzbuzz.service.FizzBuzzService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzController {

    private static final Logger logger = LogManager.getLogger(FizzBuzzController.class);

    @Autowired
    private FizzBuzzService service;

    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.POST)
    @ResponseBody
    public FizzBuzzResponse playGame(@RequestBody FizzBuzzRequest request) {
        return new FizzBuzzResponse(service.playGame(request.getNumbers()));
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            JsonProcessingException.class
    })
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public FizzBuzzError invalidInputException(Exception ex) {
        logger.warn(ex);
        return new FizzBuzzError(ex.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public FizzBuzzError exception(Exception ex) {
        logger.error(ex);
        return new FizzBuzzError("Internal server error");
    }
}
