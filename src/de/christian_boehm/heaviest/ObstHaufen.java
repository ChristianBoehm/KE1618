package de.christian_boehm.heaviest;

public class ObstHaufen {

	public static void main(String[] args) {
		Apple kleinerApple = new Apple(50);
		Apple mittlererApple = new Apple(100);
		Apple grosserApple = new Apple(200);
		
		Pear kleinePear = new Pear(22);
		Pear mittlerePear = new Pear(58.02);
		Pear grossePear = new Pear(155.78);
		
		switch (grossePear.compareTo(grosserApple)) {
		case 1:
			System.out.println("ich bin groesser");
			break;
		case -1:
			System.out.println("ich bin kleiner oder gleich");
			break;
		default:
			System.out.println("Gewicht nicht ermittelbar");
			break;
		}
		
		
		MaximumContainer<Obst> meineObstStiege = new MaximumContainer<Obst>();
		meineObstStiege.store(kleinerApple);
		meineObstStiege.store(mittlererApple);
		meineObstStiege.store(grosserApple);
		meineObstStiege.store(kleinePear);
		meineObstStiege.store(mittlerePear);
		System.out.println("das schwerste Stueck Obst in der Stiege ist ein " + meineObstStiege.getHeaviest().getClass().getSimpleName()
				+ " und wiegt " + meineObstStiege.getHeaviest().getWeight() + " g!");
	}

}
