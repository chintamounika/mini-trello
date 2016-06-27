package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chinta on 6/25/2016.
 */

@XmlRootElement
public class Card {
     String id;
     String title;
     String description;
     List<CheckListEntry> checklist;

    public Card(){
        checklist = new ArrayList<CheckListEntry>();
    }

    public Card(String id) {
        this.id = id;
        checklist = new ArrayList<CheckListEntry>();
    }

    public Card(String id, String title){
        this.id = id;
        this.title = title;
        checklist = new ArrayList<CheckListEntry>();
    }

    public Card(String id, String title, String description, List<CheckListEntry> checklist ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.checklist = checklist;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setChecklist(List<CheckListEntry> checklist) {
        this.checklist = checklist;
    }

    public List<CheckListEntry> getChecklist() {
        return checklist;
    }
}
