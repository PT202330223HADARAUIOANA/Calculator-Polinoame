

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
        float coeficient = 0;
        int gradul = 0;
        //REGEX
        Pattern pattern_gol = Pattern.compile("[-+]+\\d+$");
        Matcher matcher_gol = pattern_gol.matcher(Text);

        Pattern pattern_monom = Pattern.compile("[-+]*\\d*x+\\^+\\d{0,}");
        Matcher matcher_monom = pattern_monom.matcher(Text);
        String coef = "";
        String grad = "";
        int pattern_ok = 0;
        while (matcher_monom.find()) {
            //nu stie daca nu apare x-ul
            //daca grad la x =0 sa stie ca numar normal
            String txt = matcher_monom.group();
            System.out.println(txt);
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
                System.out.println("coeficientul este:::::" + coeficient);
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
            System.out.println("coef gol>>>" + cgol);
            if (cgol.charAt(0) == '+') {
                String valoare = cgol.substring(1) + "";
                coeficient = Float.parseFloat(valoare);
            } else if (coef.charAt(0) == '-') {
                String valoare = cgol.substring(1) + "";
                coeficient = (-1) * Float.parseFloat(valoare);
                pattern_ok = 1;
            }
            map.put(0, coeficient);
        }
        if (pattern_ok == 0) {
            System.out.println("errr-------------------------------------------");
        }
        this.hash = map;
    }
}
