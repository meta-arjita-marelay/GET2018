package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public TextEditor textEditor(){
		TextEditor textEditor = new TextEditor(spellChecker());
		return textEditor;
	}
	
	@Bean
	public SpellChecker spellChecker(){
		return new SpellChecker(false);
	}
}
