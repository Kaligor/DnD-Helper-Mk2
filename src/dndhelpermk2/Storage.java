package dndhelpermk2;

import dndhelpermk2.dices.dice;
import dndhelpermk2.misc.bonus;
import dndhelpermk2.misc.skill;
import dndhelpermk2.player.classes.charClass;
import dndhelpermk2.player.equipment.equipment;
import dndhelpermk2.player.race.Race;
import java.util.HashMap;

public class Storage
  {
    public static final String DICESUFIX = "-Sided Dice";

    private HashMap<String, Race> Races = new HashMap<String, Race>();
    private HashMap<String, charClass> Classes = new HashMap<String, charClass>();
    private HashMap<String, equipment> Weapons = new HashMap<String, equipment>();
    private HashMap<String, equipment> Armors = new HashMap<String, equipment>();

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public HashMap<String, Race> getRaces()
      {
        return Races;
      }

    public HashMap<String, charClass> getClasses()
      {
        return Classes;
      }

    public HashMap<String, equipment> getArmors()
      {
        return Armors;
      }

    public HashMap<String, equipment> getWeapons()
      {
        return Weapons;
      }

    
    //</editor-fold>
    
     public final void newWeapon(String itemRank, String itemName, int itemProf, int NrOfDice, int DmgPerDice, int Range, int Price, int Weight, String Group, String Properties, int hands)
      {
        equipment tempWeapon = new equipment(itemRank, itemName, itemProf, NrOfDice, DmgPerDice, Range, Price, Weight, Group, Properties, hands);
            for (int i = 0; i < tempWeapon.getNrOfDice(); i++) { 
            dice tempDice = new dice(tempWeapon.getDmgPerDice() + DICESUFIX, tempWeapon.getDmgPerDice());
            tempWeapon.addDiceToWeapon(tempDice);
        }
        Weapons.put(tempWeapon.getItemName(), tempWeapon);
      }

    public final void newArmor(String itemName, String itemType, int Price, String Group, int ArmorBonus, int MinimumEnhancementBonus, int Check, int Speed, int Weight)
      {
        equipment tempArmor = new equipment(itemName, itemType, Price, Group, ArmorBonus, MinimumEnhancementBonus, Check, Speed, Weight);
        Armors.put(tempArmor.getItemName(), tempArmor);
      }
    public Storage()
      {

        //<editor-fold defaultstate="collapsed" desc="Classes">

        //<editor-fold defaultstate="collapsed" desc="Ardent">
        charClass Ardent = new charClass("Ardent", "Defender", 12, 5, 7);

        Classes.put("Ardent", Ardent);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Warden">
        charClass Warden = new charClass("Warden", "Defender", 17, 7, 9);

        Classes.put("Warden", Warden);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Wizard">
        charClass Wizard = new charClass("Wizard", "Controller", 10, 4, 6);

        Classes.put("Wizard", Wizard);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Cleric">
        charClass Cleric = new charClass("Cleric", "Leader", 12, 5, 7);

        Classes.put("Cleric", Cleric);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Rogue">
        charClass Rogue = new charClass("Rogue", "Striker", 12, 5, 6);

        Classes.put("Rogue", Rogue);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Paladin">
        charClass Paladin = new charClass("Paladin", "Defender", 15, 6, 10);

        Classes.put("Paladin", Paladin);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Avenger">
        charClass Avenger = new charClass("Avenger", "Striker", 14, 6, 7);

        Classes.put("Avenger", Avenger);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Ranger">
        charClass Ranger = new charClass("Ranger", "Striker", 12, 5, 6);

        Classes.put("Ranger", Ranger);
        //</editor-fold>

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Races">
        //<editor-fold defaultstate="collapsed" desc="Minotaur">
        bonus Minotaur1 = new bonus("Nature", 2);
        bonus Minotaur2 = new bonus("Perception", 2);
        bonus Minotaur3 = new bonus("Strength", 2);
        bonus Minotaur4 = new bonus("Constitution", 2);
        bonus Minotaur5 = new bonus("Wisdom", 2);
        skill MinotaurS1 = new skill("Vitality", "You have one additional healing surge");
        skill MinotaurS2 = new skill("Ferocity", "When you drop to 0 hit points or fewer. you can make a melee basic attack as an immediate interrupt");
        skill MinotaurS3 = new skill("Heedless Charge", "You have a +2 racial bonus to AC against opportunity attacks you provoke during a charge");
        skill MinotaurS4 = new skill("Goring Charge", "You have the Goring Charge power");
        Race Minotaur = new Race("Minotaur", "Medium", 6, "Normal");
        Minotaur.addBonusesToRace(Minotaur1);
        Minotaur.addBonusesToRace(Minotaur2);
        Minotaur.addBonusesToRace(Minotaur3);
        Minotaur.addBonusesToRace(Minotaur4);
        Minotaur.addBonusesToRace(Minotaur5);
        Minotaur.addSkillstoRace(MinotaurS1);
        Minotaur.addSkillstoRace(MinotaurS2);
        Minotaur.addSkillstoRace(MinotaurS3);
        Minotaur.addSkillstoRace(MinotaurS4);
        Minotaur.addLanguageToRace("Common");
        Minotaur.addLanguageToRace("1 Free Choice");
        Races.put("Minotaur", Minotaur);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Elves">
        bonus Elf1 = new bonus("Nature", 2);
        bonus Elf2 = new bonus("Perception", 2);
        bonus Elf3 = new bonus("Dexterity", 2);
        bonus Elf4 = new bonus("Wisdom", 2);
        skill ElfS1 = new skill("Elven Weapon Proficiency", "You gain proficiency with the longbow and the shortbow.");
        skill ElfS2 = new skill("Fey Origin", "Your ancestors were native to the Feywild, so you are considered a fey creature for the purpose of effects that relate to creature origin.");
        skill ElfS3 = new skill("Group Awareness", "You grant non-elf allies within 5 squares of you a +1 racial bonus to Perception checks.");
        skill ElfS4 = new skill("Wild Step", "You ignore difficult terrain when you shift (even if you have a power that allows you to shift multiple squares).");
        skill ElfS5 = new skill("Elven Accuracy", "You can use elven accuracy as an encounter power.");
        Race Elf = new Race("Elf", "Medium", 7, "Low-light");
        Elf.addBonusesToRace(Elf1);
        Elf.addBonusesToRace(Elf2);
        Elf.addBonusesToRace(Elf3);
        Elf.addBonusesToRace(Elf4);
        Elf.addSkillstoRace(ElfS1);
        Elf.addSkillstoRace(ElfS2);
        Elf.addSkillstoRace(ElfS3);
        Elf.addSkillstoRace(ElfS4);
        Elf.addSkillstoRace(ElfS5);
        Elf.addLanguageToRace("Common");
        Elf.addLanguageToRace("Elven");
        Races.put("Elf", Elf);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Human">
        bonus Human1 = new bonus("None", 0);
        bonus Human2 = new bonus("None", 0);
        bonus Human3 = new bonus("Free choice", 2);
        bonus Human4 = new bonus("None", 0);
        skill HumanS1 = new skill("Bonus At-Will Power", "You know one extra at-will power from your class.");
        skill HumanS2 = new skill("Bonus Feat", "You gain a bonus feat at 1st level. You must meet the feat’s prerequisites.");
        skill HumanS3 = new skill("Bonus Skill", "You gain training in one additional skill from your class skill list.");
        skill HumanS4 = new skill("Human Defense Bonuses ", "+1 to Fortitude, Reflex, and Will defenses.");
        Race Human = new Race("Human", "Medium", 6, "Normal");
        Human.addBonusesToRace(Human1);
        Human.addBonusesToRace(Human2);
        Human.addBonusesToRace(Human3);
        Human.addBonusesToRace(Human4);
        Human.addSkillstoRace(HumanS1);
        Human.addSkillstoRace(HumanS2);
        Human.addSkillstoRace(HumanS3);
        Human.addSkillstoRace(HumanS4);
        Human.addLanguageToRace("Common");
        Human.addLanguageToRace("Free choice");
        Races.put("Human", Human);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Halfling">
        bonus Halfling1 = new bonus("Acrobatics", 2);
        bonus Halfling2 = new bonus("Thievery", 2);
        bonus Halfling3 = new bonus("Dexterity", 2);
        bonus Halfling4 = new bonus("Charisma", 2);
        skill HalflingS1 = new skill("Bold", "You gain a +5 racial bonus to saving throws against fear.");
        skill HalflingS2 = new skill("Nimble Reaction", "You gain a +2 racial bonus to AC against opportunity attacks.");
        skill HalflingS3 = new skill("Second Chance", "You can use second chance as an encounter power.");
        Race Halfling = new Race("Halfling", "Small", 6, "Normal");
        Halfling.addBonusesToRace(Halfling1);
        Halfling.addBonusesToRace(Halfling2);
        Halfling.addBonusesToRace(Halfling3);
        Halfling.addBonusesToRace(Halfling4);
        Halfling.addSkillstoRace(HalflingS1);
        Halfling.addSkillstoRace(HalflingS2);
        Halfling.addSkillstoRace(HalflingS3);
        Halfling.addLanguageToRace("Common");
        Halfling.addLanguageToRace("Free choice");
        Races.put("Halfling", Halfling);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="HalfElf">
        bonus HalfElf1 = new bonus("Diplomacy", 2);
        bonus HalfElf2 = new bonus("Insight", 2);
        bonus HalfElf3 = new bonus("Constitution", 2);
        bonus HalfElf4 = new bonus("Charisma", 2);
        skill HalfElfS1 = new skill("Dilettante", "At 1st level, you choose an at-will power from a class different from yours. You can use that power as an encounter power.");
        skill HalfElfS2 = new skill("Dual Heritage", "You can take feats that have either elf or human as a prerequisite (as well as those specifically for half-elves), as long as you meet any other requirements.");
        skill HalfElfS3 = new skill("Group Diplomacy", "You grant allies within 10 squares of you a +1 racial bonus to Diplomacy checks.");
        Race HalfElf = new Race("HalfElf", "Medium", 6, "Low-light");
        HalfElf.addBonusesToRace(HalfElf1);
        HalfElf.addBonusesToRace(HalfElf2);
        HalfElf.addBonusesToRace(HalfElf3);
        HalfElf.addBonusesToRace(HalfElf4);
        HalfElf.addSkillstoRace(HalfElfS1);
        HalfElf.addSkillstoRace(HalfElfS2);
        HalfElf.addSkillstoRace(HalfElfS3);
        HalfElf.addLanguageToRace("Common");
        HalfElf.addLanguageToRace("Elven + 1 Free Choice");
        Races.put("HalfElf", HalfElf);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Gtihzerai">
        bonus Gtihzerai1 = new bonus("Acrobatics", 2);
        bonus Gtihzerai2 = new bonus("Athletics", 2);
        bonus Gtihzerai3 = new bonus("Wisdom", 2);
        bonus Gtihzerai4 = new bonus("Dexterity or Intelligence", 2);
        skill GtihzeraiS1 = new skill("Danger Sense", "You have a ·2 racial bonus to initiative checks.");
        skill GtihzeraiS2 = new skill("Defended Mind", "You have a +2 racial bonus to saving throws against effects that daze. dominate. or stun.");
        skill GtihzeraiS3 = new skill("Shifting Fortunes", "When you use your second wind, you can shift 3 squares as a free action.");
        skill GtihzeraiS4 = new skill("Iron Mind", "You have the iron mind power");
        Race Gtihzerai = new Race("Gtihzerai", "Medium", 6, "Normal");
        Gtihzerai.addBonusesToRace(Gtihzerai1);
        Gtihzerai.addBonusesToRace(Gtihzerai2);
        Gtihzerai.addBonusesToRace(Gtihzerai3);
        Gtihzerai.addBonusesToRace(Gtihzerai4);
        Gtihzerai.addSkillstoRace(GtihzeraiS1);
        Gtihzerai.addSkillstoRace(GtihzeraiS2);
        Gtihzerai.addSkillstoRace(GtihzeraiS3);
        Gtihzerai.addSkillstoRace(GtihzeraiS4);
        Gtihzerai.addLanguageToRace("Common");
        Gtihzerai.addLanguageToRace("Deep Speech");
        Races.put("Gtihzerai", Gtihzerai);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Dwarf">
        bonus Dwarf1 = new bonus("Dungeoneering", 2);
        bonus Dwarf2 = new bonus("Endurance", 2);
        bonus Dwarf3 = new bonus("Constitution", 2);
        bonus Dwarf4 = new bonus("Wisdom", 2);
        skill DwarfS1 = new skill("Cast-Iron Stomach", "+5 racial bonus to saving throws against poison");
        skill DwarfS2 = new skill("Dwarven Resilience", "You can use your second wind as a minor action instead of a Standard action.");
        skill DwarfS3 = new skill("Dwarven Weapon Proficiency", "You gain proficiency with the throwing hammer and the warhammer");
        skill DwarfS4 = new skill("Encumbered Speed", "You move at your normal speed even when it would normally be reduced by armor or a heavy load. Other effects that limit speed(such as difficult terrain or magical effects) affect you normally");
        skill DwarfS5 = new skill("Stand your Ground", "When an effect forces you to move-through a pull, a push, or a slide-you can move 1 square less than the effect specifies. This means an effect that normally pulls, pushed or slides a target 1 square does not force you to move unless you want to."
                + "In addition, when an attack would knock you prone, you can immediately make a saving throw to avoid falling prone.");
        Race Dwarf = new Race("Dwarf", "Medium", 5, "Low-Light");
        Dwarf.addBonusesToRace(Dwarf1);
        Dwarf.addBonusesToRace(Dwarf2);
        Dwarf.addBonusesToRace(Dwarf3);
        Dwarf.addBonusesToRace(Dwarf4);
        Dwarf.addSkillstoRace(DwarfS1);
        Dwarf.addSkillstoRace(DwarfS2);
        Dwarf.addSkillstoRace(DwarfS3);
        Dwarf.addSkillstoRace(DwarfS4);
        Dwarf.addSkillstoRace(DwarfS5);
        Dwarf.addLanguageToRace("Common");
        Dwarf.addLanguageToRace("Dwarven");
        Races.put("Dwarf", Dwarf);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Dragonborn">
        bonus dragonborn1 = new bonus("History", 2);
        bonus dragonborn2 = new bonus("Intimidate", 2);
        bonus dragonborn3 = new bonus("Strength", 2);
        bonus dragonborn4 = new bonus("Charisma", 2);
        skill dragonbornS1 = new skill("Dragonborn Fury", "When you're Bloodied, you gain a +1 racial bonus to attack roll");
        skill dragonbornS2 = new skill("Draconic Heritage", "Your Healing Surge value is equal to one-quarter of your maximum hit points + your Constitution");
        skill dragonbornS3 = new skill("Dragon Breath", "Lots of Text", "Encounter", "Lots of Text");
        Race dragonborn = new Race("Dragonborn", "Medium", 6, "Normal");
        dragonborn.addBonusesToRace(dragonborn1);
        dragonborn.addBonusesToRace(dragonborn2);
        dragonborn.addBonusesToRace(dragonborn3);
        dragonborn.addBonusesToRace(dragonborn4);
        dragonborn.addSkillstoRace(dragonbornS1);
        dragonborn.addSkillstoRace(dragonbornS2);
        dragonborn.addSkillstoRace(dragonbornS3);
        dragonborn.addLanguageToRace("Common");
        Races.put("Dragonborn", dragonborn);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Gnome">
        bonus gnome1 = new bonus("Arcana", 2);
        bonus gnome2 = new bonus("Stealth", 2);
        bonus gnome3 = new bonus("Intelligence", 2);
        bonus gnome4 = new bonus("Charisma", 2);
        skill gnomeS1 = new skill("Fey Origin", "Your ancestors were native to the Feywild,so you are considered a fey creature for the purpose of effects that relate to creature origin");
        skill gnomeS2 = new skill("Master Trickster", "Once per encounter, you can use the wizard cantrip ghost sound (Player’s Handbook, page 158) as a minor action");
        skill gnomeS3 = new skill("Reactive Stealth", "If you have any cover or concealment when you make an initiative check, you can make a Stealth check");
        skill gnomeS4 = new skill("Trickster’s Cunning", "You have a +5 racial bonus to saving throws against illusions");
        skill gnomeS5 = new skill("Fade Away", "You have the fade away power");
        Race Gnome = new Race("Gnome", "Small", 5, "Low-light");
        Gnome.addBonusesToRace(gnome1);
        Gnome.addBonusesToRace(gnome2);
        Gnome.addBonusesToRace(gnome3);
        Gnome.addBonusesToRace(gnome4);
        Gnome.addSkillstoRace(gnomeS1);
        Gnome.addSkillstoRace(gnomeS2);
        Gnome.addSkillstoRace(gnomeS3);
        Gnome.addSkillstoRace(gnomeS4);
        Gnome.addSkillstoRace(gnomeS5);
        Gnome.addLanguageToRace("Common");
        Races.put("Gnome", Gnome);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Goliath">
        bonus Goliath1 = new bonus("Athletics", 2);
        bonus Goliath2 = new bonus("Nature", 2);
        bonus Goliath3 = new bonus("Strength", 2);
        bonus Goliath4 = new bonus("Constitution", 2);
        skill GoliathS1 = new skill("Mountain’s Tenacity:", "You have a +1 racial bonus to Will");
        skill GoliathS2 = new skill("Powerful Athlete:", "When you make an Athletics check to jump or climb, roll twice and use either result");
        skill GoliathS3 = new skill("Stone’s Endurance", "You have the stone’s endurance power");
        Race Goliath = new Race("Goliath", "Medium", 6, "Normal");

        Goliath.addBonusesToRace(Goliath1);
        Goliath.addBonusesToRace(Goliath2);
        Goliath.addBonusesToRace(Goliath3);
        Goliath.addBonusesToRace(Goliath4);
        Goliath.addSkillstoRace(GoliathS1);
        Goliath.addSkillstoRace(GoliathS2);
        Goliath.addSkillstoRace(GoliathS3);
        Goliath.addLanguageToRace("Common");
        Races.put("Goliath", Goliath);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="HalfOrcs">
        bonus HalfOrc1 = new bonus("Endurance", 2);
        bonus HalfOrc2 = new bonus("Intimidate", 2);
        bonus HalfOrc3 = new bonus("Strength", 2);
        bonus HalfOrc4 = new bonus("Dexterity", 2);
        skill HalfOrcS1 = new skill("Half-Orc Resilience:", "The first time you are bloodied during an encounter, you gain 5 temporary hit points. The temporary hit points increase to 10 at 11th level and to 15 at 21st level");
        skill HalfOrcS2 = new skill("Swift Charge:", "You gain a +2 bonus to speed when charging");
        skill HalfOrcS3 = new skill("Furious Assault", "You have the furious assault power");
        Race HalfOrc = new Race("Half-Orc", "Medium", 6, "Low-light");

        HalfOrc.addBonusesToRace(HalfOrc1);
        HalfOrc.addBonusesToRace(HalfOrc2);
        HalfOrc.addBonusesToRace(HalfOrc3);
        HalfOrc.addBonusesToRace(HalfOrc4);
        HalfOrc.addSkillstoRace(HalfOrcS1);
        HalfOrc.addSkillstoRace(HalfOrcS2);
        HalfOrc.addSkillstoRace(HalfOrcS3);
        HalfOrc.addLanguageToRace("Common");
        Races.put("HalfOrc", HalfOrc);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Shifter">
        bonus LongtoothShifter1 = new bonus("Endurance", 2);
        bonus LongtoothShifter2 = new bonus("Athletics", 2);
        bonus LongtoothShifter3 = new bonus("Strength", 2);
        bonus LongtoothShifter4 = new bonus("Wisdom", 2);
        skill LongtoothShifterS1 = new skill("Longtooth Shifting", "you have the Longtooth Shifting ability");
        Race LongtoothShifter = new Race("LongtoothShifter", "Medium", 6, "Low-light");

        LongtoothShifter.addBonusesToRace(LongtoothShifter1);
        LongtoothShifter.addBonusesToRace(LongtoothShifter2);
        LongtoothShifter.addBonusesToRace(LongtoothShifter3);
        LongtoothShifter.addBonusesToRace(LongtoothShifter4);
        LongtoothShifter.addSkillstoRace(LongtoothShifterS1);
        LongtoothShifter.addLanguageToRace("Common");
        Races.put("LongtoothShifter", LongtoothShifter);

        bonus RazorclawShifter1 = new bonus("Acrobatics", 2);
        bonus RazorclawShifter2 = new bonus("Stealth", 2);
        bonus RazorclawShifter3 = new bonus("Dexterity", 2);
        bonus RazorclawShifter4 = new bonus("Wisdom", 2);
        skill RazorclawShifterS1 = new skill("Razorclaw Shifting", "You have the Razorclaw shifting ability");
        Race RazorclawShifter = new Race("RazorclawShifter", "Medium", 6, "Low-light");

        RazorclawShifter.addBonusesToRace(RazorclawShifter1);
        RazorclawShifter.addBonusesToRace(RazorclawShifter2);
        RazorclawShifter.addBonusesToRace(RazorclawShifter3);
        RazorclawShifter.addBonusesToRace(RazorclawShifter4);
        RazorclawShifter.addSkillstoRace(RazorclawShifterS1);
        RazorclawShifter.addLanguageToRace("Common");
        Races.put("RazorclawShifter", RazorclawShifter);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Devas">
        bonus devas1 = new bonus("History", 2);
        bonus devas2 = new bonus("Religion", 2);
        bonus devas3 = new bonus("Intelligence", 2);
        bonus devas4 = new bonus("Wisdom", 2);
        skill devasS1 = new skill("Astral Majesty", "You have a +1 Bonus to all defenses against attacks made by bloodied creatures");
        skill devasS2 = new skill("Astral Resistance", "you have resistance to necrotic damage and radiant damage equal to 5 + one-half your level.");
        skill devasS3 = new skill("Memory of a Thousand Lifetimes", "Trigger: you make an attack roll, a saving throw, a skill check or an ability check and dislike the result", "Encounter", "You add 1d6 to the triggered roll");
        Race Devas = new Race("Devas", "Medium", 6, "Normal");
        Devas.addBonusesToRace(devas1);
        Devas.addBonusesToRace(devas2);
        Devas.addBonusesToRace(devas3);
        Devas.addBonusesToRace(devas4);
        Devas.addSkillstoRace(devasS1);
        Devas.addSkillstoRace(devasS2);
        Devas.addSkillstoRace(devasS3);
        Devas.addLanguageToRace("Common");
        Races.put("Devas", Devas);
        //</editor-fold>
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Armors">
        //Name                 Type    Price Group   AB MEB C  S  W 
        newArmor("Cloth Armor", "cloth", 1, "Light", 0, 0, 0, 0, 4);
        newArmor("Feyweave Armor", "cloth", 0, "Light", 1, 4, 0, 0, 5);
        newArmor("Starweave Armor", "cloth", 0, "Light", 2, 6, 0, 0, 3);

        newArmor("Leather Armor", "leather", 25, "Light", 2, 0, 0, 0, 15);
        newArmor("Feyleather Armor", "leather", 0, "Light", 3, 4, 0, 0, 15);
        newArmor("Starleather Armor", "leather", 0, "Light", 4, 6, 0, 0, 15);

        newArmor("Hide Armor", "hide", 30, "Light", 3, 0, -1, 0, 25);
        newArmor("Darkhide Armor", "hide", 0, "Light", 4, 4, -1, 0, 25);
        newArmor("Elderhide Armor", "hide", 0, "Light", 5, 6, -1, 0, 25);

        newArmor("Chainmail", "chain", 40, "Heavy", 6, 0, -1, -1, 40);
        newArmor("Forgemail", "chain", 0, "Heavy", 9, 4, -1, -1, 40);
        newArmor("Spiritmail", "chain", 0, "Heavy", 12, 6, -1, -1, 40);

        newArmor("Scale armor", "scale", 45, "Heavy", 7, 0, 0, -1, 45);
        newArmor("Wyrmscale armor", "scale", 0, "Heavy", 10, 4, 0, -1, 45);
        newArmor("Elderscale armor", "scale", 0, "Heavy", 13, 6, 0, -1, 45);

        newArmor("Plate armor", "plate", 50, "Heavy", 8, 0, -2, -1, 50);
        newArmor("Warplate armor", "plate", 0, "Heavy", 11, 4, -2, -1, 50);
        newArmor("Godplate armor", "plate", 0, "Heavy", 14, 6, -2, -1, 50);

        newArmor("Light Shield", "lightshield", 5, "Light", 1, 0, 0, 0, 6);
        newArmor("Heavy Shield", "heavyshield", 10, "Heavy", 2, 0, -1, 0, 15);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Weapons">

        newWeapon("None", "None", 0, 1, 4, 0, 0, 0, "Body", "-", 1);
        //Simple Melee Weapons
        //One Handed
        //Rank              Name      Prf DI DA R   P  W    Group                   Prop
        newWeapon("Simple", "Club", 2, 1, 6, 0, 1, 3, "Mace", "-", 1);
        newWeapon("Simple", "Dagger", 3, 1, 4, 10, 1, 1, "Light blade", "Off-hand, Light thrown", 1);
        newWeapon("Simple", "Javelin", 2, 1, 6, 20, 5, 2, "Spear", "Heavy Thrown", 1);
        newWeapon("Simple", "Mace", 2, 1, 8, 0, 5, 6, "Mace", "Versatile", 1);
        newWeapon("Simple", "Sickle", 2, 1, 6, 0, 2, 2, "Light blade", "Off-hand", 1);
        newWeapon("Simple", "Spear", 2, 1, 8, 0, 5, 10, "Spear", "Versatile", 1);
        //Two Handed
        //Rank              Name            Prf DI DA R   P  W    Group                   Prop
        newWeapon("Simple", "Greatclub", 2, 2, 4, 0, 1, 10, "Mace", "-", 2);
        newWeapon("Simple", "Morningstar", 2, 1, 10, 0, 10, 8, "Mace", "-", 2);
        newWeapon("Simple", "Quarterstaff", 2, 1, 8, 0, 5, 4, "Staff", "-", 2);
        newWeapon("Simple", "Scythe", 2, 2, 4, 0, 5, 10, "Heavy blade", "-", 2);

        //Military Melee Weapons
        //One Handed
        //Rank                Name            Prf DI DA R   P  W  Group                    Prop
        newWeapon("Military", "Battleaxe", 2, 1, 10, 0, 15, 6, "Axe", "Versatile", 1);
        newWeapon("Military", "Flail", 2, 1, 10, 0, 10, 5, "Flail", "Versatile", 1);
        newWeapon("Military", "Handaxe", 2, 1, 6, 10, 5, 3, "Axe", "Off-hand, Heavy thrown", 1);
        newWeapon("Military", "Longsword", 3, 1, 8, 0, 15, 4, "Heavy blade", "Versatile", 1);
        newWeapon("Military", "Scimitar", 2, 1, 8, 0, 10, 4, "Heavy blade", "High crit", 1);
        newWeapon("Military", "Short sword", 3, 1, 6, 0, 10, 2, "Light blade", "Off-hand", 1);
        newWeapon("Military", "Throw hammer", 2, 1, 6, 10, 5, 2, "Hammer", "Off-hand, Heavy thrown", 1);
        newWeapon("Military", "Warhammer", 2, 1, 10, 0, 15, 5, "Hammer", "Versatile", 1);
        newWeapon("Military", "War pick", 2, 1, 8, 0, 15, 6, "Pick", "High crit, Versatile", 1);
        //Military Melee Weapons
        //Two Handed
        //Rank                 Name           Prf DI DA R   P  W   Group                  Prop
        newWeapon("Military", "Falchion", 3, 2, 4, 0, 25, 7, "Heavy blade", "High crit", 2);
        newWeapon("Military", "Glaive", 2, 2, 4, 0, 25, 10, "Heavy blade, Polearm", "Reach", 2);
        newWeapon("Military", "Greataxe", 2, 1, 12, 0, 30, 12, "Axe", "High crit", 2);
        newWeapon("Military", "Greatsword", 3, 1, 10, 0, 30, 8, "Heavy blade", "-", 2);
        newWeapon("Military", "Halberd", 2, 1, 10, 0, 25, 12, "Axe, Polearm", "Reach", 2);
        newWeapon("Military", "Heavy flail", 2, 2, 6, 0, 25, 10, "Flail", "-", 2);
        newWeapon("Military", "Longspear", 2, 1, 10, 0, 10, 9, "Polearm, Spear", "Reach", 2);
        newWeapon("Military", "Maul", 2, 2, 6, 0, 30, 12, "Hammer", "-", 2);

        //Superior Melee Weapons
        //One Handed
        //Rank                 Name           Prf DI DA R   P  W  Group                    Prop
        newWeapon("Superior", "Bastard sword", 3, 1, 10, 0, 30, 6, "Heavy blade", "Versatile", 1);
        newWeapon("Superior", "Katar", 3, 1, 6, 0, 3, 1, "Light blade", "Off-hand, High crit", 1);
        newWeapon("Superior", "Rapier", 3, 1, 8, 0, 25, 2, "Light blade", "-", 1);
        //Superior Melee Weapons
        //Two Handed
        //Rank                 Name           Prf DI DA R   P  W   Group                    Prop
        newWeapon("Superior", "Spiked chain", 3, 2, 4, 0, 30, 10, "Flail", "Reach", 1);

        //Simple Ranged Weapons
        //One-Handed
        //         Rank      Name             Prf DI DA R   P  W   Group       Prop
        newWeapon("Simple", "Hand crossbow", 2, 1, 6, 20, 25, 2, "Crossbow", "Load free", 1);
        newWeapon("Simple", "Sling", 2, 1, 6, 20, 1, 0, "Sling", "Load free", 1);
        //Two-handed
        newWeapon("Simple", "Crossbow", 2, 1, 8, 30, 25, 4, "Crossbow", "Load minor", 2);

        //Military Ranged Weapons
        //Two-Handed
        //         Rank      Name             Prf DI DA R   P  W   Group       Prop
        newWeapon("Military", "Longbow", 2, 1, 10, 40, 30, 3, "Bow", "Load free", 2);
        newWeapon("Military", "Shortbow", 2, 1, 8, 30, 25, 2, "Bow", "Load free, small", 2);

        //Superior Ranged Weapons
        //One-Handed
        //         Rank      Name             Prf DI DA R   P  W   Group             Prop
        newWeapon("Superior", "Shuriken(5)", 3, 1, 4, 12, 1, 1, "Light blade", "Light thrown", 1);
        //</editor-fold>

      }
  }
