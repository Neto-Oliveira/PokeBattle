package pokemon;

public class Charmander extends Pokemon {

	public Charmander() {
		super();
	}

	public Charmander(String nome, String tipo) {
		super(nome, tipo);
	}

	@Override
	public void causarDanoNormal(Pokemon oponente) {
		int ataque;
		
		if(oponente.tipo == "Planta") {
			ataque = ataqueCritico(dano + 10);
		}
		else {
			ataque = ataqueCritico(dano);
		}
		
		System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
		oponente.hp = oponente.hp - ataque;
	}
}