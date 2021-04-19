import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class ProfessorDirectoryImpl implements ProfessorDirectory {

  Map<String,List<Integer>> directory;

  public ProfessorDirectoryImpl(){

    directory = new HashMap<>();

  }

  public void addNewProfessor(String professorName){

    directory.put(professorName,new LinkedList<>());

  }

  public void addNewProcessor(String professorName, Integer classNumber){

    addClassToProfessor(professorName,classNumber);

  }

  public void addClassToProfessor(String professorName, Integer classNumber){

    if (!containsProfessor(professorName))
      addNewProfessor(professorName);

    directory.get(professorName).add(classNumber);

  }

  public List<Integer> getClassesForProfessor(String professorName) throws IllegalArgumentException{

    if (!containsProfessor(professorName)) throw new IllegalArgumentException("Doesn't contain " + professorName);

    return directory.get(professorName);

  }

  public boolean removeProfessor(String professorName){

    if (!containsProfessor(professorName)) return false;

    directory.remove(professorName);

    return true;
  }

  public boolean containsProfessor(String professorName){

    return directory.containsKey(professorName);

  }

}
