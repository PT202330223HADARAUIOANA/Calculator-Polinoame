package DataModel;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    HashMap hash=new HashMap<>();
    String p1=new String();
    String p2=new String();
    public Polinom(String p1, String p2) {
        this.p1=p1;
        this.p2=p2;
    }
    public Polinom() {
    }

    public void Parse( String Text){
        HashMap<Integer, Float> map = new HashMap<>();
        float coeficient=0;
        Integer gradul=0;
        //REGEX
        Pattern pattern_monom= Pattern.compile("[-+]+\\d+x*\\^\\d{1,}"); //"\\^[+-]+[0-9]*[x]*\\^[0-9]*$"
        Matcher matcher_monom=pattern_monom.matcher(Text);
        String coef=new String();
        String grad=new String();
        while(matcher_monom.find()) {
            String txt = matcher_monom.group();
            System.out.println(txt);
            Pattern pattern_coef = Pattern.compile("[+-]+\\d{1,}");
            Matcher matcher_coef = pattern_coef.matcher(txt);

            if (matcher_coef.find()) {
                coef = matcher_coef.group();
                System.out.println(coef);

                if (coef.charAt(0) == '+') {
                    String val_coef = coef.substring(1) + "";
                    coeficient = Float.parseFloat(val_coef);
                    System.out.println("caux=>"+coeficient);
                } else {
                    String val_coef = coef.substring(1) + "";
                    coeficient = (-1) * Float.parseFloat(val_coef);
                    System.out.println("caux=>"+coeficient);
                }
            }
            Pattern pattern_grad = Pattern.compile("\\^+\\d{1,}");
            Matcher matcher_grad = pattern_grad.matcher(txt);
            if (matcher_grad.find()) {
                grad = matcher_grad.group();
                System.out.println(grad);
                String val_grad = grad.substring(1) + "";
                gradul = Integer.parseInt(val_grad);
                System.out.println("gaux=>"+gradul);
            }
            map.put(gradul,coeficient);
        }

    }

    @Override
    public String toString() {
        return "Polinom{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                '}';
    }
}
