public class Joystick {
	public Joystick () {
	      vf=0.0f;
	      hf=0.0f;
	   }
	   public void setVerPos(float f){
		this.vf = f;
	   }
	   public void setHorPos(float f){
		this.hf = f;
	   }
	   public float getVerPos() {
	     return vf;
	   }
	   public float getHorPos() {
	      return hf;
	   }
	   public String toString() {
	      return hf+","+vf;
	   }
	   private float vf, hf;
}
