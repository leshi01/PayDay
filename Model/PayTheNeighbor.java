package Model;

public class PayTheNeighbor implements MessageCards {
    int money = 60;
    String icon = "images\\monitor.png";


    /**
     * @return 1 to help me know that it is the paytheneighbor card.
     */
    public int GetCardNumber(){
        return 1;
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
        return "Πλήρωσε τον γείτονα";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "πλήρωσε " + money + " Ευρώ";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Αγώρασε μεταχειρισμένη οθόνη απο τον γείτονα";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
