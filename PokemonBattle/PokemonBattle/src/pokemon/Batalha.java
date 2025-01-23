package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Batalha {
	private int turno = 0; 
	private String clima;
	Pokemon jogador;
	
	private int getTurno() {
		return turno;
	}

	private void setTurno(int turno) {
		this.turno = turno;
	}

	private String getClima() {
		return clima;
	}

	private void setClima(String clima) {
		this.clima = clima;
	}

	public void apagarConsole() {
		for(int i = 0; i < 60; i++) {
			System.out.println();
		}
	}
	
	public void tutorialJogo() {
		System.out.println("\n\t                                         [R E G R A S] \n\n"
				+ "\t1 - Em 'Pokemon Battles', cada jogador pode escolher entre 3 golpes caracteristicos de cada Pokemon, ou usar poções. \n\tCada uma dessas ações, custará 'Pontos de Ataque', que por padrão, cada jogador iniciará em [15], lembrando que esses pontos são recuperáveis durante a batalha. \n\n"
				+ "\t2 - Cada Pokemon, tem seu tipo, e com isso, vem as vantagens e desvantagens que também podem ser alterados de acordo com o clima da batalha. Determinados tipos de \n\tPokemon causará mais dano do que em outros.\r\n"
				+ "\tEx.: Squirtle dará mais dano em Charmander, pois água anula fogo, e assim por diante... \n\n"
				+ "\t3 - Durante os turnos, tem uma pequena possibilidade de, o Pokemon causar dano crítico, ou ele realizar uma defesa. \n\tO dano crítico vai dobrar o dano causado, baseado no golpe escolhido. Já a defesa, vai reduzir o dano sofrido em um valor fixo. \n\n"
				+ "\t4 - O golpe número 2 de cada Pokemon, só poderá ser realizado caso cumpra tais requisitos: Ter os Pontos de Ataque iguais ou \n\tsuperiores à 4 ao mesmo tempo que ele deve estar em estado crucial (Entra em estado crucial caso o HP do Pokemon for igual ou menor a 250). \n\n"
				+ "\t5 - Alguns Pokemon podem desbloquear habilidades especiais durante a batalha.\n\n"
				+ "\t6 - Ganha o Pokemon que deixar o seu oponente com 0 de HP primeiro. \n\n"
				+ "\tTenha um bom jogo!\n");
	}
	
	public String preencherTreinador(Scanner sc) {
		System.out.print("\nInforme o nome do treinador pokémon: ");
		String nome = sc.nextLine();
		return nome;
	}
	
	// Método responsável pela instância do Pokemon escolhido.
	public Pokemon escolherPokemon(Scanner sc, String nome) {
		this.jogador = null;
		
	    while(jogador == null) {
		    System.out.print("\n" + nome + ", escolha seu pokémon: \n"
		                + "1 - [⚡] Pikachu\n"
		                + "2 - [🔥] Charmander\n"
		                + "3 - [💧] Squirtle\n"
		                + "4 - [🍃] Bulbasaur\n"
		                + "Opção: ");
		    
		    String escolhaPokemon = sc.nextLine();		    	
		   
		    switch(escolhaPokemon) {
		    	case "1":
					jogador = new Pikachu("Pikachu", "Elétrico");
					break;
		    	case "2":
					jogador = new Charmander("Charmander", "Fogo");
					break;
		    	case "3":
					jogador = new Squirtle("Squirtle", "Água");
					break;
		    	case "4":
					jogador = new Bulbasaur("Bulbasaur", "Planta");
					break;
		    	default:
		    		System.out.println("\nEscolha inválida! Tente novamente.\n");
			}
	    }
	    
		apagarConsole();
		
		return jogador;
	}
	
	public void escolherAtaqueManual(Pokemon jogador1, Pokemon jogador2, Scanner sc, String nome) { 
		String escolhaAtaque;
			
		switch(jogador1.nome.toLowerCase()) {
			case "pikachu":	
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0] \n"
							+ "2 - Choque de trovão - Custo de pontos de Ataque [4] \n"
							+ "3 - Investida trovão - Custo de pontos de Ataque [3] \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n"
							+ "Opção: ");
					
					escolhaAtaque = sc.nextLine();
					if (escolhaAtaque.equals("1")) {
						jogador1.causarDanoNormal(jogador2);
					}
					else if (escolhaAtaque.equals("2")) {
						jogador1.causarDanoCrucial(jogador2);
					}
					else if (escolhaAtaque.equals("3")) {
						jogador1.causarDanoEspecial(jogador2);
					} 
					else if (escolhaAtaque.equals("4")) {
						usarPocaoVida(jogador1);
					}
					else {
						System.out.println("\nEscolha inválida! Tente novamente.\n");
					}
				} while (!escolhaAtaque.equals("1") && !escolhaAtaque.equals("2") && !escolhaAtaque.equals("3") && !escolhaAtaque.equals("4"));
				
				break;
			case "raichu":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0] \n"
							+ "2 - Onda elétrica - Custo de pontos de Ataque [4] \n"
							+ "3 - Faíscas - Custo de pontos de Ataque [3] \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n"
							+ "Opção: ");
					
					escolhaAtaque = sc.nextLine();
					if (escolhaAtaque.equals("1")) {
						jogador1.causarDanoNormal(jogador2);
					}
					else if (escolhaAtaque.equals("2")) {
						jogador1.causarDanoCrucial(jogador2);
					}
					else if (escolhaAtaque.equals("3")) {
						jogador1.causarDanoEspecial(jogador2);
					} 
					else if (escolhaAtaque.equals("4")) {
						usarPocaoVida(jogador1);
					}
					else {
						System.out.println("\nEscolha inválida! Tente novamente.\n");
					}
				} while (!escolhaAtaque.equals("1") && !escolhaAtaque.equals("2") && !escolhaAtaque.equals("3") && !escolhaAtaque.equals("4"));
				
				break;
				
			case "charmander":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Lança chamas - Custo de pontos de Ataque [4]  \n"
							+ "3 - Brasas - Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n"
							+ "Opção: ");
						
					escolhaAtaque = sc.nextLine();
					
					if (escolhaAtaque.equals("1")) {
						jogador1.causarDanoNormal(jogador2);
					}
					else if (escolhaAtaque.equals("2")) {
						jogador1.causarDanoCrucial(jogador2);
					}
					else if (escolhaAtaque.equals("3")) {
						jogador1.causarDanoEspecial(jogador2);
					} 
					else if (escolhaAtaque.equals("4")) {
						usarPocaoVida(jogador1);
					}
					else {
						System.out.println("\nEscolha inválida! Tente novamente.\n");	
					}
				} while (!escolhaAtaque.equals("1") && !escolhaAtaque.equals("2") && !escolhaAtaque.equals("3") && !escolhaAtaque.equals("4"));
				
				break;
			case "squirtle":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Jato d'água - Custo de pontos de Ataque [4]  \n"
							+ "3 - Canhão de água - Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n"
							+ "Opção: ");
					
					escolhaAtaque = sc.nextLine();
					
					if (escolhaAtaque.equals("1")) {
						jogador1.causarDanoNormal(jogador2);
					}
					else if (escolhaAtaque.equals("2")) {
						jogador1.causarDanoCrucial(jogador2);
					}
					else if (escolhaAtaque.equals("3")) {
						jogador1.causarDanoEspecial(jogador2);
					} 
					else if (escolhaAtaque.equals("4")) {
						usarPocaoVida(jogador1);
					}
					else {
						System.out.println("\nEscolha inválida! Tente novamente.\n");
					}
				} while (!escolhaAtaque.equals("1") && !escolhaAtaque.equals("2") && !escolhaAtaque.equals("3") && !escolhaAtaque.equals("4"));
				break;
			case "bulbasaur":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Chicote de vinha - Custo de pontos de Ataque [4]  \n"
							+ "3 - Dança de pétalas - Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n"
							+ "Opção: ");
					
					escolhaAtaque = sc.nextLine();
					
					if (escolhaAtaque.equals("1")) {
						jogador1.causarDanoNormal(jogador2);
					}
					else if (escolhaAtaque.equals("2")) {
						jogador1.causarDanoCrucial(jogador2);
					}
					else if (escolhaAtaque.equals("3")) {
						jogador1.causarDanoEspecial(jogador2);
					} 
					else if (escolhaAtaque.equals("4")) {
						usarPocaoVida(jogador1);
					}
					else {
						System.out.println("\nEscolha inválida! Tente novamente.\n");
					}
				} while (!escolhaAtaque.equals("1") && !escolhaAtaque.equals("2") && !escolhaAtaque.equals("3") && !escolhaAtaque.equals("4"));
				
				break;
			default:
				System.out.println("\nEscolha inválida!\n");
		}
	}
	 
	public void escolherAtaqueAutomatico(Pokemon jogador1, Pokemon jogador2, String nome) { 	
		Random random = new Random();
				
		int ataqueAleatorio = random.nextInt(1,4); 
		
		int verificador = 0;
		
		switch(jogador1.nome.toLowerCase()) {
			case "pikachu":	
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0] \n"
							+ "2 - Choque de trovão - Custo de pontos de Ataque [4] \n"
							+ "3 - Investida trovão - Custo de pontos de Ataque [3] \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n\n");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
					
					if(jogador1.hp <= 200 && jogador1.pontoDeAtaque >= 4 && verificador % 2 == 0) {
						System.out.println(nome + " usou a poção de vida!");
						usarPocaoVida(jogador1);
						verificador++;
					} else {
						if(jogador1.pontoDeAtaque <= 10 && verificador % 2 == 0) {
							System.out.println(nome + " usou o golpe normal!");
							jogador1.causarDanoNormal(jogador2);
						} else {
							if(ataqueAleatorio == 2 && jogador1.hp <= 250 && jogador1.pontoDeAtaque >= 4){
								System.out.println(nome + " usou o choque do trovão!");
								jogador1.causarDanoCrucial(jogador2);
							} else if (jogador1.pontoDeAtaque >= 3) {
								System.out.println(nome + " usou a investida trovão!");
								jogador1.causarDanoEspecial(jogador2);
							} else {
								System.out.println(nome + " usou o golpe normal!");
								jogador1.causarDanoNormal(jogador2);
							}
						}
						verificador++;
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
				
				} while (ataqueAleatorio != 1 && ataqueAleatorio != 2 && ataqueAleatorio != 3 && ataqueAleatorio != 4);
				
				break;
			case "raichu":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0] \n"
							+ "2 - Onda elétrica - Custo de pontos de Ataque [4] \n"
							+ "3 - Faíscas - Custo de pontos de Ataque [3] \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n\n");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
				
					if(jogador1.hp <= 200 && jogador1.pontoDeAtaque >= 4 && verificador % 2 == 0) {
						System.out.println(nome + " usou a poção de vida!");
						usarPocaoVida(jogador1);
						verificador++;
					} else {
						if(jogador1.pontoDeAtaque <= 10 && verificador % 2 == 0) {
							System.out.println(nome + " usou o golpe normal!");
							jogador1.causarDanoNormal(jogador2);
						} else {
							if(ataqueAleatorio == 2 && jogador1.hp <= 250 && jogador1.pontoDeAtaque >= 4){
								System.out.println(nome + " usou o choque do trovão!");
								jogador1.causarDanoCrucial(jogador2);
							} else if (jogador1.pontoDeAtaque >= 3) {
								System.out.println(nome + " usou a investida trovão!");
								jogador1.causarDanoEspecial(jogador2);
							} else {
								System.out.println(nome + " usou o golpe normal!");
								jogador1.causarDanoNormal(jogador2);
							}
							verificador++;
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
					
				} while (ataqueAleatorio != 1 && ataqueAleatorio != 2 && ataqueAleatorio != 3 && ataqueAleatorio != 4);
				
				break;
			case "charmander":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Lança chamas - Custo de pontos de Ataque [4]  \n"
							+ "3 - Brasas - Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n\n");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
				
					if(jogador1.hp <= 200 && jogador1.pontoDeAtaque >= 4 && verificador % 2 == 0) {
						System.out.println(nome + " usou a poção de vida!");
						usarPocaoVida(jogador1);
						verificador++;
					} else {
						if(jogador1.pontoDeAtaque <= 10 && verificador % 2 == 0) {
							System.out.println(nome + " usou o golpe normal!");
							jogador1.causarDanoNormal(jogador2);
						} else {
							if(ataqueAleatorio == 2 && jogador1.hp <= 250 && jogador1.pontoDeAtaque >= 4){
								System.out.println(nome + " usou lança chamas!");
								jogador1.causarDanoCrucial(jogador2);
							} else if (jogador1.pontoDeAtaque >= 3) {
								System.out.println(nome + " usou brasas!");
								jogador1.causarDanoEspecial(jogador2);
							} else {
								System.out.println(nome + " usou o golpe normal!");
								jogador1.causarDanoNormal(jogador2);
							}
							verificador++;
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
					
				} while (ataqueAleatorio != 1 && ataqueAleatorio != 2 && ataqueAleatorio != 3 && ataqueAleatorio != 4);
				
				break;
			case "squirtle":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Jato d'água - Custo de pontos de Ataque [4]  \n"
							+ "3 - Canhão de água- Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n\n");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
				
					if(jogador1.hp <= 200 && jogador1.pontoDeAtaque >= 4 && verificador % 2 == 0) {
						System.out.println(nome + " usou a poção de vida!");
						usarPocaoVida(jogador1);
						verificador++;
					} else {
						if(jogador1.pontoDeAtaque <= 10 && verificador % 2 == 0) {
							System.out.println(nome + " usou o golpe normal!");
							jogador1.causarDanoNormal(jogador2);
						} else {
							if(ataqueAleatorio == 2 && jogador1.hp <= 250 && jogador1.pontoDeAtaque >= 4){
								System.out.println(nome + " usou jato d'água!");
								jogador1.causarDanoCrucial(jogador2);
							} else if (jogador1.pontoDeAtaque >= 3) {
								System.out.println(nome + " usou canhão de água!");
								jogador1.causarDanoEspecial(jogador2);
							} else {
								System.out.println(nome + " usou o golpe normal!");
								jogador1.causarDanoNormal(jogador2);
							}
							verificador++;
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
					
				} while (ataqueAleatorio != 1 && ataqueAleatorio != 2 && ataqueAleatorio != 3 && ataqueAleatorio != 4);
				
				break;
			case "bulbasaur":
				do {
					System.out.print(nome + ", escolha um ataque para " + jogador1.nome + ": \n"
							+ "1 - Normal - Custo de pontos de Ataque [0]  \n"
							+ "2 - Chicote de vinha - Custo de pontos de Ataque [4]  \n"
							+ "3 - Dança de pétalas - Custo de pontos de Ataque [3]  \n"
							+ "4 - Usar poção de vida - Custo de pontos de Ataque [4] \n\n");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
				
					if(jogador1.hp <= 200 && jogador1.pontoDeAtaque >= 4 && verificador % 2 == 0) {
						System.out.println(nome + " usou a poção de vida!");
						usarPocaoVida(jogador1);
						verificador++;
					} else {
						if(jogador1.pontoDeAtaque <= 10 && verificador % 2 == 0) {
							System.out.println(nome + " usou o golpe normal!");
							jogador1.causarDanoNormal(jogador2);
						} else {
							if(ataqueAleatorio == 2 && jogador1.hp <= 250 && jogador1.pontoDeAtaque >= 4){
								System.out.println(nome + " usou o chicote de vinha!");
								jogador1.causarDanoCrucial(jogador2);
							} else if (jogador1.pontoDeAtaque >= 3) {
								System.out.println(nome + " usou dança de pétalas!");
								jogador1.causarDanoEspecial(jogador2);
							} else {
								System.out.println(nome + " usou o golpe normal!");
								jogador1.causarDanoNormal(jogador2);
							}
							verificador++;
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						
					}
					
				} while (ataqueAleatorio != 1 && ataqueAleatorio != 2 && ataqueAleatorio != 3 && ataqueAleatorio != 4);
					
				break;
			default:
				System.out.println("\nEscolha inválida!\n");
		}
	}
	
	// Método responsável pelo modo jogo "Duelo Pokemon".
	public void batalhaPokemonManual(Pokemon jogador1, Pokemon jogador2, Scanner sc, String nome1, String nome2) {	        
		Random randomVezJogador = new Random();
		boolean vezJogador = randomVezJogador.nextBoolean();

		int quantidadeDeAtaques = 0;
		
		climaAleatorio(jogador1, jogador2);
		this.turno = 0;
		
		while(jogador1.hp > 0 && jogador2.hp > 0) {
			
			int hpAuxiliar1 = jogador1.hp;
			int hpAuxiliar2 = jogador2.hp;
			
			if(quantidadeDeAtaques % 2 == 0) {
				if(getTurno() != 0) {
					String tecla = null;
					if(tecla == null) {
						System.out.println("\nTurno finalizado. Pressione ENTER para prosseguir...");
						tecla = sc.nextLine();
					}
				}
				apagarConsole();
				turnoBatalha(jogador1, jogador2);
			}
			
			// Sorteio para descobrir qual jogador irá começar atacando.
			if(vezJogador) {
				if(getTurno() % 3 == 0 && turno != 0) {
					if(jogador1.pontoDeAtaque + 1 > 15) {
						jogador1.pontoDeAtaque = jogador1.pontoDeAtaque;
					} else {
						jogador1.pontoDeAtaque ++;
					}
				}
				
				mostrarInfo(jogador1, jogador2, nome1, nome2);
				
				if(jogador1.status == "Default"){
					escolherAtaqueManual(jogador1, jogador2, sc, nome1);
				
				} else if (jogador1.status == "Paralisado"){
					System.out.printf("\n%s está paralisado e não poderá atacar nessa rodada.\n\n", nome1);
				
				} else if(jogador1.status == "Confuso") {
					System.out.printf("\nO aroma das plantas deixou %s confuso! Golpe aleatório será executado.\n\n", jogador1.nome);
					escolherAtaqueAutomatico(jogador1, jogador2, nome1);
				}
				
				jogador1.status = "Default";
				quantidadeDeAtaques++;
				System.out.println(nome1 + ", você ainda tem " + jogador1.pontoDeAtaque + " pontos de ataque.\n");
				
				if(jogador2.hp != hpAuxiliar2) {
					if(jogador2.tentativaDeDefesa()) {
						System.out.println("Calma " + nome2 + ", o seu " + jogador2.nome + " defendeu! (Resistiu a 30 de dano).\n");
						jogador2.hp += 30;
					}
				}

				if(jogador2.hp <= 250) {
					System.out.println(jogador2.nome + " adversário está em um momento crucial.\n");
				}
		
				if(jogador2.hp < 0) {
					System.out.println("A vida do " + jogador2.nome + " adversário está em 0.\n"
							+ "—————————————————————————————————————————————————————");
				}
				else {
					System.out.println("A vida do " + jogador2.nome + " adversário está em " + jogador2.hp + ".\n"
							+ "———————————————————————————————————————————————————————————————————————");
				}
				
			}	
			else {
				if(getTurno() % 3 == 0 && turno != 0) {
					if(jogador2.pontoDeAtaque + 1 > 15) {
						jogador1.pontoDeAtaque = jogador1.pontoDeAtaque;
					} else {
						jogador2.pontoDeAtaque ++;
					}
				}
				mostrarInfo(jogador1, jogador2, nome1, nome2);
				
				if(jogador2.status == "Default"){
					escolherAtaqueManual(jogador2, jogador1, sc, nome2);
					
				} else if (jogador2.status == "Paralisado"){
					System.out.printf("\n%s está paralisado e não poderá atacar nessa rodada.\n\n", nome2);
				}
				
				else if(jogador2.status == "Confuso") {
					System.out.printf("\nO aroma das plantas deixou %s confuso! Golpe aleatório será executado.\n\n", jogador2.nome);
					escolherAtaqueAutomatico(jogador2, jogador1, nome2);
				}
				
				jogador2.status = "Default";
				quantidadeDeAtaques++;
				System.out.println(nome2 + ", você ainda tem " + jogador2.pontoDeAtaque + " pontos de ataque.\n");
				
				if(jogador1.hp != hpAuxiliar1) {
					if(jogador1.tentativaDeDefesa()) {
						System.out.println("Calma " + nome1 + ", o seu " + jogador1.nome + " defendeu! (Resistiu a 30 de dano).\n");
						jogador1.hp += 30;
					}
				}
	
				if(jogador1.hp <= 250) {
					System.out.println(jogador1.nome + " adversário está em um momento crucial.\n");
				}
		
				if(jogador1.hp < 0) {
					System.out.println("A vida do " + jogador1.nome + " adversário está em 0.\n"
							+ "—————————————————————————————————————————————————————");
				}
				else {
					System.out.println("A vida do " + jogador1.nome + " adversário está em " + jogador1.hp + ".\n"
							+ "———————————————————————————————————————————————————————————————————————");
				}
			}
			
			vezJogador = !vezJogador;
				        
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        
		if(jogador1.hp > 0) {
			System.out.println("\nParabéns " + nome1 + " você venceu!");
		}
		else {
			System.out.println("\nParabéns " + nome2 + " você venceu!");
		}
	}
	
	// Método responsável pelo modo de jogo "Treinamento".
	public void batalhaPokemonAutomatico(Pokemon jogador1, Pokemon jogador2, Scanner sc, String nome1, String nome2) {
		Random randomVezJogador = new Random();
		boolean vezJogador = randomVezJogador.nextBoolean();
		
		int quantidadeDeAtaques = 0;
		this.turno = 0;
		
		climaAleatorio(jogador1, jogador2);
		
		while(jogador1.hp > 0 && jogador2.hp > 0) {
			
			int hpAuxiliar1 = jogador1.hp;
			int hpAuxiliar2 = jogador2.hp;
			
			if(quantidadeDeAtaques % 2 == 0) {
				if(getTurno() != 0) {
					String tecla = null;
					if(tecla == null) {
						System.out.println("\nTurno finalizado. Pressione ENTER para prosseguir...");
						tecla = sc.nextLine();
					}
				}
				apagarConsole();
				turnoBatalha(jogador1, jogador2);
			}
			
			if(vezJogador) {
				if(getTurno() % 3 == 0 && turno != 0) {
					if(jogador1.pontoDeAtaque + 1 > 15) {
						jogador1.pontoDeAtaque = jogador1.pontoDeAtaque;
					} else {
						jogador1.pontoDeAtaque ++;
					}
				}
				mostrarInfo(jogador1, jogador2, nome1, nome2);
				
				if(jogador1.status == "Default"){
					escolherAtaqueManual(jogador1, jogador2, sc, nome1);
					
				} else if (jogador1.status == "Paralisado"){
					System.out.printf("\n%s está paralisado e não poderá atacar nessa rodada.\n\n", nome1);
				
				} else if(jogador1.status == "Confuso") {
					System.out.printf("\nO aroma das plantas deixou %s confuso! Golpe aleatório será executado.\n\n", jogador1.nome);
					escolherAtaqueAutomatico(jogador1, jogador2, nome1);
				}
				jogador1.status = "Default";
				
				quantidadeDeAtaques++;
				System.out.println(nome1 + ", você ainda tem " + jogador1.pontoDeAtaque + " pontos de ataque.\n");
				
				if(jogador2.hp != hpAuxiliar2) {
					if(jogador2.tentativaDeDefesa()) {
						System.out.println("Calma " + nome2 + ", o seu " + jogador2.nome + " defendeu! (Resistiu a 30 de dano).\n");
						jogador2.hp += 30;
					}
				}
		
				if(jogador2.hp <= 250) {
					System.out.println(jogador2.nome + " adversário está em um momento crucial.\n");
				}
		
				if(jogador2.hp < 0) {
					System.out.println("A vida do " + jogador1.nome + " adversário está em 0.\n"
							+ "—————————————————————————————————————————————————————");
				}
				else {
					System.out.println("A vida do " + jogador2.nome + " adversário está em " + jogador2.hp + ".\n"
							+ "———————————————————————————————————————————————————————————————————————");
				}
				
			}	
			else {
				if(getTurno() % 3 == 0 && turno != 0) {
					if(jogador2.pontoDeAtaque + 1 > 15) {
						jogador1.pontoDeAtaque = jogador1.pontoDeAtaque;
					} else {
						jogador2.pontoDeAtaque ++;
					}
				}
				mostrarInfo(jogador1, jogador2, nome1, nome2);
				
				if(jogador2.status == "Default"){
					escolherAtaqueAutomatico(jogador2, jogador1, nome2);
					
				} else if (jogador2.status == "Paralisado"){
					System.out.printf("\n%s está paralisado e não poderá atacar nessa rodada.\n\n", nome2);
				
				} else if(jogador2.status == "Confuso") {
					System.out.printf("\nO aroma das plantas deixou %s confuso! Golpe aleatório será executado.\n\n", jogador2.nome);
					escolherAtaqueAutomatico(jogador2, jogador1, nome2);
				}
				jogador2.status = "Default";
				
				quantidadeDeAtaques++;
				System.out.println(nome2 + ", você ainda tem " + jogador2.pontoDeAtaque + " pontos de ataque.\n");
				
				if(jogador1.hp != hpAuxiliar1) {
					if(jogador1.tentativaDeDefesa()) {
						System.out.println("Calma " + nome1 + ", o seu " + jogador1.nome + " defendeu! (Resistiu a 30 de dano).\n");
						jogador1.hp += 30;
					}
				}
	
				if(jogador1.hp <= 250) {
					System.out.println(jogador1.nome + " adversário está em um momento crucial.\n");
				}
		
				if(jogador1.hp < 0) {
					System.out.println("A vida do " + jogador1.nome + " adversário está em 0.\n"
							+ "—————————————————————————————————————————————————————");
				}
				else {
					System.out.println("A vida do " + jogador1.nome + " adversário está em " + jogador1.hp + ".\n"
							+ "———————————————————————————————————————————————————————————————————————");
				}
			}
			
			vezJogador = !vezJogador;
				        
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        
		if(jogador1.hp > 0) {
			System.out.println("\nParabéns " + nome1 + " você venceu!");
		}
		else {
			System.out.println("\nParabéns " + nome2 + " você venceu!");
		}
	}

	public void iniciarBatalhaManual(Scanner sc) {
		String nome1 = preencherTreinador(sc);
		Pokemon jogador1 = escolherPokemon(sc, nome1);
		String nome2 = preencherTreinador(sc);
	    Pokemon jogador2 = escolherPokemon(sc, nome2);
	    
	    batalhaPokemonManual(jogador1, jogador2, sc, nome1, nome2);
	}
	
	public void iniciarBatalhaAutomatico(Scanner sc) {
		String nome1 = preencherTreinador(sc);
		Pokemon jogador1 = escolherPokemon(sc, nome1);
		String nome2 = "BOT";
	    Pokemon jogador2 = escolherPokemon(sc, nome2);
	    batalhaPokemonAutomatico(jogador1, jogador2, sc, nome1, nome2);
	}
	
	// Método responsável para sempre imprimir as infomações atualizadas.
	public void mostrarInfo(Pokemon jogador1, Pokemon jogador2, String nome1, String nome2) {
		int lenghtMaior;
		
		if(nome1.length() > nome2.length()) {
			lenghtMaior = nome1.length();
		} 
		else {
			lenghtMaior = nome2.length();
		}
		
		// Formatação usando métodos pronto de "String" para o alinhamento da tabela.
		String nome1Formatado = String.format("%" + -(lenghtMaior) + "s", nome1);
		String nome2Formatado = String.format("%" + -(lenghtMaior) + "s", nome2);
		
		System.out.printf(" _______________________ \n");
		System.out.printf("| JOGADOR 1: %s\t|\n", nome1Formatado);
		System.out.printf("|———————————————————————|\n");
		System.out.printf("|%s - HP: %d\t|\n|PONTOS DE ATAQUE: %d\t|\n", jogador1.nome, jogador1.hp, jogador1.pontoDeAtaque);
		System.out.printf("|_______________________|\n\n");
		System.out.printf(" _______________________ \n");
		System.out.printf("| JOGADOR 2: %s\t|\n", nome2Formatado);
		System.out.printf("|———————————————————————|\n");
		System.out.printf("|%s - HP: %d\t|\n|PONTOS DE ATAQUE: %d\t|\n", jogador2.nome, jogador2.hp, jogador2.pontoDeAtaque);
		System.out.printf("|_______________________|\n\n");
	}
	
	public void menuPokemon(Scanner sc) {
	    PokeMusica pokeMusica = new PokeMusica();
		Artes artes = new Artes();
		String opcaoInicio;
		pokeMusica.PlayMusic("Poke musica.wav");
		
		do {
			artes.telaInicial();
			System.out.print("\n\n\t        Seja bem vindo ao Pokémon Battles! \n"
					+ "\t        1 - Jogar \n"
					+ "\t        2 - Regras \n"
					+ "\t        3 - Sair \n"
					+ "\t        Opção: ");
			opcaoInicio = sc.nextLine();
			switch(opcaoInicio) {
				case "1":
					String opcaoBatalha;
					do {
						apagarConsole();
						System.out.print("\n\tEscolha o modo de batalha: \n"
								+ "\t1 - Duelo pokémon \n"
								+ "\t2 - Modo treinamento \n"
								+ "\tOpção: ");
						opcaoBatalha = sc.nextLine();
						switch(opcaoBatalha) {
							case "1":
								apagarConsole(); 
								pokeMusica.PararMusica();
								pokeMusica.PlayMusic("TemaBatalha.wav");
								iniciarBatalhaManual(sc);
								pokeMusica.PararMusica();
								pokeMusica.PlayMusic("Tema Vitoria.wav");
								
								System.out.print("\nPressione ENTER para continuar... ");
								String tecla = sc.nextLine();
								if(tecla != null) {
									apagarConsole();
									pokeMusica.PararMusica();
									pokeMusica.PlayMusic("Poke musica.wav");
								}
								
								break;
							case "2":
								apagarConsole();
								pokeMusica.PararMusica();
								pokeMusica.PlayMusic("TemaBatalha.wav");
								iniciarBatalhaAutomatico(sc);
								pokeMusica.PararMusica();
								pokeMusica.PlayMusic("Tema Vitoria.wav");
								
								System.out.print("\nPressione ENTER para continuar... ");
								String tecla1 = sc.nextLine();
								if(tecla1 != null) {
									apagarConsole();
									pokeMusica.PararMusica();
									pokeMusica.PlayMusic("Poke musica.wav");
								}
								
								break;
							default:
								System.out.println("\n\tOpção inválida, tente novamente.\n");
								try {
									Thread.sleep(1500);
								} catch(Exception e) {
									
								}
								apagarConsole();
						}
					} while(!opcaoBatalha.equals("1") && !opcaoBatalha.equals("2"));
					break;
				case "2":
					apagarConsole();
					tutorialJogo();
					System.out.print("\tPressione ENTER para continuar... ");
					String tecla = sc.nextLine();
					if(tecla != null) {
						apagarConsole();
					}
					break;
				case "3":
					break;
				default:
					System.out.println("\n\t        Opção inválida, tente novamente.\n");
					try {
						Thread.sleep(1500);
					} catch(Exception e) {
						
					}
					apagarConsole();
					
			}
		} while(!opcaoInicio.equals("3"));
	}
	
	public void usarPocaoVida(Pokemon jogador) {
		int restaurar = 100;
		
		if(jogador.pontoDeAtaque >= 4 ) {
			if(jogador.hp + restaurar >= 600) {
				jogador.hp = 600;
				System.out.println("\nVocê usou a poção de vida! Porém você não pode ultrapassar o limite de vida (600)\n");
				jogador.pontoDeAtaque -= 4;
			} 
			else {
				jogador.hp += restaurar;
				System.out.println("\nVocê usou a poção de vida! E ficou com HP: " + jogador.hp + "\n");
				jogador.pontoDeAtaque -= 4;
			}
		} 
		else {
			System.out.println("\nVocê não tem pontos suficiente! Sua vez será passada.\n");	
		}
	}
	
	public void turnoBatalha(Pokemon jogador1, Pokemon jogador2) {
		setTurno(getTurno() + 1);
		System.out.println("================================");
		System.out.println("    " + jogador1.nome.toUpperCase() + " X " + jogador2.nome.toUpperCase() + "\n\t [Turno " + getTurno() + "]\n");
		System.out.println("      CLIMA: " + getClima());
		System.out.println("================================");
	}
	
	// Método responsável por setar o clima em batalha, e aplicar buffs e debuffs.
	public void climaAleatorio(Pokemon jogador1, Pokemon jogador2) {
		
		Random random = new Random();
		int escolherClima = random.nextInt(3);
		
		switch(escolherClima) {
			case 0:
				setClima("ENSOLARADO");
				if(jogador1.nome.equals("Charmander")){
					jogador1.dano += 10;
				} 
				if(jogador2.nome.equals("Charmander")){
					jogador2.dano += 10;
				}
				break;
			case 1:
				setClima("CHUVOSO");
				if(jogador1.nome.equals("Squirtle")){
					jogador1.dano += 10;
				} 
				if(jogador2.nome.equals("Squirtle")){
					jogador2.dano += 10;
				}
				
				if(jogador1.nome.equals("Charmander")){
					jogador1.dano -= 5;
				} 
				if(jogador2.nome.equals("Charmander")){
					jogador2.dano -= 5;
				}
				break;
			case 2: 
				setClima("TROVOADA");
				if(jogador1.tipo.equals("Elétrico")){
					jogador1.dano += 10;
				} 
				if(jogador2.tipo.equals("Elétrico")){
					jogador2.dano += 10;
				}
				break;
			default:
				break;
		}
	}
}