package traitement_son;
import  java.io.*;
import javax.sound.sampled.*;
 
/**
 * class permettant la gestion du son d'un objet modifier
 */ 
public class Traiement_son_update_objet extends Thread{
     
     
     static AudioInputStream audioInputStream = null;
    static SourceDataLine line;
     
    public void run(){
        File fichier = new File("./src/media/NouvelObjetModifie.wav");
        try {
        @SuppressWarnings("unused")
        AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
         
        try {
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
          
         try {
             line = (SourceDataLine) AudioSystem.getLine(info);
                        
             } catch (LineUnavailableException e) {
               e.printStackTrace();
               return;
             }
          
        try {
                line.open(audioFormat);
        } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
        }
        line.start();
        //Fenetre.begin=true;
        try {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                 line.write(bytes, 0, bytesRead);
                }
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }
    }
     
    
    public static  void main(String[] args){
    	   File fichier = new File("./src/media/Nouveau_client.wav");
           try {
           @SuppressWarnings("unused")
           AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
           } catch (UnsupportedAudioFileException e1) {
               e1.printStackTrace();
           } catch (IOException e1) {
               e1.printStackTrace();
           }
            
           try {
               audioInputStream = AudioSystem.getAudioInputStream(fichier);
           } catch (UnsupportedAudioFileException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
            
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
             
            try {
                line = (SourceDataLine) AudioSystem.getLine(info);
                           
                } catch (LineUnavailableException e) {
                  e.printStackTrace();
                  return;
                }
             
           try {
                   line.open(audioFormat);
           } catch (LineUnavailableException e) {
                       e.printStackTrace();
                       return;
           }
           line.start();
           //Fenetre.begin=true;
           try {
               byte bytes[] = new byte[1024];
               int bytesRead=0;
               while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                    line.write(bytes, 0, bytesRead);
                   }
           } catch (IOException io) {
               io.printStackTrace();
               return;
           }
    }

     
}