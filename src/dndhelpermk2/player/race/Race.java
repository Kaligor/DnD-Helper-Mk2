package dndhelpermk2.player.race;


import dndhelpermk2.misc.bonus;
import dndhelpermk2.misc.skill;
import dndhelpermk2.storage.Storable;
import java.util.ArrayList;

public class Race implements Storable<String>
  {
    private String raceName;
    private String Size;
    private int Speed;
    private String Vision;
    private ArrayList<String> Language = new ArrayList<String>();
    private ArrayList<bonus> Bonuses = new ArrayList<bonus>();
    private ArrayList<skill> Skills = new ArrayList<skill>();

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public ArrayList<bonus> getBonuses()
      {
        return Bonuses;
      }
    
    public void setBonuses(ArrayList<bonus> Bonuses)
      {
        this.Bonuses = Bonuses;
      }
    
    public ArrayList<String> getLanguage()
      {
        return Language;
      }
    
    public void setLanguage(ArrayList<String> Language)
      {
        this.Language = Language;
      }
    
    public String getSize()
      {
        return Size;
      }
    
    public void setSize(String Size)
      {
        this.Size = Size;
      }
    
    public ArrayList<skill> getSkills()
      {
        return Skills;
      }
    
    public void setSkills(ArrayList<skill> Skills)
      {
        this.Skills = Skills;
      }
    
    public int getSpeed()
      {
        return Speed;
      }
    
    public void setSpeed(int Speed)
      {
        this.Speed = Speed;
      }
    
    public String getVision()
      {
        return Vision;
      }
    
    public void setVision(String Vision)
      {
        this.Vision = Vision;
      }
    
    public String getRaceName()
      {
        return raceName;
      }
    
    public void setRaceName(String raceName)
      {
        this.raceName = raceName;
      }
    //</editor-fold>
    
    public void addLanguageToRace (String LanguageToBeAdded) {
        Language.add(LanguageToBeAdded);
    }
    
    public void addBonusesToRace (bonus bonusToBeAdded) {
        Bonuses.add(bonusToBeAdded);
    }
    
    public void addSkillstoRace (skill skillToBeAdded) {
        Skills.add(skillToBeAdded);
    }
 

    public Race(String raceName, String Size, int Speed, String Vision)
      {
        this.raceName = raceName;
        this.Size = Size;
        this.Speed = Speed;
        this.Vision = Vision;
      }

    @Override
    public String toString()
      {
        return "Race{" + "raceName=" + raceName + ", Size=" + Size + ", Speed=" + Speed + ", Vision=" + Vision + ", Language=" + Language + ", Bonuses=" + Bonuses + ", Skills=" + Skills + '}';
      }

    @Override
    public String getID()
      {
        return raceName;
      }
    
  }

