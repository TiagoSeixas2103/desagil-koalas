package br.edu.insper.desagil.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
	private Map<String, List<Double>> columns;

	public DataFrame() {
		this.columns = new HashMap<>();
	}

	public void addColumn(String label, List<Double> values) {
		this.columns.put(label, new ArrayList<>(values));
	}
	
	public void operation(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}
		
		double min = Double.POSITIVE_INFINITY;
		for (double value: values) {
			if (min > value) {
				min = value;
			}
		}
		
		double max = Double.NEGATIVE_INFINITY;
		for (double value: values) {
			if (max < value) {
				max = value;
			}
		}
		
		double s = 0;
		for (double value: values) {
			s += value;
		}
		
		double avg = s / values.size();
		

		double s2 = 0;
		
		for (double value: values) {
			s2 += Math.pow(value - avg, 2);
		}
		
		double var = s2 / values.size();
		
		double std = Math.sqrt(var);

		
	}
	
}
