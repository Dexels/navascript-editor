package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.ArrayList;
import java.util.List;

public class ProxyFunctionDefinition {

	private String name;
	private String description;
	private List<String> input = new ArrayList<>();
	private String result;
	
	public ProxyFunctionDefinition(String name, String description, String inputParameters, String result) {
		String [] altInputs = inputParameters.split("\\|");
		for ( String alt : altInputs ) {
			input.add(alt);
		}
		this.name = name;
		this.description = description;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getInput() {
		return input;
	}

	public String getResult() {
		return result;
	}
	
	public static void main(String [] args) {
		String input = "string, string, any, string, any";
		ProxyFunctionDefinition pfd = new ProxyFunctionDefinition("Aap", "", input, "any");
		System.err.println("input: " + pfd.getInput());
	}
}
