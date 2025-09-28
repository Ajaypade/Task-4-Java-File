import java.io.*;
import java.util.*;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    // Add a note 
    public void addNote(Note note) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(note.getContent());
            System.out.println("Note added successfully.....!");
        } catch (IOException e) {
            System.out.println("Error while writing note: " + e.getMessage());
        }
    }

    // Read all notes
    public List<Note> readNotes() {
        List<Note> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(new Note(line));
            }
        } catch (IOException e) {
            System.out.println("Error while reading notes: " + e.getMessage());
        }
        return notes;
    }

    // Clear all notes
    public void clearNotes() {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            fw.write(""); // empty the file
            System.out.println("All notes cleared.....!");
        } catch (IOException e) {
            System.out.println("Error while clearing notes: " + e.getMessage());
        }
    }
}
