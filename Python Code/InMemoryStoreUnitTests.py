import unittest
from InMemoryStore import *


class TestRecentlyPlayedStore(unittest.TestCase):
    def test_add_play(self):
        store = RecentlyPlayedStore(3, 4)
        store.add_play('user1', 'S1')
        store.add_play('user1', 'S2')
        store.add_play('user1', 'S3')
        store.add_play('user1', 'S4')
        self.assertEqual(store.get_recently_played('user1'), ['S2', 'S3', 'S4'])
        store.add_play('user1', 'S2')
        self.assertEqual(store.get_recently_played('user1'), ['S3', 'S4', 'S2'])
        store.add_play('user1', 'S1')
        self.assertEqual(store.get_recently_played('user1'), ['S4', 'S2', 'S1'])

    def test_get_recently_played(self):
        store = RecentlyPlayedStore(3, 4)
        self.assertEqual(store.get_recently_played('user1'), [])
        store.add_play('user1', 'S1')
        self.assertEqual(store.get_recently_played('user1'), ['S1'])
        store.add_play('user1', 'S2')
        self.assertEqual(store.get_recently_played('user1'), ['S1', 'S2'])
        store.add_play('user2', 'S1')
        self.assertEqual(store.get_recently_played('user2'), ['S1'])
        self.assertEqual(store.get_recently_played('user1'), ['S1', 'S2'])
