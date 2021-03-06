package org.interlis2.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;


public class ValidatorTest {

	@Test
	public void itfOk() {
		boolean ret=Validator.runValidation("test/data/Beispiel1a.itf", null);
		assertTrue(ret);
	}
	@Test
	public void itfOkWithSettings() {
		Settings settings=new Settings();
		settings.setValue(Validator.SETTING_ILIDIRS, Validator.ITF_DIR);
		boolean ret=Validator.runValidation("test/data/Beispiel1a.itf", settings);
		assertTrue(ret);
	}
	@Test
	public void itfFail() {
		boolean ret=Validator.runValidation("test/data/Beispiel1b.itf", null);
		assertFalse(ret);
	}
	@Test
	public void itfFailWithSettings() {
		Settings settings=new Settings();
		settings.setValue(Validator.SETTING_ILIDIRS, Validator.ITF_DIR);
		boolean ret=Validator.runValidation("test/data/Beispiel1b.itf", settings);
		assertFalse(ret);
	}
	@Test
	public void itfAreaBasicOk() {
		boolean ret=Validator.runValidation("test/data/Beispiel1c.itf", null);
		assertTrue(ret);
	}
	@Test
	public void itfAreaOpenFail() {
		boolean ret=Validator.runValidation("test/data/Beispiel1d.itf", null);
		assertFalse(ret);
	}
	@Test
	public void xtfOk() {
		boolean ret=Validator.runValidation("test/data/Beispiel2a.xtf", null);
		assertTrue(ret);
	}
	@Test
	public void xtfOkWithSettings() {
		Settings settings=new Settings();
		settings.setValue(Validator.SETTING_ILIDIRS, Validator.ITF_DIR);
		boolean ret=Validator.runValidation("test/data/Beispiel2a.xtf", settings);
		assertTrue(ret);
	}
	@Test
	public void xtfFail() {
		boolean ret=Validator.runValidation("test/data/Beispiel2b.xtf", null);
		assertFalse(ret);
	}
	@Test
	public void xtfFailWithSettings() {
		Settings settings=new Settings();
		settings.setValue(Validator.SETTING_ILIDIRS, Validator.ITF_DIR);
		boolean ret=Validator.runValidation("test/data/Beispiel2b.xtf", settings);
		assertFalse(ret);
	}
	@Test
	public void xtfAreaBasicOk() {
		boolean ret=Validator.runValidation("test/data/Beispiel2c.xtf", null);
		assertTrue(ret);
	}
	@Test
	public void xtfAreaOpenFail() {
		boolean ret=Validator.runValidation("test/data/Beispiel2d.xtf", null);
		assertFalse(ret);
	}
	@Test
	public void ili2cFail() {
		Settings settings=new Settings();
		settings.setValue(Validator.SETTING_ILIDIRS, "emptyFolder"); // ili2c will not find any ili files there
		boolean ret=Validator.runValidation("test/data/Beispiel2a.xtf", settings);
		assertFalse(ret);
	}

}
