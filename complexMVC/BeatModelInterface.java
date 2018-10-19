package study.complexMVC;
// 节拍模型接口
public interface BeatModelInterface {
	void initialize();  // 初始化
	void on(); // 打开
	void off(); // 关闭
	void setBRM(int bpm); // 设置bpm
	int getBPM();  // 获取bpm
	
	// 两种观察者 一种在每个节拍都被通知，一个在bpm改变是被通知
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver bo);
	void removeObserver(BPMObserver bo);
}
interface BeatObserver{
	public void updateBeat();
}

interface BPMObserver{

	void updateBPM();
	
}