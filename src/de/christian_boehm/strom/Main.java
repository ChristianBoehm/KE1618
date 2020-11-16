package de.christian_boehm.strom;

import java.io.IOException;

public class Main {
   public static void main(String[] args) throws IOException {
     String s = new String("f\u00DF\u00D6");

     CharEingabeStrom cs;
     cs = new StringLeser( s );
     //cs = new UmlautSzFilter( cs );
     cs = new GrossBuchstabenFilter( cs );
     cs = new UmlautSzFilter(cs);

     int z = cs.read();
     while(z != -1) {
       System.out.print((char)z);
       z = cs.read();
     }
     System.out.println("");   
   }
}