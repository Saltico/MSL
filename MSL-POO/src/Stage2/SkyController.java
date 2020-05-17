
public class SkyController {
	   public SkyController (Drone drone) {
	      this.drone = drone;		//Hace referencia al objeto actual de la clase
	      this.button = this.drone.getState();
      	      lStick = new Joystick();
              rStick = new Joystick();
	   }
	   public Joystick getLeftStick(){
	      return lStick;
	   }
	   public Joystick getRightStick(){
	      return rStick;
	   }
	   public void pushTakeOff_Land () {
      	   	if(this.drone.getHeight() == 0){	//Cuando la altura sea 0 y se inicia el takeoff significa que empezará su movimiento.
        		this.drone.takeOff();
      	   	}
      		else{
        		this.drone.land();		//La altura es distinta a 0 y le indica que debe comenzar el aterrizaje
      		}
   	   }
	   public void takeAction(float time) {
			 float verPer = (Math.abs(lStick.getVerPos()));
			 float percentage = Math.abs(lStick.getHorPos());
			 float forwPer = Math.abs(rStick.getVerPos());
			 float sidePer = Math.abs(rStick.getHorPos());
			 this.drone.setRotationSpeed(percentage);
       this.drone.setFlySpeed(verPer,forwPer,sidePer);
	   }
	   private Drone drone;
	   private Joystick lStick, rStick;
	   private State button;
	}
