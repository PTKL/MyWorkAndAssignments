public enum Rank
{
    ACE(20, "ace"), KING(15, "face"), QUEEN(15, "face"), JACK(15, "face"),
    TEN(10, "numeric"), NINE(9, "numeric"), EIGHT(8, "numeric"), SEVEN(7, "numeric"), SIX(6, "numeric"),
    FIVE(5, "numeric"), FOUR(4, "numeric"), THREE(3, "numeric"), TWO(2, "numeric"); 
    
    private int points;
    
    private String kind;
    
    private Rank(int points, String kind)
    {
        this.points =  points;
        
        this.kind = kind;
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public String getKind()
    {
    
      return this.kind;
    
    }

    public String toString()
    {
        return this.name() + " - " + this.points + " - " + this.kind;
    }
}
