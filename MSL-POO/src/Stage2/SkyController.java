public class SkyController {
   public SkyController (Drone drone) {
      this.drone = drone;
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
      if(this.drone.getHeight() == 0){
        this.drone.takeOff();
      }
      else{
        this.drone.land();
      }
   }
   public void takeAction(float time) {
      float percentage,verPer,forwPer,sidePer;
      percentage = lStick.getHorPos();
      verPer = lStick.getVerPos();
      forwPer = rStick.getHorPos();
      sidePer = rStick.getVerPos();
      this.drone.setRotationSpeed(percentage);
      this.drone.setFlySpeed(verPer,forwPer,sidePer);
   }
   private Drone drone;
   private Joystick lStick, rStick;
   private State button;
}
