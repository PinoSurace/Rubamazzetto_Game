package userInterface.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import network.server.RemotePlayer;
import userInterface.compontenti.CartaImageView;
import userInterface.compontenti.LabelImageView;
import userInterface.compontenti.MazzettoImageView;
import userInterface.compontenti.SelezioneImageView;
import userInterface.controllers.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Pinos on 02/07/2017.
 */
public class GUIController extends Controller {

    @FXML
    public Pane pane;

    private Pane sceltaTavolo;
    private Pane sceltaMazzo;

    private JFXButton button1;
    private JFXButton button2;

    private HBox carteInMano;
    private HBox carteInTavola;

    private ImageView sfondo;
    private ImageView mazzoDiGioco;

    private ArrayList<MazzettoImageView> mazzetti;
    private MazzettoImageView mazzetto1;
    private MazzettoImageView mazzetto2;
    private MazzettoImageView mazzetto3;
    private MazzettoImageView mazzetto0;

    private LabelImageView label11;
    private LabelImageView label22;
    private LabelImageView label33;
    private LabelImageView label00;

    private LabelImageView label1;
    private LabelImageView label2;
    private LabelImageView label3;
    private LabelImageView label0;
    private Label labelMazzoDiGioco;
    private Label turno;

    private CartaImageView cartaImageViewSelezionata = null;
    private SelezioneImageView imageView1;
    private SelezioneImageView imageView2;
    private SelezioneImageView imageView3;
    private SelezioneImageView imageView4;
    private SelezioneImageView imageView5;
    private SelezioneImageView imageView6;
    private SelezioneImageView imageView7;
    private SelezioneImageView imageView8;
    private SelezioneImageView imageView9;
    private SelezioneImageView imageView10;
    private SelezioneImageView imageView11;
    private SelezioneImageView imageView12;
    private SelezioneImageView imageView13;
    private SelezioneImageView imageView14;
    private SelezioneImageView imageView15;


