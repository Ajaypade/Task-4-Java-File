import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NotesManager manager = new NotesManager();

        while (true) {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Clear All Notes");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter note: ");
                    String content = sc.nextLine();
                    manager.addNote(new Note(content));
                    break;

                case 2:
                    System.out.println("\n--- Your Notes ---");
                    List<Note> notes = manager.readNotes();
                    if (notes.isEmpty()) {
                        System.out.println("No notes found.......");
                    } else {
                        for (int i = 0; i < notes.size(); i++) {
                            System.out.println((i + 1) + ". " + notes.get(i).getContent());
                        }
                    }
                    break;

                case 3:
                    manager.clearNotes();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.......");
            }
        }
    }
}
