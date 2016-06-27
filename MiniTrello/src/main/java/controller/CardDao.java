package controller;

import com.google.gson.Gson;
import model.Card;
import model.CheckListEntry;
import util.FileUtils;

import java.util.LinkedHashMap;

/**
 * Created by chinta on 6/25/2016.
 */
public class CardDao {


    private static LinkedHashMap<String, Card> cardHolder = new LinkedHashMap<String, Card>();

    public static Card getEmptyCard() {
        return ItemGenerator.getNewCard();
    }

    public static CheckListEntry getEmptyItem() {
        return ItemGenerator.getNewEntry();
    }

    public static void saveCard(Card card) {
        cardHolder.put(card.getId(), card);
        FileUtils.saveData(cardHolder);
        return;
    }

    public static void removeCard(String cardId) {
        cardHolder.remove(cardId);
        FileUtils.saveData(cardHolder);
        return;
    }

    public static LinkedHashMap<String, Card> getAllCards() {

        cardHolder = FileUtils.getData();
        return cardHolder;
    }

}
