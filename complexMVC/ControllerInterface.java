package study.complexMVC;

public interface ControllerInterface {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
	void setBPM(int bpm);
}
