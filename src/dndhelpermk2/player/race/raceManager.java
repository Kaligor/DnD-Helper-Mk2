package dndhelpermk2.player.race;

import dndhelpermk2.storage.CRUD;

public class raceManager 
{
    private CRUD<String, Race> raceCRUD;

    public raceManager(CRUD<String, Race> raceCRUD)
      {
        this.raceCRUD = raceCRUD;
      }
    
    
}
