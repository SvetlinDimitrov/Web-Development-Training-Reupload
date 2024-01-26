public class Client {

  public static void main(String[] args) {
    AuthenticationHandler authenticationHandler = new BasicAuthenticationHandler(new DigestAuthenticationHandler(new ClientCertificateAuthenticationHandler(null)));
    authenticationHandler.handleRequest("something");
    authenticationHandler.handleRequest("basic auth");
  }

}
