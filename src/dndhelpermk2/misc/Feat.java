package dndhelpermk2.misc;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;

public class Feat 
{
    private static final String NEWLINE = "\n";
    private String featName;
    private ArrayList<String> Prerequisite = new ArrayList<String>();
    private String Benefit;

    public Feat(String featName, String Benefit, String... Prerequisite)
      {
        this.featName = featName;
        this.Benefit = Benefit;
        for (int i = 0; i < Prerequisite.length; i++) {
            String requirement = Prerequisite[i];
            this.Prerequisite.add(requirement);
        }
      }
    
    public String PrerequisiteIterator() {
        String tempString = "";
        Iterator PreIterator = Prerequisite.iterator();
        while (PreIterator.hasNext()) {
            tempString = tempString + PreIterator.next() + " , ";
        }
        return tempString + NEWLINE;
    }
    
    public void PrintFeatInfo (JTextArea area) {
       area.setText("------" + featName + "------" + NEWLINE
                + "Prerequisite: " + PrerequisiteIterator()
                + "Benefit: " + Benefit);
    }

    @Override
    public String toString()
      {
        return featName;
      }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getBenefit()
      {
        return Benefit;
      }
    
    public void setBenefit(String Benefit)
      {
        this.Benefit = Benefit;
      }
    
    public ArrayList<String> getPrerequisite()
      {
        return Prerequisite;
      }
    
    public void setPrerequisite(ArrayList<String> Prerequisite)
      {
        this.Prerequisite = Prerequisite;
      }
    
    public String getFeatName()
      {
        return featName;
      }

    public void setFeatName(String featName)
      {
        this.featName = featName;
      }
    //</editor-fold>


    
    
}
