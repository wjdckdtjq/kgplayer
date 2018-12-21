package kgplayer.audio;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class AudioPlayer extends BasicPlayer{
	
	//기본 플레이어의 확장
	private static AudioPlayer instance = null;
	private ArrayList<String> playlist = new ArrayList<String>();
	private int index = 0;
	private boolean paused = true;
	private boolean opened = false;
	private boolean isSeeking = false;
	//현재 오디오 속성
	private float audioDurationInSeconds = 0;
	private int audioFrameSize = 0;
	private float audioFrameRate = 0;
	//스트림 정보/상태
	private byte[] cpcmdata;
	private long csms = 0; //현재 마이크로초
	private int lastSeekMs = 0; //찾을 때마다 기본 플레이어 반환 마이크로초가 재설정됨
	
	private AudioPlayer() {
		super();
		//오디오 플레이어 클래스에 기본 동작 부여
		this.addBasicPlayerListener(new BasicPlayerListener() {
			
			@Override
			public void stateUpdated(BasicPlayerEvent event) {
				if(event.getCode() == BasicPlayerEvent.EOM)
				{
					lastSeekMs = 0;
					paused = true;
					opened = false;
					log("EOM event catched, player resetted.");
				}
				if(event.getCode() == BasicPlayerEvent.SEEKING)
					isSeeking = true;
				if(event.getCode() == BasicPlayerEvent.SEEKED)
					isSeeking = false;
			}
			
			@Override
			public void setController(BasicController arg0) {
			}
			
			@Override
			public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
				csms = microseconds;
				cpcmdata = pcmdata;
			}
			
			@Override
			public void opened(Object stream, Map properties) {
				log("Opened event caught");
				Object[] e = properties.entrySet().toArray();
				Object[] k = properties.keySet().toArray();
				String line = "Stream properties:";
				for(int i = 0; i<properties.size(); i++){
					line += "\n\t" + k[i] + ":" + e[i];
				}
				log(line);
				//오디오 속성 설정
				File file = new File(playlist.get(index));
			    long audioFileLength = file.length();
				int frameSize = (int) properties.get("mp3.framesize.bytes");
			    float frameRate = (float) properties.get("mp3.framerate.fps");
			    audioFrameSize = frameSize;
			    audioFrameRate = frameRate;
			    audioDurationInSeconds = (audioFileLength / (frameSize * frameRate));
			    log("\tframesize " + frameSize + " framerate " + frameRate);
			    log("\tAudio File lenght in seconds is: " + audioDurationInSeconds);
			}
		});
	}
	
	public static AudioPlayer getInstance(){
		if(instance == null)
			instance = new AudioPlayer();
		return instance;
	}
	/////////////////////////////////////
	
	
	@Override
	public void play() throws BasicPlayerException {
		if(playlist.size() == 0)
			return;
		if(!paused || !opened){
			File f = new File(playlist.get(index));
			log("Opening file... " + f.getAbsolutePath());
			open(f);
			opened = true;
			super.play();
		}
		if(paused)
			super.resume();
		paused = false;
	}
	
	@Override
	public void pause() throws BasicPlayerException {
		log("Paused");
		paused = true;
		super.pause();
	}
	
	@Override
	public void stop() throws BasicPlayerException {
		paused = false;
		super.stop();
	}
	
	public boolean isPaused(){ return paused; }
	
	public boolean isOpenFile() { return opened; }
	
	public ArrayList<String> getPlaylist(){ return playlist; }
	
	public int getIndexSong(){ return index; }
	
	public void setIndexSong(int index){ this.index = index; lastSeekMs = 0; }
	
	public boolean isSeeking() { return isSeeking; }
	
	/**
	 * goes to the next song in playlist and plays it
	 * @throws BasicPlayerException
	 */
	public void nextSong() throws BasicPlayerException{
		if(playlist.size() == 0)
			return;
		lastSeekMs = 0;
		paused = false;
		index = (index+1)%playlist.size();
		play();
	}
	
	/**
	 * goes to the previous song and plays it
	 * @throws BasicPlayerException
	 */
	public void prvSong() throws BasicPlayerException{
		if(playlist.size() == 0)
			return;
		lastSeekMs = 0;
		paused = false;
		index = (index-1)%playlist.size();
		play();
	}
	
	/**
	 * Adds a song to the playlist
	 * @param songPath
	 */
	public void addSong(String songPath) {
		playlist.add(songPath);
	}
	
	/**
	 * Remove a song by index
	 * @param index
	 */
	public void removeSong(int index) {
		playlist.remove(index);
	}
	/**
	 * Remove a song by songPath
	 * @param songPath
	 */
	public void removeSong(String songPath)
	{
		playlist.remove(songPath);
	}
	
	public byte[] getPcmData(){return cpcmdata;}
	
	public long getProgressMicroseconds(){return csms+lastSeekMs;}
	
	public float getAudioDurationSeconds() {return audioDurationInSeconds;}
	
	public float getAudioFrameRate() {return audioFrameRate;}
	
	public float getAudioFrameSize() {return audioFrameSize;}
	
	/**
	 * Remembers what's the last position relative to the playing song
	 * when seeking
	 */
	public void setLastSeekPositionInMs(int seekMs)
	{
		lastSeekMs = seekMs;
	}
	
	
	/**
	 * For logging
	 * @param line
	 */
	private void log(String line)
	{
		System.out.println("AudioPlayer] " + line);
	}
}
