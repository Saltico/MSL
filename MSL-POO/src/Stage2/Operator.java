package Stage2;

import java.util.Scanner;

import Stage1.Joystick;

public class Operator {
	public Operator (Scanner in, SkyController sky){
	      inFile = in;
	      skyC = sky;
	      inFile.nextLine(); // skip description line
	      t = inFile.nextFloat();
	      
	   }
	   public boolean takeAction(float time){	
	      float f;
	      if (time > t) {		//o no????????????????????????
	    	String line = inFile.nextLine(); //creo que hay que usar scanner de nuevo
		    String[] data = line.split("  ");
		    	t = Integer.parseInt(data[0]);// o ya esta definida arriba? 	 
	    	    l_Joystick.setVerPos(Integer.parseInt(data[1])); //Integer.parseInt o solo parseInt?
	    	    l_Joystick.setHorPos(Integer.parseInt(data[2]));
	    	    r_Joystick.setVerPos(Integer.parseInt(data[3]));
	    	    r_Joystick.setHorPos(Integer.parseInt(data[4]));
	    	 }
	      return true;
	   }
	   private float t;
	   private Scanner inFile;
	   private Joystick l_Joystick, r_Joystick;
}

