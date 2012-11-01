package dndhelpermk2.misc;

public class skill  
  {
    private String name;
    private String text;
    private String type;
    private String effect;
    private String rolls;
    private String targets;

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getEffect()
      {
        return effect;
      }
    
    public void setEffect(String effect)
      {
        this.effect = effect;
      }
    
    public String getType()
      {
        return type;
      }
    
    public void setType(String type)
      {
        this.type = type;
      }
    
    public String getName()
      {
        return name;
      }
    
    public void setName(String name)
      {
        this.name = name;
      }
    
    public String getText()
      {
        return text;
      }
    
    public void setText(String text)
      {
        this.text = text;
      }
    //</editor-fold>

    public skill(String name, String text)
      {
        this.name = name;
        this.text = text;
      }

    public skill(String name, String text, String type, String effect)
      {
        this.name = name;
        this.text = text;
        this.type = type;
        this.effect = effect;
      }
    
    
    
    
  }
