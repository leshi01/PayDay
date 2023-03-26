package Model;

public class DealCards {

    String icon,cardTitle,cardString;
    int BuyPrice, SellPrice;

    public DealCards(String icon, String Title, String string){
        this.icon = icon;
        this.cardTitle = Title;
        this.cardString = string;
    }


    /**
     * @return the title of the card.
     */
    public String CardTitle() {

        return cardTitle;
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {

        return cardString;
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {

        return icon;
    }

}
