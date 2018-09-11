package com.github.emi_silva.debo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Properties;
import java.util.ArrayList;

public class ModelTest extends TestCase {

    private Model model;
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ModelTest( String testName ) {
        super(testName);	
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ModelTest.class);
    }

    /**
     * Checks the database is initialized correctly
     */
    public void testModel() {
	model = new Model();
        assertNotNull(model.conn);
    }

    /**
     * Checks properties are read
     */
    public void testReadProps() {
	model = new Model();
	Properties props = model.readProps("/db.properties");
	String schema = props.getProperty("currentSchema");
	assertEquals(schema, "debo");
    }

    /**
     * Checks currency types are returned correctly
     */
    public void testGetCurrencyTypes() {
	model = new Model();
	ArrayList<Model.CurrencyType> cts = model.getCurrencyTypes();
	for(Model.CurrencyType ct : cts) {
	    System.out.println(ct);
	}
    }

    /**
     * Checks an id is found for an existing currency type name
     */
    public void testFindCurrencyType() throws Exception {
	model = new Model();
	assertEquals(model.findCurrencyType("fiat"), 1);
    }

}
