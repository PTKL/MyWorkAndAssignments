class Comparison
{
  public static void main(String[] args)
  {
   String txt = "Fantatsic " ;
   String lang = "Java" ;
   boolean state = (txt == lang);
   System.out.println("String Equality Test" + state);


   state = (txt != lang);
   System.out.println("String Inequality test; " + state);

   int dozen = 12;
   int score = 20;
   state = (dozen > score);
   System.out.println("Greater than test: " + state);

   state = (dozen < score) ; 
   System.out.println("Less than Test:" + state);

  }

}