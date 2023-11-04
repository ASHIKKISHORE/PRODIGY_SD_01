package com.prodigy.ak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodigy.ak.entity.TemparatureConversion;

@RestController
@RequestMapping("/temperature")
public class TemperatureConversionController {

    @GetMapping("/convert")
    public TemparatureConversion convertTemperature(
            @RequestParam("value") double value,
            @RequestParam("from") String from,
            @RequestParam("to") String to
    ) {
        double result = 0;

        if (from.equalsIgnoreCase("celsius") && to.equalsIgnoreCase("fahrenheit")) {
            result = (value * 9/5) + 32;
        } else if (from.equalsIgnoreCase("celsius") && to.equalsIgnoreCase("kelvin")) {
            result = value + 273.15;
        } else if (from.equalsIgnoreCase("fahrenheit") && to.equalsIgnoreCase("celsius")) {
            result = (value - 32) * 5/9;
        } else if (from.equalsIgnoreCase("fahrenheit") && to.equalsIgnoreCase("kelvin")) {
            double celsius = (value - 32) * 5/9;
            result = celsius + 273.15;
        } else if (from.equalsIgnoreCase("kelvin") && to.equalsIgnoreCase("celsius")) {
            result = value - 273.15;
        } else if (from.equalsIgnoreCase("kelvin") && to.equalsIgnoreCase("fahrenheit")) {
            double celsius = value - 273.15;
            result = (celsius * 9/5) + 32;
        } else {
            throw new IllegalArgumentException("Invalid units for temperature conversion.");
        }

        return new TemparatureConversion(value, from, result, to);
    }
}
