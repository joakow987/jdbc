package Bowl;

import java.time.Instant;
import java.time.LocalDateTime;

public class SearchLog {
    private long id;
    private String searchPhrase;
    private boolean isClicked;
    private int selectedOption;
    private LocalDateTime time;

    public long getId() {
        return id;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
