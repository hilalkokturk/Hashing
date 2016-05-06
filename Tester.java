//----------------------------------------------------- 
// Title: Tester Class
// Author: Hilal Köktürk
// ID: 49093709988 
// Section: 1 
// Assignment: 1 
// Description: This class is the tester class of hash table class.
//----------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {

		int count = 1; // count begin from 1.

		HashTable ht = new HashTable(); // create an hash table object.

		File file = new File("C:\\Users\\Lilo\\Downloads\\twitter.txt");// The
																		// name
																		// of
																		// the
																		// file
																		// to
																		// open.
		try {

			FileReader inputFile = new FileReader(file); // FileReader reads
															// text files in the
															// default encoding.

			BufferedReader bufferReader = new BufferedReader(inputFile); // Always
																			// wrap
																			// FileReader
																			// in
																			// BufferedReader.

			String line; // This will reference one line at a time

			while ((line = bufferReader.readLine()) != null) {
				String[] items = line.split(" ");

				for (int i = 0; i < items.length; i++) { // if string begin with
															// '#' , we throw
															// into the
															// hashtable.
					if (!items[i].equals("")) {
						if (items[i].substring(0, 1).equals("#")) {
							ht.put(items[i].toLowerCase());// also make all of
															// elements of file
															// which begin with
															// '#' and we make
															// them lower
															// character.
						}
					}

				}

			}
			bufferReader.close(); // Always close files.

		} catch (Exception e) { // catch the error message
			System.out.println("Error while reading file line by line: "
					+ e.getMessage());
		}

		ht.find(); // find the top 10.

	}

}