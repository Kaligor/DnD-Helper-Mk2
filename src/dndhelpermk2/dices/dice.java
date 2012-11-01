package dndhelpermk2.dices;

public class dice
  {

    private String DiceName;
    private int HighestValues;

    public dice(String DiceName, int HighestValues)
      {
        this.DiceName = DiceName;
        this.HighestValues = HighestValues;
      }

    public int RollDice()
      {
        int result = (int) (Math.random() * (HighestValues) + 1);
        return result;
      }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getDiceName()
      {
        return DiceName;
      }

    public void setDiceName(String DiceName)
      {
        this.DiceName = DiceName;
      }

    public int getHighestValues()
      {
        return HighestValues;
      }

    public void setHighestValues(int HighestValues)
      {
        this.HighestValues = HighestValues;
      }
    //</editor-fold>
  }
