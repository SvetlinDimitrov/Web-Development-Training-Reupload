package org.example;

public class FacadeExample {

    static class UltraComplexService {
        public void showInfo(String type) {
            if (type.equals("short")) {
                showInfo2();
            } else if (type.equals("long")) {
                showInfo3();
            } else {
                showInfo5();
            }
        }

        public void showInfo2() {
            System.out.println("Short Info here");
        }

        public void showInfo3() {
            showInfo4();
        }

        public void showInfo4() {
            System.out.println("Long info");
        }

        public void showInfo5() {
            System.out.println("nothing was found");
        }

    }

    interface Facade {
        void showLongInfo();

        void showShortInfo();
    }

    static class FacadeImp implements Facade {
        private final UltraComplexService service = new UltraComplexService();

        public void showLongInfo() {
            service.showInfo4();
        }

        public void showShortInfo() {
            service.showInfo2();
        }
    }

    public static void main(String[] args) {
        FacadeImp facadeImp = new FacadeImp();
        facadeImp.showLongInfo();
        facadeImp.showShortInfo();
    }
}
