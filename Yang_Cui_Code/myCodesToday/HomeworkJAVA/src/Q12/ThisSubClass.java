package Q12;

public class ThisSubClass extends ThisSuperClass{

	@Override
	public boolean checkCaps(String str) {
		// TODO Auto-generated method stub
		boolean checkCaps=false;
		char[] charArray = str.toCharArray();
		for(char testChar : charArray)
			checkCaps=Character.isUpperCase(testChar);
		return checkCaps;
	}

	@Override
	public String makeCap(String str) {
		// TODO Auto-generated method stub
		char[] charArray = str.toCharArray();
		char[] capsArray =  new char[charArray.length];
		for(int i=0; i<charArray.length; i++)
			capsArray[i]=Character.toUpperCase(charArray[i]);
		String caps = String.valueOf(capsArray);
		return caps;
	}

	@Override
	public int makeIntAdd(String str) {
		// TODO Auto-generated method stub
		int num=0;
		try{
			num = Integer.parseInt(str);
		}catch (NumberFormatException nfe){
			System.out.println("string must be number");
		}
		return num+10;
	}
}
