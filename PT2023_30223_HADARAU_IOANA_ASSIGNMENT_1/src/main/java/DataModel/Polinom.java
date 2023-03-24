package DataModel;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    public HashMap<Integer,Float> hash;

    public Polinom(){
    }
    public Polinom(String Text) {
        HashMap<Integer, Float> map = new HashMap<>();
        float coeficient=0;
        int gradul=0;
        //REGEX
        Pattern pattern_monom= Pattern.compile("[-+]*\\d*x*\\^\\d{0,}");
        Matcher matcher_monom=pattern_monom.matcher(Text);
        String coef= "";
        String grad= "";
        while(matcher_monom.find()) {

            //nu stie daca nu apare x-ul
            //daca grad la x =0 sa stie ca numar normal
            String txt = matcher_monom.group();
            System.out.println(txt);
            Pattern pattern_coef = Pattern.compile("[+-]*\\d*");
            Matcher matcher_coef = pattern_coef.matcher(txt);

            if (matcher_coef.find()) {
                coef = matcher_coef.group();
                //analizez semnul (daca nu exista semn, e implicit +)

                if ( coef.equals("-") ) {
                    coeficient = -1*Float.parseFloat("1");
                }else if (coef.equals("+") ) {
                    coeficient =Float.parseFloat("1");
                } else if( coef.length()>0) {

                        if (coef.charAt(0) == '+') {
                            String val_coef = coef.substring(1) + "";
                            coeficient = Float.parseFloat(val_coef);
                        } else if(coef.charAt(0) == '-' ) {
                            String val_coef = coef.substring(1) + "";
                            coeficient = (-1) * Float.parseFloat(val_coef);
                        }else{
                            coeficient = Float.parseFloat(coef);
                        }
                }else {
                    coeficient = Float.parseFloat("1");
                }


                System.out.println("coeficientul este"+ coeficient);

            }
            Pattern pattern_grad = Pattern.compile("\\^+\\d{1,}");
            Matcher matcher_grad = pattern_grad.matcher(txt);
            if (matcher_grad.find()) {
                grad = matcher_grad.group();
                String val_grad = grad.substring(1) + "";
                gradul = Integer.parseInt(val_grad);
            }
            map.put(gradul,coeficient);
        }
        /*for (Integer g : map.keySet()) {
            float c = map.get(g);
            System.out.println(g + "cu coef " + c);
        }*/
        this.hash= map;
    }


}
