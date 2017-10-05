package QD;

public class Triangle {
	public static void main(String[] args){
		new Triangle();
	}
	
	public Triangle(){
		int[] triangle = {0,1,0,1,0,1,0,1,0,1};
		
		System.out.println(triangle[0]);
		for(int i=1; i<3; i++)
			System.out.print(triangle[i]);
		System.out.println();
		for(int i=3; i<6; i++)
			System.out.print(triangle[i]);
		System.out.println();
		for(int i=6; i<10; i++)
			System.out.print(triangle[i]);
		System.out.println();
		
		int[] triangle1 ={0,2,1,0,2,1,0,1,2,0,1,0,1,2};
		
		for(int printThis : triangle1)
			if(printThis>1)
				System.out.println();
			else
				System.out.print(printThis);
		
		boolean printThis=false;
		int k;
		for(int i=1; i<=10; i++){
			k=i-1;
			for(int j=1; j<=(i+k); j++)
				if(printThis){
					System.out.print(1);
					printThis=false;
				}
				else{
					System.out.print(0);
					printThis=true;
				}
			System.out.println();
		}
	}
}
