package Stage2;

public class SkyController {
	   public SkyController (Drone drone) {
	      this.drone = drone;		//Hace referencia al objeto actual de la clase
	      // to be coded
	   }
	   public Joystick getLeftStick(){
	      return lStick;
	   }
	   public Joystick getRightStick(){
	      return rStick;
	   }
	   public void pushTakeOff_Land () {
      	   	if(dron.getHeight == 0){	//Cuando la altura sea 0 y se inicia el takeoff significa que empezará su movimiento.
        		dron.takeOff();
      	   	}
      		else{
        		dron.land();		//La altura es distinta a 0 y le indica que debe comenzar el aterrizaje
      		}
   	   }
	   public void takeAction(float time) {
	      // to be coded
	   }
	   private Drone drone;
	   private Joystick lStick, rStick;
	   private State button;
	}
