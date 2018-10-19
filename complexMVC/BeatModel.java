package study.complexMVC;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class BeatModel implements BeatModelInterface, MetaEventListener{
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int bpm = 90;
	
	Sequence sequence;
	Track track;
	@Override
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}


	private void buildTrackAndStart() {
		int[] trackList = {35, 0, 46, 0};
		this.sequence.deleteTrack(null);
		this.track = this.sequence.createTrack();
		
		makeTracks(trackList);
		this.track.add(makeEvent(192,9,1,0,4));
		try {
			this.sequencer.setSequence(this.sequence);
		} catch(Exception e){
			e.printStackTrace();
		}
	}


	private MidiEvent makeEvent(int i, int j, int k, int l, int m) {
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(i, j, k, l);
			event = new MidiEvent(a, m);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return event;
	}


	private void makeTracks(int[] trackList) {
		for(int i = 0; i<trackList.length; i++) {
			int key = trackList[i];
			
			if (key !=0) {
				this.track.add(makeEvent(144,9,key,100,i));
				this.track.add(makeEvent(128,9,key,100,i+1));
			}
			
		}
	}


	private void setUpMidi() {
		try {
			sequencer.open();
			sequencer.addMetaEventListener(this);
			this.sequence = new Sequence(Sequence.PPQ,4);
			this.track = sequence.createTrack();
			this.sequencer.setTempoInBPM(getBPM());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void on() {
		this.sequencer.start();
		this.setBRM(90);
	}

	@Override
	public void off() {
		this.setBRM(90);
		this.sequencer.stop();
	}

	@Override
	public void setBRM(int bpm) {
		this.bpm = bpm;
		this.sequencer.setTempoInBPM(getBPM());
		// 通知所有的bpm观察者
		
	}

	@Override
	public int getBPM() {
		return this.bpm;
	}
	
	public void beatEvent() {
		notifyBeatObservers();
	}
	
	private void notifyBeatObservers() {
		for(int i = 0; i<this.beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)this.beatObservers.get(i);
			observer.updateBeat();
		}
	}


	@Override
	public void registerObserver(BeatObserver o) {
		this.beatObservers.add(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		int i = this.beatObservers.indexOf(o);
		if (i>= 0) {
			this.beatObservers.remove(i);
		}
	}

	@Override
	public void registerObserver(BPMObserver bo) {
		for(int i=0; i<this.bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)this.beatObservers.get(i);
			observer.updateBPM();
		}
	}

	@Override
	public void removeObserver(BPMObserver bo) {
		int i = this.bpmObservers.indexOf(bo);
		if (i >= 0) {
			this.bpmObservers.remove(i);
		}
	}

	@Override
	public void meta(MetaMessage meta) {
		if (meta.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBRM(getBPM());
		}
	}

}
