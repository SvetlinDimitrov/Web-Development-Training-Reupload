public class ClientCertificateAuthenticationHandler extends AuthenticationHandler {

  public ClientCertificateAuthenticationHandler(AuthenticationHandler next) {
    super(next);
  }

  public void handleRequest(String requestType) {
    if(requestType.equals("certificate auth")){
      System.out.println("Certificate authentication handler has been made.");
      return;
    }
    setNext(requestType);
  }

}
