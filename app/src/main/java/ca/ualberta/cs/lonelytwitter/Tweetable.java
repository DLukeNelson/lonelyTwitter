package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

public interface Tweetable {
    //REFACTORING LAB: "public" access modifier is unneeded. Remove it.
    String getMessage();

    Date getDate();

}
