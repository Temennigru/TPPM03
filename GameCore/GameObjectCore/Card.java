package GameCore.GameObjectCore;

import GameCore.*;

import java.util.Vector;
import java.util.Arrays;
import javax.swing.ImageIcon;

public abstract interface Card extends GameObject {

    // This is where the magic happens
    public abstract boolean cast () throws GameExceptions.GameException;
    public abstract boolean cast (boolean payManaCost) throws GameExceptions.GameException;

    public abstract void play () throws GameExceptions.GameException;

    public abstract void discard () throws GameExceptions.GameException;

    public abstract void place (GameEnums.Zone zone) throws GameExceptions.GameException;

    public abstract void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException;

    // Print card details
    public abstract String toString() throws GameExceptions.GameException;
    public abstract String toString(boolean simple) throws GameExceptions.GameException;

    public abstract ImageIcon getImg(boolean large);

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

    public abstract void tap();
    public abstract boolean isTapped();
    public abstract void unTap();

    public abstract String name() throws GameExceptions.GameException;
    public abstract void name(String name) throws GameExceptions.GameException;

    public abstract Player controler() throws GameExceptions.GameException;
    public abstract void controler(Player player) throws GameExceptions.GameException;

    public abstract Player owner() throws GameExceptions.GameException; // Owner can't be changed

    public abstract GameEnums.SuperType[] superTypes() throws GameExceptions.GameException;
    public abstract void superTypes(GameEnums.SuperType[] subtypes) throws GameExceptions.GameException;

    public abstract GameEnums.Type[] types() throws GameExceptions.GameException;
    public abstract void types(GameEnums.Type[] subtypes) throws GameExceptions.GameException;

    public abstract GameEnums.SubType[] subTypes() throws GameExceptions.GameException;
    public abstract void subTypes(GameEnums.SubType[] subtypes) throws GameExceptions.GameException;

    public abstract GameEnums.Zone location();

    public abstract boolean sick();
    public abstract sick(boolean val);




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

    public abstract String landwalk() throws GameExceptions.GameException;
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

    public abstract boolean castable() throws GameExceptions.GameException;

}