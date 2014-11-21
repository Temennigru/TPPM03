package GameCore.GameObjectCore;

import GameCore.Player;
import GameCore.GameExceptions;

import java.util.*;

public abstract interface GameObject {
    public abstract boolean stackable() throws GameExceptions.GameException;
    public abstract void stackable(boolean val) throws GameExceptions.GameException;

    public abstract GameObject source() throws GameExceptions.GameException;
    public abstract void source(GameObject val) throws GameExceptions.GameException;
    
    public abstract GameObject[] targets() throws GameExceptions.GameException;
    public abstract void targets(GameObject[] val) throws GameExceptions.GameException;

    public abstract Player owner() throws GameExceptions.GameException; // Owner can't change

    public abstract Player controler() throws GameExceptions.GameException;
    public abstract void controler(Player val) throws GameExceptions.GameException;

    public abstract boolean cast(String mana) throws GameExceptions.GameException;
    public abstract boolean cast(String mana, boolean payManaCost) throws GameExceptions.GameException;

    public abstract boolean cast(GameObject from) throws GameExceptions.GameException;

    public abstract void play () throws GameExceptions.GameException;
}