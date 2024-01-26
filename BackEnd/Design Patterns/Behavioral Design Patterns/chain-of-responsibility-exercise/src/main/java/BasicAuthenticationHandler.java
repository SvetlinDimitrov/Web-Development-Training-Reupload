public class BasicAuthenticationHandler extends AuthenticationHandler {

  public BasicAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equals("basic auth")){
      System.out.println("Basic auth. initiated");
      return;
    }
      setNext(requestType);
  }
}
