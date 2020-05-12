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
	      if (time > t) {
	    	  while(inFile.hasNextLine()) {
	    		  l_Joystick.setVerPos(1);
	    		  l_Joystick.setHorPos(1);
	    		  r_Joystick.setVerPos(1);
	    		  r_Joystick.setHorPos(1);
	    	  }
	       }
	      return true;
	   }
	   private float t;
	   private Scanner inFile;
	   private Joystick l_Joystick, r_Joystick;
}
