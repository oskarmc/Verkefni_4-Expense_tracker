package is.verkefni4expensetracker.vidmot.Switcher;

public enum View {
    // Aðal FXML skrá sem sýnir öll gögn (ferðin) í listanum
    ADAL("adal-view.fxml"),

    // FXML skrá sem sýnir upplýsinga um valin ferð
    FLOKKUR("flokkur-view.fxml");

    private final String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}

