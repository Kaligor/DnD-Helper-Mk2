package dndhelpermk2.misc;

import dndhelpermk2.player.Player;
import java.util.HashMap;
import javax.swing.JTextArea;

public class knowledge
  {
    public static final String NEWLINE = "\n";
    private HashMap<String, Integer> knowledge = new HashMap<String, Integer>();
   // Tables table = new Tables();

    public knowledge()
      {
        knowledge.put("Acrobatics", 0);
        knowledge.put("Arcana", 0);
        knowledge.put("Athletics", 0);
        knowledge.put("Bluff", 0);
        knowledge.put("Diplomacy", 0);
        knowledge.put("Dungeoneering", 0);
        knowledge.put("Endurance", 0);
        knowledge.put("Heal", 0);
        knowledge.put("History", 0);
        knowledge.put("Insight", 0);
        knowledge.put("Intimidate", 0);
        knowledge.put("Nature", 0);
        knowledge.put("Perception", 0);
        knowledge.put("Religion", 0);
        knowledge.put("Stealth", 0);
        knowledge.put("Streetwise", 0);
        knowledge.put("Thievery", 0);
      }

    public int AbiCal(int valueToBeCalculated)
      {
        return (valueToBeCalculated - 8) / 2;
      }

    public int HalfLevelCalc(int HalfingValue)
      {
        int temp = HalfingValue / 2;

        if (temp * 2 != HalfingValue) {
            temp += 1;
        }
        return temp;
      }

    //<editor-fold defaultstate="collapsed" desc="increase Skills">
    public void increaseAcrobatics(int increase)
      {
        int oldValue = knowledge.get("acrobatics");
        int newValue = oldValue + increase;
        knowledge.put("Acrobatics", newValue);
      }
    
    public void increaseArcana(int increase)
      {
        int oldValue = knowledge.get("arcana");
        int newValue = oldValue + increase;
        knowledge.put("Arcana", newValue);
      }
    
    public void increaseAthletics(int increase)
      {
        int oldValue = knowledge.get("athletics");
        int newValue = oldValue + increase;
        knowledge.put("Athletics", newValue);
      }
    
    public void increaseBluff(int increase)
      {
        int oldValue = knowledge.get("Bluff");
        int newValue = oldValue + increase;
        knowledge.put("Bluff", newValue);
      }
    
    public void increaseDiplomacy(int increase)
      {
        int oldValue = knowledge.get("Diplomacy");
        int newValue = oldValue + increase;
        knowledge.put("Diplomacy", newValue);
      }
    
    public void increaseDungeoneering(int increase)
      {
        int oldValue = knowledge.get("Dungeoneering");
        int newValue = oldValue + increase;
        knowledge.put("Dungeoneering", newValue);
      }
    
    public void increaseEndurance(int increase)
      {
        int oldValue = knowledge.get("Endurance");
        int newValue = oldValue + increase;
        knowledge.put("Endurance", newValue);
      }
    
    public void increaseHeal(int increase)
      {
        int oldValue = knowledge.get("Heal");
        int newValue = oldValue + increase;
        knowledge.put("Heal", newValue);
      }
    
    public void increaseHistory(int increase)
      {
        int oldValue = knowledge.get("History");
        int newValue = oldValue + increase;
        knowledge.put("History", newValue);
      }
    
    public void increaseInsight(int increase)
      {
        int oldValue = knowledge.get("Insight");
        int newValue = oldValue + increase;
        knowledge.put("Insight", newValue);
      }
    
    public void increaseIntimidate(int increase)
      {
        int oldValue = knowledge.get("Intimidate");
        int newValue = oldValue + increase;
        knowledge.put("Intimidate", newValue);
      }
    
    public void increaseNature(int increase)
      {
        int oldValue = knowledge.get("Nature");
        int newValue = oldValue + increase;
        knowledge.put("Nature", newValue);
      }
    
    public void increasePerception(int increase)
      {
        int oldValue = knowledge.get("Perception");
        int newValue = oldValue + increase;
        knowledge.put("Perception", newValue);
      }
    
    public void increaseReligion(int increase)
      {
        int oldValue = knowledge.get("Religion");
        int newValue = oldValue + increase;
        knowledge.put("Religion", newValue);
      }
    
    public void increaseStealth(int increase)
      {
        int oldValue = knowledge.get("Stealth");
        int newValue = oldValue + increase;
        knowledge.put("Stealth", newValue);
      }
    
    public void increaseStreetwise(int increase)
      {
        int oldValue = knowledge.get("Streetwise");
        int newValue = oldValue + increase;
        knowledge.put("Streetwise", newValue);
      }
    
    public void increaseThievery(int increase)
      {
        int oldValue = knowledge.get("Thievery");
        int newValue = oldValue + increase;
        knowledge.put("Thievery", newValue);
      }
    //</editor-fold>

    public int rollAcrobatics(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Acrobatics check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result +=  player.getSkills().getKnowledge().get("Acrobatics");
        text.append("Skill bonus: " + this.getKnowledge().get("Acrobatics") + NEWLINE);
             
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getDexterity());
        text.append("Modifier: " + AbiCal(player.getDexterity()) + " (Dexterity)" + NEWLINE);
        
        text.append("Grand Total: " + result);

        
        return result;
      }    
    public int rollArcana(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Arcana check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += player.getSkills().getKnowledge().get("Arcana");
        text.append("Skill bonus: " + player.getSkills().getKnowledge().get("Arcana") + NEWLINE);    
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getIntelligence());
        text.append("Modifier: " + AbiCal(player.getIntelligence()) + " (Intelligence)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollAthletics(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Athletics check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += player.getSkills().getKnowledge().get("Athletics");
        text.append("Skill bonus: " + player.getSkills().getKnowledge().get("Athletics") + NEWLINE);
               
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getStrength());
        text.append("Modifier: " + AbiCal(player.getStrength()) + " (Strength)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollBluff(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Bluff check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Bluff");
        text.append("Skill bonus: " + knowledge.get("Bluff") + NEWLINE);
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getCharisma());
        text.append("Modifier: " + AbiCal(player.getCharisma()) + " (Charisma)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollDiplomacy(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Diplomacy check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Diplomacy");
        text.append("Skill bonus: " + knowledge.get("Diplomacy") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getCharisma());
        text.append("Modifier: " + AbiCal(player.getCharisma()) + " (Charisma)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollDungeoneering(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Dungeoneering check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Dungeoneering");
        text.append("Skill bonus: " + knowledge.get("Dungeoneering") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getWisdom());
        text.append("Modifier: " + AbiCal(player.getWisdom()) + " (Wisdom)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollEndurance(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Endurance check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Endurance");
        text.append("Skill bonus: " + knowledge.get("Endurance") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getConstitution());
        text.append("Modifier: " + AbiCal(player.getConstitution()) + " (Constitution)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollHeal(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Heal check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Heal");
        text.append("Skill bonus: " + knowledge.get("Heal") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getWisdom());
        text.append("Modifier: " + AbiCal(player.getWisdom()) + " (Wisdom)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollHistory(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an History check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("History");
        text.append("Skill bonus: " + knowledge.get("History") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getIntelligence());
        text.append("Modifier: " + AbiCal(player.getIntelligence()) + " (Intelligence)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollInsight(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Insight check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Insight");
        text.append("Skill bonus: " + knowledge.get("Insight") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getWisdom());
        text.append("Modifier: " + AbiCal(player.getWisdom()) + " (Wisdom)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollIntimidate(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Intimidate check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Intimidate");
        text.append("Skill bonus: " + knowledge.get("Intimidate") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getCharisma());
        text.append("Modifier: " + AbiCal(player.getCharisma()) + " (Charisma)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollNature(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Nature check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Nature");
        text.append("Skill bonus: " + knowledge.get("Nature") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getWisdom());
        text.append("Modifier: " + AbiCal(player.getWisdom()) + " (Wisdom)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollPerception(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Perception check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Perception");
        text.append("Skill bonus: " + knowledge.get("Perception") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getWisdom());
        text.append("Modifier: " + AbiCal(player.getWisdom()) + " (Wisdom)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollReligion(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Religion check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Religion");
        text.append("Skill bonus: " + knowledge.get("Religion") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getIntelligence());
        text.append("Modifier: " + AbiCal(player.getIntelligence()) + " (Intelligence)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollStealth(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Stealth check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Stealth");
        text.append("Skill bonus: " + knowledge.get("Stealth") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getDexterity());
        text.append("Modifier: " + AbiCal(player.getDexterity()) + " (Dexterity)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollStreetwise(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Streetwise check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Streetwise");
        text.append("Skill bonus: " + knowledge.get("Streetwise") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getCharisma());
        text.append("Modifier: " + AbiCal(player.getCharisma()) + " (Charisma)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }
    public int rollThievery(Player player, JTextArea text)
      {
        int dice = (int) (Math.random() * (20) + 1);
        int result = dice;
        text.setText("You make an Thievery check" + NEWLINE);
        text.append("1D20: " + dice + NEWLINE);
        
        result += knowledge.get("Thievery");
        text.append("Skill bonus: " + knowledge.get("Thievery") + NEWLINE);     
        
        result += HalfLevelCalc(player.getLevel());
        text.append("Half your level: " + HalfLevelCalc(player.getLevel()) + NEWLINE);
        
        result += AbiCal(player.getDexterity());
        text.append("Modifier: " + AbiCal(player.getDexterity()) + " (Dexterity)" + NEWLINE);
        
        text.append("Grand Total: " + result);
        
        
        return result;
      }

    public HashMap<String, Integer> getKnowledge()
      {
        return knowledge;
      }

    
    
    public String getAllSkillsForSave()
      {
        return knowledge.get("Acrobatics") + ";"
                + knowledge.get("Arcana") + ";"
                + knowledge.get("Athletics") + ";"
                + knowledge.get("Bluff") + ";"
                + knowledge.get("Diplomacy") + ";"
                + knowledge.get("Dungeoneering") + ";"
                + knowledge.get("Endurance") + ";"
                + knowledge.get("Heal") + ";"
                + knowledge.get("History") + ";"
                + knowledge.get("Insight") + ";"
                + knowledge.get("Intimidate") + ";"
                + knowledge.get("Nature") + ";"
                + knowledge.get("Perception") + ";"
                + knowledge.get("Religion") + ";"
                + knowledge.get("Stealth") + ";"
                + knowledge.get("Streetwise") + ";"
                + knowledge.get("Thievery");
      }
  }
