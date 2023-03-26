package Model;

public class PayBill  implements MessageCards{
    int money = 500;
    String icon = "images\\enfia.jpg";

    /**
     * @return 4 to help me know that it is the paybill card.
     */
    public int GetCardNumber(){
        return 4;
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
        return "Εξόφληση Λογαριασμού";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "Κράτα το λογαριασμό";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Πλήρωσε στην 31η του μήνα 1η δώση του ΕΝΦΙΑ (500 Ευρώ)";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
