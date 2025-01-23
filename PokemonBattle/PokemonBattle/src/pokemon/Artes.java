package pokemon;

public class Artes {
	
	public void telaInicial() {
		String pokemon[] = new String [12];
		String battles[] = new String [6];
		
		pokemon[0] = "\t                                 ,'\\                              \n";
		pokemon[1] = "\t    _.----.        ____         ,'  \\  ___     ___     ____       \n";
		pokemon[2] = "\t_,-'       `.     |    |  /`.   \\,-'   |   \\  /   |   |    \\  |`. \n";
		pokemon[3] = "\t\\      __    \\    '.   | /   `. ___    |    \\/    |   '-.   \\ |  |\n";
		pokemon[4] = "\t \\     \\\\    | __  |   |/    /,'_  `.  |          | __  |    \\|  |\n";
		pokemon[5] = "\t  \\     \\/  /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n";
		pokemon[6] = "\t   \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n";
		pokemon[7] = "\t    \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    | |  \\_/  | |\\    |\n";
		pokemon[8] = "\t     \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n";
		pokemon[9] = "\t      \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n";
		pokemon[10]= "\t       \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n";
		pokemon[11]= "\t                               `'                            '-._|\n";
			
		battles[0] = "\t        ___.              __     __   .__                   \n";
		battles[1] = "\t        \\_ |__  _____   _/  |_ _/  |_ |  |    ____    ______\n";
		battles[2] = "\t         | __ \\ \\__  \\  \\   __\\\\   __\\|  |  _/ __ \\  /  ___/\n";
		battles[3] = "\t         | \\_\\ \\ / __ \\_ |  |   |  |  |  |__\\  ___/  \\___ \\ \n";
		battles[4] = "\t         |___  /(____  / |__|   |__|  |____/ \\___  >/____  >\n";
		battles[5] = "\t             \\/      \\/                          \\/      \\/ \n";
	
		try {
			for(int i = 0; i < 12; i ++) {
				Thread.sleep(200);
				System.out.printf("%s", pokemon[i]);
			}
		} catch (Exception e) {
					
		}
			
		try {
			for(int i = 0; i < 6; i++) {
				Thread.sleep(200);
				System.out.printf("%s", battles[i]);
			}
		} catch(Exception e) {
					
		}
		
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			
		}
	}
}