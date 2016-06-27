package controller;

import model.Card;
import model.CheckListEntry;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by chinta on 6/25/2016.
 */
public class ItemGenerator {

    private static String getUUID(){
        return new BigInteger(60, new SecureRandom()).toString(32);
    }

    public static CheckListEntry getNewEntry()
    {
        CheckListEntry entry = new CheckListEntry();
        String id = "item"+"_"+getUUID();
        entry.setId(id);
        return entry;
    }

    public static Card getNewCard(){
        Card card = new Card();
        String id = "card"+"_"+getUUID();
        card.setId(id);
        card.getChecklist().add(getNewEntry());
        return card;
    }
}
