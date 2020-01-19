package headfirst;

/**
 * 家庭影院外观
 */
public class HomeTheaterFacade {
    Amplifier amp;
    DvdPlayer dvd;
    //..... 所有子系统组件组合在一起

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd) {
        this.amp = amp;
        this.dvd = dvd;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie ...");
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(5);

        dvd.on();
        dvd.play(movie);
    }
}
