package Model;

public interface MessageCards{

    /**
     * @return 1 if it is the paytheneighbor card, 2 if it is the getfromneighbor card,
     * 3 if it is the charity card, 4.....
     */
    public int GetCardNumber();

    /**
     * @return the amount of money the card says.
     */
    public int getMoney();

    /**
     * @return the title of the card.
     */
    public String CardTitle();

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString();

    /**
     * @return what the card says the player to do.
     */
    public String CardString();

    /**
     * @return the name of card's icon.
     */
    public String CardIcon();
}
