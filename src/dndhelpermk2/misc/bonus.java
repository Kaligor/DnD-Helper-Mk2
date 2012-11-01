package dndhelpermk2.misc;

public class bonus  
  {
    private String StatName;
    private int StatBonus;

    public bonus(String StatName, int StatBonus)
      {
        this.StatName = StatName;
        this.StatBonus = StatBonus;
      }

    
    public int getStatBonus()
      {
        return StatBonus;
      }

    public void setStatBonus(int StatBonus)
      {
        this.StatBonus = StatBonus;
      }

    public String getStatName()
      {
        return StatName;
      }

    public void setStatName(String StatName)
      {
        this.StatName = StatName;
      }

    @Override
    public String toString()
      {
        return StatName + " Bonus " +StatBonus;
      }
    
    
  }
