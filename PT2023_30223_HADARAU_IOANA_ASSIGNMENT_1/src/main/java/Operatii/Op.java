package Operatii;
import DataModel.Polinom;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Op {
    Polinom polinom1 = new Polinom();
    Polinom polinom2 = new Polinom();


    public Op(Polinom polinom1, Polinom polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }

    public String Afisare( HashMap<Integer, Float> rez)
    {
        // afizez in consola rezultatul complet al operatiei, fara modificari de simplificare a formatului
        for (Integer gr : rez.keySet()) {
            if (rez.get(gr) != 0.0) {
                System.out.println(rez.get(gr) + "x^" + gr);
            }
        }

        int gmic=0; //fleg pentru un grad mai mic
        StringBuilder sb = new StringBuilder();
        for (Integer key : rez.keySet()) {
            if (rez.get(key) == 0.0) { //daca coeficientul e 0=> nu se afiseaza
                sb.append("");
            } else if (key == 0) { //daca gradul este 0 => nu afisez x-ul (x^0=1)
                if (rez.get(key) < 0 && gmic==0) {
                    sb.append(rez.get(key)).append("\n");
                } else {
                    sb.append(rez.get(key)).append("\n");
                }
                gmic=1;
            }else if(key==1){ //daca gradul=1 => nu afisez puterea
                if (gmic==1) {
                    if( rez.get(key)==1){
                        sb.append("+x").append("\n");
                     }else  if( rez.get(key) >0){
                        sb.append("+").append(rez.get(key)).append("x").append("\n");
                    }else if( rez.get(key)==-1){
                        sb.append("-x").append("\n");
                    }else  if( rez.get(key) <0){
                        sb.append(rez.get(key)).append("x").append("\n");
                    }
                } else  if( rez.get(key) ==1 ){
                    sb.append("x").append("\n");
                }else  if( rez.get(key) ==-1 ){
                    sb.append("-x").append("\n");
                }else  if( rez.get(key) >0 ){
                    sb.append(rez.get(key)).append("x").append("\n");
                }else {
                    sb.append(rez.get(key)).append("x").append("\n");
                }
                gmic=1;
            }else if (rez.get(key) == 1) { //daca coeficientul e 1 si are putere
                if(gmic==1)
                {
                    sb.append("+").append("x^").append(key).append("\n");

                }else{
                    sb.append("x^").append(key).append("\n");
                    gmic=1;
                }
            }else if (rez.get(key) == -1) {
                    if(gmic==1)
                    {
                        sb.append("-").append("x^").append(key).append("\n");

                    }else{
                        sb.append("-x^").append(key).append("\n");
                        gmic=1;
                    }
            }else if (rez.get(key) > 0) {
                    if(gmic==1)
                    {
                        sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");

                    }else{
                        sb.append(rez.get(key)).append("x^").append(key).append("\n");
                        gmic=1;
                    }
            } else {
                    sb.append(rez.get(key)).append("x^").append(key).append("\n");
                    gmic=1;
                }
            }

        return sb.toString();
    }
    public String Adunare() {
        HashMap<Integer, Float> rez = this.polinom1.hash;
        //pun primul polinom in rezultat
        for (Integer gp : polinom2.hash.keySet()) //grad polinom2
        {
            int flag = 0;
            for (Integer gr : rez.keySet()) //grad polinom rezultat
            {
                if (gr.equals(gp)) {
                    rez.put(gr, polinom2.hash.get(gp) + rez.get(gr));
                    flag = 1;
                }
            }
            //daca nu s-a gasit acelasi grad
            if (flag == 0) {
                rez.put(gp, polinom2.hash.get(gp));
            }
        }

        String rezultat=Afisare(rez);
        return rezultat;
    }
        public String Scadere () {
            HashMap<Integer, Float> rez = this.polinom1.hash;
            //pun primul polinom in rezultat

            for (Integer gp : polinom2.hash.keySet()) //grad polinom2
            {
                int flag = 0;
                for (Integer gr : rez.keySet()) //grad polinom rezultat
                {
                    if (gp == gr) {
                        rez.put(gr, rez.get(gr) - polinom2.hash.get(gp));
                        flag = 1;
                    }
                }
                //daca nu s-a gasit acelasi grad
                if (flag == 0) {
                    rez.put(gp, -1 * polinom2.hash.get(gp));
                }
            }
            String rezultat=Afisare(rez);
            return rezultat;
        }

        public String Derivare () {
            HashMap<Integer, Float> rez = new HashMap<Integer, Float>(1, 2);

            for (Integer gp : this.polinom1.hash.keySet()) //grad polinom
            {
                if (gp > 0) {
                    int gnou = gp - 1;
                    float cnou = (float) (this.polinom1.hash.get(gp) * gp);
                    rez.put(gnou, cnou);
                    System.out.println("nou: " + cnou + "x^" + gnou);
                }
            }
            String rezultat=Afisare(rez);
            return rezultat;
        }

        public String Integrare () {
            HashMap<Integer, Float> rez = new HashMap<Integer, Float>(1, 2);

            for (Integer gp : this.polinom1.hash.keySet()) //grad polinom
            {
                if (gp > 0) {
                    //gradul nou
                    int gnou = gp + 1;
                    //coeficientul nou
                    float cnou = (float) (this.polinom1.hash.get(gp) / gp);
                    String cnou_str = Float.toString(cnou);
                    Pattern pattern_decimale = Pattern.compile("\\d+\\.\\d{2}");
                    Matcher matcher_decimale = pattern_decimale.matcher(cnou_str);
                   // float cdec=cnou;
                    if (matcher_decimale.find() ) {
                        String cdec_str = matcher_decimale.group();
                        System.out.println("decimale: "+cdec_str);
                        cnou = Float.parseFloat(cdec_str);
                    }
                    rez.put(gnou, cnou);
                    System.out.println("cdec: " + cnou + "x^" + gnou);
                }
            }
            String rezultat=Afisare(rez);
            return rezultat;
        }

    public String Inmultire() {
        HashMap<Integer, Float> rez = new HashMap<>();

        for (Integer g2 : polinom2.hash.keySet())
        {
            for (Integer g1 :polinom1.hash.keySet())
            {
                 int grez=g1+g2;

                 if(rez.get(grez)==null)
                 {
                     rez.put(grez, (polinom2.hash.get(g2) * polinom1.hash.get(g1)) );
                 }else {
                     float crez= rez.get(grez)+(polinom2.hash.get(g2) * polinom1.hash.get(g1));
                     rez.put(grez,crez);
                 }
            }
        }
        String rezultat=Afisare(rez);
        return rezultat;
    }

}

