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
	      float f;
	      while(inFile.hasNextLine()) {		   
	         if (time > t) {
	    	    String line = inFile.nextLine(); //creo que hay que usar scanner de nuevo
		    String[] data = line.split("  ");
		    t = data[0] 	 
	    	    l_Joystick.setVerPos(data[1]); //hay que pasarlos a int?
	    	    l_Joystick.setHorPos(data[2]);
	    	    r_Joystick.setVerPos(data[3]);
	    	    r_Joystick.setHorPos(data[4]);
	    	 }
	      }
	      inFile.close(); 
	      return true;
	   }
	   private float t;
	   private Scanner inFile;
	   private Joystick l_Joystick, r_Joystick;
}
