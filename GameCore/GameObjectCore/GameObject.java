package GameCore.GameObjectCore;

import GameCore.*;

import java.util.*;

public abstract class GameObject {
    public boolean stackable() { return true; } // Game objects are atackable by default
    GameObject m_source = this;
    public Player m_owner;
    public Player m_controler;
}