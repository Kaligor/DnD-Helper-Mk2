package dndhelpermk2.player;

import dndhelpermk2.misc.knowledge;
import dndhelpermk2.player.classes.charClass;
import dndhelpermk2.player.race.Race;
import dndhelpermk2.storage.Storable;

public class Player implements Storable<String>
  {

    private String playerName;
    private String CharacterName;
    private int Level;
    private charClass characterClass;
    private Race Race;
    private String Age;
    private String Gender;
    private String Alignment;
    //Ability Score
    private int Strength;
    private int Constitution;
    private int Dexterity;
    private int Intelligence;
    private int Wisdom;
    private int Charisma;
    //Hit Points
    private int CurrentHP;
    private int MaxHP;
    private int bloodied;
    private int Surges;
    private int HpPerLevel;
    //Defenses
    private int AC;
    private int ACMisc;
    private int Fortitude;
    private int FortMisc;
    private int Reflex;
    private int ReflexMisc;
    private int Will;
    private int WillMisc;
    //Initiative
    private int InitiativeBase;
    private int InitiativeMisc;
    //Equipment
    //Skills
    private knowledge skills = new knowledge();
    //Bonuses
    private int CheckBonus = 0;
    private int SpeedBonus = 0;
    private int BonusAC = 0;
    private int BonusFort = 0;
    private int BonusRef = 0;
    private int BonusWill = 0;
    
    private String mainHand;
    private String armor;

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getArmor()
      {
        return armor;
      }

    public void setArmor(String armor)
      {
        this.armor = armor;
      }

    public String getMainHand()
      {
        return mainHand;
      }

    public void setMainHand(String mainHand)
      {
        this.mainHand = mainHand;
      }
    
    public knowledge getSkills()
      {
        return skills;
      }

    public void setSkills(knowledge skills)
      {
        this.skills = skills;
      }

    public int getACMisc()
      {
        return ACMisc;
      }

    public void setACMisc(int ACMisc)
      {
        this.ACMisc = ACMisc;
      }

    public void increaseACMisc(int Increase)
      {
        this.ACMisc += Increase;
      }

    public int getFortMisc()
      {
        return FortMisc;
      }

    public void setFortMisc(int FortMisc)
      {
        this.FortMisc = FortMisc;
      }

    public void increaseFortMisc(int Increase)
      {
        this.FortMisc += Increase;
      }

    public int getReflexMisc()
      {
        return ReflexMisc;
      }

    public void setReflexMisc(int ReflexMisc)
      {
        this.ReflexMisc = ReflexMisc;
      }

    public void increaseReflexMisc(int Increase)
      {
        this.ReflexMisc += Increase;
      }

    public int getWillMisc()
      {
        return WillMisc;
      }

    public void setWillMisc(int WillMisc)
      {
        this.WillMisc = WillMisc;
      }

    public void increaseWillMisc(int Increase)
      {
        this.WillMisc += Increase;
      }

    public int getInitiativeBase()
      {
        return InitiativeBase;
      }

    public void setInitiativeBase(int InitiativeBase)
      {
        this.InitiativeBase = InitiativeBase;
      }

    public int getInitiativeMisc()
      {
        return InitiativeMisc;
      }

    public void setInitiativeMisc(int InitiativeMisc)
      {
        this.InitiativeMisc = InitiativeMisc;
      }

    public int getBloodied()
      {
        return bloodied;
      }

    public void setBloodied(int bloodied)
      {
        this.bloodied = bloodied;
      }

    public int getHpPerLevel()
      {
        return HpPerLevel;
      }

    public void setHpPerLevel(int HpPerLevel)
      {
        this.HpPerLevel = HpPerLevel;
      }

    public int getCurrentHP()
      {
        return CurrentHP;
      }

    public void setCurrentHP(int HP)
      {
        this.CurrentHP = HP;
      }

    public int getMaxHP()
      {
        return MaxHP;
      }

    public void setMaxHP(int MaxHP)
      {
        this.MaxHP = MaxHP;
      }

    public int getSurges()
      {
        return Surges;
      }

    public void setSurges(int Surges)
      {
        this.Surges = Surges;
      }

    public int getAC()
      {
        return AC;
      }

    public void setAC(int AC)
      {
        this.AC = AC;
      }

    public int getFortitude()
      {
        return Fortitude;
      }

    public void setFortitude(int Fortitude)
      {
        this.Fortitude = Fortitude;
      }

    public int getReflex()
      {
        return Reflex;
      }

    public void setReflex(int Reflex)
      {
        this.Reflex = Reflex;
      }

    public int getWill()
      {
        return Will;
      }

    public void setWill(int Will)
      {
        this.Will = Will;
      }

    public charClass getCharacterClass()
      {
        return characterClass;
      }

    public void setCharacterClass(charClass characterClass)
      {
        this.characterClass = characterClass;
      }

    public Race getRace()
      {
        return Race;
      }

    public void setRace(Race Race)
      {
        this.Race = Race;
      }

    public String getAge()
      {
        return Age;
      }

    public void setAge(String Age)
      {
        this.Age = Age;
      }

    public String getAlignment()
      {
        return Alignment;
      }

    public void setAlignment(String Alignment)
      {
        this.Alignment = Alignment;
      }

    public String getCharacterName()
      {
        return CharacterName;
      }

    public void setCharacterName(String CharacterName)
      {
        this.CharacterName = CharacterName;
      }

    public int getCharisma()
      {
        return Charisma;
      }

    public void setCharisma(int Charisma)
      {
        this.Charisma = Charisma;
      }

    public int getConstitution()
      {
        return Constitution;
      }

    public void setConstitution(int Constitution)
      {
        this.Constitution = Constitution;
      }

    public int getDexterity()
      {
        return Dexterity;
      }

    public void setDexterity(int Dexterity)
      {
        this.Dexterity = Dexterity;
      }

    public String getGender()
      {
        return Gender;
      }

    public void setGender(String Gender)
      {
        this.Gender = Gender;
      }

    public int getIntelligence()
      {
        return Intelligence;
      }

    public void setIntelligence(int Intelligence)
      {
        this.Intelligence = Intelligence;
      }

    public int getLevel()
      {
        return Level;
      }

    public void setLevel(int Level)
      {
        this.Level = Level;
      }

    public int getStrength()
      {
        return Strength;
      }

    public void setStrength(int Strength)
      {
        this.Strength = Strength;
      }

    public int getWisdom()
      {
        return Wisdom;
      }

    public void setWisdom(int Wisdom)
      {
        this.Wisdom = Wisdom;
      }

    public String getPlayerName()
      {
        return playerName;
      }

    public void setPlayerName(String playerName)
      {
        this.playerName = playerName;
      }

    public int getBonusAC()
      {
        return BonusAC;
      }

    public void setBonusAC(int BonusAC)
      {
        this.BonusAC = BonusAC;
      }

    public int getBonusFort()
      {
        return BonusFort;
      }

    public void setBonusFort(int BonusFort)
      {
        this.BonusFort = BonusFort;
      }

    public int getBonusRef()
      {
        return BonusRef;
      }

    public void setBonusRef(int BonusRef)
      {
        this.BonusRef = BonusRef;
      }

    public int getBonusWill()
      {
        return BonusWill;
      }

    public void setBonusWill(int BonusWill)
      {
        this.BonusWill = BonusWill;
      }

    public int getCheckBonus()
      {
        return CheckBonus;
      }

    public void setCheckBonus(int CheckBonus)
      {
        this.CheckBonus = CheckBonus;
      }

    public int getSpeedBonus()
      {
        return SpeedBonus;
      }

    public void setSpeedBonus(int SpeedBonus)
      {
        this.SpeedBonus = SpeedBonus;
      }

    //</editor-fold>
    public Player(String playerName, String CharacterName, int Level, charClass characterClass, Race Race, String Age, String Gender, String Alignment, int Strength, int Constitution, int Dexterity, int Intelligence, int Wisdom, int Charisma)
      {
        this.playerName = playerName;
        this.CharacterName = CharacterName;
        this.Level = Level;
        this.characterClass = characterClass;
        this.Race = Race;
        this.Age = Age;
        this.Gender = Gender;
        this.Alignment = Alignment;
        this.Strength = Strength;
        this.Constitution = Constitution;
        this.Dexterity = Dexterity;
        this.Intelligence = Intelligence;
        this.Wisdom = Wisdom;
        this.Charisma = Charisma;
        this.ACMisc = 0;
        this.FortMisc = 0;
        this.ReflexMisc = 0;
        this.WillMisc = 0;
        
        mainHand = "None";
        armor = "Cloth Armor";

      }



    @Override
    public String getID()
      {
        return CharacterName;
      }
  }
