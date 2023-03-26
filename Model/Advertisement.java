package Model;

public class Advertisement implements MessageCards{
    int money = 20;
    String icon = "images\\tiktok.png";

    /**
     * @return 6 to help me know that it is the Advertisement card.
     */
    public int GetCardNumber(){
        return 6;
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
        return "Διαφήμιση";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "πούλησέ την για 20 ευρώ";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Βαριέσαι στα διαλείμματα δες λιγο Τικ Τοκ";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
