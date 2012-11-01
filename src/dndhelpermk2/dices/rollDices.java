package dndhelpermk2.dices;

import javax.swing.JTextArea;

public class rollDices
  {

    private static final String NEWLINE = "\n";

    public static void rollDices(JTextArea textArea, String abilityName, dice NrofSides, int nrOfDices, String Modifer, int ModiferValue, int bonus,  int penalties) {
        int tempDice;
        int valueStorage = 0;
        int grandTotal;
        textArea.setText("------------- | " + abilityName + " | -------------" + NEWLINE);
        for (int i = 0; i < nrOfDices; i++) {
            tempDice = NrofSides.RollDice();
            textArea.append(NrofSides.getDiceName() + NEWLINE
                    + "<Result: " + tempDice + NEWLINE);
            valueStorage += tempDice;
        }
        grandTotal = valueStorage + ModiferValue + bonus + penalties;
        textArea.append(
                "<Modifer: " + ModiferValue + "(" + Modifer + ")" + NEWLINE
                + "<Bonus: " + bonus + NEWLINE
                + "<Penalties: " + penalties + NEWLINE
                + "<Total: " + grandTotal + NEWLINE
                + "------------------------------------" + NEWLINE);
    }
    
    public static void rollDices(JTextArea textArea, dice primaryDices, int nrOfPrimaryDices, String primaryModifier, int PrimarymodifierValue, dice secondaryDices, int nrOfSecondaryDices, String secondaryModifier, int secondaryModifierValue, int bonus, int penalties)
      {
        int tempDice;
        int valueStorage = 0;
        int grandTotal;
        textArea.setText("------------------------------------" + NEWLINE);
        for (int i = 0; i < nrOfPrimaryDices; i++) {
            tempDice = primaryDices.RollDice();
            textArea.append(primaryDices.getDiceName() + NEWLINE
                    + "<Result: " + tempDice + NEWLINE);
            valueStorage += tempDice;
        }
        grandTotal = valueStorage + PrimarymodifierValue + bonus + penalties;
        textArea.append(
                "<Modifer: " + PrimarymodifierValue + "(" + primaryModifier + ")" + NEWLINE
                + "<Bonus: " + bonus + NEWLINE
                + "<Penalties: " + penalties + NEWLINE
                + "<Total: " + grandTotal + NEWLINE
                + "------------------------------------" + NEWLINE);

        //SECONDARY DICES
        tempDice = 0;
        valueStorage = 0;
        grandTotal = 0;

        if (nrOfSecondaryDices != 0) {

            textArea.append("------------------------------------" + NEWLINE);
            for (int i = 0; i < nrOfSecondaryDices; i++) {
                tempDice = secondaryDices.RollDice();
                textArea.append(secondaryDices.getDiceName() + NEWLINE
                        + "<Result: " + tempDice + NEWLINE);
                valueStorage += tempDice;
            }
            grandTotal = valueStorage + secondaryModifierValue + bonus - penalties;
            textArea.append(
                    "<Modifer: " + secondaryModifierValue + "(" + secondaryModifier + ")" + NEWLINE
                    + "<Bonus: " + bonus + NEWLINE
                    + "<Penalties: " + penalties + NEWLINE
                    + "<Total: " + grandTotal + NEWLINE
                    + "------------------------------------" + NEWLINE);
        }
      }
  }
