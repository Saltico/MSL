import java.util.Scanner;

public class Operator {
	public Operator (Scanner in, SkyController skyController){
	      inFile = in;
	      l_Joystick = skyController.getLeftStick();
	      r_Joystick = skyController.getRightStick();
	      inFile.nextLine(); // skip description line
	      t = inFile.nextFloat();

	   }
	   public boolean takeAction(float time){
		 	float f;
			if(time == 0.0){
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
	   	else if(((Math.round(time*10))/10.0) >= t) {
				if(inFile.hasNextFloat()){
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
						t+=1.0;
					}
	 	 	}
			else{
				return false;
			}
	 	}
	 return true;
 	}
	  private float t;
	  private Scanner inFile;
	  private Joystick l_Joystick, r_Joystick;

}
