/* This file is part of Vault.

    Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Vault.  If not, see <http://www.gnu.org/licenses/>.
*/
package net.milkbowl.vault.chat;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * The main Chat API - allows for Prefix/Suffix nodes along with generic Info nodes if the linked Chat system supports them
 */
public abstract class Chat {

    private final Permission perms;

    public Chat(Permission perms) {
        this.perms = perms;
    }

    /**
     * Gets name of permission method
     *
     * @return Name of Permission Method
     */
    abstract public String getName();

    /**
     * Checks if permission method is enabled.
     *
     * @return Success or Failure
     */
    abstract public boolean isEnabled();

    /**
     * Get a players prefix in the given world
     * Use NULL for world if requesting a global prefix
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @return Prefix
     */
    abstract public String getPlayerPrefix(String world, OfflinePlayer player);

    /**
     * Get players prefix from the world they are currently in.
     * May or may not return the global prefix depending on implementation.
     *
     * @param player Player Object
     * @return Prefix
     */
    public String getPlayerPrefix(Player player) {
        return getPlayerPrefix(player.getWorld().getName(), player);
    }

    /**
     * Sets players prefix in the given world.
     * Use NULL for world for setting in the Global scope.
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param prefix Prefix
     */
    abstract public void setPlayerPrefix(String world, OfflinePlayer player, String prefix);

    /**
     * Set players prefix in the world they are currently in.
     *
     * @param player Player Object
     * @param prefix Prefix
     */
    public void setPlayerPrefix(Player player, String prefix) {
        setPlayerPrefix(player.getWorld().getName(), player, prefix);
    }

    /**
     * Get players suffix in the specified world.
     *
     * @param world  World name
     * @param player OfflinePlayer name
     * @return Suffix
     */
    abstract public String getPlayerSuffix(String world, OfflinePlayer player);

    /**
     * Get players suffix in the world they are currently in.
     *
     * @param player Player Object
     * @return Suffix
     */
    public String getPlayerSuffix(Player player) {
        return getPlayerSuffix(player.getWorld().getName(), player);
    }

    /**
     * Set players suffix for the world specified
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param suffix Suffix
     */
    abstract public void setPlayerSuffix(String world, OfflinePlayer player, String suffix);

    /**
     * Set players suffix in the world they currently occupy.
     *
     * @param player Player Object
     * @param suffix Suffix
     */
    public void setPlayerSuffix(Player player, String suffix) {
        setPlayerSuffix(player.getWorld().getName(), player, suffix);
    }

    /**
     * Get group prefix
     *
     * @param world World name
     * @param group Group name
     * @return Prefix
     */
    abstract public String getGroupPrefix(String world, String group);

    /**
     * Get group prefix
     *
     * @param world World Object
     * @param group Group name
     * @return Prefix
     */
    public String getGroupPrefix(World world, String group) {
        return getGroupPrefix(world.getName(), group);
    }

    /**
     * Set group prefix
     *
     * @param world  World name
     * @param group  Group name
     * @param prefix Prefix
     */
    abstract public void setGroupPrefix(String world, String group, String prefix);

    /**
     * Set group prefix
     *
     * @param world  World Object
     * @param group  Group name
     * @param prefix Prefix
     */
    public void setGroupPrefix(World world, String group, String prefix) {
        setGroupPrefix(world.getName(), group, prefix);
    }

    /**
     * Get group suffix
     *
     * @param world World name
     * @param group Group name
     * @return Suffix
     */
    abstract public String getGroupSuffix(String world, String group);

    /**
     * Get group suffix
     *
     * @param world World Object
     * @param group Group name
     * @return Suffix
     */
    public String getGroupSuffix(World world, String group) {
        return getGroupSuffix(world.getName(), group);
    }

    /**
     * Set group suffix
     *
     * @param world  World name
     * @param group  Group name
     * @param suffix Suffix
     */
    abstract public void setGroupSuffix(String world, String group, String suffix);

    /**
     * Set group suffix
     *
     * @param world  World Object
     * @param group  Group name
     * @param suffix Suffix
     */
    public void setGroupSuffix(World world, String group, String suffix) {
        setGroupSuffix(world.getName(), group, suffix);
    }

