package pokemon;

import java.util.Random;

public class Bulbasaur extends Pokemon implements Planta {
	
	public Bulbasaur() {
		super();
	}

	public Bulbasaur(String nome, String tipo) {
		super(nome, tipo);
	}

	@Override
	public void causarDanoNormal(Pokemon oponente) {
		int ataque;
		
		if(oponente.tipo == "Elétrico") {
			ataque = ataqueCritico(dano + 10);
		}
		else {
			ataque = ataqueCritico(dano);
		}
		
		regenerarVida(oponente);			
		
		chaparOponente(oponente);
		System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
		oponente.hp = oponente.hp - ataque;	
	}
	
	// Polimorfismo de sobrescrita para implementar a interface "Planta".
	@Override
	public void regenerarVida(Pokemon oponente) {
		Random random = new Random();
		int chanceRegenerar = random.nextInt(4);
		
		if(chanceRegenerar == 0) {
			System.out.printf("\nBulbasaur drenou 60 de HP do seu oponente! Bulbasaur recuperou 60 de HP.\n");			oponente.hp -= 60;
			hp += 60;
		}
	}
	
	// Polimorfismo de sobrescrita para aplicar efeitos no oponente.
	@Override
	public void chaparOponente(Pokemon oponente) {
		Random random = new Random();
		int chanceDomar = random.nextInt(4);
		
		if(chanceDomar == 0) {
			System.out.printf("\n%s deixou o %s adversário chapado 🍃🍃🍃...\n", nome, oponente.nome);
			oponente.status = "Confuso";
		}
		
	}
}