    private String tavolo = "verde";
    private String mazzo = "Napoletane";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inizializza();
    }

    public void inizializzaSceltaMazzo(){
        sceltaMazzo = new Pane();
        sceltaMazzo.setPrefHeight(300);
        sceltaMazzo.setPrefWidth(400);
        sceltaMazzo.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
        sceltaMazzo.layoutXProperty().bind(pane.layoutXProperty().add(400));
        sceltaMazzo.layoutYProperty().bind(pane.layoutYProperty().add(250));
        imageView9 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Bergamasche/1b.png"), "Bergamasche");
        imageView9.setFitHeight(80);
        imageView9.setFitWidth(45);
        imageView9.setOnMouseClicked(e->{
            //imageView9.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView9.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView10 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Francitalia/1b.png"), "Francitalia");
        imageView10.setFitHeight(80);
        imageView10.setFitWidth(45);
        imageView10.setOnMouseClicked(e->{
            //imageView10.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView10.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView11 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Napoletane/1b.png"), "Napoletane");
        imageView11.setFitHeight(80);
        imageView11.setFitWidth(45);
        imageView11.setOnMouseClicked(e->{
            //imageView11.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView11.getName();
            setCarte();

            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView12 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Piacentine/1b.png"), "Piacentine");
        imageView12.setFitHeight(80);
        imageView12.setFitWidth(45);
        imageView12.setOnMouseClicked(e->{
            //imageView12.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView12.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView13 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Siciliane/1b.png"), "Siciliane");
        imageView13.setFitHeight(80);
        imageView13.setFitWidth(45);
        imageView13.setOnMouseClicked(e->{
            //imageView13.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView13.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView14 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Toscane/1b.png"), "Toscane");
        imageView14.setFitHeight(80);
        imageView14.setFitWidth(45);
        imageView14.setOnMouseClicked(e->{
           // imageView14.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView14.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });
        imageView15 = new SelezioneImageView(new Image("userInterface/immagini/mazzi/Trevisane/1b.png"), "Trevisane");
        imageView15.setFitHeight(80);
        imageView15.setFitWidth(45);
        imageView15.setOnMouseClicked(e->{
            //imageView15.setEffect(new DropShadow(20, Color.AQUAMARINE));
            mazzo = imageView15.getName();
            setCarte();
            //setTavolo();
            sceltaMazzo.setVisible(false);
            sceltaMazzo.setMouseTransparent(true);
        });

        imageView9.xProperty().bind(pane.layoutXProperty().add(25));
        imageView9.yProperty().bind(pane.layoutYProperty().add(60));


        imageView10.xProperty().bind(imageView9.xProperty().add(100));
        imageView10.yProperty().bind(imageView9.yProperty());

        imageView11.xProperty().bind(imageView10.xProperty().add(100));
        imageView11.yProperty().bind(imageView10.yProperty());

        imageView12.xProperty().bind(imageView11.xProperty().add(100));
        imageView12.yProperty().bind(imageView11.yProperty());

        imageView13.xProperty().bind(imageView9.xProperty().add(45));
        imageView13.yProperty().bind(imageView9.yProperty().add(100));

        imageView14.xProperty().bind(imageView13.xProperty().add(100));
        imageView14.yProperty().bind(imageView13.yProperty());

        imageView15.xProperty().bind(imageView14.xProperty().add(100));
        imageView15.yProperty().bind(imageView14.yProperty());




        sceltaMazzo.getChildren().add(imageView9);
        sceltaMazzo.getChildren().add(imageView10);
        sceltaMazzo.getChildren().add(imageView11);
        sceltaMazzo.getChildren().add(imageView12);
        sceltaMazzo.getChildren().add(imageView13);
        sceltaMazzo.getChildren().add(imageView14);
        sceltaMazzo.getChildren().add(imageView15);

        sceltaMazzo.setVisible(false);
        sceltaMazzo.setMouseTransparent(true);
        pane.getChildren().add(sceltaMazzo);




    }

    public void inizializzaSceltaTavolo(){
        sceltaTavolo = new Pane();
        sceltaTavolo.setPrefHeight(300);
        sceltaTavolo.setPrefWidth(400);
        sceltaTavolo.setBackground(new Background(new BackgroundFill(Color.AZURE, null, null)));
        sceltaTavolo.layoutXProperty().bind(pane.layoutXProperty().add(400));
        sceltaTavolo.layoutYProperty().bind(pane.layoutYProperty().add(250));
        imageView1 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/biliardo.png"), "biliardo");
        imageView1.setOnMouseClicked(e->{
            imageView1.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView1.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView2 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/carbon.png"), "carbon");
        imageView2.setOnMouseClicked(e->{
            imageView2.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView2.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView3 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/cuoio.png"), "cuoio");
        imageView3.setOnMouseClicked(e->{
            imageView3.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView3.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView4 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/legno.png"), "legno");
        imageView4.setOnMouseClicked(e->{
            imageView4.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView4.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView5 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/panno.png"), "panno");
        imageView5.setOnMouseClicked(e->{
            imageView5.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView5.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView6 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/sabbia.png"), "sabbia");
        imageView6.setOnMouseClicked(e->{
            imageView6.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView6.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView7 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/tappeto.png"), "tappeto");
        imageView7.setOnMouseClicked(e->{
            imageView7.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView7.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView8 = new SelezioneImageView(new Image("userInterface/immagini/tavoli/verde.png"), "verde");
        imageView8.setOnMouseClicked(e->{
            imageView8.setEffect(new DropShadow(20, Color.AQUAMARINE));
            tavolo = imageView8.getName();
            setTavolo();
            sceltaTavolo.setVisible(false);
            sceltaTavolo.setMouseTransparent(true);
        });
        imageView1.xProperty().bind(pane.layoutXProperty().add(25));
        imageView1.yProperty().bind(pane.layoutYProperty().add(60));


        imageView2.xProperty().bind(imageView1.xProperty().add(100));
        imageView2.yProperty().bind(imageView1.yProperty());
        imageView3.xProperty().bind(imageView2.xProperty().add(100));
        imageView3.yProperty().bind(imageView2.yProperty());
        imageView4.xProperty().bind(imageView3.xProperty().add(100));
        imageView4.yProperty().bind(imageView3.yProperty());
        imageView5.xProperty().bind(imageView1.xProperty());
        imageView5.yProperty().bind(imageView1.yProperty().add(100));
        imageView6.xProperty().bind(imageView5.xProperty().add(100));
        imageView6.yProperty().bind(imageView5.yProperty());
        imageView7.xProperty().bind(imageView6.xProperty().add(100));
        imageView7.yProperty().bind(imageView6.yProperty());
        imageView8.xProperty().bind(imageView7.xProperty().add(100));
        imageView8.yProperty().bind(imageView7.yProperty());
        sceltaTavolo.getChildren().add(imageView1);
        sceltaTavolo.getChildren().add(imageView2);
        sceltaTavolo.getChildren().add(imageView3);
        sceltaTavolo.getChildren().add(imageView4);
        sceltaTavolo.getChildren().add(imageView5);
        sceltaTavolo.getChildren().add(imageView6);
        sceltaTavolo.getChildren().add(imageView7);
        sceltaTavolo.getChildren().add(imageView8);
        sceltaTavolo.setVisible(false);
        sceltaTavolo.setMouseTransparent(true);
        pane.getChildren().add(sceltaTavolo);




    }

    public void inizializza(){
        inizializzaPane();
        inizializzaSfondo();
        inizializzaCarteInTavola();
        inizializzaCarteInMano();
        inizializzaMazzetti();
        inizializzaMazzoDiGioco();
        inizializzaSceltaTavolo();
        inizializzaSceltaMazzo();


    }

    public void inizializzaPane(){

        pane.isResizable();
    }

    public void inizializzaSfondo(){
        sfondo = new ImageView(new Image("userInterface/immagini/tavoli/"+tavolo+".png"));
        sfondo.setPreserveRatio(false);
        sfondo.xProperty().bind(pane.layoutXProperty());
        sfondo.yProperty().bind(pane.layoutYProperty());
        sfondo.fitHeightProperty().bind(pane.heightProperty());
        sfondo.fitWidthProperty().bind(pane.widthProperty());

        button1 = new JFXButton();
        button1.setText("CAMBIA TAVOLO");
        button1.setStyle("-fx-background-color: white");

        button1.setOnAction(e-> {sceltaTavolo.setMouseTransparent(false);
        sceltaTavolo.setVisible(true);}
        );
        button1.layoutXProperty().bind(pane.layoutXProperty().add(1200));
        button1.layoutYProperty().bind(pane.layoutYProperty().add(50));

        button2 = new JFXButton();
        button2.setText("CAMBIA CARTE");
        button2.setStyle("-fx-background-color: white");
        button2.setOnAction(e-> {sceltaMazzo.setMouseTransparent(false);
            sceltaMazzo.setVisible(true);}
        );

        button2.layoutXProperty().bind(button1.layoutXProperty());
        button2.layoutYProperty().bind(button1.layoutYProperty().add(50));

        pane.getChildren().add(sfondo);
        pane.getChildren().add(button1);
        pane.getChildren().add(button2);

        turno = new Label(null, null);


        turno.layoutXProperty().bind(pane.layoutXProperty());
        turno.layoutYProperty().bind(pane.layoutYProperty());
        turno.setText("Turno: ");
        turno.setFont(Font.font("Arial", 20));
        turno.textAlignmentProperty().setValue(TextAlignment.CENTER);
        turno.setPadding(new Insets(4,4,4,4));
        turno.setMinWidth(100);
        turno.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
        turno.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#107896"), null, null)));
        pane.getChildren().add(turno);

    }

    public void setTavolo(){
        sfondo.setImage(new Image("userInterface/immagini/tavoli/"+tavolo+".png"));
    }

    public void setCarte(){
        for(Node tmp: carteInTavola.getChildren()){
            if(tmp instanceof CartaImageView)
                ((CartaImageView) tmp).setImmagine(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+((CartaImageView) tmp).getCarta()+".png"));
        }

        for(Node tmp: carteInMano.getChildren()){
            if(tmp instanceof CartaImageView)
                ((CartaImageView) tmp).setImmagine(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+((CartaImageView) tmp).getCarta()+".png"));
        }

        if(mazzetto0.getCarta()!= null)
            mazzetto0.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+mazzetto0.getCarta()+".png"));
        else
            mazzetto0.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));


        if(mazzetto1.getCarta() != null)
            mazzetto1.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+mazzetto1.getCarta()+".png"));
        else
            mazzetto1.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));

        if(mazzetto2.getCarta() != null)
            mazzetto2.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+mazzetto2.getCarta()+".png"));
        else
            mazzetto2.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));

        if(mazzetto3.getCarta() != null)
            mazzetto3.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+mazzetto3.getCarta()+".png"));
        else
            mazzetto3.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));



    }

    public void inizializzaCarteInTavola(){
        carteInTavola = new HBox();
        carteInTavola.layoutXProperty().bind(pane.layoutXProperty().add(400));
        carteInTavola.layoutYProperty().bind(pane.layoutYProperty().add(350));
        pane.getChildren().add(carteInTavola);
    }




    public void inizializzaCarteInMano(){
        carteInMano = new HBox();
        carteInMano.layoutXProperty().bind(pane.layoutXProperty().add(500));
        carteInMano.layoutYProperty().bind(pane.layoutYProperty().add(600));
        pane.getChildren().add(carteInMano);

    }


    public void inizializzaMazzettoUno(){
        mazzetto1 = new MazzettoImageView();
        mazzetto1.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
        mazzetto1.setOnMouseClicked(e-> {
            //mazzetto1.setEffect(new DropShadow(20, Color.AZURE));
            if(mazzetto1.getRemotePlayer().getMazzetto().size() > 0)
                getGuiClient().selezionaMazzetto(mazzetto1.getRemotePlayer().getMazzetto());

        });
        mazzetto1.setFitWidth(100);
        mazzetto1.setFitHeight(180);
        mazzetto1.xProperty().bind(pane.layoutXProperty().add(200));
        mazzetto1.yProperty().bind(pane.layoutYProperty().add(100));
        mazzetto1.setMouseTransparent(true);
        mazzetto1.setVisible(false);
        pane.getChildren().add(mazzetto1);
        label1 = new LabelImageView(null, null);


        label1.layoutXProperty().bind(mazzetto1.xProperty().add(mazzetto1.getFitWidth()).add(5));
        label1.layoutYProperty().bind(mazzetto1.yProperty().add(mazzetto1.getFitHeight()).divide(2).add(10));
        label1.setText("0");
        label1.setTextFill(Color.YELLOW);
        label1.setFont(Font.font("Garamond", 50));
        label1.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000005"), new CornerRadii(100), null)));
        label1.setMouseTransparent(true);
        label1.setVisible(false);


        label11 = new LabelImageView(null, null);


        label11.layoutXProperty().bind(mazzetto1.xProperty());
        label11.layoutYProperty().bind(mazzetto1.yProperty().subtract(40));
        label11.setText("Username");
        label11.setFont(Font.font("Arial", 20));
        //label11.textAlignmentProperty().setValue(TextAlignment.CENTER);
        label11.setAlignment(Pos.CENTER);

        label11.setPadding(new Insets(4,4,4,4));
        label11.setMinWidth(100);
        label11.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
        label11.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#9a2617"), null, null)));

        //label11.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000800"), null, null)));
        label11.setMouseTransparent(true);
        label11.setVisible(false);



        pane.getChildren().add(label1);
        pane.getChildren().add(label11);
    }


    public void inizializzaMazzettoDue(){
        mazzetto2 = new MazzettoImageView();
        mazzetto2.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
        mazzetto2.setOnMouseClicked(e-> {
            //mazzetto2.setEffect(new DropShadow(20, Color.AZURE));
            if(mazzetto2.getRemotePlayer().getMazzetto().size() > 0)
                getGuiClient().selezionaMazzetto(mazzetto2.getRemotePlayer().getMazzetto());
        });
        mazzetto2.setFitWidth(100);
        mazzetto2.setFitHeight(180);
        mazzetto2.xProperty().bind(mazzetto1.xProperty().add(400));
        mazzetto2.yProperty().bind(mazzetto1.yProperty().subtract(20));
        mazzetto2.setMouseTransparent(true);
        mazzetto2.setVisible(false);
        pane.getChildren().add(mazzetto2);

        label2 = new LabelImageView(null, null);

        label2.layoutXProperty().bind(mazzetto2.xProperty().add(mazzetto2.getFitWidth()).add(5));
        label2.layoutYProperty().bind(mazzetto2.yProperty().add(mazzetto2.getFitHeight()).divide(2).add(10));
        label2.setText("0");
        label2.setTextFill(Color.YELLOW);
        label2.setFont(Font.font("Garamond", 50));
        label2.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000005"), new CornerRadii(100), null)));
        label2.setMouseTransparent(true);
        label2.setVisible(false);

        label22 = new LabelImageView(null, null);

        label22.layoutXProperty().bind(mazzetto2.xProperty());
        label22.layoutYProperty().bind(mazzetto2.yProperty().subtract(40));
        label22.setText("Username");
        label22.setFont(Font.font("Arial", 20));
        label22.setAlignment(Pos.CENTER);
        label22.setPadding(new Insets(4,4,4,4));
        label22.setMinWidth(100);
        label22.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
        label22.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#9a2617"), null, null)));



        label22.setMouseTransparent(true);
        label22.setVisible(false);

        pane.getChildren().add(label2);
        pane.getChildren().add(label22);

    }


    public void inizializzaMazzettoTre(){
        mazzetto3 = new MazzettoImageView();
        mazzetto3.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
        mazzetto3.setOnMouseClicked(e-> {
            //mazzetto3.setEffect(new DropShadow(20, Color.AZURE));
            if(mazzetto3.getRemotePlayer().getMazzetto().size() > 0)
                getGuiClient().selezionaMazzetto(mazzetto3.getRemotePlayer().getMazzetto());
        });
        mazzetto3.setFitWidth(100);
        mazzetto3.setFitHeight(180);
        mazzetto3.xProperty().bind(mazzetto2.xProperty().add(400));
        mazzetto3.yProperty().bind(mazzetto1.yProperty());
        mazzetto3.setMouseTransparent(true);
        mazzetto3.setVisible(false);
        pane.getChildren().add(mazzetto3);

        label3 = new LabelImageView(null, null);

        label3.layoutXProperty().bind(mazzetto3.xProperty().add(mazzetto3.getFitWidth()).add(5));
        label3.layoutYProperty().bind(mazzetto3.yProperty().add(mazzetto3.getFitHeight()).divide(2).add(10));
        label3.setText("0");
        label3.setTextFill(Color.YELLOW);
        label3.setFont(Font.font("Garamond", 50));
        label3.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000005"), new CornerRadii(100), null)));
        label3.setMouseTransparent(true);
        label3.setVisible(false);

        label33 = new LabelImageView(null, null);

        label33.layoutXProperty().bind(mazzetto3.xProperty());
        label33.layoutYProperty().bind(mazzetto3.yProperty().subtract(40));
        label33.setText("Username");
        label33.setFont(Font.font("Arial", 20));
        label33.setAlignment(Pos.CENTER);
        label33.setPadding(new Insets(4,4,4,4));
        label33.setMinWidth(100);
        label33.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
        label33.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#9a2617"), null, null)));


        label33.setMouseTransparent(true);
        label33.setVisible(false);

        pane.getChildren().add(label3);
        pane.getChildren().add(label33);



    }

    public void inizializzaMazzettoZero(){
        //mazzetto0 = new ImageView(new Image("sample/immagini/1c.png"));
        mazzetto0 = new MazzettoImageView();//todo setta immagine vuota
        mazzetto0.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
        mazzetto0.setFitWidth(100);
        mazzetto0.setFitHeight(160);
        mazzetto0.xProperty().bind(carteInMano.layoutXProperty().add(500));
        mazzetto0.yProperty().bind(carteInMano.layoutXProperty().add(30));
        pane.getChildren().add(mazzetto0);

        label0 = new LabelImageView(null, null);

        label0.layoutXProperty().bind(mazzetto0.xProperty().add(mazzetto0.getFitWidth()).add(5));
        label0.layoutYProperty().bind(mazzetto0.yProperty().add(mazzetto0.getFitHeight()/2).subtract(15));
        label0.setText("0");
        label0.setTextFill(Color.YELLOW);
        label0.setFont(Font.font("Garamond", 50));
        label0.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000000"), new CornerRadii(100), null)));


        label00 = new LabelImageView(null, null);

        label00.layoutXProperty().bind(mazzetto0.xProperty());
        label00.layoutYProperty().bind(mazzetto0.yProperty().add(mazzetto0.getFitHeight()).add(40));
        label00.setText("Username");
        label00.setFont(Font.font("Arial", 20));
        label00.setAlignment(Pos.CENTER);
        label00.setPadding(new Insets(4,4,4,4));
        label00.setMinWidth(100);
        label00.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
        label00.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#9a2617"), null, null)));

        pane.getChildren().add(label0);
        pane.getChildren().add(label00);
    }



    public void inizializzaMazzetti(){
        inizializzaMazzettoZero();
        inizializzaMazzettoUno();
        inizializzaMazzettoDue();
        inizializzaMazzettoTre();
    }

    public void inizializzaMazzoDiGioco(){
        mazzoDiGioco = new ImageView(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));

        mazzoDiGioco.setFitWidth(125);
        mazzoDiGioco.setFitHeight(200);
        mazzoDiGioco.xProperty().bind(carteInMano.layoutXProperty().subtract(400));
        mazzoDiGioco.yProperty().bind(carteInMano.layoutYProperty().subtract(100));
        pane.getChildren().add(mazzoDiGioco);


        labelMazzoDiGioco = new Label();

        labelMazzoDiGioco.layoutXProperty().bind(mazzoDiGioco.xProperty().add(mazzoDiGioco.getFitWidth()/2.7));
        labelMazzoDiGioco.layoutYProperty().bind(mazzoDiGioco.yProperty().add(mazzoDiGioco.getFitHeight()/2.7));
        labelMazzoDiGioco.setText("0");
        labelMazzoDiGioco.setTextFill(Color.YELLOW);
        labelMazzoDiGioco.setFont(Font.font("Garamond", 50));
        labelMazzoDiGioco.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Paint.valueOf("#000005"), new CornerRadii(100), null)));

        pane.getChildren().add(labelMazzoDiGioco);
    }


    //----------------------------------------------------


    public synchronized void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori){

        for(RemotePlayer tmp: giocatori){
            if(mazzetto0.getRemotePlayer()!= null && tmp.getLasciaGioco() &&  mazzetto0.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto0.setImage(new Image("userInterface/immagini/delete.png"));

            }
            if(mazzetto1.getRemotePlayer()!= null && tmp.getLasciaGioco() &&  mazzetto1.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto1.setImage(new Image("userInterface/immagini/delete.png"));

            }
            if(mazzetto2.getRemotePlayer()!= null && tmp.getLasciaGioco() &&  mazzetto2.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto2.setImage(new Image("userInterface/immagini/delete.png"));
            }
            if(mazzetto3.getRemotePlayer()!= null && tmp.getLasciaGioco() &&  mazzetto3.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())) {
                mazzetto3.setImage(new Image("userInterface/immagini/delete.png"));

            }

        }

        for(RemotePlayer tmp: giocatori){
            if(mazzetto0.getRemotePlayer()!= null && tmp.getVincitore() &&  mazzetto0.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto0.setImage(new Image("userInterface/immagini/winner.png"));

                pane.setMouseTransparent(true);
                return;

            }
            if(mazzetto1.getRemotePlayer()!= null && tmp.getVincitore() &&  mazzetto1.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto1.setImage(new Image("userInterface/immagini/winner.png"));

                pane.setMouseTransparent(true);
                return;
            }
            if(mazzetto2.getRemotePlayer()!= null && tmp.getVincitore() &&  mazzetto2.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())){
                mazzetto2.setImage(new Image("userInterface/immagini/winner.png"));

                pane.setMouseTransparent(true);

                return;
            }
            if(mazzetto3.getRemotePlayer()!= null && tmp.getVincitore() &&  mazzetto3.getRemotePlayer().getGiocatoreId().equals(tmp.getGiocatoreId())) {
                mazzetto3.setImage(new Image("userInterface/immagini/winner.png"));

                pane.setMouseTransparent(true);
                return;
            }

        }


        aggiornaTavolo(tavolo);
        labelMazzoDiGioco.setText(String.valueOf(tavolo.getMazzoDiGioco().size()));
        for(RemotePlayer tmp: giocatori){


            if(tmp.getMioTurno()) {
                turno.setText("Turno: " + tmp.getUsername());

            }



            if(tmp.getGiocatoreId().equals(mazzetto0.getRemotePlayer().getGiocatoreId())){
                if(!tmp.getMioTurno())
                    pane.setMouseTransparent(true);
                else
                    pane.setMouseTransparent(false);
                aggiornaMano(tmp);
            }

        }
        aggiornaMazzetti(giocatori);






    }

    public synchronized void aggiornaTavolo(Tavolo tavolo){
        carteInTavola.getChildren().clear();


        for(Carta tmp: tavolo.getCarteInTavola()){
            CartaImageView cartaImageView = new CartaImageView();
            cartaImageView.setCarta(tmp);

            cartaImageView.setImmagine(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+tmp.toString()+".png"));
            aggiungiCartaAlTavolo(cartaImageView);

        }


    }



    public void aggiungiCartaAlTavolo(CartaImageView cartaImageView){

        ImageView imageView = new ImageView();
        imageView.setFitWidth(10);
        imageView.setFitHeight(160);
        cartaImageView.setOnMouseClicked(event -> {
            //cartaImageView.setEffect(new DropShadow(20, Color.FUCHSIA));
            getGuiClient().selezionaCartaInTavola(cartaImageView.getCarta());
        });
        //imageView.setOnMouseClicked(event -> {imageView.setEffect(new InnerShadow());});
        //carteInTavolaImage.put(imageView, )
        carteInTavola.getChildren().add(cartaImageView);
        carteInTavola.getChildren().add(imageView);

    }

    public synchronized void aggiornaMano(RemotePlayer giocatore){
        carteInMano.getChildren().clear();
        /*
        for(Node tmp: carteInMano.getChildren()){
            carteInMano.getChildren().remove(tmp);
        }*/

        for(Carta tmp: giocatore.getMano().getCarteInMano()){
            CartaImageView cartaImageView = new CartaImageView();
            cartaImageView.setCarta(tmp);

            cartaImageView.setImmagine(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+tmp.toString()+".png"));
            aggiungiCartaInMano(cartaImageView);

        }


    }

    public void aggiungiCartaInMano(CartaImageView cartaImageView){
        ImageView imageView = new ImageView();
        imageView.setFitWidth(10);
        imageView.setFitHeight(160);
        cartaImageView.setOnMouseClicked(event -> {
            if(cartaImageViewSelezionata != null)
                cartaImageViewSelezionata.setEffect(null);
            cartaImageView.setEffect(new DropShadow(20, Color.AZURE));
            if(cartaImageViewSelezionata == cartaImageView)
                getGuiClient().tiraCartaSulTavolo(cartaImageViewSelezionata.getCarta());
            getGuiClient().selezionaCartaInMano(cartaImageView.getCarta());
            cartaImageViewSelezionata = cartaImageView;

        });
        //imageView.setOnMouseClicked(event -> {imageView.setEffect(new InnerShadow());});
        //carteInTavolaImage.put(imageView, )
        carteInMano.getChildren().add(cartaImageView);
        carteInMano.getChildren().add(imageView);
    }


    public void aggiornaMazzetti(ArrayList<RemotePlayer> giocatori){


        for(RemotePlayer tmp1: giocatori) {
            if (mazzetto0.getRemotePlayer() != null && mazzetto0.getRemotePlayer().getGiocatoreId().equals(tmp1.getGiocatoreId())) {

                if(tmp1.getMazzetto().size() > 0) {
                    mazzetto0.setRemotePlayer(tmp1);
                    mazzetto0.setCarta(tmp1.getMazzetto().mostraPrimaCarta());
                    mazzetto0.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/" + mazzetto0.getCarta().toString() + ".png"));
                    label0.setText(String.valueOf(mazzetto0.getRemotePlayer().getMazzetto().size()));
                }
                else{
                    mazzetto0.setRemotePlayer(tmp1);
                    mazzetto0.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
                    label0.setText(String.valueOf(mazzetto0.getRemotePlayer().getMazzetto().size()));

                }
                continue;
            }
            if (mazzetto1.getRemotePlayer() != null && mazzetto1.getRemotePlayer().getGiocatoreId().equals(tmp1.getGiocatoreId())) {

                if(tmp1.getMazzetto().size() > 0) {
                    mazzetto1.setRemotePlayer(tmp1);
                    mazzetto1.setCarta(tmp1.getMazzetto().mostraPrimaCarta());
                    mazzetto1.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/" + mazzetto1.getCarta().toString() + ".png"));
                    label1.setText(String.valueOf(mazzetto1.getRemotePlayer().getMazzetto().size()));
                }
                else{
                    mazzetto1.setRemotePlayer(tmp1);
                    mazzetto1.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
                    label1.setText(String.valueOf(mazzetto1.getRemotePlayer().getMazzetto().size()));}
                continue;
            }
            if (mazzetto2.getRemotePlayer() != null && mazzetto2.getRemotePlayer().getGiocatoreId().equals(tmp1.getGiocatoreId())) {

                if(tmp1.getMazzetto().size() > 0) {
                    mazzetto2.setRemotePlayer(tmp1);
                    mazzetto2.setCarta(tmp1.getMazzetto().mostraPrimaCarta());
                    mazzetto2.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/" + mazzetto2.getCarta().toString() + ".png"));
                    label2.setText(String.valueOf(mazzetto2.getRemotePlayer().getMazzetto().size()));
                }
                else{
                    mazzetto2.setRemotePlayer(tmp1);
                    mazzetto2.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
                    label2.setText(String.valueOf(mazzetto2.getRemotePlayer().getMazzetto().size()));
                }
                continue;
            }
            if (mazzetto3.getRemotePlayer() != null && mazzetto3.getRemotePlayer().getGiocatoreId().equals(tmp1.getGiocatoreId())) {

                if(tmp1.getMazzetto().size() > 0) {
                    mazzetto3.setRemotePlayer(tmp1);
                    mazzetto3.setCarta(tmp1.getMazzetto().mostraPrimaCarta());
                    mazzetto3.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/" + mazzetto3.getCarta().toString() + ".png"));
                    label3.setText(String.valueOf(mazzetto3.getRemotePlayer().getMazzetto().size()));
                }
                else{
                    mazzetto3.setRemotePlayer(tmp1);
                    mazzetto3.setImage(new Image("userInterface/immagini/mazzi/"+mazzo+"/bg.png"));
                    label3.setText(String.valueOf(mazzetto3.getRemotePlayer().getMazzetto().size()));
                }
                continue;
            }

        }
    }

    public void creaPartita(int numeroDiGiocatori){

        if(numeroDiGiocatori == 2){
            mazzetto1.setVisible(false);
            mazzetto1.setMouseTransparent(true);
            label1.setVisible(false);
            label1.setMouseTransparent(true);
            label3.setMouseTransparent(true);
            label3.setVisible(false);
            mazzetto3.setVisible(false);
            mazzetto3.setMouseTransparent(true);

        }
        else if(numeroDiGiocatori == 3){
            mazzetto2.setVisible(false);
            mazzetto2.setMouseTransparent(true);
            label2.setMouseTransparent(true);
            label2.setVisible(false);
        }



    }

    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori){
        if(giocatori.size() == 2){
            for(RemotePlayer tmp: giocatori){
                if(tmp.getMioTurno())
                    turno.setText("Turno: "+ tmp.getUsername());
                if(tmp.getGiocatoreId().equals(getGuiClient().getId())){
                    mazzetto0.setRemotePlayer(tmp);
                    label00.setText(tmp.getUsername());
                }

                else {
                    mazzetto2.setRemotePlayer(tmp);
                    label22.setText(tmp.getUsername());
                    mazzetto2.setVisible(true);
                    mazzetto2.setMouseTransparent(false);
                    label2.setVisible(true);
                    label2.setMouseTransparent(false);
                    label22.setVisible(true);
                    label22.setMouseTransparent(false);
                }

            }
        }

        if(giocatori.size() == 3){
            for(RemotePlayer tmp: giocatori){
                if(tmp.getMioTurno())
                    turno.setText("Turno: "+ tmp.getUsername());
                if(tmp.getGiocatoreId().equals(getGuiClient().getId())){
                    mazzetto0.setRemotePlayer(tmp);
                    label00.setText(tmp.getUsername());
                }
                else if(mazzetto1.getRemotePlayer() == null){
                    mazzetto1.setRemotePlayer(tmp);
                    label11.setText(tmp.getUsername());
                    mazzetto1.setVisible(true);
                    mazzetto1.setMouseTransparent(false);
                    label1.setVisible(true);
                    label1.setMouseTransparent(false);
                    label11.setVisible(true);
                    label11.setMouseTransparent(false);
                }
                else {
                    mazzetto3.setRemotePlayer(tmp);
                    label33.setText(tmp.getUsername());
                    mazzetto3.setVisible(true);
                    mazzetto3.setMouseTransparent(false);
                    label3.setVisible(true);
                    label3.setMouseTransparent(false);
                    label33.setVisible(true);
                    label33.setMouseTransparent(false);
                }
            }

        }

        if(giocatori.size() == 4){
            for(RemotePlayer tmp: giocatori){
                if(tmp.getMioTurno())
                    turno.setText("Turno: "+ tmp.getUsername());
                if(tmp.getGiocatoreId().equals(getGuiClient().getId())){
                    mazzetto0.setRemotePlayer(tmp);
                    label00.setText(tmp.getUsername());
                }
                else if(mazzetto1.getRemotePlayer() == null){
                    mazzetto1.setRemotePlayer(tmp);
                    label11.setText(tmp.getUsername());
                    mazzetto1.setVisible(true);
                    mazzetto1.setMouseTransparent(false);
                    label1.setVisible(true);
                    label1.setMouseTransparent(false);
                    label11.setVisible(true);
                    label11.setMouseTransparent(false);

                }
                else if(mazzetto2.getRemotePlayer() == null){
                    mazzetto2.setRemotePlayer(tmp);
                    label22.setText(tmp.getUsername());
                    mazzetto2.setVisible(true);
                    mazzetto2.setMouseTransparent(false);
                    label2.setVisible(true);
                    label2.setMouseTransparent(false);
                    label22.setVisible(true);
                    label22.setMouseTransparent(false);
                }
                else if(mazzetto3.getRemotePlayer() == null){
                    mazzetto3.setRemotePlayer(tmp);
                    label33.setText(tmp.getUsername());
                    mazzetto3.setVisible(true);
                    mazzetto3.setMouseTransparent(false);
                    label3.setVisible(true);
                    label3.setMouseTransparent(false);
                    label33.setVisible(true);
                    label33.setMouseTransparent(false);
                }


            }

        }
        for(Carta tmp: tavolo.getCarteInTavola()){
            boolean a = true;
            for(Node tmp1: carteInTavola.getChildren()){

                if(tmp1 instanceof CartaImageView && ((CartaImageView) tmp1).getCarta().equals(tmp)){
                    a = false;

                }

            }

            if(a == true){
                CartaImageView cartaImageView = new CartaImageView();
                cartaImageView.setCarta(tmp);
                cartaImageView.setImmagine(new Image("userInterface/immagini/mazzi/"+mazzo+"/"+tmp.toString()+".png"));
                //cartaImageView.setOnMouseClicked(e-> getGuiClient().selezionaCartaInTavola(cartaImageView.getCarta()));
                aggiungiCartaAlTavolo(cartaImageView);

            }

        }

    }


}
