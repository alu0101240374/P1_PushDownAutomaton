package source.main;

import java.util.Scanner;

public class AutomatonProject {
  public static void main(String args[]) {
    try {
      if (args.length == 0) {
        System.out.println("No ha especificado un fichero de entrada");
      }
      PdaReader reader = new PdaReader(args[0]);
      Scanner userInput = new Scanner(System.in);
      System.out.println("¿Le gustaría ejecutar en modo traza [s/n]?");
      Boolean traceMode;
      String input = userInput.nextLine();
      if (input.equals("s")) traceMode = true;
      else traceMode = false;
      Automaton automaton = new Automaton(reader.getStates(), reader.getAlphabet(), 
                                          reader.getStackAlphabet(), reader.getinitialState(),
                                          reader.getStartingStackSymbol(), reader.getTransitions(), traceMode);
      System.out.println("Introduzca una cadena a comprobar (para terminar escriba \"salir\"): ");                                
      while (true) {
        input = userInput.nextLine();
        if (input.equals("salir")) break;
        automaton.checkString(input);
      }
      userInput.close();
    } catch (Exception error) {
      System.out.println(error);
    }

  }
}
