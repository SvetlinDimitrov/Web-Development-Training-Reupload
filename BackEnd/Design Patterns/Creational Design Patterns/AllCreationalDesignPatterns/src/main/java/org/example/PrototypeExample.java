package org.example;

public class PrototypeExample {

    interface Cloneable {
        Cloneable clone();
    }

    static class ClassToBeCloned implements Cloneable {
        private String filed1;
        private String filed2;

        public String getFiled1() {
            return filed1;
        }

        public void setFiled1(String filed1) {
            this.filed1 = filed1;
        }

        public String getFiled2() {
            return filed2;
        }

        public void setFiled2(String filed2) {
            this.filed2 = filed2;
        }

        @Override
        public ClassToBeCloned clone() {
            ClassToBeCloned classToBeCloned = new ClassToBeCloned();
            classToBeCloned.setFiled1(filed1);
            classToBeCloned.setFiled2(filed2);
            return classToBeCloned;
        }
    }

    public static void main(String[] args) {
        ClassToBeCloned classToBeCloned = new ClassToBeCloned();
        classToBeCloned.setFiled1("Yes");
        classToBeCloned.setFiled2("Sir");
        ClassToBeCloned clone = classToBeCloned.clone();
        System.out.println(clone.getFiled1().equals(classToBeCloned.getFiled1()));
        System.out.println(clone.getFiled2().equals(classToBeCloned.getFiled2()));

    }
}
