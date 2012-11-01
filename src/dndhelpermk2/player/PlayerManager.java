package dndhelpermk2.player;

import dndhelpermk2.exception.CRUDException;
import dndhelpermk2.exception.ManagerException;
import dndhelpermk2.misc.WriteFile;
import dndhelpermk2.player.classes.charClass;
import dndhelpermk2.player.classes.charClassManager;
import dndhelpermk2.player.race.Race;
import dndhelpermk2.player.race.raceManager;
//import static dndhelpermk2.staticMethods.JSONizer.StringifyPlayer;
import dndhelpermk2.storage.CRUD;
import java.util.Scanner;

public final class PlayerManager
  {

    private CRUD<String, Player> playerCRUD;
    private CRUD<String, Race> raceCRUD;
    private CRUD<String, charClass> classCRUD;
    charClassManager classManager;
    raceManager raceManager;
    WriteFile Writer;
    Scanner Scanner;

    public PlayerManager(CRUD<String, Player> PlayerCRUD, CRUD<String, Race> raceCRUD, CRUD<String, charClass> classCRUD) throws ManagerException
      {
        this.playerCRUD = PlayerCRUD;
        this.raceCRUD = raceCRUD;
        this.classCRUD = classCRUD;
        
        this.raceManager = new raceManager(raceCRUD);
        this.classManager = new charClassManager(classCRUD);
      }

    public Player createPlayer(
            String playerName, String CharacterName, int Level, String characterClass, String Race, String Age, String Gender, String Alignment, int Strength, int Constitution, int Dexterity, int Intelligence, int Wisdom, int Charisma) throws ManagerException
      {
        try {
            if (playerCRUD.containsKey(CharacterName)) {
                throw new ManagerException("a Player with that name already exists");
            } else {
                Player player = new Player(playerName, CharacterName, Level, null, null, Age, Gender, Alignment, Strength, Constitution, Dexterity, Intelligence, Wisdom, Charisma);
                playerCRUD.create(player);
             //   System.out.println(StringifyPlayer(player));
                
                return player;
            }
        } catch (CRUDException e) {
            throw new ManagerException("Unable to create Player", e);
        }
      }
  }
