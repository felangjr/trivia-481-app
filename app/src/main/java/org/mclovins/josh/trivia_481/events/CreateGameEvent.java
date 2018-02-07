package org.mclovins.josh.trivia_481.events;

/**
 * Created by Josh on 2/6/18.
 */

public class CreateGameEvent extends BaseEvent {
    public String Username;
    public int Time;
    public int Rounds;
    public int Players;

    public CreateGameEvent(String username, int time, int rounds, int players) {
        this.Type = EventType.CREATE_ROOM;
        this.Username = username;
        this.Time = time;
        this.Rounds = rounds;
        this.Players = players;
    }
}
