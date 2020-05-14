package Stage2;

public class Drone {
	   public Drone () {
	      // to be coded
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
	          // to be coded
	      case FLYING:
	          // to be coded
	      case LANDING: //drone moves only downwards in this stage
	          // to be coded
	      }
	      time = t;
	   }
	   public void setRotationSpeed(float percentage) {
	      // to be coded
	   }
	   public void setFlySpeed(float verPer, float forwPer, float sidePer) {
	      // to be coded
	   }
	   public float getHeight() {
	      return h;
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
	   private static float MAX_F_SPEED;
	   private static float MAX_V_SPEED;
	   private static float MAX_S_SPEED;
	   private static float MAX_R_SPEED;
	   private static float TAKEOFF_LANDING_SPEED;
	}