    /**
     * Get a players informational node (Integer) value
     *
     * @param world        World name
     * @param player       OfflinePlayer
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public int getPlayerInfoInteger(String world, OfflinePlayer player, String node, int defaultValue);

    /**
     * Get a players informational node (Integer) value
     *
     * @param player       Player Object
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public int getPlayerInfoInteger(Player player, String node, int defaultValue) {
        return getPlayerInfoInteger(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Set a players informational node (Integer) value
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param node   Permission node
     * @param value  Value to set
     */
    abstract public void setPlayerInfoInteger(String world, OfflinePlayer player, String node, int value);

    /**
     * Set a players informational node (Integer) value
     *
     * @param player Player Object
     * @param node   Permission node
     * @param value  Value to set
     */
    public void setPlayerInfoInteger(Player player, String node, int value) {
        setPlayerInfoInteger(player.getWorld().getName(), player, node, value);
    }

    /**
     * Get a groups informational node (Integer) value
     *
     * @param world        World name
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public int getGroupInfoInteger(String world, String group, String node, int defaultValue);

    /**
     * Get a groups informational node (Integer) value
     *
     * @param world        World Object
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public int getGroupInfoInteger(World world, String group, String node, int defaultValue) {
        return getGroupInfoInteger(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a groups informational node (Integer) value
     *
     * @param world World name
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoInteger(String world, String group, String node, int value);

    /**
     * Set a groups informational node (Integer) value
     *
     * @param world World Object
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    public void setGroupInfoInteger(World world, String group, String node, int value) {
        setGroupInfoInteger(world.getName(), group, node, value);
    }

    /**
     * Get a players informational node (Double) value
     *
     * @param world        World name
     * @param player       OfflinePlayer
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public double getPlayerInfoDouble(String world, OfflinePlayer player, String node, double defaultValue);

    /**
     * Get a players informational node (Double) value
     *
     * @param player       Player Object
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public double getPlayerInfoDouble(Player player, String node, double defaultValue) {
        return getPlayerInfoDouble(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Set a players informational node (Double) value
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param node   Permission node
     * @param value  Value to set
     */
    abstract public void setPlayerInfoDouble(String world, OfflinePlayer player, String node, double value);

    /**
     * Set a players informational node (Double) value
     *
     * @param player Player Object
     * @param node   Permission node
     * @param value  Value to set
     */
    public void setPlayerInfoDouble(Player player, String node, double value) {
        setPlayerInfoDouble(player.getWorld().getName(), player, node, value);
    }

