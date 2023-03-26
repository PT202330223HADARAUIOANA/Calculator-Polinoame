package Operatii;
import DataModel.Polinom;

import java.util.HashMap;


public class Op {
    Polinom polinom1 = new Polinom();
    Polinom polinom2 = new Polinom();

    public Op(Polinom polinom1, Polinom polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }

    //public HashMap<Integer, Float> Adunare(){
    public String Adunare() {
        HashMap<Integer, Float> rez = this.polinom1.hash;
        //pun primul polinom in rezultat
        for (Integer gp : polinom2.hash.keySet()) //grad polinom2
        {
            int fleg = 0;
            for (Integer gr : rez.keySet()) //grad polinom rezultat
            {
                if (gr.equals(gp)) {
                    rez.put(gr, polinom2.hash.get(gp) + rez.get(gr));
                    fleg = 1;
                }
            }
            //daca nu s-a gasit acelasi grad
            if (fleg == 0) {
                rez.put(gp, polinom2.hash.get(gp));
            }
        }

        System.out.println("rezulta:");
        for (Integer gr : rez.keySet()) {
            if (rez.get(gr) == 0.0) {
                System.out.println("brr");
            } else {
                System.out.println(rez.get(gr) + "x^" + gr);
            }
        }
        //google-it
        int gmic=0;
        StringBuilder sb = new StringBuilder();
        for (Integer key : rez.keySet()) {
            if (rez.get(key) == 0.0) { //0
                sb.append("");
            } else if (key == 0) { //grad )
                gmic=1;
                if (rez.get(key) < 0) {
                    sb.append("-").append(rez.get(key));
                } else {
                    sb.append(rez.get(key));
                }
            }else if(key==1){
                if (rez.get(key) < 0) {
                    sb.append("-").append(rez.get(key)).append("x").append("\n");
                }else  if( rez.get(key) >0 && gmic==1){
                    sb.append("+").append(rez.get(key)).append("x").append("\n");
                }else{
                    sb.append(rez.get(key)).append("x").append("\n");
                }
                gmic=1;
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
        public String Scadere () {
            HashMap<Integer, Float> rez = this.polinom1.hash;
            //pun primul polinom in rezultat

            for (Integer gp : polinom2.hash.keySet()) //grad polinom2
            {
                int fleg = 0;
                for (Integer gr : rez.keySet()) //grad polinom rezultat
                {
                    if (gp == gr) {
                        rez.put(gr, rez.get(gr) - polinom2.hash.get(gp));
                        fleg = 1;
                    }
                }
                //daca nu s-a gasit acelasi grad
                if (fleg == 0) {
                    rez.put(gp, -1 * polinom2.hash.get(gp));
                }
            }
            System.out.println("rezulta:");
            for (Integer gr : rez.keySet()) {
                System.out.println(rez.get(gr) + "x^" + gr);
            }

            StringBuilder sb = new StringBuilder();
            for (Integer key : rez.keySet()) {
                if (rez.get(key) == 0.0) {
                    sb.append("");
                } else if (rez.get(key) > 0) {
                    sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");
                } else {
                    sb.append(rez.get(key)).append("x^").append(key).append("\n");
                }
            }
            return sb.toString();
        }

        public String Derivare () {
            HashMap<Integer, Float> rez = new HashMap<Integer, Float>(1, 2);
            //pun primul polinom in rezultat
            System.out.println("--------derivare:+++++++++++++++++++++++");

            for (Integer gp : this.polinom1.hash.keySet()) //grad polinom
            {
                if (gp > 0) {
                    int gnou = gp - 1;
                    float cnou = (float) (this.polinom1.hash.get(gp) * gp);
                    rez.put(gnou, cnou);
                    System.out.println("nou: " + cnou + "x^" + gnou);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer key : rez.keySet()) {
                if (rez.get(key) == 0.0) {
                    sb.append("");
                } else if (rez.get(key) > 0) {
                    sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");
                } else {
                    sb.append(rez.get(key)).append("x^").append(key).append("\n");
                }
            }
            return sb.toString();
        }

        public String Integrare () {
            HashMap<Integer, Float> rez = new HashMap<Integer, Float>(1, 2);
            //pun primul polinom in rezultat
            System.out.println("--------integrare:*******************");

            for (Integer gp : this.polinom1.hash.keySet()) //grad polinom
            {
                if (gp > 0) {
                    int gnou = gp + 1;
                    float cnou = (float) (this.polinom1.hash.get(gp) * 1 / gp);
                    rez.put(gnou, cnou);
                    System.out.println("nou: " + cnou + "x^" + gnou);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer key : rez.keySet()) {
                if (rez.get(key) == 0.0) {
                    sb.append("");
                } else if (rez.get(key) > 0) {
                    sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");
                } else {
                    sb.append(rez.get(key)).append("x^").append(key).append("\n");
                }
            }
            return sb.toString();
        }

}

