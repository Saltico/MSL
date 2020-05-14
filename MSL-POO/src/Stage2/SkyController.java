package Stage2;

public class SkyController {
	   public SkyController (Drone drone) {
	      this.drone = drone;
	      // to be coded
	   }
	   public Joystick getLeftStick(){
	      return lStick;
	   }
	   public Joystick getRightStick(){
	      return rStick;
	   }
	   public void pushTakeOff_Land () {
	      // to be coded
	   }
	   public void takeAction(float time) {
	      // to be coded
	   }
	   private Drone drone;
	   private Joystick lStick, rStick;
	   private State button;
	}
