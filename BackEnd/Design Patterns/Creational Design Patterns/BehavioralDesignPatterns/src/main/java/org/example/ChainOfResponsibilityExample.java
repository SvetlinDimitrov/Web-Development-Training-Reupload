package org.example;

public class ChainOfResponsibilityExample {

    static abstract class Security {
        protected final Security security;

        Security(Security security) {
            this.security = security;
        }

        abstract void checkAttack(String attack);
    }

    static class SecurityImp extends Security {


        SecurityImp(Security security) {
            super(security);
        }

        @Override
        public void checkAttack(String attack) {
            if (attack.equals("cyber")) {
                System.out.println("SecurityImp caches the attack");
                return;
            }
            System.out.println("SecurityImp passes the attack");
            if (security != null) {
                security.checkAttack(attack);
            }
        }
    }

    static class SecurityImp2 extends Security {

        SecurityImp2(Security security) {
            super(security);
        }

        @Override
        void checkAttack(String attack) {
            if (attack.equals("trans")) {
                System.out.println("SecurityImp2 caches the attack");
                return;
            }
            System.out.println("SecurityImp2 passes the attack");
            if (security != null) {
                security.checkAttack(attack);
            }
        }
    }

    public static void main(String[] args) {
        SecurityImp2 securityImp2 = new SecurityImp2(new SecurityImp(null));
        securityImp2.checkAttack("cyber");
    }
}