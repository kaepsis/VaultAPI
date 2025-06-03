package net.milkbowl.vault.permission;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

/**
 * The main Permission API - allows for group and player based permission tests
 */
public abstract class Permission {

    protected static final Logger log = Logger.getLogger("Minecraft");
    protected Plugin plugin = null;

    /**
     * Gets name of permission method
     *
     * @return Name of Permission Method
     */
    public abstract String getName();

    /**
     * Checks if permission method is enabled.
     *
     * @return Success or Failure
     */
    public abstract boolean isEnabled();

    /**
     * Returns if the permission system is or attempts to be compatible with super-perms.
     *
     * @return True if this permission implementation works with super-perms
     */
    public abstract boolean hasSuperPermsCompat();

    /**
     * Checks if a CommandSender has a permission node.
     * This will return the result of bukkit's generic .hasPermission() method and is identical in all cases.
     * This method will explicitly fail if the registered permission system does not register permissions in bukkit.
     *
     * @param sender     to check permissions on
     * @param permission to check for
     * @return true if has permission
     */
    public boolean has(CommandSender sender, String permission) {
        return sender.hasPermission(permission);
    }

    public abstract boolean playerHas(String worldName, OfflinePlayer player, String permission);

    public abstract boolean playerAdd(String worldName, OfflinePlayer player, String permission);

    public abstract boolean playerRemove(String worldName, OfflinePlayer player, String permission);

    public abstract boolean groupHas(String world, String group, String permission);

    public abstract boolean groupAdd(String world, String group, String permission);

    public abstract boolean groupRemove(String world, String group, String permission);

    public abstract boolean playerInGroup(String world, OfflinePlayer player, String group);

    public abstract boolean playerAddGroup(String world, OfflinePlayer player, String group);

    public abstract boolean playerRemoveGroup(String world, OfflinePlayer player, String group);

    public abstract String[] getPlayerGroups(String world, OfflinePlayer player);

    public abstract String getPrimaryGroup(String world, OfflinePlayer player);

    public abstract String[] getGroups();

    public abstract boolean hasGroupSupport();

    public abstract PermissionAttachment addAttachment(Player player, String permission, boolean value);

    public abstract PermissionAttachment removeAttachment(Player player, PermissionAttachment attachment);

    public abstract void playerRemoveAttachment(Player player, PermissionAttachment attachment);

    public abstract PermissionAttachmentInfo[] getEffectivePermissions(Player player);
}
