package headfirst.mvc;
  
public interface BeatModelInterface {
	// 以下 4 个方法是让控制器调用的，
	// 控制器根据用户的操作对模型做成适当的处理

	// BeatModel 初始化时调用
	void initialize();
  	// 打开节拍产生器
	void on();
  	// 关闭节拍产生器
	void off();
  	// 设置 BPM
    void setBPM(int bpm);

	/**
	 * 以下方法允许视图和控制器取得状态
	 */

	// 获取 BPM
	int getBPM();
  	// 注册观察者：观察每个节拍的改变
	void registerObserver(BeatObserver o);
  
	void removeObserver(BeatObserver o);

	// 注册观察者：观察 BPM 的改变
	void registerObserver(BPMObserver o);
  
	void removeObserver(BPMObserver o);
}
