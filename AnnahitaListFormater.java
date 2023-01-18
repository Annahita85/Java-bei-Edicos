package de.edicos.azubi.aufgabe1;

import java.util.List;
//import java.nio.file.FileSystems;
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;

public class AnnahitaListFormater implements IListFormater {

	private String separator;

	public AnnahitaListFormater() {
		super();
	}

	@Override
	public String asCommaSeparatedList(List<String> list) {

		String result = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				result = result + list.get(i);
			} else {
				result = result + list.get(i) + ", ";
			}
		}
		return result;
	}

	@Override
	public String asSeparatedList(List<String> list) {

		String result = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				result = result + list.get(i);
			} else {
				result = result + list.get(i) + this.getSeparator();
			}
		}
		return result;

	}

	@Override
	public String asSeparatedList(List<String> list, String separator) {
		StringBuilder builder = new StringBuilder();
		for (String s : list) {
			builder.append(s);
			builder.append(separator);
		}
		String result = builder.toString();
		if (result.endsWith(separator)) {
			result = result.substring(0, result.length() - separator.length());
		}
		return result;
	}


	public String asSeparatedList(List<String> list, String separator, String lastSeparator) {
//		StringBuilder builder = new StringBuilder();
//		for (String s : list) {
//			builder.append(s);
//			builder.append(separator);
//		}
//		
//		String result = builder.toString();
//		if (result.endsWith(separator)) {
//			result = result.substring(0, result.length() - separator.length());
//		}
//		
//		if (result.contains(separator)) {
//			int lastIndexOfSeparator = result.lastIndexOf(separator);
//			result = result.substring(0, lastIndexOfSeparator) + lastSeparator
//					+ result.substring(lastIndexOfSeparator + separator.length(), result.length());
//		}
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				result = result + list.get(i);
			} else if (i == list.size() - 2) {
				result = result + list.get(i) + lastSeparator;
			} else {
				result = result + list.get(i) + separator;
			}
		}
		
		return result;
	}

	@Override
	public String asTabSeparatedList(List<String> list) {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				result = result + list.get(i);
			} else {
				result = result + list.get(i) + "\t";
			}
		}
		return result;
	}

	@Override
	public String getSeparator() {
		return separator;
	}

	@Override
	public void setSeparator(String separator) throws NullPointerException {
		if (separator == null) {
			throw new NullPointerException("separator kann nicht null sein");
		}
		this.separator = separator;
	}
}
