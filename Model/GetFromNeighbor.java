package Model;

public class GetFromNeighbor implements MessageCards{
    int money = 50;
    String icon = "images\\format.jpeg";

    /**
     * @return 2 to help me know that it is the getfromneighbor card.
     */
    public int GetCardNumber(){
        return 2;
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
        return "πάρε λεφτά απο τον γείτονα";
    }

    /**
     * @return the sting written on the button of the card.
     */
    public String ButtonString() {
        return "πάρε " + money + " Ευρώ απο τον γείτονα";
    }

    /**
     * @return what the card says the player to do.
     */
    public String CardString() {
        return "Format στον υπολογιστή του γείτονα";
    }

    /**
     * @return the name of card's icon.
     */
    public String CardIcon() {
        return icon;
    }
}
