package introduction.Interfaces;

import introduction.Player.Item;

public interface 	Shop {

	public int showShopItems();

	public Item buyItem(int itemChoice);

	public String inspectItem(int itemChoice);

	public int itemCost(int itemChoice);
}
