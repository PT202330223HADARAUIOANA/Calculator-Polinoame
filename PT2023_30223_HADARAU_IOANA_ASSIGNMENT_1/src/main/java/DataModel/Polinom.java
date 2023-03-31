

        package DataModel;

        import graphicsinterface.ErrPattern;

        import java.util.HashMap;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Polinom {

    public HashMap<Integer,Float> hash;

    public Polinom(){
    }
    public Polinom(String Text) {
        HashMap<Integer, Float> map = new HashMap<>();
        float coeficient = 0;
        int gradul = 0;
        //REGEX
        Pattern pattern_sintaxa_gresita=Pattern.compile("[^x0123456789+-\\^]");
        Matcher matcher_sintaxa_gresita = pattern_sintaxa_gresita.matcher(Text);

        Pattern pattern_fara_putere = Pattern.compile("[-+]*\\d*x+[+-]+");
        Pattern pattern_fara_putere2 = Pattern.compile("[-+]*\\d*x+$");
        Matcher matcher_fara_putere = pattern_fara_putere.matcher(Text);
        Matcher matcher_fara_putere2 = pattern_fara_putere2.matcher(Text);

        //nu are x (x^0)
        Pattern pattern_gol = Pattern.compile("[-+]+\\d+$");
        Matcher matcher_gol = pattern_gol.matcher(Text);

        Pattern pattern_monom = Pattern.compile("[-+]*\\d*x+\\^+\\d{0,}");
        Matcher matcher_monom = pattern_monom.matcher(Text);
        String coef = "";
        String grad = "";
        int pattern_ok = 0;
            while (matcher_monom.find()) {
                String txt = matcher_monom.group();
                Pattern pattern_coef = Pattern.compile("[+-]*\\d*");
                Matcher matcher_coef = pattern_coef.matcher(txt);

                if (matcher_coef.find()) {
                    coef = matcher_coef.group();
                    //analizez semnul (daca nu exista semn, e implicit +)
                    pattern_ok = 1;
                    if (coef.equals("-")) {
                        coeficient = -1 * Float.parseFloat("1");
                    } else if (coef.equals("+")) {
                        coeficient = Float.parseFloat("1");
                    } else if (coef.length() > 0) {

                        if (coef.charAt(0) == '+') {
                            String val_coef = coef.substring(1) + "";
                            coeficient = Float.parseFloat(val_coef);
                        } else if (coef.charAt(0) == '-') {
                            String val_coef = coef.substring(1) + "";
                            coeficient = (-1) * Float.parseFloat(val_coef);
                        } else {
                            coeficient = Float.parseFloat(coef);
                        }
                    } else {
                        coeficient = Float.parseFloat("1");
                    }

                }
                Pattern pattern_grad = Pattern.compile("\\^+\\d{1,}");
                Matcher matcher_grad = pattern_grad.matcher(txt);
                if (matcher_grad.find()) {
                    pattern_ok = 1;
                    grad = matcher_grad.group();
                    String val_grad = grad.substring(1) + "";
                    gradul = Integer.parseInt(val_grad);
                }
                map.put(gradul, coeficient);
            }

        if (matcher_gol.find()) {
            String cgol = matcher_gol.group();
            if (cgol.charAt(0) == '+') {
                String valoare = cgol.substring(1) + "";
                coeficient = Float.parseFloat(valoare);
            } else if (cgol.charAt(0) == '-') {
                String valoare = cgol.substring(1) + "";
                coeficient = (-1) * Float.parseFloat(valoare);
            }
            pattern_ok = 1;
            map.put(0, coeficient);
        }
        if (matcher_fara_putere.find() ) {
            String sir = matcher_fara_putere.group();
            String str_sir=sir.substring(0,sir.length()-1) + "";
            if(str_sir.equals("x") ||str_sir.equals("+x") )
            {
                coeficient = Float.parseFloat("1");
            }else if( str_sir.equals("-x")){
                coeficient = (-1)*Float.parseFloat("1");
            } else if (sir.charAt(0) == '+') {
                String valoare = sir.substring(1,sir.length()-2) + "";//sterg x+
                System.out.println("pls"+valoare);
                coeficient = Float.parseFloat(valoare);
            } else if (sir.charAt(0) == '-') {
                String valoare = sir.substring(1,sir.length()-2) + "";
                coeficient = (-1) * Float.parseFloat(valoare);
            }else {
                String valoare = sir.substring(0,sir.length()-2) +"";
                coeficient = Float.parseFloat(valoare);
            }
            pattern_ok = 1;
            map.put(1, coeficient);
        }
        if (matcher_fara_putere2.find() ) {
            String sir = matcher_fara_putere2.group();

            if( sir.equals("+x") || sir.equals("x")) {
                coeficient = Float.parseFloat("1");
            }else if(sir.equals("-x")) {
                coeficient = (-1)*Float.parseFloat("1");
            } else if (sir.charAt(0) == '+') {
                String valoare = sir.substring(1,sir.length()-1) + ""; //sterg x-ul
                coeficient = Float.parseFloat(valoare);
            } else if (sir.charAt(0) == '-') {
                String valoare = sir.substring(1,sir.length()-1) + "";
                coeficient = (-1) * Float.parseFloat(valoare);
            }else {
                String valoare = sir.substring(0,sir.length()-1) +"";
                coeficient = Float.parseFloat(valoare);
            }
            pattern_ok = 1;
            map.put(1, coeficient);
        }
        if (pattern_ok == 0 || matcher_sintaxa_gresita.find()) {
            ErrPattern err=new ErrPattern();
        } else{
            this.hash = map;
        }
    }
}
