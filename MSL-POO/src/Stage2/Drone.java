package Stage2;

public class Drone {
   public Drone () {
      state = State.LANDED;
      x = 0.0f;
      y = 0.0f;
      h = 0.0f;
      direction = 0.0f;  //apuntando el eje y como adelante
   }
   static {
      MAX_F_SPEED = MAX_S_SPEED = 5; // [m/s]
      MAX_V_SPEED = 2;    // [m/s]
      MAX_R_SPEED = 0.39f; // [rad/s] Aproximacion pi/8
      TAKEOFF_LANDING_SPEED = 1; // [m/s]
   }
   public void takeAction(float t){
      float delta_t = t-time;
	      switch (state) {
	        case TAKING_OFF:  //drone moves only upwards in this stage
	          if(t>0){
			h+=0.1; //velocidad de subida definida es
			h = calc_h(h); 
		  }
		  if(h>=1.0){
	                state = State.FLYING;
		  }		  
	          break;				
	      case FLYING:
		    if(h>0.0){
			    //System.out.println(MAX_R_SPEED);
			    //System.out.println(rSpeed*delta_t);		
			    direction = direction + (rSpeed*delta_t);
		            //System.out.println("soy el angulo:" + direction);

			    h = ((h + (vSpeed*delta_t)));
                            h = calc_h(h);
			    x = calc_x(sSpeed, fSpeed, direction);
			    //System.out.println("soy el x:" + x);
			    y = calc_y(sSpeed, fSpeed, direction);
			    //System.out.println("soy el y:" + y);	
		     }
          		break;
			
	      case LANDING: //drone moves only downwards in this stage
	      	if(h>0){
		      h-=0.1;
		      h = calc_h(h);
		      if(h<0.0 && h>0.0){
		      System.out.println("Aterrizaje completado");
            		}
		}
		break;  
		// to be coded
	      }
	      time = t;
	   }
	   public void setRotationSpeed(float percentage) {
	      rSpeed = percentage * MAX_R_SPEED;
        //System.out.println("rspeed " + rSpeed);
	   }
	   public void setFlySpeed(float verPer, float forwPer, float sidePer) {
	      	vSpeed = verPer * MAX_V_SPEED;
        	fSpeed = forwPer * MAX_F_SPEED;
        	sSpeed = sidePer * MAX_S_SPEED;
	   }
	   public float getHeight(){
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
	   public State getState(){
		return state;
	   }
	   public static float calc_x(float sspe, float fspe, float ang){
		  double calcx;
		  calcx = (((sspe*0.1)*Math.cos(ang))-((fspe*0.1)*Math.sin(ang)))*Math.pow(10,2);
		  calcx = Math.round(calcx);
		  calcx = calcx/Math.pow(10,2);
		  float resultx = (float)calcx;
		  return resultx;
	   }
    public static float calc_y(float sspe, float fspe, float ang){
		  double calcy;
		  calcy = (((fspe*0.1)*Math.cos(ang))-((sspe*0.1)*Math.sin(ang)))*Math.pow(10,2);
		  calcy = Math.round(calcy);
		  calcy = calcy/Math.pow(10,2);
		  float resulty = (float)calcy;
		  return resulty;
	   }
   public static float calc_h(float alt){
		double calch;
		calch = alt*Math.pow(10,2);
		calch = Math.round(calch);
		calch = calch/Math.pow(10,2);
		float fh = (float)calch;
		return fh;
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

