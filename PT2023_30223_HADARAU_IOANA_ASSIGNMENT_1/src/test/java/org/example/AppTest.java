package org.example;
import DataModel.Polinom;
import Operatii.Op;
import jdk.jfr.StackTrace;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{
    Polinom p1=new Polinom("5x^3+2x^2+x+2");
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
    public void testApp_Adunare()    {
        String rezultat_adunare="4.0\n+2.0x\n+4.0x^2\n+8.0x^3\n";
         String ad=operatie.Adunare();
        assertEquals(ad,rezultat_adunare);
    }
    public void testApp_Scadere()
    {
        String rezultat_scadere="2.0x^3\n";
        String sub=operatie.Scadere();
        assertEquals(sub,rezultat_scadere);

    }
    public void testApp_Derivare()
    {
        String rezultat_derivare="1.0\n+15.0x^2\n+4.0x\n";
        String ad=operatie.Derivare();
        assertEquals(ad,rezultat_derivare);
    }
    public void testApp_Integrare()
    {
        String rezultat_integrare="x^2\n+1.66x^4\n+x^3\n";
        String ad=operatie.Integrare();
        assertEquals(ad,rezultat_integrare);
    }
}
