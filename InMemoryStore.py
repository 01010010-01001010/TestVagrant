from collections import deque


class RecentlyPlayedStore:
    def __init__(self, capacity, n_songs):
        self.capacity = capacity
        self.n_songs = n_songs
        self.store = {}

    def add_play(self, user, song):
        if user not in self.store:
            self.store[user] = deque([], maxlen=self.capacity)
        self.store[user].append(song)

    def get_recently_played(self, user):
        if user in self.store:
            return list(self.store[user])
        else:
            return []