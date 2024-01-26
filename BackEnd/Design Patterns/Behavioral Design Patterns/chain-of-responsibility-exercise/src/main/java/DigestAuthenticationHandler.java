public class DigestAuthenticationHandler extends AuthenticationHandler {

  public DigestAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equals("digest auth")){
      System.out.println("Digest auth ahs been initiated.");
      return;
    }
    setNext(requestType);
  }

}
