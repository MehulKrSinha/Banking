
public class Test {
	public static void main(String[] args) {
		
		Rose rose = new Rose(); //tight coupling
		rose.flowering(); 
		
		Flower f1 = Garden.getFlower(); //loose coupling
		f1.flowering(); //still the default is Rose
		
		Flower f2 = Garden.getFlower("prayer"); //proper loose coupling
		f2.flowering();
		
	}
}
class Garden {
	static Flower getFlower () {
		return new Rose(); //default
	}
	
	static Flower getFlower (String hint) {
		Flower fl = null;
		if(hint.equals("valentine")) 
			fl = new Rose();
		else if(hint.equalsIgnoreCase("decorate")) 
			fl = new Lily();
		else if(hint.equalsIgnoreCase("prayer")) 
			fl = new Lotus();
		
		return fl;
	}
}
abstract class Flower
{
	abstract void flowering();
}
class Rose extends Flower {
	void flowering() {
		System.out.println("Rose is flowering...");
	}
}
class Lily extends Flower {
	void flowering() {
		System.out.println("Lily is flowering...");
	}
}
class Lotus extends Flower {
	void flowering() {
		System.out.println("Lotus is flowering...");
	}
}