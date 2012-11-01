package GUI;

import dndhelpermk2.Storage;
import dndhelpermk2.dices.diceCollection;
import static dndhelpermk2.dices.rollDices.rollDices;
import dndhelpermk2.exception.ManagerException;
import dndhelpermk2.misc.imageHandler;
import dndhelpermk2.network.getIP;
import dndhelpermk2.player.Player;
import dndhelpermk2.player.PlayerManager;
import dndhelpermk2.player.classes.charClass;
import dndhelpermk2.player.race.Race;
import static dndhelpermk2.staticMethods.NumberConverter.AbiCal;
import static dndhelpermk2.staticMethods.NumberConverter.defenseCalculation;
import dndhelpermk2.storage.MapCRUD;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MainScreen extends javax.swing.JFrame {

    diceCollection diceCollection = new diceCollection();
    Storage storage = new Storage();
    PlayerManager PM;
    Player player;
    imageHandler imageHandler = new imageHandler();
    ClickListener CL = new ClickListener();
    getIP getIP = new getIP();
    static final String imagePath = "/GUI/bilder/equipment/";
    private int amuChargesValue = 0;

    public MainScreen() throws ManagerException {
        PM = new PlayerManager(new MapCRUD<String, Player>(), new MapCRUD<String, Race>(), new MapCRUD<String, charClass>());
        initComponents();
        player = new Player("newPlayer", "newCharacter", 1, storage.getClasses().get("Avenger"), storage.getRaces().get("Devas"), "20", "Male", "Lawful Good", 8, 10, 10, 10, 10, 10);
        //<editor-fold defaultstate="collapsed" desc="ActionListener">
        PlayernameButton.addActionListener(CL);
        CharacternameButton.addActionListener(CL);
        levelButton.addActionListener(CL);
        raceButton.addActionListener(CL);
        classButton.addActionListener(CL);
        changeAC.addActionListener(CL);
        changeFor.addActionListener(CL);
        changeRef.addActionListener(CL);
        changeWill.addActionListener(CL);
        changeStr.addActionListener(CL);
        changeCon.addActionListener(CL);
        changeWis.addActionListener(CL);
        changeCha.addActionListener(CL);
        changeDex.addActionListener(CL);
        changeInt.addActionListener(CL);
        athleticsButton.addActionListener(CL);
        diplomacyButton.addActionListener(CL);
        intimidateButton.addActionListener(CL);
        streetwiseButton.addActionListener(CL);
        bluffButton.addActionListener(CL);
        acrobaticsButton.addActionListener(CL);
        thieveryButton.addActionListener(CL);
        stealthButton.addActionListener(CL);
        enduranceButton.addActionListener(CL);
        dungeoneeringButton.addActionListener(CL);
        perceptionButton.addActionListener(CL);
        insightButton.addActionListener(CL);
        natureButton.addActionListener(CL);
        healButton.addActionListener(CL);
        religionButton.addActionListener(CL);
        historyButton.addActionListener(CL);
        arcanaButton.addActionListener(CL);
        rollAbility1.addActionListener(CL);
        rollAbility2.addActionListener(CL);
        rollAbility3.addActionListener(CL);
        rollAbility4.addActionListener(CL);
        rollAbility5.addActionListener(CL);
        rollAbility6.addActionListener(CL);
        rollAbility7.addActionListener(CL);
        rollAbility8.addActionListener(CL);
        rollAbility9.addActionListener(CL);
        rollAbility10.addActionListener(CL);
        rollAbility11.addActionListener(CL);
        rollAbility12.addActionListener(CL);
        rollAbility13.addActionListener(CL);
        rollAbility14.addActionListener(CL);
        rollAbility15.addActionListener(CL);
        changeWeapon.addActionListener(CL);
        changeArmor.addActionListener(CL);
        amuChangeValue.addActionListener(CL);
        amuHeal.addActionListener(CL);
        amuShield.addActionListener(CL);
        amuRegen.addActionListener(CL);
        getIPButton.addActionListener(CL);
        ConnectButton.addActionListener(CL);
        networkSendData.addActionListener(CL);

        //</editor-fold>



    }

    private class ClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //<editor-fold defaultstate="collapsed" desc="CharacterInfoStuff">
            if (e.getSource() == PlayernameButton) {
                player.setPlayerName(JOptionPane.showInputDialog(MainScreen.this, "Enter a new Playername"));
                PlayernameLabel.setText(player.getPlayerName());
            } else if (e.getSource() == CharacternameButton) {
                player.setCharacterName(JOptionPane.showInputDialog(MainScreen.this, "Enter a new Charactername"));
                characterNameLabel.setText(player.getCharacterName());
            } else if (e.getSource() == levelButton) {
                try {
                    player.setLevel(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Enter a new level")));
                    levelLabel.setText("" + player.getLevel());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainScreen.this, "Invalid level input");
                }
            } else if (e.getSource() == raceButton) {
                try {
                    player.setRace(storage.getRaces().get(JOptionPane.showInputDialog(MainScreen.this, "Enter a Race")));
                    raceLabel.setText(player.getRace().getRaceName());
                } catch (NullPointerException b) {
                    JOptionPane.showMessageDialog(MainScreen.this, "Invalid race entered");
                    raceLabel.setText("Invalid Race");
                }
            } else if (e.getSource() == classButton) {
                try {
                    player.setCharacterClass(storage.getClasses().get(JOptionPane.showInputDialog(MainScreen.this, "Enter a Class")));
                    classLabel.setText(player.getCharacterClass().getName());
                } catch (NullPointerException b) {
                    JOptionPane.showMessageDialog(MainScreen.this, "Invalid Class entered");
                    classLabel.setText("Invalid Class");
                }
            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="DefenseButtons">
            else if (e.getSource() == changeAC) {
                try {
                    player.setACMisc(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Enter a Bonus or Penalty value")));
                    if (player.getACMisc() > 0) {
                        ACBonus.setText("+" + player.getACMisc());
                        ACValue.setText(player.getAC() + player.getACMisc() + "(" + player.getAC() + ")");
                    } else if (player.getACMisc() < 0) {
                        ACBonus.setText("" + player.getACMisc());
                        ACValue.setText(player.getAC() + player.getACMisc() + "(" + player.getAC() + ")");
                    } else if (player.getACMisc() == 0) {
                        ACValue.setText("" + player.getAC());
                        ACBonus.setText("");
                    }
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeFor) {
                try {
                    player.setFortMisc(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Enter a Bonus or Penalty value")));
                    if (player.getFortMisc() > 0) {
                        ForBonus.setText("+" + player.getFortMisc());
                        ForValue.setText(player.getFortitude() + player.getFortMisc() + "(" + player.getFortitude() + ")");
                    } else if (player.getFortMisc() < 0) {
                        ForBonus.setText("" + player.getFortMisc());
                        ForValue.setText((player.getFortitude() + player.getFortMisc()) + "(" + player.getFortitude() + ")");
                    } else if (player.getACMisc() == 0) {
                        ForValue.setText("" + player.getFortitude());
                        ForBonus.setText("");
                    }
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeRef) {
                try {
                    player.setReflexMisc(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Enter a Bonus or Penalty value")));
                    if (player.getReflexMisc() > 0) {
                        RefBonus.setText("+" + player.getReflexMisc());
                        RefValue.setText(player.getReflex() + player.getReflexMisc() + "(" + player.getReflex() + ")");
                    } else if (player.getReflexMisc() < 0) {
                        RefBonus.setText("" + player.getReflexMisc());
                        RefValue.setText(player.getReflex() + player.getReflexMisc() + "(" + player.getReflex() + ")");
                    } else if (player.getReflexMisc() == 0) {
                        RefValue.setText("" + player.getReflex());
                        RefBonus.setText("");
                    }
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeWill) {
                try {
                    player.setWillMisc(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Enter a Bonus or Penalty value")));
                    if (player.getWillMisc() > 0) {
                        WillBonus.setText("+" + player.getWillMisc());
                        WillValue.setText(player.getWill() + player.getWillMisc() + "(" + player.getWill() + ")");
                    } else if (player.getWillMisc() < 0) {
                        WillBonus.setText("" + player.getWillMisc());
                        WillValue.setText(player.getWill() + player.getWillMisc() + "(" + player.getWill() + ")");
                    } else if (player.getWillMisc() == 0) {
                        WillValue.setText("" + player.getWill());
                        WillBonus.setText("");
                    }
                } catch (NumberFormatException ex) {
                }
            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="baseStats">
            else if (e.getSource() == changeStr) {
                try {
                    player.setStrength(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Strength Value")));
                    StrValue.setText("" + player.getStrength());
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeCon) {
                try {
                    player.setConstitution(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Constitution Value")));
                    ConValue.setText("" + player.getConstitution());
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeWis) {
                try {
                    player.setWisdom(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Wisdom Value")));
                    WisValue.setText("" + player.getWisdom());
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeCha) {
                try {
                    player.setCharisma(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Charisma Value")));
                    ChaValue.setText("" + player.getCharisma());
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeDex) {
                try {
                    player.setDexterity(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Dexterity Value")));
                    DexValue.setText("" + player.getDexterity());
                } catch (NumberFormatException ex) {
                }
            } else if (e.getSource() == changeInt) {
                try {
                    player.setIntelligence(Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Intelligence Value")));
                    IntValue.setText("" + player.getIntelligence());
                } catch (NumberFormatException ex) {
                }
            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Skills">
            //<editor-fold defaultstate="collapsed" desc="athleticsButton">
            else if (e.getSource() == athleticsButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Athletics", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        athleticsValue.setText("" + player.getSkills().getKnowledge().get("Athletics"));
                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollAthletics(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="diplomacyButton">
            } else if (e.getSource() == diplomacyButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Diplomacy", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        diplomacyValue.setText("" + player.getSkills().getKnowledge().get("Diplomacy"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollDiplomacy(player, mainTextArea);
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="intimidateButton">
            } else if (e.getSource() == intimidateButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Intimidate", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        intimidateValue.setText("" + player.getSkills().getKnowledge().get("Intimidate"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollIntimidate(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="streetwiseButton">
            } else if (e.getSource() == streetwiseButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Streetwise", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        streetwiseValue.setText("" + player.getSkills().getKnowledge().get("Streetwise"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollStreetwise(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="bluffButton">
            } else if (e.getSource() == bluffButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Bluff", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        bluffValue.setText("" + player.getSkills().getKnowledge().get("Bluff"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollBluff(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="acrobaticsButton">
            } else if (e.getSource() == acrobaticsButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Acrobatics", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        acrobaticsValue.setText("" + player.getSkills().getKnowledge().get("Acrobatics"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollAcrobatics(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="thieveryButton">
            } else if (e.getSource() == thieveryButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Thievery", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        thieveryValue.setText("" + player.getSkills().getKnowledge().get("Thievery"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollThievery(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="stealthButton">
            } else if (e.getSource() == stealthButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Stealth", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        stealthValue.setText("" + player.getSkills().getKnowledge().get("Stealth"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollStealth(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="enduranceButton">
            } else if (e.getSource() == enduranceButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Endurance", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        enduranceValue.setText("" + player.getSkills().getKnowledge().get("Endurance"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollEndurance(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="dungeoneeringButton">
            } else if (e.getSource() == dungeoneeringButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Dungeoneering", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        dungeoneeringValue.setText("" + player.getSkills().getKnowledge().get("Dungeoneering"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollDungeoneering(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="perceptionButton">
            } else if (e.getSource() == perceptionButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Perception", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        perceptionValue.setText("" + player.getSkills().getKnowledge().get("Perception"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollPerception(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="insightButton">
            } else if (e.getSource() == insightButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Insight", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        insightValue.setText("" + player.getSkills().getKnowledge().get("Insight"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollInsight(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="natureButton">
            } else if (e.getSource() == natureButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Nature", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        natureValue.setText("" + player.getSkills().getKnowledge().get("Nature"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollNature(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="healButton">
            } else if (e.getSource() == healButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Heal", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        healValue.setText("" + player.getSkills().getKnowledge().get("Heal"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollHeal(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="religionButton">
            } else if (e.getSource() == religionButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Religion", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        religionValue.setText("" + player.getSkills().getKnowledge().get("Religion"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollReligion(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="historyButton">
            } else if (e.getSource() == historyButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("History", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        historyValue.setText("" + player.getSkills().getKnowledge().get("History"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollHistory(player, mainTextArea);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="arcanaButton">
            } else if (e.getSource() == arcanaButton) {
                if (editMode.isSelected()) {
                    try {
                        player.getSkills().getKnowledge().put("Arcana", Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Number")));
                        arcanaValue.setText("" + player.getSkills().getKnowledge().get("Arcana"));

                    } catch (NumberFormatException ex) {
                    }
                } else {
                    player.getSkills().rollArcana(player, mainTextArea);

                }
                //</editor-fold>

            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Abilities">
            else if (e.getSource() == rollAbility1) {
                rollDices(
                        mainTextArea,
                        ability1.getText(),
                        diceCollection.getDice(abilityDice.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices.getValue().toString()),
                        ability1Stat.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility2) {
                rollDices(
                        mainTextArea,
                        ability2.getText(),
                        diceCollection.getDice(abilityDice1.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices1.getValue().toString()),
                        ability1Stat1.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat1.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility3) {
                rollDices(
                        mainTextArea,
                        ability3.getText(),
                        diceCollection.getDice(abilityDice2.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices2.getValue().toString()),
                        ability1Stat2.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat2.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility4) {
                rollDices(
                        mainTextArea,
                        ability4.getText(),
                        diceCollection.getDice(abilityDice3.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices3.getValue().toString()),
                        ability1Stat3.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat3.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility5) {
                rollDices(
                        mainTextArea,
                        ability5.getText(),
                        diceCollection.getDice(abilityDice4.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices4.getValue().toString()),
                        ability1Stat4.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat4.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility6) {
                rollDices(
                        mainTextArea,
                        ability6.getText(),
                        diceCollection.getDice(abilityDice5.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices5.getValue().toString()),
                        ability1Stat5.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat5.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility7) {
                rollDices(
                        mainTextArea,
                        ability7.getText(),
                        diceCollection.getDice(abilityDice6.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices6.getValue().toString()),
                        ability1Stat6.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat6.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility8) {
                rollDices(
                        mainTextArea,
                        ability8.getText(),
                        diceCollection.getDice(abilityDice7.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices7.getValue().toString()),
                        ability1Stat7.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat7.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility9) {
                rollDices(
                        mainTextArea,
                        ability9.getText(),
                        diceCollection.getDice(abilityDice8.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices8.getValue().toString()),
                        ability1Stat8.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat8.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility10) {
                rollDices(
                        mainTextArea,
                        ability10.getText(),
                        diceCollection.getDice(abilityDice9.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices9.getValue().toString()),
                        ability1Stat9.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat9.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility11) {
                rollDices(
                        mainTextArea,
                        ability11.getText(),
                        diceCollection.getDice(abilityDice10.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices10.getValue().toString()),
                        ability1Stat10.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat10.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility12) {
                rollDices(
                        mainTextArea,
                        ability12.getText(),
                        diceCollection.getDice(abilityDice11.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices11.getValue().toString()),
                        ability1Stat11.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat11.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility13) {
                rollDices(
                        mainTextArea,
                        ability13.getText(),
                        diceCollection.getDice(abilityDice12.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices12.getValue().toString()),
                        ability1Stat12.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat12.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility14) {
                rollDices(
                        mainTextArea,
                        ability14.getText(),
                        diceCollection.getDice(abilityDice13.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices13.getValue().toString()),
                        ability1Stat13.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat13.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } else if (e.getSource() == rollAbility15) {
                rollDices(
                        mainTextArea,
                        ability15.getText(),
                        diceCollection.getDice(abilityDice14.getSelectedItem().toString()),
                        Integer.parseInt(ability1NrOfDices14.getValue().toString()),
                        ability1Stat14.getSelectedItem().toString(),
                        AbiCal(StringToInt(ability1Stat14.getSelectedItem().toString())),
                        Integer.parseInt(abilityBonus.getValue().toString()),
                        Integer.parseInt(abilityPenalties.getValue().toString()));

            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="equipment">
            else if (e.getSource() == changeWeapon) {
                player.setMainHand(storage.getWeapons().get(weaponSelecter.getSelectedItem().toString()).getItemName());
                Image MainHandWeapon = imageHandler.getScaledImage(new javax.swing.ImageIcon(getClass().getResource(imagePath + player.getMainHand() + ".png")).getImage(), 190, 330);
                weaponImage.setIcon((new javax.swing.ImageIcon(MainHandWeapon)));
                MainHandName.setText(storage.getWeapons().get(player.getMainHand()).getItemName());
                MainHandDmg.setText(storage.getWeapons().get(player.getMainHand()).getNrOfDice() + "D" + storage.getWeapons().get(player.getMainHand()).getDmgPerDice());
                MainhandHands.setText(storage.getWeapons().get(player.getMainHand()).getHands() + "-Handed");
                MainHandType.setText(storage.getWeapons().get(player.getMainHand()).getGroup());
                MainHandProps.setText(storage.getWeapons().get(player.getMainHand()).getProperties());
            } else if (e.getSource() == changeArmor) {
                player.setArmor(storage.getArmors().get(armorSelecter.getSelectedItem().toString()).getItemName());
                Image Armor = imageHandler.getScaledImage(new javax.swing.ImageIcon(getClass().getResource(imagePath + player.getArmor() + ".png")).getImage(), 190, 330);
                ArmorImage.setIcon((new javax.swing.ImageIcon(Armor)));
                bodyName.setText(storage.getArmors().get(player.getArmor()).getItemName());
                bodyAC.setText("Armor: " + storage.getArmors().get(player.getArmor()).getArmorBonus());
                BodySpeed.setText("Speed: " + storage.getArmors().get(player.getArmor()).getSpeed());
                BodyChecks.setText("Checks: " + storage.getArmors().get(player.getArmor()).getCheck());
                BodyWeight.setText("Weight: " + storage.getArmors().get(player.getArmor()).getWeight());
            } //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Amulet">
            else if (e.getSource() == amuChangeValue) {
                try {

                    amuChargesValue = Integer.parseInt(JOptionPane.showInputDialog(MainScreen.this, "Input a new Value"));
                    amuCharges.setText("" + amuChargesValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainScreen.this, "Invalid input");
                }
            } else if (e.getSource() == amuHeal) {
                if (amuChargesValue != 0) {
                    mainTextArea.setText("---Healing---" + "\n");
                    mainTextArea.append("result: " + diceCollection.getDice("6-Sided").RollDice());
                    amuChargesValue--;
                    amuCharges.setText("" + amuChargesValue);
                } else {
                    mainTextArea.setText("Not enough ");
                }

            } else if (e.getSource() == amuShield) {
                if (amuChargesValue != 0) {
                    mainTextArea.setText("---Shield---" + "\n");
                    mainTextArea.append("result: " + diceCollection.getDice("8-Sided").RollDice());
                    amuChargesValue--;
                    amuCharges.setText("" + amuChargesValue);
                } else {
                    mainTextArea.setText("Not enough ");
                }
            } else if (e.getSource() == amuRegen) {
                if (amuChargesValue > 1) {
                    mainTextArea.setText("---Regen---" + "\n");
                    mainTextArea.append("Your Target is Regenerating 2 Health each turn");
                    amuChargesValue -= 2;
                    amuCharges.setText("" + amuChargesValue);
                } else {
                    mainTextArea.setText("Not enough ");
                }
            } //</editor-fold>
            else if (e.getSource() == getIPButton) {

                IPLabel.setText("My IP: " + getIP.getLocalIP().getHostAddress());

            } else if (e.getSource() == ConnectButton) {
            } else if (e.getSource() == networkSendData) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabScreen = new javax.swing.JTabbedPane();
        SkillsTab = new javax.swing.JPanel();
        editMode = new javax.swing.JCheckBox();
        athleticsValue = new javax.swing.JLabel();
        athleticsButton = new javax.swing.JButton();
        stealthValue = new javax.swing.JLabel();
        stealthButton = new javax.swing.JButton();
        arcanaValue = new javax.swing.JLabel();
        arcanaButton = new javax.swing.JButton();
        diplomacyValue = new javax.swing.JLabel();
        diplomacyButton = new javax.swing.JButton();
        intimidateValue = new javax.swing.JLabel();
        intimidateButton = new javax.swing.JButton();
        streetwiseValue = new javax.swing.JLabel();
        streetwiseButton = new javax.swing.JButton();
        bluffValue = new javax.swing.JLabel();
        bluffButton = new javax.swing.JButton();
        acrobaticsValue = new javax.swing.JLabel();
        acrobaticsButton = new javax.swing.JButton();
        thieveryValue = new javax.swing.JLabel();
        thieveryButton = new javax.swing.JButton();
        enduranceValue = new javax.swing.JLabel();
        enduranceButton = new javax.swing.JButton();
        dungeoneeringValue = new javax.swing.JLabel();
        dungeoneeringButton = new javax.swing.JButton();
        perceptionValue = new javax.swing.JLabel();
        perceptionButton = new javax.swing.JButton();
        insightValue = new javax.swing.JLabel();
        insightButton = new javax.swing.JButton();
        natureValue = new javax.swing.JLabel();
        natureButton = new javax.swing.JButton();
        healValue = new javax.swing.JLabel();
        healButton = new javax.swing.JButton();
        religionValue = new javax.swing.JLabel();
        religionButton = new javax.swing.JButton();
        historyValue = new javax.swing.JLabel();
        historyButton = new javax.swing.JButton();
        skillsimage = new javax.swing.JLabel();
        equipmentTab = new javax.swing.JPanel();
        MainWeaponTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        weaponImage = new javax.swing.JLabel();
        weaponSelecter = new javax.swing.JComboBox();
        changeWeapon = new javax.swing.JButton();
        MainHandName = new javax.swing.JLabel();
        MainhandHands = new javax.swing.JLabel();
        MainHandDmg = new javax.swing.JLabel();
        MainHandType = new javax.swing.JLabel();
        MainHandProps = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ArmorImage = new javax.swing.JLabel();
        armorSelecter = new javax.swing.JComboBox();
        changeArmor = new javax.swing.JButton();
        bodyName = new javax.swing.JLabel();
        bodyAC = new javax.swing.JLabel();
        BodySpeed = new javax.swing.JLabel();
        BodyChecks = new javax.swing.JLabel();
        BodyWeight = new javax.swing.JLabel();
        abilities = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        ability1 = new javax.swing.JTextField();
        abilityDice = new javax.swing.JComboBox();
        ability1Stat = new javax.swing.JComboBox();
        rollAbility1 = new javax.swing.JButton();
        ability1NrOfDices = new javax.swing.JSpinner();
        ability2 = new javax.swing.JTextField();
        rollAbility2 = new javax.swing.JButton();
        ability1NrOfDices1 = new javax.swing.JSpinner();
        ability1Stat1 = new javax.swing.JComboBox();
        abilityDice1 = new javax.swing.JComboBox();
        ability3 = new javax.swing.JTextField();
        rollAbility3 = new javax.swing.JButton();
        ability1NrOfDices2 = new javax.swing.JSpinner();
        ability1Stat2 = new javax.swing.JComboBox();
        abilityDice2 = new javax.swing.JComboBox();
        ability4 = new javax.swing.JTextField();
        rollAbility4 = new javax.swing.JButton();
        ability1NrOfDices3 = new javax.swing.JSpinner();
        ability1Stat3 = new javax.swing.JComboBox();
        abilityDice3 = new javax.swing.JComboBox();
        rollAbility5 = new javax.swing.JButton();
        ability1NrOfDices4 = new javax.swing.JSpinner();
        ability1Stat4 = new javax.swing.JComboBox();
        abilityDice4 = new javax.swing.JComboBox();
        ability5 = new javax.swing.JTextField();
        ability6 = new javax.swing.JTextField();
        abilityDice5 = new javax.swing.JComboBox();
        ability1Stat5 = new javax.swing.JComboBox();
        ability1NrOfDices5 = new javax.swing.JSpinner();
        rollAbility6 = new javax.swing.JButton();
        ability7 = new javax.swing.JTextField();
        abilityDice6 = new javax.swing.JComboBox();
        ability1Stat6 = new javax.swing.JComboBox();
        ability1NrOfDices6 = new javax.swing.JSpinner();
        rollAbility7 = new javax.swing.JButton();
        ability8 = new javax.swing.JTextField();
        abilityDice7 = new javax.swing.JComboBox();
        ability1Stat7 = new javax.swing.JComboBox();
        ability1NrOfDices7 = new javax.swing.JSpinner();
        rollAbility8 = new javax.swing.JButton();
        ability9 = new javax.swing.JTextField();
        abilityDice8 = new javax.swing.JComboBox();
        ability1Stat8 = new javax.swing.JComboBox();
        ability1NrOfDices8 = new javax.swing.JSpinner();
        rollAbility9 = new javax.swing.JButton();
        ability10 = new javax.swing.JTextField();
        abilityDice9 = new javax.swing.JComboBox();
        ability1Stat9 = new javax.swing.JComboBox();
        ability1NrOfDices9 = new javax.swing.JSpinner();
        rollAbility10 = new javax.swing.JButton();
        ability1NrOfDices10 = new javax.swing.JSpinner();
        ability11 = new javax.swing.JTextField();
        rollAbility11 = new javax.swing.JButton();
        abilityDice10 = new javax.swing.JComboBox();
        ability1Stat10 = new javax.swing.JComboBox();
        ability1NrOfDices11 = new javax.swing.JSpinner();
        ability12 = new javax.swing.JTextField();
        rollAbility12 = new javax.swing.JButton();
        abilityDice11 = new javax.swing.JComboBox();
        ability1Stat11 = new javax.swing.JComboBox();
        ability1NrOfDices12 = new javax.swing.JSpinner();
        ability13 = new javax.swing.JTextField();
        rollAbility13 = new javax.swing.JButton();
        abilityDice12 = new javax.swing.JComboBox();
        ability1Stat12 = new javax.swing.JComboBox();
        ability1NrOfDices13 = new javax.swing.JSpinner();
        ability14 = new javax.swing.JTextField();
        rollAbility14 = new javax.swing.JButton();
        abilityDice13 = new javax.swing.JComboBox();
        ability1Stat13 = new javax.swing.JComboBox();
        ability1NrOfDices14 = new javax.swing.JSpinner();
        ability15 = new javax.swing.JTextField();
        rollAbility15 = new javax.swing.JButton();
        abilityDice14 = new javax.swing.JComboBox();
        ability1Stat14 = new javax.swing.JComboBox();
        abilityBonus = new javax.swing.JSpinner();
        abilityPenalties = new javax.swing.JSpinner();
        AbilityBonusLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        playerTab = new javax.swing.JPanel();
        Recalculate = new javax.swing.JButton();
        PlayernameButton = new javax.swing.JButton();
        PlayernameLabel = new javax.swing.JLabel();
        CharacternameButton = new javax.swing.JButton();
        characterNameLabel = new javax.swing.JLabel();
        levelButton = new javax.swing.JButton();
        levelLabel = new javax.swing.JLabel();
        raceButton = new javax.swing.JButton();
        raceLabel = new javax.swing.JLabel();
        classButton = new javax.swing.JButton();
        classLabel = new javax.swing.JLabel();
        characterTabImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        amuCharges = new javax.swing.JLabel();
        amuChangeValue = new javax.swing.JButton();
        highestModifierforAmuShield = new javax.swing.JComboBox();
        amuHeal = new javax.swing.JButton();
        amuShield = new javax.swing.JButton();
        amuRegen = new javax.swing.JButton();
        amuLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        getIPButton = new javax.swing.JButton();
        IPLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkChatOutput = new javax.swing.JTextArea();
        networkChatInput = new javax.swing.JTextField();
        networkSendData = new javax.swing.JButton();
        ConnectButton = new javax.swing.JButton();
        connectionStatusLabel = new javax.swing.JLabel();
        IPinput = new javax.swing.JTextField();
        textpane = new javax.swing.JScrollPane();
        mainTextArea = new javax.swing.JTextArea();
        playerTitle = new javax.swing.JLabel();
        changeStr = new javax.swing.JButton();
        StrValue = new javax.swing.JLabel();
        StrModifier = new javax.swing.JLabel();
        changeCon = new javax.swing.JButton();
        ConValue = new javax.swing.JLabel();
        ConModifier = new javax.swing.JLabel();
        changeWis = new javax.swing.JButton();
        WisValue = new javax.swing.JLabel();
        WisModifier = new javax.swing.JLabel();
        changeCha = new javax.swing.JButton();
        ChaValue = new javax.swing.JLabel();
        ChaModifier = new javax.swing.JLabel();
        changeDex = new javax.swing.JButton();
        DexValue = new javax.swing.JLabel();
        DexModifier = new javax.swing.JLabel();
        changeInt = new javax.swing.JButton();
        IntValue = new javax.swing.JLabel();
        IntModifier = new javax.swing.JLabel();
        ACValue = new javax.swing.JLabel();
        changeAC = new javax.swing.JButton();
        ACBonus = new javax.swing.JLabel();
        ForValue = new javax.swing.JLabel();
        changeFor = new javax.swing.JButton();
        ForBonus = new javax.swing.JLabel();
        RefValue = new javax.swing.JLabel();
        changeRef = new javax.swing.JButton();
        RefBonus = new javax.swing.JLabel();
        WillValue = new javax.swing.JLabel();
        changeWill = new javax.swing.JButton();
        WillBonus = new javax.swing.JLabel();
        SpdValue = new javax.swing.JLabel();
        IniValue = new javax.swing.JLabel();
        baseStatsImage = new javax.swing.JLabel();
        MainDice = new javax.swing.JComboBox();
        DiceModifiers = new javax.swing.JComboBox();
        NrOfDices = new javax.swing.JSpinner();
        extraDices1 = new javax.swing.JComboBox();
        secondaryDiceModifier = new javax.swing.JComboBox();
        NrOfExtraDices = new javax.swing.JSpinner();
        RollDmg = new javax.swing.JButton();
        rollBonuses = new javax.swing.JSpinner();
        rollPenalties = new javax.swing.JSpinner();
        mainBonus = new javax.swing.JLabel();
        mainPenalty = new javax.swing.JLabel();
        healthbarButton = new javax.swing.JButton();
        Healthbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(792, 603));
        setName("mainFrame");
        getContentPane().setLayout(null);

        SkillsTab.setLayout(null);

        editMode.setText("Edit Mode");
        SkillsTab.add(editMode);
        editMode.setBounds(130, 0, 81, 23);

        athleticsValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        athleticsValue.setText("0");
        SkillsTab.add(athleticsValue);
        athleticsValue.setBounds(130, 51, 50, 20);

        athleticsButton.setContentAreaFilled(false);
        SkillsTab.add(athleticsButton);
        athleticsButton.setBounds(30, 50, 80, 20);

        stealthValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stealthValue.setText("0");
        SkillsTab.add(stealthValue);
        stealthValue.setBounds(130, 294, 50, 20);

        stealthButton.setContentAreaFilled(false);
        SkillsTab.add(stealthButton);
        stealthButton.setBounds(30, 293, 80, 20);

        arcanaValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        arcanaValue.setText("0");
        SkillsTab.add(arcanaValue);
        arcanaValue.setBounds(330, 296, 50, 20);

        arcanaButton.setContentAreaFilled(false);
        SkillsTab.add(arcanaButton);
        arcanaButton.setBounds(210, 300, 60, 20);

        diplomacyValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diplomacyValue.setText("0");
        SkillsTab.add(diplomacyValue);
        diplomacyValue.setBounds(130, 104, 50, 20);

        diplomacyButton.setContentAreaFilled(false);
        SkillsTab.add(diplomacyButton);
        diplomacyButton.setBounds(30, 100, 90, 20);

        intimidateValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        intimidateValue.setText("0");
        SkillsTab.add(intimidateValue);
        intimidateValue.setBounds(130, 129, 50, 20);

        intimidateButton.setContentAreaFilled(false);
        SkillsTab.add(intimidateButton);
        intimidateButton.setBounds(30, 130, 90, 20);

        streetwiseValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        streetwiseValue.setText("0");
        SkillsTab.add(streetwiseValue);
        streetwiseValue.setBounds(130, 157, 50, 20);

        streetwiseButton.setContentAreaFilled(false);
        SkillsTab.add(streetwiseButton);
        streetwiseButton.setBounds(30, 155, 90, 20);

        bluffValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bluffValue.setText("0");
        SkillsTab.add(bluffValue);
        bluffValue.setBounds(130, 182, 50, 20);

        bluffButton.setContentAreaFilled(false);
        SkillsTab.add(bluffButton);
        bluffButton.setBounds(30, 180, 60, 20);

        acrobaticsValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        acrobaticsValue.setText("0");
        SkillsTab.add(acrobaticsValue);
        acrobaticsValue.setBounds(130, 243, 50, 20);

        acrobaticsButton.setContentAreaFilled(false);
        SkillsTab.add(acrobaticsButton);
        acrobaticsButton.setBounds(30, 240, 90, 20);

        thieveryValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        thieveryValue.setText("0");
        SkillsTab.add(thieveryValue);
        thieveryValue.setBounds(130, 268, 50, 20);

        thieveryButton.setContentAreaFilled(false);
        SkillsTab.add(thieveryButton);
        thieveryButton.setBounds(30, 267, 80, 20);

        enduranceValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enduranceValue.setText("0");
        SkillsTab.add(enduranceValue);
        enduranceValue.setBounds(330, 50, 50, 20);

        enduranceButton.setContentAreaFilled(false);
        SkillsTab.add(enduranceButton);
        enduranceButton.setBounds(210, 50, 90, 20);

        dungeoneeringValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dungeoneeringValue.setText("0");
        SkillsTab.add(dungeoneeringValue);
        dungeoneeringValue.setBounds(330, 100, 50, 20);

        dungeoneeringButton.setContentAreaFilled(false);
        SkillsTab.add(dungeoneeringButton);
        dungeoneeringButton.setBounds(210, 100, 110, 20);

        perceptionValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        perceptionValue.setText("0");
        SkillsTab.add(perceptionValue);
        perceptionValue.setBounds(330, 122, 50, 20);

        perceptionButton.setContentAreaFilled(false);
        SkillsTab.add(perceptionButton);
        perceptionButton.setBounds(210, 120, 80, 20);

        insightValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insightValue.setText("0");
        SkillsTab.add(insightValue);
        insightValue.setBounds(330, 142, 50, 20);

        insightButton.setContentAreaFilled(false);
        SkillsTab.add(insightButton);
        insightButton.setBounds(210, 143, 60, 20);

        natureValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        natureValue.setText("0");
        SkillsTab.add(natureValue);
        natureValue.setBounds(330, 163, 50, 20);

        natureButton.setContentAreaFilled(false);
        SkillsTab.add(natureButton);
        natureButton.setBounds(210, 165, 60, 20);

        healValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        healValue.setText("0");
        SkillsTab.add(healValue);
        healValue.setBounds(330, 185, 50, 20);

        healButton.setContentAreaFilled(false);
        SkillsTab.add(healButton);
        healButton.setBounds(210, 186, 40, 20);

        religionValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        religionValue.setText("0");
        SkillsTab.add(religionValue);
        religionValue.setBounds(330, 245, 50, 20);

        religionButton.setContentAreaFilled(false);
        SkillsTab.add(religionButton);
        religionButton.setBounds(210, 243, 70, 20);

        historyValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        historyValue.setText("0");
        SkillsTab.add(historyValue);
        historyValue.setBounds(330, 271, 50, 20);

        historyButton.setContentAreaFilled(false);
        SkillsTab.add(historyButton);
        historyButton.setBounds(210, 270, 70, 20);

        skillsimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bilder/skills.png"))); // NOI18N
        skillsimage.setText("jLabel3");
        SkillsTab.add(skillsimage);
        skillsimage.setBounds(0, 0, 390, 360);

        TabScreen.addTab("Skills", SkillsTab);

        equipmentTab.setLayout(null);

        MainWeaponTab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setLayout(null);

        weaponImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weaponImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(weaponImage);
        weaponImage.setBounds(0, 0, 190, 330);

        weaponSelecter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Club", "Dagger", "Javelin", "Mace", "Sickle", "Spear", "Greatclub", "Morningstar", "Quarterstaff", "Scythe", "Battleaxe", "Flail", "Handaxe", "Longsword", "Scimitar", "Short sword", "Throw hammer", "Warhammer", "War pick", "Falchion", "Glaive", "Greataxe", "Greatsword", "Halberd", "Maul", "Bastard sword", "Hand crossbow", "Sling", "Crossbow", "Longbow", "Shortbow" }));
        jPanel2.add(weaponSelecter);
        weaponSelecter.setBounds(200, 10, 180, 20);

        changeWeapon.setText("Change Weapon");
        jPanel2.add(changeWeapon);
        changeWeapon.setBounds(200, 30, 180, 20);

        MainHandName.setText("MainHandName");
        jPanel2.add(MainHandName);
        MainHandName.setBounds(200, 90, 190, 14);

        MainhandHands.setText("MainHandHands");
        jPanel2.add(MainhandHands);
        MainhandHands.setBounds(200, 110, 190, 14);

        MainHandDmg.setText("MainHandDmg");
        jPanel2.add(MainHandDmg);
        MainHandDmg.setBounds(200, 130, 190, 14);

        MainHandType.setText("MainHandType");
        jPanel2.add(MainHandType);
        MainHandType.setBounds(200, 150, 190, 14);

        MainHandProps.setText("MainHandProps");
        jPanel2.add(MainHandProps);
        MainHandProps.setBounds(200, 170, 190, 14);

        MainWeaponTab.addTab("Weapon", jPanel2);

        jPanel3.setLayout(null);

        ArmorImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArmorImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ArmorImage);
        ArmorImage.setBounds(0, 0, 190, 330);

        armorSelecter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cloth Armor", "Leather Armor", "Hide Armor", "Chainmail", "Scale armor", "Plate armor" }));
        jPanel3.add(armorSelecter);
        armorSelecter.setBounds(200, 10, 180, 20);

        changeArmor.setText("Change Armor");
        jPanel3.add(changeArmor);
        changeArmor.setBounds(200, 30, 180, 20);

        bodyName.setText("BodyArmorName");
        jPanel3.add(bodyName);
        bodyName.setBounds(200, 60, 180, 20);

        bodyAC.setText("BodyArmorAC");
        jPanel3.add(bodyAC);
        bodyAC.setBounds(200, 80, 180, 20);

        BodySpeed.setText("BodySpeed");
        jPanel3.add(BodySpeed);
        BodySpeed.setBounds(200, 100, 180, 20);

        BodyChecks.setText("BodyChecks");
        jPanel3.add(BodyChecks);
        BodyChecks.setBounds(200, 120, 180, 20);

        BodyWeight.setText("BodyWeight");
        jPanel3.add(BodyWeight);
        BodyWeight.setBounds(200, 140, 180, 20);

        MainWeaponTab.addTab("Armor", jPanel3);

        equipmentTab.add(MainWeaponTab);
        MainWeaponTab.setBounds(0, 0, 400, 360);

        TabScreen.addTab("Equipment", equipmentTab);

        abilities.setLayout(null);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setPreferredSize(new java.awt.Dimension(398, 920));
        jPanel1.setLayout(null);
        jPanel1.add(ability1);
        ability1.setBounds(10, 10, 240, 20);

        abilityDice.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice);
        abilityDice.setBounds(10, 40, 80, 20);

        ability1Stat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat);
        ability1Stat.setBounds(100, 40, 70, 20);
        jPanel1.add(rollAbility1);
        rollAbility1.setBounds(220, 40, 30, 23);

        ability1NrOfDices.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices);
        ability1NrOfDices.setBounds(180, 40, 31, 20);
        jPanel1.add(ability2);
        ability2.setBounds(10, 70, 240, 20);
        jPanel1.add(rollAbility2);
        rollAbility2.setBounds(220, 100, 30, 23);

        ability1NrOfDices1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices1);
        ability1NrOfDices1.setBounds(180, 100, 31, 20);

        ability1Stat1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat1);
        ability1Stat1.setBounds(100, 100, 70, 20);

        abilityDice1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice1);
        abilityDice1.setBounds(10, 100, 80, 20);
        jPanel1.add(ability3);
        ability3.setBounds(10, 130, 240, 20);
        jPanel1.add(rollAbility3);
        rollAbility3.setBounds(220, 160, 30, 23);

        ability1NrOfDices2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices2);
        ability1NrOfDices2.setBounds(180, 160, 31, 20);

        ability1Stat2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat2);
        ability1Stat2.setBounds(100, 160, 70, 20);

        abilityDice2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice2);
        abilityDice2.setBounds(10, 160, 80, 20);
        jPanel1.add(ability4);
        ability4.setBounds(10, 190, 240, 20);
        jPanel1.add(rollAbility4);
        rollAbility4.setBounds(220, 220, 30, 23);

        ability1NrOfDices3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices3);
        ability1NrOfDices3.setBounds(180, 220, 31, 20);

        ability1Stat3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat3);
        ability1Stat3.setBounds(100, 220, 70, 20);

        abilityDice3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice3);
        abilityDice3.setBounds(10, 220, 80, 20);
        jPanel1.add(rollAbility5);
        rollAbility5.setBounds(220, 280, 30, 23);

        ability1NrOfDices4.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices4);
        ability1NrOfDices4.setBounds(180, 280, 31, 20);

        ability1Stat4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat4);
        ability1Stat4.setBounds(100, 280, 70, 20);

        abilityDice4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice4);
        abilityDice4.setBounds(10, 280, 80, 20);
        jPanel1.add(ability5);
        ability5.setBounds(10, 250, 240, 20);
        jPanel1.add(ability6);
        ability6.setBounds(10, 310, 240, 20);

        abilityDice5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice5);
        abilityDice5.setBounds(10, 340, 80, 20);

        ability1Stat5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat5);
        ability1Stat5.setBounds(100, 340, 70, 20);

        ability1NrOfDices5.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices5);
        ability1NrOfDices5.setBounds(180, 340, 31, 20);
        jPanel1.add(rollAbility6);
        rollAbility6.setBounds(220, 340, 30, 23);
        jPanel1.add(ability7);
        ability7.setBounds(10, 370, 240, 20);

        abilityDice6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice6);
        abilityDice6.setBounds(10, 400, 80, 20);

        ability1Stat6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat6);
        ability1Stat6.setBounds(100, 400, 70, 20);

        ability1NrOfDices6.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices6);
        ability1NrOfDices6.setBounds(180, 400, 31, 20);
        jPanel1.add(rollAbility7);
        rollAbility7.setBounds(220, 400, 30, 23);
        jPanel1.add(ability8);
        ability8.setBounds(10, 430, 240, 20);

        abilityDice7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice7);
        abilityDice7.setBounds(10, 460, 80, 20);

        ability1Stat7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat7);
        ability1Stat7.setBounds(100, 460, 70, 20);

        ability1NrOfDices7.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices7);
        ability1NrOfDices7.setBounds(180, 460, 31, 20);
        jPanel1.add(rollAbility8);
        rollAbility8.setBounds(220, 460, 30, 23);
        jPanel1.add(ability9);
        ability9.setBounds(10, 490, 240, 20);

        abilityDice8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice8);
        abilityDice8.setBounds(10, 520, 80, 20);

        ability1Stat8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat8);
        ability1Stat8.setBounds(100, 520, 70, 20);

        ability1NrOfDices8.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices8);
        ability1NrOfDices8.setBounds(180, 520, 31, 20);
        jPanel1.add(rollAbility9);
        rollAbility9.setBounds(220, 520, 30, 23);
        jPanel1.add(ability10);
        ability10.setBounds(10, 550, 240, 20);

        abilityDice9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice9);
        abilityDice9.setBounds(10, 580, 80, 20);

        ability1Stat9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat9);
        ability1Stat9.setBounds(100, 580, 70, 20);

        ability1NrOfDices9.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices9);
        ability1NrOfDices9.setBounds(180, 580, 31, 20);
        jPanel1.add(rollAbility10);
        rollAbility10.setBounds(220, 580, 30, 23);

        ability1NrOfDices10.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices10);
        ability1NrOfDices10.setBounds(180, 640, 31, 20);
        jPanel1.add(ability11);
        ability11.setBounds(10, 610, 240, 20);
        jPanel1.add(rollAbility11);
        rollAbility11.setBounds(220, 640, 30, 23);

        abilityDice10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice10);
        abilityDice10.setBounds(10, 640, 80, 20);

        ability1Stat10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat10);
        ability1Stat10.setBounds(100, 640, 70, 20);

        ability1NrOfDices11.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices11);
        ability1NrOfDices11.setBounds(180, 700, 31, 20);
        jPanel1.add(ability12);
        ability12.setBounds(10, 670, 240, 20);
        jPanel1.add(rollAbility12);
        rollAbility12.setBounds(220, 700, 30, 23);

        abilityDice11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice11);
        abilityDice11.setBounds(10, 700, 80, 20);

        ability1Stat11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat11);
        ability1Stat11.setBounds(100, 700, 70, 20);

        ability1NrOfDices12.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices12);
        ability1NrOfDices12.setBounds(180, 760, 31, 20);
        jPanel1.add(ability13);
        ability13.setBounds(10, 730, 240, 20);
        jPanel1.add(rollAbility13);
        rollAbility13.setBounds(220, 760, 30, 23);

        abilityDice12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice12);
        abilityDice12.setBounds(10, 760, 80, 20);

        ability1Stat12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat12);
        ability1Stat12.setBounds(100, 760, 70, 20);

        ability1NrOfDices13.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices13);
        ability1NrOfDices13.setBounds(180, 820, 31, 20);
        jPanel1.add(ability14);
        ability14.setBounds(10, 790, 240, 20);
        jPanel1.add(rollAbility14);
        rollAbility14.setBounds(220, 820, 30, 23);

        abilityDice13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice13);
        abilityDice13.setBounds(10, 820, 80, 20);

        ability1Stat13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat13);
        ability1Stat13.setBounds(100, 820, 70, 20);

        ability1NrOfDices14.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(ability1NrOfDices14);
        ability1NrOfDices14.setBounds(180, 880, 31, 20);
        jPanel1.add(ability15);
        ability15.setBounds(10, 850, 240, 20);
        jPanel1.add(rollAbility15);
        rollAbility15.setBounds(220, 880, 30, 23);

        abilityDice14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        abilityDice14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        jPanel1.add(abilityDice14);
        abilityDice14.setBounds(10, 880, 80, 20);

        ability1Stat14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel1.add(ability1Stat14);
        ability1Stat14.setBounds(100, 880, 70, 20);

        abilityBonus.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jPanel1.add(abilityBonus);
        abilityBonus.setBounds(260, 40, 50, 20);

        abilityPenalties.setModel(new javax.swing.SpinnerNumberModel(0, -10, 0, 1));
        jPanel1.add(abilityPenalties);
        abilityPenalties.setBounds(260, 70, 50, 20);

        AbilityBonusLabel.setText("Bonus");
        jPanel1.add(AbilityBonusLabel);
        AbilityBonusLabel.setBounds(320, 40, 40, 20);

        jLabel3.setText("Penalties");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(320, 70, 50, 20);

        jScrollPane2.setViewportView(jPanel1);

        abilities.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 390, 360);

        TabScreen.addTab("Abilities", abilities);

        playerTab.setLayout(null);

        Recalculate.setText("Recalculate");
        Recalculate.setContentAreaFilled(false);
        Recalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecalculateActionPerformed(evt);
            }
        });
        playerTab.add(Recalculate);
        Recalculate.setBounds(0, 150, 390, 20);

        PlayernameButton.setContentAreaFilled(false);
        playerTab.add(PlayernameButton);
        PlayernameButton.setBounds(180, 15, 140, 20);

        PlayernameLabel.setText("--InsertPlayernameHere--");
        playerTab.add(PlayernameLabel);
        PlayernameLabel.setBounds(180, 10, 210, 30);

        CharacternameButton.setContentAreaFilled(false);
        playerTab.add(CharacternameButton);
        CharacternameButton.setBounds(180, 40, 140, 20);

        characterNameLabel.setText("--InsertCharacterName--");
        playerTab.add(characterNameLabel);
        characterNameLabel.setBounds(180, 35, 210, 30);

        levelButton.setContentAreaFilled(false);
        playerTab.add(levelButton);
        levelButton.setBounds(180, 68, 140, 20);

        levelLabel.setText("--InsertLevelHere---");
        playerTab.add(levelLabel);
        levelLabel.setBounds(180, 63, 210, 30);

        raceButton.setContentAreaFilled(false);
        playerTab.add(raceButton);
        raceButton.setBounds(180, 96, 140, 20);

        raceLabel.setText("--InsertRaceHere----");
        playerTab.add(raceLabel);
        raceLabel.setBounds(180, 91, 210, 30);

        classButton.setContentAreaFilled(false);
        playerTab.add(classButton);
        classButton.setBounds(180, 124, 140, 20);

        classLabel.setText("--InsertClassHere---");
        playerTab.add(classLabel);
        classLabel.setBounds(180, 119, 210, 30);

        characterTabImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bilder/characterScreen.png"))); // NOI18N
        playerTab.add(characterTabImage);
        characterTabImage.setBounds(0, 0, 390, 360);

        TabScreen.addTab("Player", playerTab);

        jPanel4.setLayout(null);

        amuCharges.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        amuCharges.setText("0");
        jPanel4.add(amuCharges);
        amuCharges.setBounds(190, 30, 60, 20);

        amuChangeValue.setContentAreaFilled(false);
        jPanel4.add(amuChangeValue);
        amuChangeValue.setBounds(130, 30, 110, 20);

        highestModifierforAmuShield.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        jPanel4.add(highestModifierforAmuShield);
        highestModifierforAmuShield.setBounds(150, 100, 80, 20);

        amuHeal.setText("Heal");
        jPanel4.add(amuHeal);
        amuHeal.setBounds(40, 130, 80, 23);

        amuShield.setText("Shield");
        jPanel4.add(amuShield);
        amuShield.setBounds(150, 130, 80, 23);

        amuRegen.setText("Regen");
        jPanel4.add(amuRegen);
        amuRegen.setBounds(270, 130, 70, 23);

        amuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bilder/amulet.png"))); // NOI18N
        amuLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(amuLabel);
        amuLabel.setBounds(0, 0, 390, 360);

        TabScreen.addTab("Amulet", jPanel4);

        jPanel5.setLayout(null);

        getIPButton.setText("Get IP");
        jPanel5.add(getIPButton);
        getIPButton.setBounds(10, 20, 100, 23);

        IPLabel.setText("My IP:");
        jPanel5.add(IPLabel);
        IPLabel.setBounds(130, 21, 250, 20);

        networkChatOutput.setColumns(20);
        networkChatOutput.setRows(5);
        jScrollPane1.setViewportView(networkChatOutput);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 216, 380, 100);
        jPanel5.add(networkChatInput);
        networkChatInput.setBounds(10, 330, 310, 20);

        networkSendData.setText("Send");
        jPanel5.add(networkSendData);
        networkSendData.setBounds(330, 330, 60, 20);

        ConnectButton.setText("Connect");
        jPanel5.add(ConnectButton);
        ConnectButton.setBounds(10, 50, 100, 23);

        connectionStatusLabel.setText("Not Connected");
        jPanel5.add(connectionStatusLabel);
        connectionStatusLabel.setBounds(120, 50, 130, 20);
        jPanel5.add(IPinput);
        IPinput.setBounds(10, 80, 250, 20);

        TabScreen.addTab("Network", jPanel5);

        getContentPane().add(TabScreen);
        TabScreen.setBounds(0, 170, 400, 390);

        mainTextArea.setColumns(20);
        mainTextArea.setLineWrap(true);
        mainTextArea.setRows(5);
        mainTextArea.setWrapStyleWord(true);
        textpane.setViewportView(mainTextArea);

        getContentPane().add(textpane);
        textpane.setBounds(400, 190, 370, 370);

        playerTitle.setText("-------------------------------------------------------------");
        getContentPane().add(playerTitle);
        playerTitle.setBounds(10, 10, 380, 14);

        changeStr.setContentAreaFilled(false);
        getContentPane().add(changeStr);
        changeStr.setBounds(9, 32, 60, 20);

        StrValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StrValue.setText(" 1");
        getContentPane().add(StrValue);
        StrValue.setBounds(50, 34, 30, 20);

        StrModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(StrModifier);
        StrModifier.setBounds(70, 34, 50, 20);

        changeCon.setContentAreaFilled(false);
        getContentPane().add(changeCon);
        changeCon.setBounds(9, 55, 60, 20);

        ConValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConValue.setText(" 1");
        getContentPane().add(ConValue);
        ConValue.setBounds(50, 55, 30, 20);

        ConModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ConModifier);
        ConModifier.setBounds(70, 55, 50, 20);

        changeWis.setContentAreaFilled(false);
        getContentPane().add(changeWis);
        changeWis.setBounds(9, 76, 60, 20);

        WisValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WisValue.setText(" 1");
        getContentPane().add(WisValue);
        WisValue.setBounds(50, 76, 30, 20);

        WisModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(WisModifier);
        WisModifier.setBounds(70, 76, 50, 20);

        changeCha.setContentAreaFilled(false);
        getContentPane().add(changeCha);
        changeCha.setBounds(9, 98, 60, 20);

        ChaValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChaValue.setText(" 1");
        getContentPane().add(ChaValue);
        ChaValue.setBounds(50, 98, 30, 20);

        ChaModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ChaModifier);
        ChaModifier.setBounds(70, 98, 50, 20);

        changeDex.setContentAreaFilled(false);
        getContentPane().add(changeDex);
        changeDex.setBounds(9, 119, 60, 20);

        DexValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DexValue.setText(" 1");
        getContentPane().add(DexValue);
        DexValue.setBounds(50, 119, 30, 20);

        DexModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(DexModifier);
        DexModifier.setBounds(70, 119, 50, 20);

        changeInt.setContentAreaFilled(false);
        getContentPane().add(changeInt);
        changeInt.setBounds(9, 141, 60, 20);

        IntValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IntValue.setText(" 1");
        getContentPane().add(IntValue);
        IntValue.setBounds(50, 141, 30, 20);

        IntModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(IntModifier);
        IntModifier.setBounds(70, 140, 50, 20);

        ACValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ACValue.setText(" 1");
        getContentPane().add(ACValue);
        ACValue.setBounds(230, 32, 50, 20);

        changeAC.setContentAreaFilled(false);
        getContentPane().add(changeAC);
        changeAC.setBounds(180, 33, 70, 20);

        ACBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ACBonus);
        ACBonus.setBounds(280, 32, 50, 20);

        ForValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ForValue.setText(" 1");
        getContentPane().add(ForValue);
        ForValue.setBounds(230, 55, 50, 20);

        changeFor.setContentAreaFilled(false);
        getContentPane().add(changeFor);
        changeFor.setBounds(180, 55, 70, 20);

        ForBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ForBonus);
        ForBonus.setBounds(280, 55, 50, 20);

        RefValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RefValue.setText(" 1");
        getContentPane().add(RefValue);
        RefValue.setBounds(230, 76, 50, 20);

        changeRef.setContentAreaFilled(false);
        getContentPane().add(changeRef);
        changeRef.setBounds(180, 75, 70, 20);

        RefBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(RefBonus);
        RefBonus.setBounds(280, 76, 50, 20);

        WillValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WillValue.setText(" 1");
        getContentPane().add(WillValue);
        WillValue.setBounds(230, 98, 50, 20);

        changeWill.setContentAreaFilled(false);
        getContentPane().add(changeWill);
        changeWill.setBounds(180, 97, 70, 20);

        WillBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(WillBonus);
        WillBonus.setBounds(280, 98, 50, 20);

        SpdValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SpdValue.setText(" 1");
        getContentPane().add(SpdValue);
        SpdValue.setBounds(230, 119, 30, 20);

        IniValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IniValue.setText(" 1");
        getContentPane().add(IniValue);
        IniValue.setBounds(230, 141, 30, 20);

        baseStatsImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bilder/stats.png"))); // NOI18N
        getContentPane().add(baseStatsImage);
        baseStatsImage.setBounds(0, 0, 390, 190);

        MainDice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided", "Weapon" }));
        getContentPane().add(MainDice);
        MainDice.setBounds(390, 20, 90, 20);

        DiceModifiers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        getContentPane().add(DiceModifiers);
        DiceModifiers.setBounds(490, 20, 110, 20);

        NrOfDices.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        getContentPane().add(NrOfDices);
        NrOfDices.setBounds(600, 20, 40, 25);

        extraDices1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "20-Sided", "12-Sided", "10-Sided", "8-Sided", "6-Sided", "4-Sided" }));
        getContentPane().add(extraDices1);
        extraDices1.setBounds(390, 50, 90, 20);

        secondaryDiceModifier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "Strength", "Constitution", "Wisdom", "Charisma", "Dexterity", "Intelligence" }));
        getContentPane().add(secondaryDiceModifier);
        secondaryDiceModifier.setBounds(490, 50, 110, 20);

        NrOfExtraDices.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        getContentPane().add(NrOfExtraDices);
        NrOfExtraDices.setBounds(600, 50, 40, 25);

        RollDmg.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        RollDmg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bilder/20sidedDice.png"))); // NOI18N
        RollDmg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RollDmg.setMargin(new java.awt.Insets(1, 1, 1, 1));
        RollDmg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollDmgActionPerformed(evt);
            }
        });
        getContentPane().add(RollDmg);
        RollDmg.setBounds(650, 20, 120, 110);

        rollBonuses.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        rollBonuses.setEditor(new javax.swing.JSpinner.NumberEditor(rollBonuses, ""));
        getContentPane().add(rollBonuses);
        rollBonuses.setBounds(430, 80, 50, 30);

        rollPenalties.setModel(new javax.swing.SpinnerNumberModel(0, -20, 0, 1));
        rollPenalties.setEditor(new javax.swing.JSpinner.NumberEditor(rollPenalties, ""));
        getContentPane().add(rollPenalties);
        rollPenalties.setBounds(530, 80, 50, 30);

        mainBonus.setText("Bonus");
        getContentPane().add(mainBonus);
        mainBonus.setBounds(390, 80, 100, 30);

        mainPenalty.setText("Penalty");
        getContentPane().add(mainPenalty);
        mainPenalty.setBounds(490, 80, 100, 30);

        healthbarButton.setText("0 / 0");
        healthbarButton.setBorder(null);
        healthbarButton.setContentAreaFilled(false);
        healthbarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthbarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(healthbarButton);
        healthbarButton.setBounds(450, 160, 260, 20);

        Healthbar.setValue(100);
        Healthbar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        getContentPane().add(Healthbar);
        Healthbar.setBounds(450, 160, 260, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int StringToInt(String StatName) {

        if (StatName.equals("Strength")) {
            return player.getStrength();
        } else if (StatName.equals("Constitution")) {
            return player.getConstitution();
        } else if (StatName.equals("Wisdom")) {
            return player.getWisdom();
        } else if (StatName.equals("Charisma")) {
            return player.getCharisma();
        } else if (StatName.equals("Dexterity")) {
            return player.getDexterity();
        } else if (StatName.equals("Intelligence")) {
            return player.getIntelligence();
        } else {
            return 0;
        }
    }

    private void RollDmgActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RollDmgActionPerformed
      {//GEN-HEADEREND:event_RollDmgActionPerformed
          rollDices(
                  mainTextArea,
                  diceCollection.getDice(MainDice.getSelectedItem().toString()),
                  Integer.parseInt(NrOfDices.getValue().toString()),
                  DiceModifiers.getSelectedItem().toString(),
                  AbiCal(StringToInt(DiceModifiers.getSelectedItem().toString())),
                  diceCollection.getDice(extraDices1.getSelectedItem().toString()),
                  Integer.parseInt(NrOfExtraDices.getValue().toString()),
                  secondaryDiceModifier.getSelectedItem().toString(),
                  AbiCal(StringToInt(secondaryDiceModifier.getSelectedItem().toString())),
                  Integer.parseInt(rollBonuses.getValue().toString()),
                  Integer.parseInt(rollPenalties.getValue().toString()));
      }//GEN-LAST:event_RollDmgActionPerformed

    private void RecalculateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RecalculateActionPerformed
      {//GEN-HEADEREND:event_RecalculateActionPerformed
          playerTitle.setText(player.getCharacterName() + " the level " + player.getLevel() + " " + player.getRace().getRaceName() + " " + player.getCharacterClass().getName());
          StrValue.setText("" + player.getStrength());
          ConValue.setText("" + player.getConstitution());
          WisValue.setText("" + player.getWisdom());
          ChaValue.setText("" + player.getCharisma());
          DexValue.setText("" + player.getDexterity());
          IntValue.setText("" + player.getIntelligence());
          defenseCalculation(player);
          ACValue.setText("" + player.getAC());
          ForValue.setText("" + player.getFortitude());
          RefValue.setText("" + player.getReflex());
          WillValue.setText("" + player.getWill());

          StrModifier.setText("(+" + AbiCal(player.getStrength()) + ")");
          ConModifier.setText("(+" + AbiCal(player.getConstitution()) + ")");
          WisModifier.setText("(+" + AbiCal(player.getWisdom()) + ")");
          ChaModifier.setText("(+" + AbiCal(player.getCharisma()) + ")");
          DexModifier.setText("(+" + AbiCal(player.getDexterity()) + ")");
          IntModifier.setText("(+" + AbiCal(player.getIntelligence()) + ")");

          player.setMaxHP(player.getCharacterClass().getStartHP() + player.getCharacterClass().getLevelHP() + player.getConstitution());
          player.setCurrentHP(player.getMaxHP());
          Healthbar.setMaximum(player.getMaxHP());
          healthbarButton.setText(player.getCurrentHP() + " / " + player.getMaxHP());

          Image MainHandWeapon = imageHandler.getScaledImage(new javax.swing.ImageIcon(getClass().getResource(imagePath + player.getMainHand() + ".png")).getImage(), 190, 330);
          weaponImage.setIcon((new javax.swing.ImageIcon(MainHandWeapon)));

          MainHandName.setText(storage.getWeapons().get(player.getMainHand()).getItemName());
          MainHandDmg.setText(storage.getWeapons().get(player.getMainHand()).getNrOfDice() + "D" + storage.getWeapons().get(player.getMainHand()).getDmgPerDice());
          MainhandHands.setText(storage.getWeapons().get(player.getMainHand()).getHands() + "-Handed");
          MainHandType.setText(storage.getWeapons().get(player.getMainHand()).getGroup());
          MainHandProps.setText(storage.getWeapons().get(player.getMainHand()).getProperties());

          Image Armor = imageHandler.getScaledImage(new javax.swing.ImageIcon(getClass().getResource(imagePath + player.getArmor() + ".png")).getImage(), 190, 330);
          ArmorImage.setIcon((new javax.swing.ImageIcon(Armor)));

          bodyName.setText(storage.getArmors().get(player.getArmor()).getItemName());
          bodyAC.setText("Armor: " + storage.getArmors().get(player.getArmor()).getArmorBonus());
          BodySpeed.setText("Speed: " + storage.getArmors().get(player.getArmor()).getSpeed());
          BodyChecks.setText("Checks: " + storage.getArmors().get(player.getArmor()).getCheck());
          BodyWeight.setText("Weight: " + storage.getArmors().get(player.getArmor()).getWeight());


      }//GEN-LAST:event_RecalculateActionPerformed

    private void healthbarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_healthbarButtonActionPerformed
      {//GEN-HEADEREND:event_healthbarButtonActionPerformed
          try {
              player.setCurrentHP(Integer.parseInt(JOptionPane.showInputDialog("input your new Current HP")));
              Healthbar.setValue(player.getCurrentHP());
              healthbarButton.setText(player.getCurrentHP() + " / " + player.getMaxHP());
          } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(null, "Invalid Input");
          }
      }//GEN-LAST:event_healthbarButtonActionPerformed

    public static void main(String args[]) {


        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;




                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                    new MainScreen().setVisible(true);
                } catch (ManagerException ex) {
                    System.out.println("Error");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACBonus;
    private javax.swing.JLabel ACValue;
    private javax.swing.JLabel AbilityBonusLabel;
    private javax.swing.JLabel ArmorImage;
    private javax.swing.JLabel BodyChecks;
    private javax.swing.JLabel BodySpeed;
    private javax.swing.JLabel BodyWeight;
    private javax.swing.JLabel ChaModifier;
    private javax.swing.JLabel ChaValue;
    private javax.swing.JButton CharacternameButton;
    private javax.swing.JLabel ConModifier;
    private javax.swing.JLabel ConValue;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JLabel DexModifier;
    private javax.swing.JLabel DexValue;
    private javax.swing.JComboBox DiceModifiers;
    private javax.swing.JLabel ForBonus;
    private javax.swing.JLabel ForValue;
    private javax.swing.JProgressBar Healthbar;
    private javax.swing.JLabel IPLabel;
    private javax.swing.JTextField IPinput;
    private javax.swing.JLabel IniValue;
    private javax.swing.JLabel IntModifier;
    private javax.swing.JLabel IntValue;
    private javax.swing.JComboBox MainDice;
    private javax.swing.JLabel MainHandDmg;
    private javax.swing.JLabel MainHandName;
    private javax.swing.JLabel MainHandProps;
    private javax.swing.JLabel MainHandType;
    private javax.swing.JTabbedPane MainWeaponTab;
    private javax.swing.JLabel MainhandHands;
    private javax.swing.JSpinner NrOfDices;
    private javax.swing.JSpinner NrOfExtraDices;
    private javax.swing.JButton PlayernameButton;
    private javax.swing.JLabel PlayernameLabel;
    private javax.swing.JButton Recalculate;
    private javax.swing.JLabel RefBonus;
    private javax.swing.JLabel RefValue;
    private javax.swing.JButton RollDmg;
    private javax.swing.JPanel SkillsTab;
    private javax.swing.JLabel SpdValue;
    private javax.swing.JLabel StrModifier;
    private javax.swing.JLabel StrValue;
    private javax.swing.JTabbedPane TabScreen;
    private javax.swing.JLabel WillBonus;
    private javax.swing.JLabel WillValue;
    private javax.swing.JLabel WisModifier;
    private javax.swing.JLabel WisValue;
    private javax.swing.JPanel abilities;
    private javax.swing.JTextField ability1;
    private javax.swing.JTextField ability10;
    private javax.swing.JTextField ability11;
    private javax.swing.JTextField ability12;
    private javax.swing.JTextField ability13;
    private javax.swing.JTextField ability14;
    private javax.swing.JTextField ability15;
    private javax.swing.JSpinner ability1NrOfDices;
    private javax.swing.JSpinner ability1NrOfDices1;
    private javax.swing.JSpinner ability1NrOfDices10;
    private javax.swing.JSpinner ability1NrOfDices11;
    private javax.swing.JSpinner ability1NrOfDices12;
    private javax.swing.JSpinner ability1NrOfDices13;
    private javax.swing.JSpinner ability1NrOfDices14;
    private javax.swing.JSpinner ability1NrOfDices2;
    private javax.swing.JSpinner ability1NrOfDices3;
    private javax.swing.JSpinner ability1NrOfDices4;
    private javax.swing.JSpinner ability1NrOfDices5;
    private javax.swing.JSpinner ability1NrOfDices6;
    private javax.swing.JSpinner ability1NrOfDices7;
    private javax.swing.JSpinner ability1NrOfDices8;
    private javax.swing.JSpinner ability1NrOfDices9;
    private javax.swing.JComboBox ability1Stat;
    private javax.swing.JComboBox ability1Stat1;
    private javax.swing.JComboBox ability1Stat10;
    private javax.swing.JComboBox ability1Stat11;
    private javax.swing.JComboBox ability1Stat12;
    private javax.swing.JComboBox ability1Stat13;
    private javax.swing.JComboBox ability1Stat14;
    private javax.swing.JComboBox ability1Stat2;
    private javax.swing.JComboBox ability1Stat3;
    private javax.swing.JComboBox ability1Stat4;
    private javax.swing.JComboBox ability1Stat5;
    private javax.swing.JComboBox ability1Stat6;
    private javax.swing.JComboBox ability1Stat7;
    private javax.swing.JComboBox ability1Stat8;
    private javax.swing.JComboBox ability1Stat9;
    private javax.swing.JTextField ability2;
    private javax.swing.JTextField ability3;
    private javax.swing.JTextField ability4;
    private javax.swing.JTextField ability5;
    private javax.swing.JTextField ability6;
    private javax.swing.JTextField ability7;
    private javax.swing.JTextField ability8;
    private javax.swing.JTextField ability9;
    private javax.swing.JSpinner abilityBonus;
    private javax.swing.JComboBox abilityDice;
    private javax.swing.JComboBox abilityDice1;
    private javax.swing.JComboBox abilityDice10;
    private javax.swing.JComboBox abilityDice11;
    private javax.swing.JComboBox abilityDice12;
    private javax.swing.JComboBox abilityDice13;
    private javax.swing.JComboBox abilityDice14;
    private javax.swing.JComboBox abilityDice2;
    private javax.swing.JComboBox abilityDice3;
    private javax.swing.JComboBox abilityDice4;
    private javax.swing.JComboBox abilityDice5;
    private javax.swing.JComboBox abilityDice6;
    private javax.swing.JComboBox abilityDice7;
    private javax.swing.JComboBox abilityDice8;
    private javax.swing.JComboBox abilityDice9;
    private javax.swing.JSpinner abilityPenalties;
    private javax.swing.JButton acrobaticsButton;
    private javax.swing.JLabel acrobaticsValue;
    private javax.swing.JButton amuChangeValue;
    private javax.swing.JLabel amuCharges;
    private javax.swing.JButton amuHeal;
    private javax.swing.JLabel amuLabel;
    private javax.swing.JButton amuRegen;
    private javax.swing.JButton amuShield;
    private javax.swing.JButton arcanaButton;
    private javax.swing.JLabel arcanaValue;
    private javax.swing.JComboBox armorSelecter;
    private javax.swing.JButton athleticsButton;
    private javax.swing.JLabel athleticsValue;
    private javax.swing.JLabel baseStatsImage;
    private javax.swing.JButton bluffButton;
    private javax.swing.JLabel bluffValue;
    private javax.swing.JLabel bodyAC;
    private javax.swing.JLabel bodyName;
    private javax.swing.JButton changeAC;
    private javax.swing.JButton changeArmor;
    private javax.swing.JButton changeCha;
    private javax.swing.JButton changeCon;
    private javax.swing.JButton changeDex;
    private javax.swing.JButton changeFor;
    private javax.swing.JButton changeInt;
    private javax.swing.JButton changeRef;
    private javax.swing.JButton changeStr;
    private javax.swing.JButton changeWeapon;
    private javax.swing.JButton changeWill;
    private javax.swing.JButton changeWis;
    private javax.swing.JLabel characterNameLabel;
    private javax.swing.JLabel characterTabImage;
    private javax.swing.JButton classButton;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel connectionStatusLabel;
    private javax.swing.JButton diplomacyButton;
    private javax.swing.JLabel diplomacyValue;
    private javax.swing.JButton dungeoneeringButton;
    private javax.swing.JLabel dungeoneeringValue;
    private javax.swing.JCheckBox editMode;
    private javax.swing.JButton enduranceButton;
    private javax.swing.JLabel enduranceValue;
    private javax.swing.JPanel equipmentTab;
    private javax.swing.JComboBox extraDices1;
    private javax.swing.JButton getIPButton;
    private javax.swing.JButton healButton;
    private javax.swing.JLabel healValue;
    private javax.swing.JButton healthbarButton;
    private javax.swing.JComboBox highestModifierforAmuShield;
    private javax.swing.JButton historyButton;
    private javax.swing.JLabel historyValue;
    private javax.swing.JButton insightButton;
    private javax.swing.JLabel insightValue;
    private javax.swing.JButton intimidateButton;
    private javax.swing.JLabel intimidateValue;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton levelButton;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel mainBonus;
    private javax.swing.JLabel mainPenalty;
    private javax.swing.JTextArea mainTextArea;
    private javax.swing.JButton natureButton;
    private javax.swing.JLabel natureValue;
    private javax.swing.JTextField networkChatInput;
    private javax.swing.JTextArea networkChatOutput;
    private javax.swing.JButton networkSendData;
    private javax.swing.JButton perceptionButton;
    private javax.swing.JLabel perceptionValue;
    private javax.swing.JPanel playerTab;
    private javax.swing.JLabel playerTitle;
    private javax.swing.JButton raceButton;
    private javax.swing.JLabel raceLabel;
    private javax.swing.JButton religionButton;
    private javax.swing.JLabel religionValue;
    private javax.swing.JButton rollAbility1;
    private javax.swing.JButton rollAbility10;
    private javax.swing.JButton rollAbility11;
    private javax.swing.JButton rollAbility12;
    private javax.swing.JButton rollAbility13;
    private javax.swing.JButton rollAbility14;
    private javax.swing.JButton rollAbility15;
    private javax.swing.JButton rollAbility2;
    private javax.swing.JButton rollAbility3;
    private javax.swing.JButton rollAbility4;
    private javax.swing.JButton rollAbility5;
    private javax.swing.JButton rollAbility6;
    private javax.swing.JButton rollAbility7;
    private javax.swing.JButton rollAbility8;
    private javax.swing.JButton rollAbility9;
    private javax.swing.JSpinner rollBonuses;
    private javax.swing.JSpinner rollPenalties;
    private javax.swing.JComboBox secondaryDiceModifier;
    private javax.swing.JLabel skillsimage;
    private javax.swing.JButton stealthButton;
    private javax.swing.JLabel stealthValue;
    private javax.swing.JButton streetwiseButton;
    private javax.swing.JLabel streetwiseValue;
    private javax.swing.JScrollPane textpane;
    private javax.swing.JButton thieveryButton;
    private javax.swing.JLabel thieveryValue;
    private javax.swing.JLabel weaponImage;
    private javax.swing.JComboBox weaponSelecter;
    // End of variables declaration//GEN-END:variables
}
