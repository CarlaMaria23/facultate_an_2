package Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Service {
    private String filePath = "C:\\Users\\Carla1999\\Desktop\\Rezervare de bilete\\src\\Registrii\\RaportSpectacole.csv";

    public void writeDataToReport( String name, double procent ) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.append(name);
            bufferedWriter.append(",");
            bufferedWriter.append(procent + " %");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReport_( String namePers, String nameEv, double price ) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.append(namePers);
            bufferedWriter.append(",");
            bufferedWriter.append(price + " pentru " + nameEv);
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initReportHeader() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.append("Spectacol");
            bufferedWriter.append(",");
            bufferedWriter.append("Locuri-Ocupate");
            bufferedWriter.append("\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initReportHeader_() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.append("Nume");
            bufferedWriter.append(",");
            bufferedWriter.append("Pret");
            bufferedWriter.append("\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
