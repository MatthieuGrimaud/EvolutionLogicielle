package org.anonbnr.design_patterns.oop.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import org.anonbnr.design_patterns.oop.structural.composite.Song;

/**
 * a SongList concrete class that plays the role of ConcreteAggregate
 * in the Iterator Design pattern.<br/>
 * It implements the aggregation as a list addition, and returns
 * an iterator over the list's elements.
 * @author anonbnr
 *
 */
public class SongList implements SongAggregate {
	
	/* ATTRIBUTES */
	/**
	 * This SongList's list of songs.
	 */
	private ArrayList<Song> songs = new ArrayList<>();

	/* METHODS */
	/**
	 * Adds a Song named songName, played by the band named bandName,
	 * and released in releaseYear to this SongList's list of songs.
	 */
	
	public void addSong(String songName, String bandName, int releaseYear) {
		songs.add(new Song(songName, bandName, releaseYear));
	}
	
	/**
	 * Returns an iterator over this SongList's list of songs.
	 */
	
	public Iterator<Song> iterator() {
		return songs.iterator();
	}
}