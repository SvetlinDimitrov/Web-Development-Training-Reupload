package org.example;

public class BuilderExample {
    static class BuilderClass {
        private String filed1;
        private String filed2;
        private String filed3;
        private String filed4;
        private String filed5;

        public BuilderClass() {
        }

        public BuilderClass(String filed1, String filed2, String filed3, String filed4, String filed5) {
            this.filed1 = filed1;
            this.filed2 = filed2;
            this.filed3 = filed3;
            this.filed4 = filed4;
            this.filed5 = filed5;
        }

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

        public String getFiled3() {
            return filed3;
        }

        public void setFiled3(String filed3) {
            this.filed3 = filed3;
        }

        public String getFiled4() {
            return filed4;
        }

        public void setFiled4(String filed4) {
            this.filed4 = filed4;
        }

        public String getFiled5() {
            return filed5;
        }

        public void setFiled5(String filed5) {
            this.filed5 = filed5;
        }
    }

    interface BuilderInterface {
        BuilderBuilderPattern setFiled1(String value);

        BuilderBuilderPattern setFiled2(String value);

        BuilderBuilderPattern setFiled3(String value);

        BuilderBuilderPattern setFiled4(String value);

        BuilderBuilderPattern setFiled5(String value);

        BuilderClass build();
    }

    static class BuilderBuilderPattern implements BuilderInterface {
        private final BuilderClass builderClass = new BuilderClass();

        public BuilderBuilderPattern setFiled1(String value) {
            this.builderClass.setFiled1(value);
            return this;
        }

        public BuilderBuilderPattern setFiled2(String value) {
            this.builderClass.setFiled2(value);
            return this;
        }

        public BuilderBuilderPattern setFiled3(String value) {
            this.builderClass.setFiled3(value);
            return this;
        }

        public BuilderBuilderPattern setFiled4(String value) {
            this.builderClass.setFiled4(value);
            return this;
        }

        public BuilderBuilderPattern setFiled5(String value) {
            this.builderClass.setFiled5(value);
            return this;
        }

        public BuilderClass build() {
            return builderClass;
        }

    }

    public static void main(String[] args) {
        BuilderClass builderClass = new BuilderBuilderPattern()
                .setFiled1("Something here")
                .setFiled2("Something else")
                .setFiled3("And another one")
                .build();
    }
}
