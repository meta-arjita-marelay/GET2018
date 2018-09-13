package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (c) 2018 Metacube.com. All rights reserved. This is the Text Editor
 * class.
 * 
 * @author Arjita
 *
 */
public class TextEditor {
	@Autowired
	private SpellChecker spellChecker;

	// a setter method to return spellChecker
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	// a getter method to return spellChecker

	public void spellCheck() {
		spellChecker.checkStatus();
	}
}
