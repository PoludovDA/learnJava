import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SetterReadOnly {
    public static void main(String[] args) {
        File dir = new File("src\\com\\company\\stringTasks");
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            System.out.println(file.setReadOnly());
        }
    }
}
