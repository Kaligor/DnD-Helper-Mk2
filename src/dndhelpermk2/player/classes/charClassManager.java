package dndhelpermk2.player.classes;

import dndhelpermk2.storage.CRUD;

public class charClassManager 
{
    private CRUD<String, charClass> classCRUD;

    public charClassManager(CRUD<String, charClass> classCRUD)
      {
        this.classCRUD = classCRUD;
      }

}
