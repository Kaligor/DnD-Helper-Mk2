package dndhelpermk2.player.classes;

import dndhelpermk2.misc.bonus;
import dndhelpermk2.storage.Storable;
import java.util.ArrayList;

public class charClass implements Storable<String>
  {

    private String name;
    private String archtype;
    private int startHP;
    private int levelHP;
    private int surgesPerDay;
    private ArrayList<bonus> defenseBonus = new ArrayList<bonus>();

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public ArrayList<bonus> getDefenseBonus()
      {
        return defenseBonus;
      }

    public int getLevelHP()
      {
        return levelHP;
      }

    public int getStartHP()
      {
        return startHP;
      }

    public int getSurgesPerDay()
      {
        return surgesPerDay;
      }

    public void setDefenseBonus(ArrayList<bonus> defenseBonus)
      {
        this.defenseBonus = defenseBonus;
      }

    public void setLevelHP(int levelHP)
      {
        this.levelHP = levelHP;
      }

    public void setStartHP(int startHP)
      {
        this.startHP = startHP;
      }

    public void setSurgesPerDay(int surgesPerDay)
      {
        this.surgesPerDay = surgesPerDay;
      }

    public String getArchtype()
      {
        return archtype;
      }

    public void setArchtype(String archtype)
      {
        this.archtype = archtype;
      }

    public String getName()
      {
        return name;
      }

    public void setName(String name)
      {
        this.name = name;
      }
    //</editor-fold>

    public void addBonusToClass(bonus bonus)
      {
        defenseBonus.add(bonus);
      }

    public charClass(String name, String archtype, int startHP, int levelHP, int surgesPerDay)
      {
        this.name = name;
        this.archtype = archtype;
        this.startHP = startHP;
        this.levelHP = levelHP;
        this.surgesPerDay = surgesPerDay;
      }

    @Override
    public String toString()
      {
        return name;
      }

    @Override
    public String getID()
      {
        return name;
      }
  }
