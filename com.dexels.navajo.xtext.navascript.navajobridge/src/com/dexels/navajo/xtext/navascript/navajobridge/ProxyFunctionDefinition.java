package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProxyFunctionDefinition {

	private String name;
	private String description;
	private List<String> input = new ArrayList<>();
	private Set<Integer> validInputSizes = new HashSet<>();
	private String result;

	public ProxyFunctionDefinition(String name, String description, String inputParameters, String result) {
		String[] altInputs = inputParameters.split(",");
		int emptyArg = 0;
		boolean anyArg = false;
		for (String alt : altInputs) {
			if (alt != null && !alt.trim().equals("")) {
				input.add(alt);
				if (alt.contains("..")) {
					anyArg = true;
				}
				if ( alt.contains("empty")) {
					emptyArg++;
				}
			}
		}
		if (!anyArg) {
			validInputSizes.add(altInputs.length);
			while ( emptyArg != 0 ) {
				validInputSizes.add(altInputs.length - emptyArg);
				emptyArg--;
			}
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

	public boolean isValidNrInputParameters(int inputSize) {
		return validInputSizes.isEmpty() || validInputSizes.contains(inputSize);
	}

	public static void main(String[] args) {
		String input = "string, string, any, string, any|empty";
		ProxyFunctionDefinition pfd = new ProxyFunctionDefinition("Aap", "", input, "any");
		System.err.println("input: " + pfd.getInput());
		System.err.println("5: -> " + pfd.isValidNrInputParameters(5));
		System.err.println("4: -> " + pfd.isValidNrInputParameters(4));
		System.err.println("6: -> " + pfd.isValidNrInputParameters(6));
		
		input = "string, string, any, string, any|empty, ...";
		pfd = new ProxyFunctionDefinition("Aap", "", input, "any");
		System.err.println("input: " + pfd.getInput());
		System.err.println("5: -> " + pfd.isValidNrInputParameters(5));
		System.err.println("4: -> " + pfd.isValidNrInputParameters(4));
		System.err.println("6: -> " + pfd.isValidNrInputParameters(6));
	}
}
