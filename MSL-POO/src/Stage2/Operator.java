import java.util.Scanner;

public class Operator {
	public Operator (Scanner in, SkyController skyController){  	//Operator recibe el archivo csv entregado
	      inFile = in;
	      l_Joystick = skyController.getLeftStick();		//Se le asigna a left joystick el stick izquierdo del skyController
	      r_Joystick = skyController.getRightStick();
	      inFile.nextLine(); // skip description line	
	      t = inFile.nextFloat();					//Con el nextFloat se lee el siguiente flotante

	   }
	   public boolean takeAction(float time){
		 	float f;
			if(time == 0){					//Toma la primera linea de datos para cuando el dron comience a funcionar
				f = inFile.nextFloat();
				l_Joystick.setHorPos(f);		//Luego con el set se fijan las variables horizontales y verticales 
				f = inFile.nextFloat();
	    			l_Joystick.setVerPos(f);
				f = inFile.nextFloat();
	    			r_Joystick.setHorPos(f);
				f = inFile.nextFloat();
	    			r_Joystick.setVerPos(f);
				t = inFile.nextFloat();
			}
	   	else if(((Math.round(time*10))/10.0) >= t) {		//Se usa el redondeo para poder tener el tiempo con un digito de decimal
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
