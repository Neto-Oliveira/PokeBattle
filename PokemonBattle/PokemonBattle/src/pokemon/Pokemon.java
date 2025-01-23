package pokemon;

import java.util.Random;

public abstract class Pokemon {
	protected String nome;
	protected String tipo;
	protected int dano;
	protected int hp;
	protected int pontoDeAtaque;
	protected String status;
	
	public Pokemon() {	
		
	}

	public Pokemon(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.dano = 50;
		this.hp = 600;
		this.pontoDeAtaque = 15;
		this.status = "Default";
	}
	
	// Método responsável pelo ataque com relação de vantagem de acordo com o tipo do Pokemon.
	public abstract void causarDanoNormal(Pokemon jogador);	
	
	// Método responsável pelo ataque que só poderá ser usado em momentos cruciais (HP <= 250).
	public void causarDanoCrucial(Pokemon oponente) {
		int ataque;
		
		if(hp <= 250 && pontoDeAtaque >= 4) {
			ataque = ataqueCritico(dano + 25);
			System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
			oponente.hp = oponente.hp - ataque;
			this.pontoDeAtaque -= 4;
		}
		else {
			if(pontoDeAtaque >= 4) {
				System.out.println("\nAtaque ainda não pode ser realizado, somenete em momentos cruciais, use com sabedoria. Não ataca mais essa rodada. \n");
			}
			else {
				System.out.println("\nSeus pontos de ataque acabaram, você não consegue usar mais esse golpe e não ataca mais essa rodada.\n");
			}
		}
	}
	
	// Método responsável pelo ataque característico de cada Pokemon, e pode ser usado em qualquer fase da batalha.
	public void causarDanoEspecial(Pokemon oponente) {
		int ataque;
		
		if(pontoDeAtaque >= 3) {
			ataque = ataqueCritico(dano + 15);
			System.out.println("\n" + nome + " causou " + ataque + " de dano ao " + oponente.nome + " adversário!\n");
			oponente.hp = oponente.hp - ataque;
			this.pontoDeAtaque -= 3;
		}
		else {
			System.out.println("\nSeus pontos de ataque acabaram, você não consegue usar mais esse golpe e não ataca mais essa rodada.\n");
		}
	}
	
	// Método responsável para a tentativa de defesa.
	public boolean tentativaDeDefesa() {
		int chanceDeDefesa = 20;
		Random randomTentativaDeDefesa = new Random();
		int resultado = randomTentativaDeDefesa.nextInt(100);
		return resultado < chanceDeDefesa;
	}
	
	// Método responsável para a tentativa de ataque crítico.
	public int ataqueCritico(int dano) {
        Random randomAtaqueCritico = new Random();
        int resultado = randomAtaqueCritico.nextInt(10);

        if(resultado < 2) {
        	System.out.println("\nCRÍTICO!!! ");
            return dano * 2;
        } 
        else {
            return dano;
        }
    }
}