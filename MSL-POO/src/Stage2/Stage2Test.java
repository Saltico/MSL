import java.io.*;
import java.util.Scanner;
import java.util.Locale;
import java.lang.Math.*;

public class Stage2Test  {
   public static void main (String[] arg) throws IOException {
      Locale.setDefault(Locale.US);  // to read number in US format, like 1.5 (not like 1,5)
      Scanner in = new Scanner(new File(arg[0]));
      float time = 0;
      Drone drone = new Drone();
      SkyController skyController = new SkyController(drone);
      Operator operator = new Operator(in, skyController);
      skyController.pushTakeOff_Land(); // to take-off
      while(operator.takeAction(time)) {
         skyController.takeAction(time);
         drone.takeAction(time);
         System.out.println(((Math.round(time*10))/10.0)+ ",\t"+drone);
         time+=0.1;
      }
      skyController.pushTakeOff_Land(); // to land
      while (drone.getHeight() >=0) {
         drone.takeAction(time);
         System.out.println(((Math.round(time*10))/10.0)+ ",\t"+drone);
         time+=0.1;
      }
   }
}
