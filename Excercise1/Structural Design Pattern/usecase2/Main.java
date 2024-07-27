package usecase2;
//Fascade Pattern
class CDPlayer {
    public void on() {
        System.out.println("CD Player is ON");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
    public void stop() {
        System.out.println("Stopping the movie");
    }
    public void off() {
        System.out.println("CD Player is OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }
    public void wideScreenMode() {
        System.out.println("Projector is in widescreen mode");
    }
    public void off() {
        System.out.println("Projector is OFF");
    }
}

class SoundSystem {
    public void on() {
        System.out.println(" Sound System is ON");
    }
    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
    public void off() {
        System.out.println(" Sound System is OFF");
    }
}
class HomeTheaterFacade {
    private CDPlayer cdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(CDPlayer cd, Projector projector,SoundSystem sound) {
        this.cdPlayer = cd;
        this.projector = projector;
        this.soundSystem = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(5);
        cdPlayer.on();
        cdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        cdPlayer.stop();
        cdPlayer.off();
        soundSystem.off();
        projector.off();
    }
}
public class Main {
    public static void main(String[] args) {
        CDPlayer cdPlayer = new CDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(cdPlayer, projector, soundSystem);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
