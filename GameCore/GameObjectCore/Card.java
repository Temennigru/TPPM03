package GameCore.GameObjectCore;

import GameCore.*;

import java.util.Vector;
import java.util.Arrays;

public abstract interface Card extends GameObject {

    // Card reflection
    public GameEnums.SuperType[] superTypes() throws GameExceptions.GameException;
    public void superTypes(GameEnums.SuperType[] subtypes) throws GameExceptions.GameException;

    public GameEnums.Type[] types() throws GameExceptions.GameException;
    public void types(GameEnums.Type[] subtypes) throws GameExceptions.GameException;

    public GameEnums.SubType[] subTypes() throws GameExceptions.GameException;
    public void subTypes(GameEnums.SubType[] subtypes) throws GameExceptions.GameException;

    // This is where the magic happens
    public boolean cast () throws GameExceptions.GameException;

    public boolean cast (boolean payManaCost) throws GameExceptions.GameException;

    public abstract void play () throws GameExceptions.GameException;

    public abstract void discard () throws GameExceptions.GameException;

    public abstract void place (GameEnums.Zone zone) throws GameExceptions.GameException;

    public abstract void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException;

    // Print card details
    public abstract String toString() throws GameExceptions.GameException;

    // Activate ability
    public abstract boolean activateAt(int ability) throws GameExceptions.GameException;

    // Modifiers / Member access
    public abstract void reset(String field) throws GameExceptions.GameException;

    public abstract int power () throws GameExceptions.GameException;
    public abstract void power (int value) throws GameExceptions.GameException;

    public abstract int toughness () throws GameExceptions.GameException;
    public abstract void toughness (int value) throws GameExceptions.GameException;

    public abstract int damage () throws GameExceptions.GameException;
    public abstract void damage (int value) throws GameExceptions.GameException;

    // Evergreen abilities
    public abstract boolean deathtouch() throws GameExceptions.GameException;
    public abstract void deathtouch(boolean val) throws GameExceptions.GameException;

    public abstract boolean defender() throws GameExceptions.GameException;
    public abstract void defender(boolean val) throws GameExceptions.GameException;

    public abstract boolean doublestrike() throws GameExceptions.GameException;
    public abstract void doublestrike(boolean val) throws GameExceptions.GameException;

    public abstract boolean firststrike() throws GameExceptions.GameException;
    public abstract void firststrike(boolean val) throws GameExceptions.GameException;

    public abstract boolean flash() throws GameExceptions.GameException;
    public abstract void flash(boolean val) throws GameExceptions.GameException;

    public abstract boolean flying() throws GameExceptions.GameException;
    public abstract void flying(boolean val) throws GameExceptions.GameException;

    public abstract boolean hexproof() throws GameExceptions.GameException;
    public abstract void hexproof(boolean val) throws GameExceptions.GameException;

    public abstract boolean indestructible() throws GameExceptions.GameException;
    public abstract void indestructible(boolean val) throws GameExceptions.GameException;

    public abstract boolean intimidate() throws GameExceptions.GameException;
    public abstract void intimidate(boolean val) throws GameExceptions.GameException;

    public abstract boolean landwalk() throws GameExceptions.GameException;
    public abstract void landwalk(boolean val) throws GameExceptions.GameException;

    public abstract boolean lifelink() throws GameExceptions.GameException;
    public abstract void lifelink(boolean val) throws GameExceptions.GameException;

    public abstract boolean protection() throws GameExceptions.GameException;
    public abstract void protection(boolean val) throws GameExceptions.GameException;

    public abstract boolean reach() throws GameExceptions.GameException;
    public abstract void reach(boolean val) throws GameExceptions.GameException;

    public abstract boolean trample() throws GameExceptions.GameException;
    public abstract void trample(boolean val) throws GameExceptions.GameException;

    public abstract boolean vigilance() throws GameExceptions.GameException;
    public abstract void vigilance(boolean val) throws GameExceptions.GameException;

    public abstract int regen() throws GameExceptions.GameException;
    public abstract void regen(int val) throws GameExceptions.GameException;

}