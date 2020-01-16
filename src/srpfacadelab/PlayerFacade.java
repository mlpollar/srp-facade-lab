package srpfacadelab;

public class PlayerFacade {
    Inventory inventory;
    Health health;
    Action action;
    public PlayerFacade(IGameEngine gameEngine)
    {
        RpgPlayer player = new RpgPlayer(gameEngine);
        inventory = new Inventory(player);
        health = new Health(player, inventory);
        action = new Action(player, inventory);
    }

    public void useItem(Item item)
    {
        action.useItem(item);
    }

    public void pickupItem(Item item)
    {
        action.pickUpItem(item);
    }

    public void takeDamage(int damage)
    {
        health.takeDamage(damage);
    }

    public void calculateStats(){
        inventory.calculateStats();
    }

    public void checkIfItemExistsInInventory(Item item){
        inventory.checkIfItemExistsInInventory(item);
    }

    public int calculateInventoryWeight() {
        return inventory.calculateInventoryWeight();
    }

}
