package Model;

public class Charity implements MessageCards{
    int money = 50;
    String icon = "images\\caretta.jpg";

    /**
     * @return 3 to help me know that it is the charity card.
     */
    public int GetCardNumber(){
        return 3;
    }

    /**
     * @return the amount of money the card says.
     */
    public int getMoney() {
        return money;
    }

    /**
     * @return the title of the card.
     */
    public String CardTitle() {
        return "Φιλανθρωπία";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "Πλήρωσε " + money + " Ευρώ στο Jackpot";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Διάσωση χελώνας Καρέτα-Καρέτα";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
