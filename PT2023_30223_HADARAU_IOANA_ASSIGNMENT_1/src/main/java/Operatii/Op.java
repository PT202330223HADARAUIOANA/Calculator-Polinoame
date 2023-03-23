package Operatii;
import DataModel.Polinom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Op {
    Polinom polinom1=new Polinom();
    Polinom polinom2=new Polinom();
    Polinom rezultat=new Polinom();


    public Op(Polinom polinom1, Polinom polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }

    //public HashMap<Integer, Float> Adunare(){
    public String Adunare(){
        HashMap<Integer,Float> rez=this.polinom1.hash;
        //pun primul polinom in rezultat
        for( Integer gp: polinom2.hash.keySet()) //grad polinom2
        {
            int fleg=0;
            for(Integer gr: rez.keySet()) //grad polinom rezultat
            {
                if(gr.equals(gp))
                {
                        rez.put(gr,polinom2.hash.get(gp)+rez.get(gr));
                    fleg=1;
                }
            }
            //daca nu s-a gasit acelasi grad
            if(fleg==0)
            {
                rez.put(gp,polinom2.hash.get(gp));
            }
        }

        System.out.println("rezulta:");
        for( Integer gr: rez.keySet())
        {
            if( rez.get(gr) == 0.0)
            {
                System.out.println( "brr");
            }else {
                System.out.println( rez.get(gr)+"x^"+gr);
            }
        }
        //google-it
        StringBuilder sb = new StringBuilder();
        for (Integer key : rez.keySet()) {
            if( rez.get(key)==0.0)
            {
                sb.append("");
            } else if(rez.get(key)>0 )
            {
                sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");
            }
            else {
                sb.append(rez.get(key)).append("x^").append(key).append("\n");
            }
        }
        return sb.toString();
    }

    public String Scadere(){
        HashMap<Integer,Float> rez=this.polinom1.hash;
        //pun primul polinom in rezultat

        for( Integer gp: polinom2.hash.keySet()) //grad polinom2
        {
            int fleg=0;
            for(Integer gr: rez.keySet()) //grad polinom rezultat
            {
                if(gp==gr)
                {
                    rez.put(gr, rez.get(gr)- polinom2.hash.get(gp));
                    fleg=1;
                }
            }
            //daca nu s-a gasit acelasi grad
            if(fleg==0)
            {
                rez.put(gp,-1*polinom2.hash.get(gp));
            }
        }
        System.out.println("rezulta:");
        for( Integer gr: rez.keySet())
        {
            System.out.println( rez.get(gr)+"x^"+gr);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer key : rez.keySet()) {
            if( rez.get(key)==0.0)
            {
                sb.append("");
            } else if(rez.get(key)>0 )
            {
                sb.append("+").append(rez.get(key)).append("x^").append(key).append("\n");
            }
            else {
                sb.append(rez.get(key)).append("x^").append(key).append("\n");
            }
        }
        return sb.toString();
    }
}
