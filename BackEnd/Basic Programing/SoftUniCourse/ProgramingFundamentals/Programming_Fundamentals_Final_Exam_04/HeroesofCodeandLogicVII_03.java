package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesofCodeandLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroHitPoint = new LinkedHashMap<>();
        Map<String, Integer> heroManaPoint = new LinkedHashMap<>();

        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String hero = input.split(" ")[0];
            int hp = Integer.parseInt(input.split(" ")[1]);
            int mp = Integer.parseInt(input.split(" ")[2]);
            heroHitPoint.put(hero, hp);
            heroManaPoint.put(hero, mp);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" - ")[0];
            switch (command) {
                case "CastSpell":
                    String nameCast = input.split(" - ")[1];
                    int mpCast = Integer.parseInt(input.split(" - ")[2]);
                    String spellName = input.split(" - ")[3];
                    if (heroManaPoint.containsKey(nameCast)) {
                        if (heroManaPoint.get(nameCast) >= mpCast) {
                            int currentMp = heroManaPoint.get(nameCast);
                            heroManaPoint.put(nameCast, currentMp - mpCast);
                            System.out.printf("%s has successfully cast %s and now has %d MP!%n", nameCast, spellName,heroManaPoint.get(nameCast));
                        } else {
                            System.out.printf("%s does not have enough MP to cast %s!%n", nameCast, spellName);
                        }
                    }
                    break;
                case "TakeDamage":
                    String nameDamage = input.split(" - ")[1];
                    int damage = Integer.parseInt(input.split(" - ")[2]);
                    String attacker = input.split(" - ")[3];
                    if(heroHitPoint.containsKey(nameDamage)){
                        int currentHp = heroHitPoint.get(nameDamage);
                        heroHitPoint.put(nameDamage , currentHp - damage);
                        if(heroHitPoint.get(nameDamage) <= 0){
                            System.out.printf("%s has been killed by %s!%n",nameDamage,attacker);
                            heroHitPoint.remove(nameDamage);
                            heroManaPoint.remove(nameDamage);
                        }else{
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",nameDamage,damage,attacker,heroHitPoint.get(nameDamage));
                        }
                    }
                    break;
                case "Recharge":
                    String nameRecharge = input.split(" - ")[1];
                    int mpRegen = Integer.parseInt(input.split(" - ")[2]);
                    int currentMp = heroManaPoint.get(nameRecharge);
                    if(currentMp+mpRegen > 200){
                        int leftMp = mpRegen -((currentMp+mpRegen) -200);
                        heroManaPoint.put(nameRecharge , 200);
                        System.out.printf("%s recharged for %d MP!%n",nameRecharge , leftMp);
                    }else{
                        heroManaPoint.put(nameRecharge , currentMp + mpRegen);
                        System.out.printf("%s recharged for %d MP!%n",nameRecharge , mpRegen);
                    }
                    break;
                case "Heal":
                    String nameHeal = input.split(" - ")[1];
                    int hpRegen = Integer.parseInt(input.split(" - ")[2]);
                    int currentHP = heroHitPoint.get(nameHeal);
                    if(currentHP+hpRegen > 100){
                        int leftHp = hpRegen -((currentHP+hpRegen) -100);
                        heroHitPoint.put(nameHeal , 100);
                        System.out.printf("%s healed for %d HP!%n",nameHeal , leftHp);
                    }else{
                        heroHitPoint.put(nameHeal , currentHP + hpRegen);
                        System.out.printf("%s healed for %d HP!%n",nameHeal , hpRegen);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String , Integer> entryHp :heroHitPoint.entrySet()){
            for (Map.Entry<String , Integer> entryMp : heroManaPoint.entrySet()){
                if(entryHp.getKey() .equals(entryMp.getKey())){
                    System.out.println(entryHp.getKey());
                    System.out.printf("  HP: %d%n",entryHp.getValue());
                    System.out.printf("  MP: %d%n",entryMp.getValue());
                }
            }
        }
    }
}
