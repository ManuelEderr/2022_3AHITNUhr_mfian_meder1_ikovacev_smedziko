package View;

import Model.Uhr;

public class ShowUhrBinary implements ShowUhr{
    String newTimeInBin;
    String oldTimeinBin;

    public ShowUhrBinary() {
        newTimeInBin="";
        oldTimeinBin="0000000000000000";
    }

    @Override
    public void showUhr() {
        for (int i = 0; i<16;i++){

        }


        oldTimeinBin=newTimeInBin;
    }
    public void upadte(String[] newTime){
        String hourInBin = Integer.toBinaryString(Integer.parseInt(newTime[0]));
        String minInBin = Integer.toBinaryString(Integer.parseInt(newTime[1]));
        String secInBin = Integer.toBinaryString(Integer.parseInt(newTime[2].substring(0,2)));
        newTimeInBin = hourInBin+minInBin+secInBin;
        showUhr();
    }
}
