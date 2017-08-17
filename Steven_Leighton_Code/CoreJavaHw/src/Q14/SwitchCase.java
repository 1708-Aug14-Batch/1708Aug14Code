package Q14;

import java.util.Date;

public class SwitchCase {

	public static void main(String[] args) {
		for(int i = 1; i <=3; i++){
			switch(i){
				case 1: System.out.println("Sqrt of 169 is: " + Math.sqrt(169));
					break;
				case 2: Date d = new Date();
						System.out.println(d.toString());
					break;
				case 3: String s = "I am learning Core Java";
						String[] split = s.split(" ");
						for (int j = 0; j < split.length; j++) {
							System.out.println("Index " + j + ": " + split[j]);
						}
					break;
			}
		}
	}
}
