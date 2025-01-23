package pokemon;

import java.util.Random;

public class Pikachu extends Pokemon implements Eletrico {

	public Pikachu() {
		super();
	}

	public Pikachu(String nome, String tipo) {
		super(nome, tipo);
	}

	@Override
	public void causarDanoNormal(Pokemon oponente) {
		int ataque;
		
		if(oponente.tipo == "Água") {
			ataque = ataqueCritico(dano + 10);
		}
		else {
			ataque = ataqueCritico(dano);
		}
		paralisar(oponente);
		
		System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
		oponente.hp = oponente.hp - ataque;	
		
		if(nome.equals("Pikachu") && hp <= 250) {
			tentarEvoluir();			
		}
		
		if(nome.equals("Raichu")) {
			tentarEvoluir(oponente);			
		}
	}
	
	// Polimorfismo de sobrescrita para implementar a interface "Elétrico".
	@Override
	public void tentarEvoluir() {
		Random random = new Random();
		int chancePedra = random.nextInt(3);

		if(chancePedra == 0) {
			System.out.printf("Você viu algo brilhando na arena de batalha! E usa em seu Pikachu.\n");
			System.out.printf("\nSeu Pikachu evoluiu pra Raichu no meio da batalha!\n\nSeu Pokemon recuperou 150 de HP e seu dano aumentou.\n\n");
			nome = "Raichu";
			hp += 150;
			dano += 10;
		}
	}
	
	public void tentarEvoluir(Pokemon oponente) {
		if(oponente.status.equals("Paralisado")) {
			System.out.printf("Raichu conseguiu acumular uma grande quantidade de elétrons e canalizou uma áurea ao seu redor.\n\n");
			hp += 50;
			dano += 5;
		}
	}
	
	// Polimorfismo de sobrescrita para aplicar efeitos no oponente.
	@Override
	public void paralisar(Pokemon oponente) {
		Random random = new Random();
		int chanceParalisar = random.nextInt(5);
		
		if(chanceParalisar < 2) {
			System.out.printf("\n%s deixou o %s adversário paralisado!\n", nome, oponente.nome);
			oponente.status = "Paralisado";
		}
	}	
}