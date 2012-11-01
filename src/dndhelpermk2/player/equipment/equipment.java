package dndhelpermk2.player.equipment;

import dndhelpermk2.dices.dice;
import dndhelpermk2.player.Player;
import static dndhelpermk2.staticMethods.NumberConverter.AbiCal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;

public class equipment
  {
    //Weapon Values
    private String itemRank;
    private String itemName;
    private String itemType;
    private int itemProf;
    private int NrOfDice;
    private int DmgPerDice;
    private int Range;
    private int Price;
    private int hands;
    private String Group;
    private String Properties;
    private ArrayList<dice> dices = new ArrayList<dice>();
    private ArrayList<dice> tempDices = new ArrayList<dice>();
    //Armor Values
    private int ArmorBonus;
    private int MinimumEnhancementBonus;
    private int Check;
    private int Speed;
    private int Weight;
    int StatUsed;
    String StatUsedText;

    public void addDiceToWeapon(dice dice)
      {
        dices.add(dice);
      }

    public int RollAllDices(Player CP, JTextArea text, String type)
      {
        tempDices = dices;
        Iterator<dice> diceItr = tempDices.iterator();
        int result = 0;
        int diceRoll;
        int total = 0;
        dice tempDice;
        while (diceItr.hasNext()) {
            tempDice = diceItr.next();
            if (type.equals("Strength")) {
                StatUsed = CP.getStrength();
                StatUsedText = "Strength";
            } else if (type.equals("Constitution")) {
                StatUsed = CP.getConstitution();
                StatUsedText = "Constitution";
            } else if (type.equals("Wisdom")) {
                StatUsed = CP.getWisdom();
                StatUsedText = "Wisdom";
            } else if (type.equals("Charisma")) {
                StatUsed = CP.getCharisma();
                StatUsedText = "Charisma";
            } else if (type.equals("Dexterity")) {
                StatUsed = CP.getDexterity();
                StatUsedText = "Dexterity";
            } else if (type.equals("Intelligence")) {
                StatUsed = CP.getIntelligence();
                StatUsedText = "Intelligence";
            }
            diceRoll = tempDice.RollDice();
            text.append(tempDice.getDiceName() + "\n");
            result = diceRoll;
            total += diceRoll;
            text.append("DiceResult: " + result + " Damage \n");
        }
        text.append("***************************** \n");
        text.append("Modifier: " + AbiCal(StatUsed) + "(" + StatUsedText + ")" + "\n");
        text.append("Grand Total: " + (total + AbiCal(StatUsed)) + "\n");
        text.append("***************************** \n");

        return result;
      }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public int getHands()
      {
        return hands;
      }

    public void setHands(int hands)
      {
        this.hands = hands;
      }

    public ArrayList<dice> getDices()
      {
        return dices;
      }

    public void setDices(ArrayList<dice> dices)
      {
        this.dices = dices;
      }

    public int getArmorBonus()
      {
        return ArmorBonus;
      }

    public void setArmorBonus(int ArmorBonus)
      {
        this.ArmorBonus = ArmorBonus;
      }

    public int getCheck()
      {
        return Check;
      }

    public void setCheck(int Check)
      {
        this.Check = Check;
      }

    public int getDmgPerDice()
      {
        return DmgPerDice;
      }

    public void setDmgPerDice(int DmgPerDice)
      {
        this.DmgPerDice = DmgPerDice;
      }

    public String getGroup()
      {
        return Group;
      }

    public void setGroup(String Group)
      {
        this.Group = Group;
      }

    public int getMinimumEnhancementBonus()
      {
        return MinimumEnhancementBonus;
      }

    public void setMinimumEnhancementBonus(int MinimumEnhancementBonus)
      {
        this.MinimumEnhancementBonus = MinimumEnhancementBonus;
      }

    public int getNrOfDice()
      {
        return NrOfDice;
      }

    public void setNrOfDice(int NrOfDice)
      {
        this.NrOfDice = NrOfDice;
      }

    public int getPrice()
      {
        return Price;
      }

    public void setPrice(int Price)
      {
        this.Price = Price;
      }

    public String getProperties()
      {
        return Properties;
      }

    public void setProperties(String Properties)
      {
        this.Properties = Properties;
      }

    public int getRange()
      {
        return Range;
      }

    public void setRange(int Range)
      {
        this.Range = Range;
      }

    public int getSpeed()
      {
        return Speed;
      }

    public void setSpeed(int Speed)
      {
        this.Speed = Speed;
      }

    public int getWeight()
      {
        return Weight;
      }

    public void setWeight(int Weight)
      {
        this.Weight = Weight;
      }

    public String getItemName()
      {
        return itemName;
      }

    public void setItemName(String itemName)
      {
        this.itemName = itemName;
      }

    public int getItemProf()
      {
        return itemProf;
      }

    public void setItemProf(int itemProf)
      {
        this.itemProf = itemProf;
      }

    public String getItemRank()
      {
        return itemRank;
      }

    public void setItemRank(String itemRank)
      {
        this.itemRank = itemRank;
      }

    public String getItemType()
      {
        return itemType;
      }

    public void setItemType(String itemType)
      {
        this.itemType = itemType;
      }
    //</editor-fold>

    /**
     * Weapon Constructor
     *
     * @param itemRank
     * @param itemName
     * @param itemProf
     * @param NrOfDice
     * @param DmgPerDice
     * @param Range
     * @param Price
     * @param Group
     * @param Properties
     */
    public equipment(String itemRank, String itemName, int itemProf, int NrOfDice, int DmgPerDice, int Range, int Price, int Weight, String Group, String Properties, int hands)
      {
        this.itemRank = itemRank;
        this.itemName = itemName;
        this.itemProf = itemProf;
        this.NrOfDice = NrOfDice;
        this.DmgPerDice = DmgPerDice;
        this.Range = Range;
        this.Price = Price;
        this.Group = Group;
        this.Properties = Properties;
        this.Weight = Weight;
        this.itemType = "Weapon";
        this.hands = hands;
      }

    /**
     * Armor Constructor
     *
     * @param itemName
     * @param itemType
     * @param Price
     * @param Group
     * @param ArmorBonus
     * @param MinimumEnhancementBonus
     * @param Speed
     * @param Weight
     */
    public equipment(String itemName, String itemType, int Price, String Group, int ArmorBonus, int MinimumEnhancementBonus, int Check, int Speed, int Weight)
      {
        this.itemName = itemName;
        this.itemType = itemType;
        this.Price = Price;
        this.Group = Group;
        this.ArmorBonus = ArmorBonus;
        this.MinimumEnhancementBonus = MinimumEnhancementBonus;
        this.Speed = Speed;
        this.Weight = Weight;
        this.Check = Check;
      }
  }
