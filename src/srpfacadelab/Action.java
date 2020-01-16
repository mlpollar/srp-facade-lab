package srpfacadelab;

import java.util.List;

public class Action {
    RpgPlayer player;
    Inventory inventory;
    public Action(RpgPlayer player, Inventory inventory)
    {
        this.player = player;
        this.inventory = inventory;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.gameEngine.getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) {
        int weight = inventory.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && inventory.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());;

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }
        if (item.isRare() && item.isUnique())
            player.gameEngine.playSpecialEffect("blue_swirly");
        else if (item.isRare())
            player.gameEngine.playSpecialEffect("cool_swirly_particles");

        player.getInventory().add(item);

        inventory.calculateStats();

        return true;
    }
}
