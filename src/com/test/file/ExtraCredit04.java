package com.test.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Read all line of file 'input.txt', processing and output result to file:
 * output. txt
 */
public class ExtraCredit04 {
	public static void main(String args[]) {
		try {
			List<String> lstIn = Files.readAllLines(Paths.get("input.txt"));
			String lstAsString = String.join(" ", lstIn);
			System.out.println("======Result read from file:input.txt========");
			System.out.println(lstAsString);
			System.out.println("==============");
			int i = 0;
			StringBuilder fullName = new StringBuilder();
			List<String> lstOut = new LinkedList<String>();
			// Processing file with fullName = firstName + ' ' + lastName
			for (String namePart : lstAsString.split(" ")) {
				if (++i == 2) {
					i = 0;
					fullName.append(namePart);
					lstOut.add(fullName.toString());
					fullName.setLength(0);
				} else {
					fullName.append(namePart).append(" ");
				}
			}
			System.out.println("======Output to file: output.txt========");
			// Output to file
			Files.write(Paths.get("output.txt"), lstOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
