package Stage1;

import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class Stage1Test {

	public static void main(String[] args) throws Exception {
	    Locale.setDefault(Locale.US);  // to read number in US format, like 1.5 (not like 1,5)
	    Scanner in = new Scanner(new File(args[0]));
	    float time = 0.0f;
	    Joystick l_Joy = new Joystick();
	    Joystick r_Joy = new Joystick();
	    Operator operator = new Operator(in, l_Joy, r_Joy);
	    while(operator.takeAction(time)) {
	         System.out.println(time + "\n"  ); //tobecoded Aca deberiamos imprimir tiempo,   jih,   jiv,   jdh,  jdv
	         time+=0.1;

	    }
	    in.close();

	}
}
