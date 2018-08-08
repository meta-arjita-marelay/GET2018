package commandPrompt;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * Directory contains details of directories in tree
 * 
 * @author Arjita
 *
 */
public class Directory {

	private final String name;// name of directory
	private final Date dateOfCreation;// date in which directory is created
	private List<Directory> listOfSubDirectory;// list of subdirectories present
												// in directory

	/**
	 * constructor of class
	 * 
	 * @param name
	 *            name of director
	 * @param dateOfCreation
	 *            date of creation of directory
	 */
	public Directory(String name, Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
		this.name = name;
		this.listOfSubDirectory = new ArrayList<Directory>();
	}

	public List<Directory> getListOfSubDirectory() {
		return listOfSubDirectory;
	}

	public void setListOfSubDirectory(List<Directory> listOfSubDirectory) {
		this.listOfSubDirectory = listOfSubDirectory;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

}
