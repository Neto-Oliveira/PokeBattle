package pokemon;

// Bibliotecas para buscar os arquivos de mídia.
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PokeMusica {
	Clip clip;
	
	public void PlayMusic(String local) {
		try {
			File musicaArquivo = new File(local); // Objeto responsável pela busca.
			if(musicaArquivo.exists()) {  
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicaArquivo); // Se achar, faz a conversão para "AudioInputStream". 
				this.clip = AudioSystem.getClip(); // Responsável por permitir o uso das funções no atributo Clip.
				clip.open(audioInput);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start(); 
			}
			else {
				System.out.println("Música não encontrada.");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void PararMusica() {
		try {
			clip.stop(); 
		} catch(NullPointerException e ) {
			
		}
	}
}