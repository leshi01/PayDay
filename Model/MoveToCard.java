package Model;

public class MoveToCard implements MessageCards{
    int money = 0;
    String icon = "images\\db.jpg";

    /**
     * @return 5 to help me know that it is the movetocard card.
     */
    public int GetCardNumber(){
        return 5;
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
        return "Μετακίνηση στην πλησιέστερη θέση Συμφωνίας/Αγοραστή";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "Εντάξει";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Πηγαίνετε στην επόμενη θέση Συμφωνίας/Αγοραστή\"";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
