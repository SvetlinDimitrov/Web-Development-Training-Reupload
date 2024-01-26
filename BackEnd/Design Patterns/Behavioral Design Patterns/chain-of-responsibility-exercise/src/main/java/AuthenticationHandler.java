public abstract class AuthenticationHandler {

  private AuthenticationHandler next;

  public AuthenticationHandler(AuthenticationHandler next) {
    this.next = next;
  }

  protected void setNext(String requestType){
    if(next != null) {
      System.out.println("Pass to the next");
      next.handleRequest(requestType);
    }else {
      System.out.println("There is no such an authentication");
    }
  }
  abstract void handleRequest(String requestType);
}
