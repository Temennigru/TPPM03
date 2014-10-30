package GameCore.GameObjectCore;

import GameCore.*;

import java.util.*;

public abstract interface GameObject {
    public abstract boolean stackable() throws GameExceptions.GameException;
    public abstract void stackable(boolean val) throws GameExceptions.GameException;

    public abstract GameObject source() throws GameExceptions.GameException;
    public abstract void source(GameObject val) throws GameExceptions.GameException;
    
    public abstract GameObject destination() throws GameExceptions.GameException;
    public abstract void destination(GameObject val) throws GameExceptions.GameException;

    public abstract Player owner() throws GameExceptions.GameException;
    public abstract void owner(Player val) throws GameExceptions.GameException;

    public abstract Player controler() throws GameExceptions.GameException;
    public abstract void controler(Player val) throws GameExceptions.GameException;
}