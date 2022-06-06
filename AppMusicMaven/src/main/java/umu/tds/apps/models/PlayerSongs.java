package umu.tds.apps.models;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class PlayerSongs {
	
	private MediaPlayer mediaPlayer;

	
	public PlayerSongs() {
		try {
			com.sun.javafx.application.PlatformImpl.startup(()->{});
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
		}
	}
	
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	public void playSong(String path) {
		File f = new File(path);
		String source = f.toURI().toString();
		if (mediaPlayer == null || !mediaPlayer.getMedia().getSource().equals(source)) {
			if (mediaPlayer != null) {
				mediaPlayer.dispose();
			}
			Media hit = new Media(source);
			mediaPlayer = new MediaPlayer(hit);
		}
		mediaPlayer.play();
	}
	
	public void pauseSong() {
		mediaPlayer.pause();
	}
	
	
}
