package pokemon;

public class Squirtle extends Pokemon{

	public Squirtle() {
		super();
	}

	public Squirtle(String nome, String tipo) {
		super(nome, tipo);
	}

	@Override
	public void causarDanoNormal(Pokemon oponente) {
		int ataque;
		
		if(oponente.tipo == "Fogo") {
			ataque = ataqueCritico(dano + 10);
		}
		else {
			ataque = ataqueCritico(dano);
		}
		
		System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
		oponente.hp = oponente.hp - ataque;	
	}	
}
