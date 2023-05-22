package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Class clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		while(!input.equals("HARVEST")){
			switch (input){
				case "private":
					Arrays.stream(fields)
							.filter(e->Modifier.isPrivate(e.getModifiers()))
							.forEach(e->System.out.printf("%s %s %s%n",
									Modifier.toString(e.getModifiers()),
									e.getType().getSimpleName(),
									e.getName()));
					break;
				case "protected":
					Arrays.stream(fields)
							.filter(e->Modifier.isProtected(e.getModifiers()))
							.forEach(e->System.out.printf("%s %s %s%n",
									Modifier.toString(e.getModifiers()),
									e.getType().getSimpleName(),
									e.getName()));
					break;
				case "public":
					Arrays.stream(fields)
							.filter(e->Modifier.isPublic(e.getModifiers()))
							.forEach(e->System.out.printf("%s %s %s%n",
									Modifier.toString(e.getModifiers()),
									e.getType().getSimpleName(),
									e.getName()));
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(e->System.out.printf("%s %s %s%n",
									Modifier.toString(e.getModifiers()),
									e.getType().getSimpleName(),
									e.getName()));
					break;
			}


			input=scanner.nextLine();
		}
	}
}
//· private - print all private fields
//
//· protected - print all protected fields
//
//· public - print all public fields
//
//· all - print ALL declared fields
//
//· HARVEST - end the input