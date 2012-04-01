package segment; 

public class Segment {
  //attributs
  private int extr1, extr2;
  
  // Constructeur
  Segment( int extr1, int extr2) {
    this.extr1 = extr1;
    this.extr2 = extr2;
    this.ordonne();
  }
    
  private void ordonne() {
    if( this.extr1 > this.extr2) {
      int k;
      k = this.extr2;  
      this.extr2 = this.extr1; 
      this.extr1 = k;  
    }   
  }

  public int getLongueur() {
    return (this.extr2 - this.extr1);
  }

  public boolean appartient(int x) {
	    if( x > this.extr2 || x < this.extr1) {
	      return false;
	    }
	    return true;
  }

  public int getExtr1() {
    return this.extr1;
  }

  public void setExtr1(int extr1) {
    this.extr1 = extr1;
    this.ordonne(); //tres important de ne pas oublier d'ordonner sinon bug
  }

  public int getExtr2() {
    return this.extr2;
  }

  public void setExtr2(int extr2) {
    this.extr2 = extr2;
    this.ordonne();
  }

  public String toString() {
    return "segment [" + this.extr1 + ", " + this.extr2 + "]";
  }
}
