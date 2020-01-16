package srpfacadelab;

public class Inventory {

    RpgPlayer player;

    public Inventory(RpgPlayer player)
    {
        this.player = player;
    }

    public void calculateStats() {
        for (Item i: player.inventory) {
            player.setArmour(player.getArmour()+ i.getArmour());
        }
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.inventory) {
            sum += i.getWeight();
        }
        return sum;
    }



}
