package umu.tds.apps.controller;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Reproductor {
	
	private MediaPlayer mediaPlayer;

	
	public Reproductor() {
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
