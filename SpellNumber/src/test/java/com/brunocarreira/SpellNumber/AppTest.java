package com.brunocarreira.SpellNumber;

import junit.framework.TestCase;

/**
 * Unit test for App
 */
public class AppTest 
    extends TestCase
{

    /**
     * JUnit test for SpellNumber domain class
     */
    public void testApp()
    {
    	SpellNumber spellNumber = new SpellNumber();

    	assertEquals("forty-five", spellNumber.spellItOut(45));
    	assertEquals("four thousand eight hundred ninety-five", spellNumber.spellItOut(4895));
    	assertEquals("six million eight hundred ninety-five thousand four hundred twelve", spellNumber.spellItOut(6895412));
    	
    }
}
