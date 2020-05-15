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
			if(time == 0){
				f = inFile.nextFloat();
				l_Joystick.setHorPos(f);
				f = inFile.nextFloat();
	    	l_Joystick.setVerPos(f);
				f = inFile.nextFloat();
	    	r_Joystick.setHorPos(f);
				f = inFile.nextFloat();
	    	r_Joystick.setVerPos(f);
				t = inFile.nextFloat();
			}
	   	else if(time >= t) {
				f = inFile.nextFloat();
				l_Joystick.setHorPos(f);
				f = inFile.nextFloat();
	    	l_Joystick.setVerPos(f);
				f = inFile.nextFloat();
	    	r_Joystick.setHorPos(f);
				f = inFile.nextFloat();
	    	r_Joystick.setVerPos(f);
				if(inFile.hasNextFloat()){
					t=inFile.nextFloat();
				}
				/*else{
					return false;
				}*/
			}

	    return true;
	   }
	   private float t;
	   private Scanner inFile;
	   private Joystick l_Joystick, r_Joystick;
}
