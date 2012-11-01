package dndhelpermk2.dices;

import java.util.HashMap;

public class diceCollection
  {

    private HashMap<String, dice> DiceLibrary = new HashMap<String, dice>();
    
    public dice getDice(String diceName)
      {
        return DiceLibrary.get(diceName);
      }
    
    public diceCollection () {
        dice Dice20 = new dice("20-Sided", 20);
        dice Dice12 = new dice("12-Sided", 12);
        dice dice10 = new dice("10-Sided", 10);
        dice dice8 = new dice("8-Sided", 8);
        dice dice6 = new dice("6-Sided", 6);
        dice dice4 = new dice("4-Sided", 4);
        DiceLibrary.put("20-Sided", Dice20);
        DiceLibrary.put("12-Sided", Dice12);
        DiceLibrary.put("10-Sided", dice10);
        DiceLibrary.put("8-Sided", dice8);
        DiceLibrary.put("6-Sided", dice6);
        DiceLibrary.put("4-Sided", dice4);
    }
  } 
