import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RecentlyPlayedStoreTest {
    @Test
    public void testAddAndGetRecentSongs() {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user1", "song3");
        store.addSong("user1", "song4");
        store.addSong("user1", "song2");
        store.addSong("user1", "song1");
        store.addSong("user2", "song1");
        store.addSong("user2", "song2");
        store.addSong("user2", "song3");

        List<String> recentSongs1 = store.getRecentSongs("user1");
        assertEquals(Arrays.asList("song4", "song2", "song1"), recentSongs1);

        List<String> recentSongs2 = store.getRecentSongs("user2");
        assertEquals(Arrays.asList("song1", "song2", "song3"), recentSongs2);

        List<String> recentSongs3 = store.getRecentSongs("user3");
        assertTrue(recentSongs3.isEmpty());
    }
}
