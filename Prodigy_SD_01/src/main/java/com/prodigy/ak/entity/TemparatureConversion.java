package com.prodigy.ak.entity;

import lombok.Getter;

@Getter
public class TemparatureConversion {
	private double value;
	private String from;
	private double result;
	private String to;

	public TemparatureConversion(double value, String from, double result, String to) {
        this.value = value;
        this.from = from;
        this.result = result;
        this.to = to;
    }
}
