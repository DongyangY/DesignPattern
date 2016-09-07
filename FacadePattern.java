/*
 * The Facade Pattern provides a unified interface to a set of interfaces ina subsystem.
 * Facade defines a higher level interface that makes the subsystem easier to use.
 */

class HomeTheaterFacade {
    Amplifier amp;
    Tunner tunner;
    DvdPlayer dvd;
    Projector projector;
    Screen screen;

    public HomeTheaterFacade(Amplifier amp, Tunner tunner, DvdPlayer dvd, Projector projector, Screen screen) {
	this.amp = amp;
	this.tunner = tunner;
	this.dvd = dvd;
	this.projector = projector;
	this.screen = screen;
    }

    public void watchMovie(String movie) {
	screen.down();
	projector.on();
	amp.on();
	dvd.on();
	dvd.play(movie);
    }

    public void endMovie() {
	screen.up();
	projector.off();
	amp.off();
	dvd.stop();
	dvd.eject();
	dvd.off();
    }
}
