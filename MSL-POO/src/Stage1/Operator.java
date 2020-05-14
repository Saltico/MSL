package Stage1;
import java.util.Scanner;

public class Operator {
	public Operator (Scanner in, Joystick l_Joy, Joystick r_Joy){
	      inFile = in;
	      l_Joystick = l_Joy;
	      r_Joystick = r_Joy;
	      inFile.nextLine(); // skip description line
	      t = inFile.nextFloat();
	      
	   }
	   public boolean takeAction(float time){	
	      //float f;
	      if (time > t) {		//o no????????????????????????
	    	  	String line = inFile.nextLine(); //creo que hay que usar scanner de nuevo
	    	  	String[] data = line.split("  ");
		    	t = Integer.parseInt(data[0]);// o ya esta definida arriba? 	 
	    	    l_Joystick.setVerPos(Float.parseFloat(data[1])); //Integer.parseInt o solo parseInt?
	    	    l_Joystick.setHorPos(Float.parseFloat(data[2]));
	    	    r_Joystick.setVerPos(Float.parseFloat(data[3]));
	    	    r_Joystick.setHorPos(Float.parseFloat(data[4]));
	    	 }
	      return true;
	   }
	   private float t;
	   private Scanner inFile;
	   private Joystick l_Joystick, r_Joystick;
}
