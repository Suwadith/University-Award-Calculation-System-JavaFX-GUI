package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    //Declaration of variables used in the login page
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField txtPassword;
    @FXML
    Label lblLoginError;


    //Creating an action for the login button click
    public void loginButtonClicked(ActionEvent event) throws IOException {
        //validation of the user name & the password fields
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("user")) {
            //when the scene changes hide the starting window
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //loading the next scene
            Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Award Calculation System");
            //making the scene appear on the screen
            stage.show();
        } else {
            //Error message for invalid input
            lblLoginError.setText("Invalid Username or Password");
        }
    }

    //Declaration of some more variable used in the calculation
    @FXML
    TextField iCT01 = new TextField();
    @FXML
    TextField iCT02 = new TextField();
    @FXML
    TextField courseWork = new TextField();

    @FXML
    TextField resit_ICT01 = new TextField();
    @FXML
    TextField resit_ICT02 = new TextField();
    @FXML
    TextField resit_Coursework = new TextField();

    @FXML
    Button nextModule = new Button();
    @FXML
    Button dropOut = new Button();
    @FXML
    Label retakeLimit = new Label();
    @FXML
    Label endOfTheRoad = new Label();
    @FXML
    Label finalResult = new Label();


    int x = 1, x2 = 1, x3 = 1;
    @FXML
    Label moduleName = new Label();
    @FXML
    Label levelName = new Label();
    int credit = 0;
    int iCT01Integer = 0;
    int iCT02Integer = 0;
    int courseWorkInteger = 0;
    int resitICT1 = 0;
    int resitICT2 = 0;
    int resitCourse = 0;
    int average=0;
    int retakeCount=0;
    int averagel5=0;
    int l5CreditAverage=0;
    int averagel6=0;
    int l6CreditAverage=0;


    @FXML
    //method to to move forward from 1 module to the next
    void nextModule() throws IOException {

        //setting up a counter for number of retakes so we can limit the number of retakes to not more than 3
        if(retakeCount<4) {

            //Level 4 counter
            if (x < 6) {

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT01.getText().isEmpty()) {
                    iCT01Integer = Integer.parseInt(iCT01.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT02.getText().isEmpty()) {
                    iCT02Integer = Integer.parseInt(iCT02.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!courseWork.getText().isEmpty()) {
                    courseWorkInteger = Integer.parseInt(courseWork.getText());
                }

                //Setting up a validation Range for inputs. (0-100)
                if ((iCT01Integer >= 0 && iCT01Integer <= 100) && (iCT02Integer >= 0 && iCT02Integer <= 100) && (courseWorkInteger >= 0 && courseWorkInteger <= 100)) {

                    //making the resit field visible if the initial ICT 1 mark is less than 40
                    if (iCT01Integer < 40) {
                        resit_ICT01.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT01.getText().isEmpty()) {
                            resitICT1 = Integer.parseInt(resit_ICT01.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT1 >= 0 && resitICT1 <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT1 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT01.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular ICT to 40
                                } else {
                                    iCT01Integer = 40;
                                    resit_ICT01.clear();
                                    resit_ICT01.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial ICT 2 mark is less than 40
                    if (iCT02Integer < 40) {
                        resit_ICT02.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT02.getText().isEmpty()) {
                            resitICT2 = Integer.parseInt(resit_ICT02.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT2 >= 0 && resitICT2 <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT2 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT02.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular ICT to 40
                                } else {
                                    iCT02Integer = 40;
                                    resit_ICT02.clear();
                                    resit_ICT02.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial Coursework mark is less than 40
                    if (courseWorkInteger < 40) {
                        resit_Coursework.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_Coursework.getText().isEmpty()) {
                            resitCourse = Integer.parseInt(resit_Coursework.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitCourse >= 0 && resitCourse <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitCourse < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular Coursework to 40
                                } else {
                                    courseWorkInteger = 40;
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                }
                            }
                        }
                    }

                    //Calculating the average for each module in level 4
                    average = (iCT01Integer + iCT02Integer + courseWorkInteger) / 3;

                    //adding up 20 credits for each and every successful completion of the module
                    if (iCT01Integer >= 40 && iCT02Integer >= 40 && courseWorkInteger >= 40 && average >= 40) {
                        credit += 20;
                        x++;


                    }

                    //setting up the counter value to increase module number on the successful completion of a module
                    if (x == 1) {
                        if (iCT01Integer >= 40 && iCT02Integer >= 40 && courseWorkInteger >= 40 && average >= 40) {
                            moduleName.setText("Module " + ++x);
                        }

                        //keeping the module number same as it if the module hasn't been completed successfully
                    } else moduleName.setText("Module " + x);

                }


                //Level 5 counter
            } else if (x < 12) {
                moduleName.setText("Module " + x2);
                if (x == 6) {
                    levelName.setText("Level 5");
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT01.getText().isEmpty()) {
                    iCT01Integer = Integer.parseInt(iCT01.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT02.getText().isEmpty()) {
                    iCT02Integer = Integer.parseInt(iCT02.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!courseWork.getText().isEmpty()) {
                    courseWorkInteger = Integer.parseInt(courseWork.getText());
                }

                //Setting up a validation Range for inputs. (0-100)
                if ((iCT01Integer >= 0 && iCT01Integer <= 100) && (iCT02Integer >= 0 && iCT02Integer <= 100) && (courseWorkInteger >= 0 && courseWorkInteger <= 100)) {

                    //making the resit field visible if the initial ICT 1 mark is less than 40
                    if (iCT01Integer < 40) {
                        resit_ICT01.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT01.getText().isEmpty()) {
                            resitICT1 = Integer.parseInt(resit_ICT01.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT1 >= 0 && resitICT1 <= 100)) {


                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT1 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT01.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular ICT to 40
                                } else {
                                    iCT01Integer = 40;
                                    resit_ICT01.clear();
                                    resit_ICT01.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial ICT 2 mark is less than 40
                    if (iCT02Integer < 40) {
                        resit_ICT02.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT02.getText().isEmpty()) {
                            resitICT2 = Integer.parseInt(resit_ICT02.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT2 >= 0 && resitICT2 <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT2 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT02.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular ICT to 40
                                } else {
                                    iCT02Integer = 40;
                                    resit_ICT02.clear();
                                    resit_ICT02.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial Coursework mark is less than 40
                    if (courseWorkInteger < 40) {
                        resit_Coursework.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_Coursework.getText().isEmpty()) {
                            resitCourse = Integer.parseInt(resit_Coursework.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitCourse >= 0 && resitCourse <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitCourse < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular Coursework to 40
                                } else {
                                    courseWorkInteger = 40;
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                }
                            }
                        }
                    }

                    //Calculating the average for each module in level 5
                    average = (iCT01Integer + iCT02Integer + courseWorkInteger) / 3;


                    //setting up the counter value to increase module number on the successful completion of a module
                    if (iCT01Integer >= 40 && iCT02Integer >= 40 && courseWorkInteger >= 40 && average >= 40) {
                        credit += 20;
                        x2++;
                        x++;
                    }
                }

                //Level 6 counter
            } else if (x < 18) {
                moduleName.setText("Module " + x3);

                if (x == 12) {

                    levelName.setText("Level 6");
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT01.getText().isEmpty()) {
                    iCT01Integer = Integer.parseInt(iCT01.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!iCT02.getText().isEmpty()) {
                    iCT02Integer = Integer.parseInt(iCT02.getText());
                }

                //Setting up a text field to receive Integer value and not to move forward if the field is empty
                if (!courseWork.getText().isEmpty()) {
                    courseWorkInteger = Integer.parseInt(courseWork.getText());
                }

                //Setting up a validation Range for inputs. (0-100)
                if ((iCT01Integer >= 0 && iCT01Integer <= 100) && (iCT02Integer >= 0 && iCT02Integer <= 100) && (courseWorkInteger >= 0 && courseWorkInteger <= 100)) {

                    //making the resit field visible if the initial ICT mark is less than 40
                    if (iCT01Integer < 40) {
                        resit_ICT01.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT01.getText().isEmpty()) {
                            resitICT1 = Integer.parseInt(resit_ICT01.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT1 >= 0 && resitICT1 <= 100)) {


                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT1 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT01.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular Coursework to 40
                                } else {
                                    iCT01Integer = 40;
                                    resit_ICT01.clear();
                                    resit_ICT01.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial ICT mark is less than 40
                    if (iCT02Integer < 40) {
                        resit_ICT02.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_ICT02.getText().isEmpty()) {
                            resitICT2 = Integer.parseInt(resit_ICT02.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitICT2 >= 0 && resitICT2 <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitICT2 < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_ICT02.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular Coursework to 40
                                } else {
                                    iCT02Integer = 40;
                                    resit_ICT02.clear();
                                    resit_ICT02.setVisible(false);
                                }
                            }
                        }
                    }

                    //making the resit field visible if the initial Coursework mark is less than 40
                    if (courseWorkInteger < 40) {
                        resit_Coursework.setVisible(true);

                        //Setting up a text field to receive Integer value and not to move forward if the field is empty
                        if (!resit_Coursework.getText().isEmpty()) {
                            resitCourse = Integer.parseInt(resit_Coursework.getText());

                            //Setting up a validation Range for inputs. (0-100)
                            if ((resitCourse >= 0 && resitCourse <= 100)) {

                                //activating the retake counter if the resit attempt is a failure
                                if (resitCourse < 40) {
                                    iCT01.clear();
                                    iCT02.clear();
                                    courseWork.clear();
                                    resit_ICT01.clear();
                                    resit_ICT02.clear();
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                    retakeCount += 1;

                                    //if the resit attempt is successful then capping the mark for that particular Coursework to 40
                                } else {
                                    courseWorkInteger = 40;
                                    resit_Coursework.clear();
                                    resit_Coursework.setVisible(false);
                                }
                            }
                        }
                    }


                    //Calculating the average for each module in level 6
                    int average = (iCT01Integer + iCT02Integer + courseWorkInteger) / 3;

                    //setting up the counter value to increase module number on the successful completion of a module
                    if (iCT01Integer >= 40 && iCT02Integer >= 40 && courseWorkInteger >= 40 && average >= 40) {
                        credit += 20;
                        //adding extra 20 credits for the last module in level 6 since it's a double credit module
                        if (x == 17) {
                            credit += 20;
                        }
                        x3++;
                        x++;
                    }
                }

            }

            //continuously adding each module average in level 5 and getting 1/3 of the average to use in the award calculation
            if(x>7&&x<14) {
                averagel5 += average;
            }
            l5CreditAverage=averagel5/18;

            //continuously adding each module average in level 6 and getting 2/3 of the average to use in the award calculation
            if(x>13&&x<19) {
                averagel6 += average;
            }
            l6CreditAverage=(averagel6*2)/15;

            iCT01.clear();
            iCT02.clear();
            courseWork.clear();

            //showing the user if he has reached the maximum amount of retakes that can be taken
        }else {
            retakeLimit.setVisible(true);
        }

        //letting the user know that he has completed the whole 3 years in the campus successfully
        if(credit==360){
            endOfTheRoad.setVisible(true);
        }

    }

    @FXML
    //method to output the appropriate award
    void dropOut(ActionEvent event) throws IOException{

        retakeLimit.setVisible(false);
        endOfTheRoad.setVisible(false);

        if (credit < 120){
            finalResult.setText("Sorry. The number of credits received by the student is very low!");
            finalResult.setVisible(true);
        }

        if (credit >= 120){
            finalResult.setText("The Student is Eligible to get a Certificate in Higher Education");
            finalResult.setVisible(true);
        }

        if (credit >= 240){
            finalResult.setText("The Student is Eligible to get a Diploma in Higher Education");
            finalResult.setVisible(true);
        }

        if (credit >= 300){
            finalResult.setText("The Student is Eligible to get a Non-Honors Degree");
            finalResult.setVisible(true);
        }

        if (credit >= 360){

            if(l5CreditAverage+l6CreditAverage>=40){
                finalResult.setText("The Student is Eligible to get a 3rd class Honors Degree");
                finalResult.setVisible(true);
            }

            if(l5CreditAverage+l6CreditAverage>=50){
                finalResult.setText("The Student is Eligible to get 2nd a class Honors Lower Division Degree");
                finalResult.setVisible(true);
            }

            if(l5CreditAverage+l6CreditAverage>=60){
                finalResult.setText("The Student is Eligible to get a 2nd class Honors Upper Division Degree");
                finalResult.setVisible(true);
            }

            if(l5CreditAverage+l6CreditAverage>=70){
                finalResult.setText("The Student is Eligible to get a 1st class Honors Degree");
                finalResult.setVisible(true);
            }
        }
    }

    }





