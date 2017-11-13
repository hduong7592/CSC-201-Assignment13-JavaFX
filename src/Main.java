import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Create by hieuduong on 11/12/17
 *
 * CSC 201 - Assignment 13
 * Problem 13.3:
 *
 * (Sort ArrayList) Write the following method that sorts an ArrayList of numbers.
 *  public static void sort(ArrayList<Number> list)
 */

public class Main extends Application {

    private TextField val1Txt = new TextField();
    private TextField val2Txt = new TextField();
    private TextField val3Txt = new TextField();
    private TextField val4Txt = new TextField();
    private TextField val5Txt = new TextField();
    private Label status = new Label();
    private Button sortBtn = new Button("Sort");
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private String result;
    private boolean isSorted = false;

    @Override
    public void start(Stage primaryStage) {

        //Create a new gridPane to hold the textfields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("Value 1:"), 0, 0);
        gridPane.add(val1Txt, 1, 0);
        gridPane.add(new Label("Value 2:"), 0, 1);
        gridPane.add(val2Txt, 1, 1);
        gridPane.add(new Label("Value 1:"), 0, 2);
        gridPane.add(val3Txt, 1, 2);
        gridPane.add(new Label("Value 1:"), 0, 3);
        gridPane.add(val4Txt, 1, 3);
        gridPane.add(new Label("Value 1:"), 0, 4);
        gridPane.add(val5Txt, 1, 4);
        gridPane.add(sortBtn, 0, 5);
        gridPane.add(new Label("Result:"), 0, 6);
        gridPane.add(status, 1, 6);

        //Set alignments
        gridPane.setAlignment(Pos.CENTER);
        status.setAlignment(Pos.BOTTOM_LEFT);

        //add handler event to textfields
        //the event will trigger when user click the ENTER key

        sortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!isSorted) {
                    int val1 = Integer.parseInt(val1Txt.getText());
                    int val2 = Integer.parseInt(val2Txt.getText());
                    int val3 = Integer.parseInt(val3Txt.getText());
                    int val4 = Integer.parseInt(val4Txt.getText());
                    int val5 = Integer.parseInt(val5Txt.getText());

                    list.add(val1);
                    list.add(val2);
                    list.add(val3);
                    list.add(val4);
                    list.add(val5);

                    result = displayList(sortArray(list));
                    status.setText(result);
                }
                else{
                    status.setText("Array list already sorted.\nResult: "+result);
                }
            }
        });


        //Create scene
        Scene scene = new Scene(gridPane, 350, 400);
        primaryStage.setTitle("Sort Array"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Display array list
     * @param list
     * @return
     */
    private String displayList(ArrayList<Integer> list) {
        String arrayList = "";
        for(int i=0; i < list.size(); i++){
            if(i==list.size()-1){
                arrayList+=list.get(i);
            }
            else{
                arrayList+=list.get(i)+",";
            }
        }
        return arrayList;
    }

    /**
     * Sort array list
     * @param list
     * @return
     */
    private ArrayList sortArray(ArrayList<Integer> list) {

        for(int index =0; index < list.size(); index++){
            int currentMinVal = list.get(index);
            int currentIndex = index;

            for(int nextIndex = index+1; nextIndex<list.size(); nextIndex ++){
                if(currentMinVal > list.get(nextIndex)){
                    currentMinVal = list.get(nextIndex);
                    currentIndex = nextIndex;
                }
            }

            if(currentIndex != index){
                list.set(currentIndex, list.get(index));
                list.set(index, currentMinVal);
            }
        }
        isSorted = true;
        return list;
    }
}
