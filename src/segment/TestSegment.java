package segment;
import segment.Segment;

class TestSegment{ 
  public static void main(String arg[]) {
    int extr1, extr2, x;
    extr1 = Integer.parseInt(arg[0]);
    extr2 = Integer.parseInt(arg[1]);
    x = Integer.parseInt(arg[2]);
    Segment monSegment = new Segment (extr1, extr2);
    int longueur = monSegment.getLongueur();
    System.out.println("Longueur du " + monSegment.toString() + ": " + longueur);
    if(monSegment.appartient(x)) { // == true is implicit 
      System.out.println(x + " appartient au " + monSegment.toString());
    } 
    else {
      System.out.println(x + " n'appartient pas au " + monSegment.toString());
    }
  }
}