    /**
     * Get a groups informational node (Double) value
     *
     * @param world        World name
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public double getGroupInfoDouble(String world, String group, String node, double defaultValue);

    /**
     * Get a groups informational node (Double) value
     *
     * @param world        World Object
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public double getGroupInfoDouble(World world, String group, String node, double defaultValue) {
        return getGroupInfoDouble(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a groups informational node (Double) value
     *
     * @param world World name
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoDouble(String world, String group, String node, double value);

    /**
     * Set a groups informational node (Double) value
     *
     * @param world World Object
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    public void setGroupInfoDouble(World world, String group, String node, double value) {
        setGroupInfoDouble(world.getName(), group, node, value);
    }

    /**
     * Get a players informational node (Boolean) value
     *
     * @param world        World name
     * @param player       OfflinePlayer
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public boolean getPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean defaultValue);

    /**
     * Get a players informational node (Boolean) value
     *
     * @param player       Player Object
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public boolean getPlayerInfoBoolean(Player player, String node, boolean defaultValue) {
        return getPlayerInfoBoolean(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Set a players informational node (Boolean) value
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param node   Permission node
     * @param value  Value to set
     */
    abstract public void setPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean value);

    /**
     * Set a players informational node (Boolean) value
     *
     * @param player Player Object
     * @param node   Permission node
     * @param value  Value to set
     */
    public void setPlayerInfoBoolean(Player player, String node, boolean value) {
        setPlayerInfoBoolean(player.getWorld().getName(), player, node, value);
    }

    /**
     * Get a groups informational node (Boolean) value
     *
     * @param world        Name of World
     * @param group        Name of Group
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue);

    /**
     * Set a players informational node (Boolean) value
     *
     * @param world        World Object
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public boolean getGroupInfoBoolean(World world, String group, String node, boolean defaultValue) {
        return getGroupInfoBoolean(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a groups informational node (Boolean) value
     *
     * @param world World name
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoBoolean(String world, String group, String node, boolean value);

    /**
     * Set a players informational node (Boolean) value
     *
     * @param world World Object
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    public void setGroupInfoBoolean(World world, String group, String node, boolean value) {
        setGroupInfoBoolean(world.getName(), group, node, value);
    }

    /**
     * Get a players informational node (String) value
     *
     * @param world        World name
     * @param player       OfflinePlayer
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public String getPlayerInfoString(String world, OfflinePlayer player, String node, String defaultValue);

    /**
     * Get a players informational node (String) value
     *
     * @param player       Player Object
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public String getPlayerInfoString(Player player, String node, String defaultValue) {
        return getPlayerInfoString(player.getWorld().getName(), player, node, defaultValue);
    }

    /**
     * Set a players informational node (String) value
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param node   Permission node
     * @param value  Value to set
     */
    abstract public void setPlayerInfoString(String world, OfflinePlayer player, String node, String value);

    /**
     * Set a players informational node (String) value
     *
     * @param player Player Object
     * @param node   Permission node
     * @param value  Value ot set
     */
    public void setPlayerInfoString(Player player, String node, String value) {
        setPlayerInfoString(player.getWorld().getName(), player, node, value);
    }

    /**
     * Get a groups informational node (String) value
     *
     * @param world        Name of World
     * @param group        Name of Group
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    abstract public String getGroupInfoString(String world, String group, String node, String defaultValue);

    /**
     * Set a players informational node (String) value
     *
     * @param world        World Object
     * @param group        Group name
     * @param node         Permission node
     * @param defaultValue Default value
     * @return Value
     */
    public String getGroupInfoString(World world, String group, String node, String defaultValue) {
        return getGroupInfoString(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a groups informational node (String) value
     *
     * @param world World name
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    abstract public void setGroupInfoString(String world, String group, String node, String value);

    /**
     * Set a groups informational node (String) value
     *
     * @param world World name
     * @param group Group name
     * @param node  Permission node
     * @param value Value to set
     */
    public void setGroupInfoString(World world, String group, String node, String value) {
        setGroupInfoString(world.getName(), group, node, value);
    }

    /**
     * Check if player is member of a group.
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @param group  Group name
     * @return Success or Failure
     */
    abstract public boolean playerInGroup(String world, OfflinePlayer player, String group);

    /**
     * Check if player is member of a group.
     *
     * @param player Player Object
     * @param group  Group name
     * @return Success or Failure
     */
    public boolean playerInGroup(Player player, String group) {
        return playerInGroup(player.getWorld().getName(), player, group);
    }

    /**
     * Gets the list of groups that this player has
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @return Array of groups
     */
    abstract public String[] getPlayerGroups(String world, OfflinePlayer player);

    /**
     * Gets the list of groups that this player has
     *
     * @param player Player Object
     * @return Array of groups
     */
    public String[] getPlayerGroups(Player player) {
        return getPlayerGroups(player.getWorld().getName(), player);
    }

    /**
     * Gets players primary group
     *
     * @param world  World name
     * @param player OfflinePlayer
     * @return Players primary group
     */
    abstract public String getPrimaryGroup(String world, OfflinePlayer player);

    /**
     * Get players primary group
     *
     * @param player Player Object
     * @return Players primary group
     */
    public String getPrimaryGroup(Player player) {
        return getPrimaryGroup(player.getWorld().getName(), player);
    }

    /**
     * Returns a list of all known groups
     *
     * @return an Array of String of all groups
     */
    public String[] getGroups() {
        return perms.getGroups();
    }
}
