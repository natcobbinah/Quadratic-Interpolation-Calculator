public class QuadraticInterpolation {
  private double lnot;
  
  private double lxone;
  
  private double lxtwo;
  
  private double xnot;
  
  private double xone;
  
  private double xtwo;
  
  private double ptwo;
  
  private double pevaluated;
  
  public double getLnot() {
    return this.lnot;
  }
  
  public String setLnot(double xnot, double xone, double xtwo) {
    String lnotvalue = "(" + "(x" + -xone + ")*(" + "x" + -xtwo + 
      ")/" + 
      "(" + ((xnot - xone) * (xnot - xtwo)) + ")" + ")";
    return lnotvalue;
  }
  
  public double getLxone() {
    return this.lxone;
  }
  
  public String setLxone(double xnot, double xone, double xtwo) {
    String lonevalue = "(" + "(x" + -xnot + ")*(" + "x" + -xtwo + 
      ")/" + 
      "(" + ((xone - xnot) * (xone - xtwo)) + ")" + ")";
    return lonevalue;
  }
  
  public double getLxtwo() {
    return this.lxtwo;
  }
  
  public String setLxtwo(double xnot, double xone, double xtwo) {
    String ltwovalue = "(" + "(x" + -xnot + ")*(" + "x" + -xone + 
      ")/" + 
      "(" + ((xtwo - xnot) * (xtwo - xone)) + ")" + ")";
    return ltwovalue;
  }
  
  public double getPtwo() {
    return this.ptwo;
	}

  public String setPtwo(double ynot, double yone, double ytwo, double xnot, double xone, double xtwo) {
    this.xnot = xnot;
    this.xone = xone;
    this.xtwo = xtwo;
    String setpanswer = String.valueOf(ynot) + "*" + setLnot(xnot, xone, xtwo) + " +" + 
      yone + "*" + setLxone(xnot, xone, xtwo) + " +" + 
      ytwo + "*" + setLxtwo(xnot, xone, xtwo);
    return setpanswer;
  }
  
  public double getPevaluated() {
    return this.pevaluated;
  }
  
  public double setPevaluated(double pvalue, double ynot, double yone, double ytwo, double xnot, double xone, double xtwo) {
    this.pevaluated = pvalue;
    double setpevaluated = ynot * (pvalue - xone) * (pvalue - xtwo) / (xnot - xone) * (xnot - xtwo) + 
      
      yone * (pvalue - xnot) * (pvalue - xtwo) / (xone - xnot) * (xone - xtwo) + 
      
      ytwo * (pvalue - xnot) * (pvalue - xone) / (xtwo - xnot) * (xtwo - xone);
    return setpevaluated;
  }
}
