module com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires gson;
    // requires com.google.gson;
    //requires gson;
    //requires javax.annotation;


    opens com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko to javafx.fxml;
    exports com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;
}