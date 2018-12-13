package br.com.rafaelleme.senai.sdsandroid.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae on 13/12/2018.
 */

public class Utils {

    public static String abrevia(String nome){
        String[] palavrasV = nome.split(" ");
        List<String> palavras = new ArrayList<>();
        String ab = "";
        for(int i=0;i<palavrasV.length;i++){
            String palavra = palavrasV[i];
            if(palavra.equals("de")
                    || palavra.equals("para")
                    || palavra.equals("e")
                    || palavra.equals("a")
                    || palavra.equals("do")
                    || palavra.equals("em")
                    || palavra.equals("da")
                    || (i != 0 && palavra.equals("Técnico"))){
            }else{
                palavras.add(palavra);
            }

        }

        switch (palavras.size()) {
            case 1:
                ab = palavras.get(0).substring(0, 3);
                break;

            case 2:
                ab = palavras.get(0).substring(0, 1);
                ab += palavras.get(1).substring(0, 2);
                break;

            case 3:
                ab = palavras.get(0).substring(0, 1);
                ab += palavras.get(1).substring(0, 1);
                ab += palavras.get(2).substring(0, 1);
                break;

            default:
                break;
        }

        return ab.toUpperCase();
    }

}
