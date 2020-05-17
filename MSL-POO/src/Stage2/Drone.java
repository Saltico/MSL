package Stage2;

public class Drone {
   public Drone () {
      state = State.LANDED;
      x = 0;
      y = 0;
      h = 0;
      direction = (float)(Math.PI/2);  //apuntando el eje y como adelante
   }
   static {
      MAX_F_SPEED = MAX_S_SPEED = 5; // [m/s]
      MAX_V_SPEED = 2;    // [m/s]
      MAX_R_SPEED = (float)(0.25*Math.PI/2); // [rad/s]
      TAKEOFF_LANDING_SPEED = 1; // [m/s]
   }
   public void takeAction(float t){
      float delta_t = t-time;
      switch (state) {
      case TAKING_OFF:  //drone moves only upwards in this stage
          while(h<1.0){
            h+=0.2;
          }
          System.out.println(h + "antes de FLYING");
          state = State.FLYING;
          break;
      case FLYING:
          while(h>0.0){
            direction = direction + (rSpeed*delta_t);
            h = h + (vSpeed*delta_t);
            y = y + (fSpeed*delta_t);
            x = x + (sSpeed*delta_t);
          }
          break;
      case LANDING: //drone moves only downwards in this stage
          while(h>0.0){
            h -= 0.2;
          }
          state = State.LANDED;
          break;
      }
      time = t;
   }
   public void setRotationSpeed(float percentage) {
      rSpeed = percentage * MAX_R_SPEED;
      System.out.println("rspeed " + rSpeed);
   }
   public void setFlySpeed(float verPer, float forwPer, float sidePer) {
      vSpeed = verPer * MAX_V_SPEED;
      fSpeed = forwPer * MAX_F_SPEED;
      sSpeed = sidePer * MAX_S_SPEED;
   }
   public float getHeight() {
      return h;
   }
   public State getState(){
     return state;
   }
   public String toString() {
      return x + ", " + y + ", " + h;
   }
   public void takeOff() {
      if (state==State.LANDED)
         state = State.TAKING_OFF;
   }
   public void land() {
      if (state==State.FLYING)
         state = State.LANDING;
   }
   private State state;
   private float time;
   private float fSpeed, vSpeed, sSpeed, rSpeed;
   private float direction; // angle
   private float x,y,h;
   private float delta_direction;
   private static float MAX_F_SPEED;
   private static float MAX_V_SPEED;
   private static float MAX_S_SPEED;
   private static float MAX_R_SPEED;
   private static float TAKEOFF_LANDING_SPEED;
}
