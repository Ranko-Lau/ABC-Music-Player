package sound;

/**
 * A LyricListener responds to lyric events.
 */
public interface LyricListener {
	/**
	 * This method is called when a lyric event is triggered.
	 * 
	 * @param text
	 *            The text associated with the lyric event.
	 */
	public void processLyricEvent(String text);
}