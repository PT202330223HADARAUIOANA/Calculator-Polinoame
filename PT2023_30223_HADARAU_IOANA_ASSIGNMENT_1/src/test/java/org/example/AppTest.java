package org.example;
import DataModel.Polinom;
import Operatii.Op;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    Polinom p1=new Polinom("3x^3+2x^2+x+2");
    Polinom p2=new Polinom("3x^3+2x^2+x+2");
    Op operatie=new Op(p1,p2);
   public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {

        String reztext="4.0+2.0x+4.0x^2+6.0x^3";
        Polinom rezultat_adunare1=new Polinom(reztext);
        assertEquals(operatie.Adunare(),rezultat_adunare1);
        //assertTrue( true );
    }
}
