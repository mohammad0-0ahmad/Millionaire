package millionaire.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import millionaire.FINAL_GLOBAL_VARIABLES.*;

/**
 * @author Henrik, Mohammad, Joakim
 * A singleton class for showing the lifelife hints at the screen. The class also creates the lifeline objects.
 */
class LifeLineArea extends VBox {
    private static LifeLineArea lifeLineArea = new LifeLineArea();

    /**
     * A getter to return the object
     * @return the private object
     */
    public static LifeLineArea getInstance() {
        return lifeLineArea;
    }

    private LifeLine audience, friend, removeHalf, change;
    private Label lifeLineHint;

    /**
     * The constructor creating the lifelines, the lifelinehint label and the lifelinearea.
     */
    private LifeLineArea() {
        super();
        audience = new LifeLine(LifeLineType.ASK_AUDIENCE, SoundEffectName.AUDIENCE);
        friend = new LifeLine(LifeLineType.CALL_A_FRIEND, SoundEffectName.CALL_FRIEND);
        removeHalf = new LifeLine(LifeLineType.REMOVE_HALF, SoundEffectName.REMOVE_HALF_CHANGE_QUESTION);
        change = new LifeLine(LifeLineType.CHANGE_QUESTION, SoundEffectName.REMOVE_HALF_CHANGE_QUESTION);

        HBox lifeLines = new HBox(audience, friend, removeHalf, change);
        lifeLines.setSpacing(10);
        lifeLines.setAlignment(Pos.CENTER);

        lifeLineHint = new Label();
        lifeLineHint.setFont(Font.font("arial", 30));
        lifeLineHint.setMaxWidth(500);
        lifeLineHint.setWrapText(true);
        lifeLineHint.setTextAlignment(TextAlignment.CENTER);
        lifeLineHint.setAlignment(Pos.CENTER);

        getChildren().addAll(lifeLines, lifeLineHint);
        setSpacing(30);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(5));

    }

    /**
     * Disable the actionevents temporarily until next question.
     */
    void deactivateTemporarily() {
        audience.setOnMouseClicked(null);
        friend.setOnMouseClicked(null);
        removeHalf.setOnMouseClicked(null);
        change.setOnMouseClicked(null);
    }

    /**
     * Enable the temporarily disabled actionevents if the lifeline isn't used.
     */
    void activate() {
        if (!audience.isUsed()) {
            audience.setAction();
        }
        if (!friend.isUsed()) {
            friend.setAction();
        }
        if (!removeHalf.isUsed()) {
            removeHalf.setAction();
        }
        if (!change.isUsed()) {
            change.setAction();
        }
    }

    /**
     * Setting the lifeline hints from the audience or the friend.
     * @param lifeLineHint The hint
     */
    void setLifeLineHint(String lifeLineHint) {
        this.lifeLineHint.setText(lifeLineHint);
    }

    //Joakim
    void resetLifeLineArea() {
        audience.reset();
        removeHalf.reset();
        friend.reset();
        change.reset();
        lifeLineHint.setText("");
    }
}




