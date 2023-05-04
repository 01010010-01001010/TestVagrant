import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, LinkedList<String>> songMap;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.songMap = new HashMap<>();
    }

    public void addSong(String user, String song) {
        if (!songMap.containsKey(user)) {
            songMap.put(user, new LinkedList<>());
        }
        LinkedList<String> songsList = songMap.get(user);
        if (songsList.size() == capacity) {
            songsList.removeFirst();
        }
        songsList.addLast(song);
    }

    public List<String> getRecentSongs(String user) {
        if (!songMap.containsKey(user)) {
            return new ArrayList<>();
        }
        LinkedList<String> songsList = songMap.get(user);
        return new ArrayList<>(songsList);
    }
}
